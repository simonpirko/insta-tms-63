package by.tms.insta.dao;

import by.tms.insta.entity.User;

import java.util.Optional;

public interface UserDAO extends DAO<User> {
    Optional<User> findByUsername(String username);

    Optional<User> changePasswordById(User user);

    Optional<User> changeEmailFullNameAvatarById(User user);
}
