package by.tms.insta.storage;

import by.tms.insta.entity.User;

import java.util.Optional;

public interface UserStorage {
    void save(User user);
    Optional<User> findUserByUsername(String username);
}
