package by.tms.insta.service;

import by.tms.insta.entity.User;
import by.tms.insta.storage.JDBCUserStorage;
import by.tms.insta.storage.Storage;

import java.util.Optional;

public class UserService {
    private static UserService userService;

    private UserService() {
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public void createAccount(User user) {
        JDBCUserStorage.getInstance().save(user);
    }

    public void removeAccount(User user) {
        JDBCUserStorage.getInstance().remove(user.getId());
    }

    public Optional<User> findUser(String username) {
        return JDBCUserStorage.getInstance().findUserByUsername(username);
    }

}
