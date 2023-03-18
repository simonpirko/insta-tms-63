package by.tms.insta.service;

import by.tms.insta.entity.User;
import by.tms.insta.storage.JDBCUserStorage;
import by.tms.insta.storage.Storage;
import by.tms.insta.storage.UserStorage;

import java.util.Optional;

public class UserService {

    private static UserService userService;
    private UserStorage userStorage = JDBCUserStorage.getInstance();

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

    public void removeAccount(User user) {
        userStorage.remove(user.getId());
    }

    public boolean deleteById (long id) { return userStorage.deleteById(id); }


    public Optional<User> findUser(String username) {
        return userStorage.findUserByUsername(username);
    }

}
