package net.greet;

import org.h2.jdbc.JdbcSQLSyntaxErrorException;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class GreetJDBC implements GreetInterface {
    Connection conn;
    String jdbcURL = "jdbc:h2:file:./target/greetings-in-java";
    final String username = "";
    final String password = "";


    public Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");
            try {
                conn = DriverManager.getConnection(jdbcURL, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public void addUsers(String name) {
        try{
            conn = getConnection();
            final String INSERT_USERNAMES = "insert into users(name,counter) values(?,?)";
            final String UPDATE_COUNTER = "update users set counter = counter + 1 where name = ?";

            PreparedStatement ps_Insert = conn.prepareStatement(INSERT_USERNAMES);
            PreparedStatement rsCheck = conn.prepareStatement("select * from users where name = ?");
            rsCheck.setString(1,name);

            ResultSet rs = rsCheck.executeQuery();

                if (!rs.next()){
                    ps_Insert.setString(1,name);
                    ps_Insert.setInt(2,1);
                    ps_Insert.execute();
                }else{
                    PreparedStatement ps_counter = conn.prepareStatement(UPDATE_COUNTER);
                    ps_counter.setString(1,name);
                    ps_counter.execute();
                }

        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Map<String, Integer> greetedUsers() {
         conn =  getConnection();
        final Map<String, Integer> greetedUser = new HashMap<>();

            try {
                String select_users = "select * from users";
                PreparedStatement ps = conn.prepareStatement(select_users);

                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    greetedUser.put(rs.getString("name"), rs.getInt("counter"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        return greetedUser;
    }

    @Override
    public int getCountForAllUsers() {
        return greetedUsers().size();
    }

    @Override
    public void clearAllUsers() {
        conn = getConnection();
        String CLEAR_EVERYONE = "delete from users";

        try {
            PreparedStatement ps = conn.prepareStatement(CLEAR_EVERYONE);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public  String clearPerUser(String user) {
        conn = getConnection();
        String remove_one = "delete from users where name = ? ";

        try {
            PreparedStatement remove_user = conn.prepareStatement(remove_one);
            remove_user.setString(1,user);
            remove_user.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

         return greetedUsers().toString();
    }

    @Override
    public String getCountForUser(String user){
        conn = getConnection();
        String count_per_user = "select * from users where name = ?";

        try {
            PreparedStatement count = conn.prepareStatement(count_per_user);
            count.setString(1,user);
            ResultSet rs = count.executeQuery();

            if(rs.next()){
                    return user + " has been greeted "+ rs.getInt("counter") + " time(s)";
            }


        } catch (SQLException e) {
            e.printStackTrace();

        }
        return user + " has been greeted 0 time(s)" ;
    }

    @Override
    public void exit() {
        System.exit(0);
    }


}
