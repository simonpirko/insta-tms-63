package by.tms.insta.storage;

import by.tms.insta.entity.User;

import java.util.Optional;

public interface Storage<T> {
    void save(T value);
    void remove(long id);
}