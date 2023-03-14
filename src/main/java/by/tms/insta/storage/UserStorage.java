package by.tms.insta.storage;

import by.tms.insta.entity.User;

import java.util.Optional;

public interface UserStorage extends Storage<User> {
    Optional<User> findUserByUsername(String username);

}
