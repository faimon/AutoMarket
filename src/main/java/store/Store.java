package store;

import model.car.User;

public interface Store extends AutoCloseable {
    void saveUser(User user);

    User findUser(String login, String password);
}
