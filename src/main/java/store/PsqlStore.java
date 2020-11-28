package store;

import model.car.Car;
import model.car.Engine;
import model.car.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class PsqlStore implements Store {
    private SessionFactory sf;

    private PsqlStore() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        sf = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    private <T> T tx(final Function<Session, T> command) {
        final Session session = sf.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void saveUser(User user) {
        tx(session -> session.save(user));
    }

    @Override
    public User findUser(String login, String password) {
        return tx(session -> {
            User resultUser = null;
            List<User> list = session.createQuery("FROM User WHERE login = :login AND password = :password")
                    .setParameter("login", login)
                    .setParameter("password", password)
                    .list();
            if (list.size() != 0) {
                resultUser = list.get(0);
            }
            return resultUser;
        });
    }

    @Override
    public User findUserByName(String login) {
        return tx(session -> {
            User resultUser = null;
            List<User> list = session.createQuery("FROM User WHERE login = :login")
                    .setParameter("login", login)
                    .list();
            if (list.size() != 0) {
                resultUser = list.get(0);
            }
            return resultUser;
        });
    }

    @Override
    public void saveCar(Car car, Engine engine) {
        tx(session -> {
            session.save(engine);
            return session.save(car);
        });
    }

    @Override
    public void updateStatusCar(int id, boolean status) {
        tx(session -> {
            Car car = session.get(Car.class, id);
            car.setSaleStatus(status);
            session.update(car);
            return car;
        });
    }

    @Override
    public Collection<Car> findAllCars() {
        return tx(session -> session.createQuery("select c from Car c", Car.class).list());

    }

    @Override
    public Collection<Car> findCarsByUser(String login) {
        return tx(session -> session.createQuery("FROM Car AS c LEFT JOIN fetch c.user WHERE c.user.login = :login")
                .setParameter("login", login)
                .list());
    }

    @Override
    public Car findCarById(int id) {
        return tx(session -> session.get(Car.class, id));
    }


    private static final class Lazy {
        private static final PsqlStore INSTANCE = new PsqlStore();
    }

    public static PsqlStore instanceOf() {
        return Lazy.INSTANCE;
    }

    @Override
    public void close() throws Exception {
        sf.close();
    }
}

