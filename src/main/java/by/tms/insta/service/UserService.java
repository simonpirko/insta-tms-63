package by.tms.insta.service;

import by.tms.insta.entity.User;
import by.tms.insta.dao.JDBCUserDAO;
import by.tms.insta.dao.UserDAO;

import java.util.List;
import java.util.Optional;

public class UserService {

    private static UserService userService;
    private final UserDAO userStorage = JDBCUserDAO.getInstance();

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
