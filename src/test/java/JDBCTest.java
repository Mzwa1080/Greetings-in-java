import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.sql.*;

import static org.junit.Assert.assertEquals;

public class JDBCTest {

    final String GREETINGS_JDBC ="jdbc:h2:file:./dbTest/greetings-in-java";
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

    @BeforeEach
    public void deleteUsers(){
        conn = getConnection();

        try {
            Statement stmt = conn.createStatement();
            stmt.addBatch("delete from users");
            stmt.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
    public void existingUsers(){
        conn = getConnection();

        String  check_user= "select * from users";
        String insert_users = "insert into users(name,counter) values(?,?)";

        try {
            PreparedStatement ps1 = conn.prepareStatement(insert_users);
            PreparedStatement ps2 = conn.prepareStatement(check_user);
            ps1.setString(1,"mzwa");
            ps1.setInt(1,2);
            ps1.execute();

            ps1.setString(1,"shawn");
            ps1.setInt(1,9);
            ps1.execute();

            ps1.setString(1,"sakhi");
            ps1.setInt(1,5);
            ps1.execute();

            ResultSet rs = ps2.executeQuery();

            int counter = 0;
            while (rs.next()){
                if(counter == 1){
                    counter++;
                    System.out.println(counter);
                    assertEquals(2,"mzwa");

                }else if(counter ==2){
                    counter++;
                    assertEquals(9,"shawn");
                }else{
                    assertEquals(5,"sakhi");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
