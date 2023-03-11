package by.tms.insta.storage;

import by.tms.insta.entity.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

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
    private static final String INSERTING_USER = "insert into users values (default, ?, ?, ?, ?, ?, ?)";
    private static final String SELECTION_USER_BY_USERNAME = "select * from users where username = ?";
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
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTING_USER);
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

    @Override
    public Optional<User> findUserByUsername(String username) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECTION_USER_BY_USERNAME);
            preparedStatement.setString(USERNAME_COLUMN, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            String password = resultSet.getString(PASSWORD_COLUMN);
            String email = resultSet.getString(EMAIL_COLUMN);
            String fullName = resultSet.getString(FULL_NAME_COLUMN);
            LocalDateTime createAt = resultSet.getTimestamp(CREATE_AT_COLUMN).toLocalDateTime();
            LocalDateTime updateAt = resultSet.getTimestamp(UPDATE_AT_COLUMN).toLocalDateTime();

            return Optional.of(new User(username, password, email, fullName, createAt, updateAt));
        } catch (SQLException ignored) {
        }
        return Optional.empty();
    }
}