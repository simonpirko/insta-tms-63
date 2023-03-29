package by.tms.insta.service;

import by.tms.insta.entity.User;
import by.tms.insta.dao.JDBCUserDAO;
import by.tms.insta.dao.UserDAO;

import java.util.List;
import java.util.Optional;

public class UserService {

    private static UserService userService;
    private final UserDAO userDAO = JDBCUserDAO.getInstance();

    private UserService() {
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public void createAccount(User user) {
        userDAO.save(user);
    }

    public void removeAccount(User user) {
        userDAO.remove(user.getId());
    }

    public Optional<User> findByUserName(String username) {
        return userDAO.findByUsername(username);
    }

    public Optional<User> findById(long id) {
        return userDAO.findById(id);
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public Optional<User> updatePasswordById(String password, long id) {
        return userDAO.updatePasswordById(password, id);
    }

    public Optional<User> updateById(User user){
        return userDAO.updateById(user);
    }
}
