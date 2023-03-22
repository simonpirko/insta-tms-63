package by.tms.insta.storage;

import by.tms.insta.entity.Comment;
import by.tms.insta.entity.User;
import by.tms.insta.service.UserService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class JDBCCommentStorage extends AbstractStorage implements Storage<Comment> {
    private static final String INSERTING_COMMENT = "insert into comments values (default, ?, ?, ?)";
    private static final String DELETION_COMMENT_BY_ID = "delete from comments where id = ?";
    private static final String SELECTION_COMMENT_BY_ID = "select * from comments where id = ?";
    private static final int ID_COLUMN = 1;
    private static final int BODY_COLUMN = 2;
    private static final int USER_ID_COLUMN = 3;
    private static final int CREATE_AT_COLUMN = 4;
    private static JDBCCommentStorage commentStorage;

    private JDBCCommentStorage() {

    }

    public static JDBCCommentStorage getInstance() {
        if (commentStorage == null) {
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
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(DELETION_COMMENT_BY_ID);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Comment> findById(long id) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(SELECTION_COMMENT_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String body = resultSet.getString(BODY_COLUMN);
            long userId = resultSet.getLong(USER_ID_COLUMN);
            LocalDateTime createAt = resultSet.getTimestamp(CREATE_AT_COLUMN).toLocalDateTime();
            return Optional.of(Comment.builder()
                    .setId(id)
                    .setBody(body)
                    .setAuthor(UserService.getInstance().findUserById(userId).get())
                    .setCreateAt(createAt)
                    .build());
        } catch (SQLException ignored) {
        }
        return Optional.empty();
    }

    @Override
    public List<Comment> findAll() {
        return null;
    }
}
