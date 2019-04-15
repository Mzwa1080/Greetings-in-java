package net.greet;

import java.sql.*;

public class GreetJDBC implements GreetInterface {
    Connection conn;
    final String jdbcURL = "jdbc:h2:file:./db/greetings-in-java";
    final String username = "";
    final String password = "";


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
            Connection conn = getConnection();
            final String INSERT_USERNAMES = "insert into users(name,counter) values(?,?)";


            PreparedStatement ps = conn.prepareStatement(INSERT_USERNAMES);
            ps.setString(1,name.toString());
            ps.setInt(2,1);
            ps.execute();
            //System.out.println(ps);

//            Statement stmt = conn.createStatement();
            ResultSet rs = conn.createStatement().executeQuery("select * from users");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }


        } catch(SQLException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void greetedUsers() {

            try {
                Connection conn =  getConnection();
                Statement stmnt = conn.createStatement();
                ResultSet rs = stmnt.executeQuery("select name from users");
                rs.getString("name");
                System.out.println(rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    @Override
    public void getCountForAllUsers() {

    }

    @Override
    public void clearAllUsers() {

    }

    @Override
    public void clearPerUser(String user) {

    }



    @Override
    public void out() {

    }

}
