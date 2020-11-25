package store;

import model.car.Car;
import model.car.Engine;
import model.car.User;

import java.util.Collection;

public interface Store extends AutoCloseable {
    void saveUser(User user);

    User findUser(String login, String password);

    User findUserByName(String login);

    void saveCar(Car car, Engine engine);

    Collection<Car> findAllCars();

    Car findCarById(int id);
}
