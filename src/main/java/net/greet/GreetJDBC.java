package net.greet;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class GreetJDBC implements GreetInterface {
    private Connection conn;
    private String jdbcURL = "jdbc:h2:file:./target/greetings-in-java";
    private final String username = "";
    private final String password = "";
    private PreparedStatement rsCheck,ps_Insert,ps, ps_counter ,ps_DELETE,REMOVE_USER,COUNT;
    private final String INSERT_USERNAMES,UPDATE_COUNTER,SELECT_USERS,CLEAR_EVERYONE,REMOVE_ONE,COUNT_PER_PERSON;

    public GreetJDBC(){
         conn = getConnection();
         INSERT_USERNAMES = "insert into users(name,counter) values(?,?)";
         UPDATE_COUNTER = "update users set counter = counter + 1 where name = ?";
         SELECT_USERS = "select * from users";
         CLEAR_EVERYONE = "delete from users";
         REMOVE_ONE = "delete from users where name = ? ";
         COUNT_PER_PERSON = "select * from users where name = ?";

        try {
             ps_Insert = conn.prepareStatement(INSERT_USERNAMES);
             rsCheck = conn.prepareStatement("select * from users where name = ?");
             ps = conn.prepareStatement(SELECT_USERS);
             ps_counter = conn.prepareStatement(UPDATE_COUNTER);

            ps_DELETE = conn.prepareStatement(CLEAR_EVERYONE);
             REMOVE_USER = conn.prepareStatement(REMOVE_ONE);
             COUNT = conn.prepareStatement(COUNT_PER_PERSON);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
            rsCheck.setString(1,name);

            ResultSet rs = rsCheck.executeQuery();
                if (!rs.next()){
                    ps_Insert.setString(1,name);
                    ps_Insert.setInt(2,1);
                    ps_Insert.execute();
                }else{
                    ps_counter.setString(1,name);
                    ps_counter.execute();
                }
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Map<String, Integer> greetedUsers() {
        final Map<String, Integer> greetedUser = new HashMap<>();
            try {
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
        try {
            ps_DELETE.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public  String clearPerUser(String user) {
        try {
            REMOVE_USER.setString(1,user);
            REMOVE_USER.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return greetedUsers().toString();
    }

    @Override
    public String getCountForUser(String user){
        try {
            COUNT.setString(1,user);
            ResultSet rs = COUNT.executeQuery();
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
