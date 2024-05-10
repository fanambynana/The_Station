package the.station.dbConnection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
public class DbConnect {
    @Bean
    public Connection createConnection() {
        try {
            return DriverManager.getConnection(
                    System.getenv("DB_URL"),
                    System.getenv("DB_USERNAME"),
                    System.getenv("DB_PASSWORD")
            );
        } catch (Exception exception) {
            System.err.println("Connection error :\n  > " + exception.getMessage());
            return null;
        }
    }
    
    public Connection createTestConnection() {
        try {
            return DriverManager.getConnection(
                    System.getenv("DB_URL_TEST"),
                    System.getenv("DB_USERNAME_TEST"),
                    System.getenv("DB_PASSWORD_TEST")
            );
        } catch (Exception exception) {
            System.err.println("Connection error for test :\n  > " + exception.getMessage());
            return null;
        }
    }
}
