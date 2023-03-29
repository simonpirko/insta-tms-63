package by.tms.insta.storage;

import by.tms.insta.entity.Like;

import java.util.List;
import java.util.Optional;

public interface Storage<T> {
    void save(T value);
    void remove(long id);
    Optional<T> findById(long id);
    List<T> findAll();
}