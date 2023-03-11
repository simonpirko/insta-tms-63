package by.tms.insta.storage;

import by.tms.insta.entity.User;

import java.sql.*;

public class SQLUserStorage implements UserStorage {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    private static final int USERNAME_COLUMN = 1;
    private static final int PASSWORD_COLUMN = 2;
    private static final int EMAIL_COLUMN = 3;
    private static final int FULL_NAME_COLUMN = 4;
    private static final int CREATE_AT_COLUMN = 5;
    private static final int UPDATE_AT_COLUMN = 6;
    private static final String INSERT_USER = "insert into users values (default, ?, ?, ?, ?, ?, ?)";

    private final Connection connection;

    public SQLUserStorage() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(USERNAME_COLUMN, user.getUsername());
            preparedStatement.setString(PASSWORD_COLUMN, user.getPassword());
            preparedStatement.setString(EMAIL_COLUMN, user.getEmail());
            preparedStatement.setString(FULL_NAME_COLUMN, user.getFullName());
            preparedStatement.setTimestamp(CREATE_AT_COLUMN, Timestamp.valueOf(user.getCreateAt()));
            preparedStatement.setTimestamp(UPDATE_AT_COLUMN, Timestamp.valueOf(user.getUpdateAt()));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
