package run;

import model.car.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HbmRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();
//            Owner owner = new Owner("Alex", "255344");
//            session.save(owner);
//
//            Engine engine = new Engine(150, 2.0f, "Бензиновый");
//            session.save(engine);
//
//            Car car = new Car("Volkswagen Polo", "White", engine);
//            car.addOwner(owner);

            session.remove(session.get(Car.class, 3));
            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
