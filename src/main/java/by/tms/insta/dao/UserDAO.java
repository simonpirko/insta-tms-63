package by.tms.insta.dao;

import by.tms.insta.entity.User;

import java.time.LocalDateTime;
import java.util.Optional;

public interface UserDAO extends DAO<User> {
    Optional<User> findByUsername(String username);

    Optional<User> changePasswordById(User updatedUser);

    Optional<User> changeInfoNameById(User updatedUser);
}
