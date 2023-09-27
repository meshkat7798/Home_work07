package applicationConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/postgres","postgres", "meshkat77");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}