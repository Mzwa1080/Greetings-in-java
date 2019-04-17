package net.greet;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class GreetJDBC implements GreetInterface {
    Connection conn;
    final String jdbcURL = "jdbc:h2:file:./db/greetings-in-java";
    final String username = "";
    final String password = "";
    final Map<String, Integer> greetedUser = new HashMap<>();


    public void registerConnection(){
        try {
            Class.forName("org.h2.Driver"); //registers a connection of db with driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connect;

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
            rsCheck.setString(1,name);
            rsCheck.execute();

            ResultSet rs = rsCheck.executeQuery();

                if (!rs.next()){
                    ps_Insert.setString(1,name);
                    ps_Insert.setInt(2,1);
                    ps_Insert.execute();

                }else{
                    PreparedStatement ps_counter = conn.prepareStatement(UPDATE_COUNTER);
//                    ps_counter.setInt(1, +1);
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
                    System.out.println(greetedUser);
//                    return greetedUser;
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

            while (rs.next()){
                System.out.println(rs.getString("name"));
                System.out.println(greetedUser.remove(user));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



    @Override
    public void out() {

    }

}
