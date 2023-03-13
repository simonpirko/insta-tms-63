package by.tms.insta.storage;

import by.tms.insta.entity.User;

import java.util.Optional;

public abstract class Storage<T> {
    public abstract void save(T value);
    public abstract void remove(long id);
    public abstract Optional<User> findUserByUsername(String username);
}