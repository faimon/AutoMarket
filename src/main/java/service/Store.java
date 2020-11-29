package service;

import model.car.Car;
import model.car.Engine;
import model.car.User;

import java.util.Collection;

public interface Store extends AutoCloseable {
    void saveUser(User user);

    User findUser(String login, String password);

    User findUserByName(String login);

    void saveCar(Car car, Engine engine);

    void updateStatusCar(int id, boolean status);

    Collection<Car> findAllCars();

    Collection<Car> findCarsByUser(String login);

    Collection<Car> findCarsWithPhoto();

    Collection<Car> findCarsOnlyLastDay();

    Collection<Car> findCarsByModel(String model);

    Car findCarById(int id);
}
