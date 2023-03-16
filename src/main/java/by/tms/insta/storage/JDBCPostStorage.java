package by.tms.insta.storage;

import by.tms.insta.entity.Post;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCPostStorage implements PostStorage {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    private static final String INSERTING_POST = "insert into posts values (default, ?, ?, ?, ?)";

    private static final String DELETION_POST_BY_ID = "delete from posts where id = ?";
    private static final String SELECTION_BY_ID = "select * from posts where id = ?";
    private static final int ID_COLUMN = 1;
    private static final int DESCRIPTION_COLUMN = 2;
    private static final int URL_COLUMN = 3;
    private static final int USER_ID_COLUMN = 4;
    private static final int CREATE_AT_COLUMN = 5;
    private final Connection connection;
    private static JDBCPostStorage postStorage;

    public JDBCPostStorage() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static JDBCPostStorage getInstance() {
        if (postStorage == null) {
            postStorage = new JDBCPostStorage();
        }
        return postStorage;
    }

    @Override
    public void save(Post post) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTING_POST);
            preparedStatement.setString(1, post.getDescription());
            preparedStatement.setString(2, post.getUrl());
            preparedStatement.setLong(3, post.getCreator().getId());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(post.getCreateAt()));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETION_POST_BY_ID);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Post> findById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECTION_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            String description = resultSet.getString(DESCRIPTION_COLUMN);
            String url = resultSet.getString(URL_COLUMN);
            long userId = resultSet.getLong(USER_ID_COLUMN);
            LocalDateTime createAt = resultSet.getTimestamp(CREATE_AT_COLUMN).toLocalDateTime();
            return Optional.of(new Post(id, description, url, userId, createAt));
        } catch (SQLException ignoring) {
        }
        return Optional.empty();
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<>();
    }
}
