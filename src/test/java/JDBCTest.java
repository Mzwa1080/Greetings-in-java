import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {

    final String GREETINGS_JDBC ="jdbc:h2:file:./db/greetings-in-java";
    Connection conn;
    public Connection getConnection(){
        String username = "";
        String password = "";

        try {
            Connection conn = DriverManager.getConnection(GREETINGS_JDBC, username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
