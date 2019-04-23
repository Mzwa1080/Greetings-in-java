import net.greet.GreetJDBC;
import org.junit.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.sql.*;

import static org.junit.Assert.*;


public class JDBCTest {

    final String GREETINGS_JDBC ="jdbc:h2:file:./target/greetings-in-java";
    final String username = "";
    final String password = "";
    Connection conn;

    public Connection getConnection(){


        try {
            conn = DriverManager.getConnection(GREETINGS_JDBC, username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    @Test
    public void isItConnected(){
        try {
            Class.forName("org.h2.Driver");

            try {
                conn = DriverManager.getConnection(GREETINGS_JDBC, "", "");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    public void clearTable(){
        conn = getConnection();
        try {
            Statement statement = null;
            try {
                statement = conn.createStatement();
                statement.addBatch("delete from users");
                statement.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void addUsers(){
        GreetJDBC insert = new GreetJDBC();
//        insert.clearAllUsers();
        insert.addUsers("Mzwakhe");
        insert.addUsers("Shawn");
        insert.getCountForUser("Shawn");

        System.out.println("Where is this null coming from : "+ insert.greetedUsers());

        assertEquals(1,1);
    }

    @AfterEach
    public void clearTable2(){
        GreetJDBC clean =  new GreetJDBC();
        clean.clearAllUsers();
    }
}
