package by.tms.insta.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractStorage {
    private static final String URL = "jdbc:postgresql://localhost:5432/instagram_bd";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    private final Connection connection;

    public AbstractStorage() {
        this.connection = createConnection();
    }

    public Connection getConnection(){
        return connection;
    }

    private Connection createConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
