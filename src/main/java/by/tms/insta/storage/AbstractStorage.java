package by.tms.insta.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractStorage {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    private Connection connection;

    public Connection getConnection(){
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
