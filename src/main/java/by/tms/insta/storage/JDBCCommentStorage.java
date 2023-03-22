package by.tms.insta.storage;

import by.tms.insta.entity.Comment;

import java.util.List;
import java.util.Optional;

public class JDBCCommentStorage implements Storage<Comment>{
    @Override
    public void save(Comment value) {

    }

    @Override
    public void remove(long id) {

    }

    @Override
    public Optional<Comment> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Comment> findAll() {
        return null;
    }
}
