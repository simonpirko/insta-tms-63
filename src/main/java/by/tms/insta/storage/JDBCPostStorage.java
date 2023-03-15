package by.tms.insta.storage;

import by.tms.insta.entity.Post;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class JDBCPostStorage implements PostStorage {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    private static final String INSERTING_POST = "insert into posts values (default, ?, ?, ?, ?)";

    private static final String DELETION_POST_BY_ID = "delete from posts where id = ?";
    private final Connection connection;

    public JDBCPostStorage() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        return Optional.empty();
    }

    @Override
    public List<Post> findAll() {
        return null;
    }
}
