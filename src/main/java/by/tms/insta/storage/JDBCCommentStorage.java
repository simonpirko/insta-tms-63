package by.tms.insta.storage;

import by.tms.insta.entity.Comment;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JDBCCommentStorage extends AbstractStorage implements Storage<Comment>{
    private static JDBCCommentStorage commentStorage;
    private JDBCCommentStorage(){

    }

    public static JDBCCommentStorage getInstance(){
        if(commentStorage == null){
            commentStorage = new JDBCCommentStorage();
        }
        return commentStorage;
    }

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
