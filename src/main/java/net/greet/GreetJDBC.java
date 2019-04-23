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


//    public GreetJDBC(String jdbcURL) {
//        this.jdbcURL = jdbcURL;
//    }

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
        try{
            conn = getConnection();
            final String INSERT_USERNAMES = "insert into users(name,counter) values(?,?)";
            final String UPDATE_COUNTER = "update users set counter = counter + 1 where name = ?";


            PreparedStatement ps_Insert = conn.prepareStatement(INSERT_USERNAMES);
//            Statement stmt = conn.createStatement();
            PreparedStatement rsCheck = conn.prepareStatement("select * from users where name = ?");
            rsCheck.setString(1,name.substring(0,1).toUpperCase().charAt(0) + name.substring(1));
            rsCheck.execute();

            ResultSet rs = rsCheck.executeQuery();

                if (!rs.next()){
                    ps_Insert.setString(1,name.substring(0,1).toUpperCase().charAt(0) + name.substring(1));
                    ps_Insert.setInt(2,1);
                    ps_Insert.execute();

                }else{
                    PreparedStatement ps_counter = conn.prepareStatement(UPDATE_COUNTER);
//                    ps_counter.setInt(1, +1);
                    ps_counter.setString(1,name.substring(0,1).toUpperCase().charAt(0) + name.substring(1));
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
                    System.out.println(greetedUser);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        return greetedUser;
    }

    @Override
    public void getCountForAllUsers() {
        conn = getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rsCountEveryOne = stmt.executeQuery("select count(*) from users");

            while(rsCountEveryOne.next()){
                System.out.println(greetedUser.size());

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void clearAllUsers() {
        conn = getConnection();
        String CLEAR_EVERYONE = "delete from users";

        try {
            PreparedStatement psClear = conn.prepareStatement(CLEAR_EVERYONE); //psClear ---> uses/holds the query
            psClear.execute(); //clear from db
            greetedUser.clear(); //clear from map

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearPerUser(String user) {
        conn = getConnection();
        String remove_one = "delete from users where name = ? ";

        String select_user = "select * from users";

        try {
            PreparedStatement remove_user = conn.prepareStatement(remove_one);
            remove_user.setString(1,user);
            remove_user.execute();

            PreparedStatement check_user = conn.prepareStatement(select_user);
            ResultSet rs = check_user.executeQuery();
//
//            while (rs.next()){
//                System.out.println(greetedUser.remove(user));
//            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void getCountForUser(String user) {
        conn = getConnection();
        String count_per_user = "select count(*) from users where name = ?";
        String get_user = "select * from users";

        try {
            PreparedStatement count = conn.prepareStatement(count_per_user);
            count.setString(1,user.substring(0,1).toUpperCase().charAt(0) + user.substring(1));
            count.execute();

            PreparedStatement check = conn.prepareStatement(get_user);
            ResultSet rs = check.executeQuery();
//            while (rs.next()){
                System.out.println(user.substring(0,1).toUpperCase().charAt(0) + user.substring(1) + " has been greeted "+ greetedUser.get(user) + " time(s)");
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void out() {

    }

}
