package by.tms.insta.storage;

import by.tms.insta.entity.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCUserStorage extends AbstractStorage implements UserStorage {
    private static final int ID_COLUMN = 1;
    private static final int USERNAME_COLUMN = 2;
    private static final int PASSWORD_COLUMN = 3;
    private static final int EMAIL_COLUMN = 4;
    private static final int FULL_NAME_COLUMN = 5;
    private static final int CREATE_AT_COLUMN = 6;
    private static final int UPDATE_AT_COLUMN = 7;
    private static final int AVATAR_COLUMN = 8;
    private static final String INSERTING_USER = "insert into users values (default, ?, ?, ?, ?, ?, ?,?)";
    private static final String DELETION_USER_BY_ID = "delete from users where id = ?";
    private static final String SELECTION_USER_BY_USERNAME = "select * from users where username = ?";
    private static final String SELECTION_USER_BY_ID = "select * from users where id = ?";
    private static final String SELECTION_ALL_USERS = "select * from users";

    private static JDBCUserStorage userStorage;

    public static JDBCUserStorage getInstance() {
        if (userStorage == null) {
            userStorage = new JDBCUserStorage();
        }
        return userStorage;
    }

    private JDBCUserStorage() {
    }

    @Override
    public void save(User user) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(INSERTING_USER);
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getFullName());
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(user.getCreateAt()));
            preparedStatement.setTimestamp(6, Timestamp.valueOf(user.getUpdateAt()));
            preparedStatement.setString(7, user.getAvatar());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(long id) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(DELETION_USER_BY_ID);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Optional<User> findById(long id) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(SELECTION_USER_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String username = resultSet.getString(USERNAME_COLUMN);
            String password = resultSet.getString(PASSWORD_COLUMN);
            String email = resultSet.getString(EMAIL_COLUMN);
            String fullName = resultSet.getString(FULL_NAME_COLUMN);
            LocalDateTime createAt = resultSet.getTimestamp(CREATE_AT_COLUMN).toLocalDateTime();
            LocalDateTime updateAt = resultSet.getTimestamp(UPDATE_AT_COLUMN).toLocalDateTime();
            return Optional.of(User.builder()
                    .setId(id)
                    .setUsername(username)
                    .setPassword(password)
                    .setEmail(email)
                    .setFullName(fullName)
                    .setCreateAt(createAt)
                    .setUpdateAt(updateAt)
                    .build());
        } catch (SQLException ignored) {
        }
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECTION_ALL_USERS);
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                long id = resultSet.getLong(ID_COLUMN);
                String username = resultSet.getString(USERNAME_COLUMN);
                String password = resultSet.getString(PASSWORD_COLUMN);
                String email = resultSet.getString(EMAIL_COLUMN);
                String fullName = resultSet.getString(FULL_NAME_COLUMN);
                LocalDateTime createAt = resultSet.getTimestamp(CREATE_AT_COLUMN).toLocalDateTime();
                LocalDateTime updateAt = resultSet.getTimestamp(UPDATE_AT_COLUMN).toLocalDateTime();
                users.add(User.builder()
                        .setId(id)
                        .setUsername(username)
                        .setPassword(password)
                        .setEmail(email)
                        .setFullName(fullName)
                        .setCreateAt(createAt)
                        .setUpdateAt(updateAt)
                        .build());
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Optional<User> findUserByUsername(String username) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(SELECTION_USER_BY_USERNAME);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            long id = resultSet.getLong(ID_COLUMN);
            String password = resultSet.getString(PASSWORD_COLUMN);
            String email = resultSet.getString(EMAIL_COLUMN);
            String fullName = resultSet.getString(FULL_NAME_COLUMN);
            LocalDateTime createAt = resultSet.getTimestamp(CREATE_AT_COLUMN).toLocalDateTime();
            LocalDateTime updateAt = resultSet.getTimestamp(UPDATE_AT_COLUMN).toLocalDateTime();
            String avatar = resultSet.getString(AVATAR_COLUMN);
            return Optional.of(User.builder()
                    .setId(id)
                    .setUsername(username)
                    .setPassword(password)
                    .setEmail(email)
                    .setFullName(fullName)
                    .setCreateAt(createAt)
                    .setUpdateAt(updateAt)
                    .setAvatar(avatar)
                    .build());
        } catch (SQLException ignored) {
        }
        return Optional.empty();
    }
}