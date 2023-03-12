package by.tms.insta.storage;

import by.tms.insta.entity.User;

import java.util.Optional;

public abstract class Storage<T> {
    abstract void save(T value);
    abstract void remove(long id);
    abstract Optional<User> findUserByUsername(String username);
}