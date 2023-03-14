package by.tms.insta.storage;

import by.tms.insta.entity.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class JDBCUserStorage implements UserStorage {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    private static final int ID_COLUMN = 1;
    private static final int USERNAME_COLUMN = 2;
    private static final int PASSWORD_COLUMN = 3;
    private static final int EMAIL_COLUMN = 4;
    private static final int FULL_NAME_COLUMN = 5;
    private static final int CREATE_AT_COLUMN = 6;
    private static final int UPDATE_AT_COLUMN = 7;
    private static final String INSERTING_USER = "insert into users values (default, ?, ?, ?, ?, ?, ?)";
    private static final String DELETION_USER_BY_USERNAME = "delete from users where username = ?";
    private static final String SELECTION_USER_BY_USERNAME = "select * from users where username = ?";
    private final Connection connection;

    private static JDBCUserStorage userStorage;

    public static JDBCUserStorage getInstance(){
        if(userStorage == null){
            userStorage = new JDBCUserStorage();
        }
        return userStorage;
    }

    public JDBCUserStorage() {
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
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getFullName());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(user.getCreateAt()));
            preparedStatement.setTimestamp(6, Timestamp.valueOf(user.getUpdateAt()));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETION_USER_BY_USERNAME);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> findUserByUsername(String username) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECTION_USER_BY_USERNAME);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            long id = resultSet.getLong(ID_COLUMN);
            String password = resultSet.getString(PASSWORD_COLUMN);
            String email = resultSet.getString(EMAIL_COLUMN);
            String fullName = resultSet.getString(FULL_NAME_COLUMN);
            LocalDateTime createAt = resultSet.getTimestamp(CREATE_AT_COLUMN).toLocalDateTime();
            LocalDateTime updateAt = resultSet.getTimestamp(UPDATE_AT_COLUMN).toLocalDateTime();

            return Optional.of(new User(id, username, password, email, fullName, createAt, updateAt));
        } catch (SQLException ignored) {
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}