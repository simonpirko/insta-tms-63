package by.tms.insta.service;

import by.tms.insta.entity.User;
import by.tms.insta.storage.JDBCUserStorage;
import by.tms.insta.storage.UserStorage;

import java.util.List;
import java.util.Optional;

public class UserService {

    private static UserService userService;
    private final UserStorage userStorage = JDBCUserStorage.getInstance();

    private UserService() {
    }

    public static UserService getInstance() {
        if (userService == null)
        {
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
    
    public Optional<User> findUserByUserName(String username) {
        return userStorage.findUserByUsername(username);
    }

    public Optional<User> findUserById(long id){
        return userStorage.findById(id);
    }

    public List<User> findAll(){
        return userStorage.findAll();
    }
}
