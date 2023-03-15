package by.tms.insta.storage;

import by.tms.insta.entity.Post;

import java.sql.*;

public class JDBCPostStorage implements PostStorage {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    private static final String INSERTING_POST = "insert into posts values (default, ?, ?, ?, ?)";
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

    }
}
