package by.tms.insta.storage;

import by.tms.insta.entity.Comment;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public class JDBCCommentStorage extends AbstractStorage implements Storage<Comment>{
    private static final String INSERTING_COMMENT = "insert into comments values (default, ?, ?, ?)";
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
    public void save(Comment comment) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(INSERTING_COMMENT);
            preparedStatement.setString(1, comment.getBody());
            preparedStatement.setLong(2, comment.getAuthor().getId());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(comment.getCreateAt()));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
