package net.greet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainConnection {

    private final String USERNAME = "";
    private final String PASSWORD = "";
    private static final String jdbcURL = "jdbc:h2:file:./target/greetings_in_java";

    public static void main(String [] args) throws SQLException {
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL, "", "");
            System.out.println("connected!---- " + conn);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }


    }

}
