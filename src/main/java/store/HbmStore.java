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


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class HbmStore implements Store {
    private SessionFactory sf;

    private HbmStore() {
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
    public Collection<Car> findAllCars() {
        return tx(session -> session.createQuery("select c from Car c", Car.class).list());

    }

    @Override
    public Car findCarById(int id) {
        return tx(session -> session.get(Car.class, id));
    }


    private static final class Lazy {
        private static final HbmStore INSTANCE = new HbmStore();
    }

    public static HbmStore instanceOf() {
        return Lazy.INSTANCE;
    }

    //    public void addNewHuman(Human human, String[] ids) {
//        try (Session session = sf.openSession()) {
//            session.beginTransaction();
//
//            for (String id : ids) {
//                City city = session.find(City.class, Integer.parseInt(id));
//                human.addCity(city);
//            }
//            session.save(human);
//
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            sf.getCurrentSession().getTransaction().rollback();
//        }
//    }
//
//    public List<City> allCities() {
//        List<City> rsl = new ArrayList<>();
//        try (Session session = sf.openSession()) {
//            session.beginTransaction();
//
//            rsl = session.createQuery("select c from City c", City.class).list();
//
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            sf.getCurrentSession().getTransaction().rollback();
//        }
//        return rsl;
//    }
//
    @Override
    public void close() throws Exception {
        sf.close();
    }
}

