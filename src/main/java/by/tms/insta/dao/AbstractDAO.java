package by.tms.insta.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/instagram_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private final Connection connection;

    public AbstractDAO() {
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
