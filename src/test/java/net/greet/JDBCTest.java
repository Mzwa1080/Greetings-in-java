package net.greet;
import org.junit.*;
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

    @Test
    public void checkTheList(){
        GreetJDBC insert = new GreetJDBC();
        insert.clearAllUsers();
        insert.addUsers("Mzwakhe");
        insert.addUsers("Shawn");
        assertEquals(false,insert.greetedUsers().isEmpty());
    }

    @Test
    public void checkUser(){
        GreetJDBC check = new GreetJDBC();
        check.clearAllUsers();
        check.addUsers("Shawn");
        check.addUsers("Shawn");
        check.addUsers("Steve");
        check.addUsers("ben");
        assertEquals(true,check.greetedUsers().containsKey("Shawn"));
    }

    @Test
    public void countUser(){
       GreetJDBC count = new GreetJDBC();
       count.clearAllUsers();
       count.addUsers("Mzwa");
       count.addUsers("Sakhi");
       count.addUsers("Mzwa");
       count.greetedUsers();
       assertEquals("Mzwa has been greeted 2 time(s)",count.getCountForUser("Mzwa"));
    }
    @Test
    public void counter(){
        GreetJDBC counter = new GreetJDBC();
        counter.clearAllUsers();
        counter.addUsers("Mzwa");
        counter.addUsers("Sakhi");
        counter.addUsers("Sbu");
        counter.greetedUsers();
        assertEquals(3,counter.getCountForAllUsers());
    }

    @Test
    public void clearSingleUser(){
        GreetJDBC remove = new GreetJDBC();
        remove.clearAllUsers();
        remove.addUsers("Mzwa");
        remove.addUsers("Ayas");
        remove.addUsers("Av");
        remove.greetedUsers();
        remove.clearPerUser("Ayas");
        assertEquals(2,remove.getCountForAllUsers());
    }
}
