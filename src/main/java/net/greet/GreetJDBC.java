package net.greet;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class GreetJDBC implements GreetInterface {
    Connection conn;
    String jdbcURL = "jdbc:h2:file:./target/greetings-in-java";
    final String username = "";
    final String password = "";
    final Map<String, Integer> greetedUser = new HashMap<>();


    public Connection getConnection() {
        conn = null;

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
        name = name.substring(0,1).toUpperCase().charAt(0) + name.substring(1);

        try{
            conn = getConnection();
            final String INSERT_USERNAMES = "insert into users(name,counter) values(?,?)";
            final String UPDATE_COUNTER = "update users set counter = counter + 1 where name = ?";

            PreparedStatement ps_Insert = conn.prepareStatement(INSERT_USERNAMES);
            PreparedStatement rsCheck = conn.prepareStatement("select * from users where name = ?");
            rsCheck.setString(1,name);
            rsCheck.execute();

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

            try {
                Statement stmnt = conn.createStatement();
                ResultSet rs = stmnt.executeQuery("select * from users");
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
        conn = getConnection();

        return greetedUser.size();
    }

    @Override
    public void clearAllUsers() {
        conn = getConnection();
        String CLEAR_EVERYONE = "delete from users";

        try {
            PreparedStatement psClear = conn.prepareStatement(CLEAR_EVERYONE);
            psClear.execute();
            greetedUser.clear();

        } catch (SQLException e) {
            e.printStackTrace();
        }
            greetedUser.clear();
    }

    @Override
    public  String clearPerUser(String user) {
        user = user.substring(0,1).toUpperCase().charAt(0) + user.substring(1);
        conn = getConnection();
        String remove_one = "delete from users where name = ? ";

        try {
            PreparedStatement remove_user = conn.prepareStatement(remove_one);
            remove_user.setString(1,user);
            remove_user.execute();
            greetedUser.remove(user);

        } catch (SQLException e) {
            e.printStackTrace();
        }

         return greetedUser.toString();
    }

    @Override
    public String getCountForUser(String user){
        user = user.substring(0,1).toUpperCase().charAt(0) + user.substring(1);
        conn = getConnection();
        String count_per_user = "select count(*) from users where name = ?";

        try {
            PreparedStatement count = conn.prepareStatement(count_per_user);
            count.setString(1,user);
            count.execute();

            if(greetedUser.containsKey(user)){
                return user + " has been greeted "+ greetedUser.get(user) + " time(s)";
            }else
            return user + " has been greeted " + 0 + " time(s)";


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user + " has been greeted "+ greetedUser.get(user) + " time(s)" ;
    }

    @Override
    public void exit() {
        System.exit(0);
    }


}
