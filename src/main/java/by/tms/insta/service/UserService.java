package by.tms.insta.service;

import by.tms.insta.entity.User;
import by.tms.insta.storage.JDBCUserStorage;
import by.tms.insta.storage.Storage;

public class UserService {
    private static UserService userService;

    private static Storage<User> userStorage = new JDBCUserStorage();

    private UserService() {
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public void createAccount(User user) {
        userStorage.save(user);
    }

}
