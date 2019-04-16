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
            final String UPDATE_COUNTER = "update users set counter = counter + 1 where name = ?";


            PreparedStatement ps_Insert = conn.prepareStatement(INSERT_USERNAMES);
            Statement stmt = conn.createStatement();
            ResultSet rsCheck = stmt.executeQuery("select * from users");


                if (!rsCheck.next()){
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
    public void greetedUsers() {
        Connection conn =  getConnection();

            try {
                Statement stmnt = conn.createStatement();
                ResultSet rs = stmnt.executeQuery("select * from users");
                while(rs.next()){
                    System.out.println("NAME_COUNT : ---> " + rs.getInt("counter"));
                    System.out.println("NAME : ---------> "+ rs.getString("name"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    @Override
    public void getCountForAllUsers() {
//        conn = getConnection();
//        try {
//            Statement stmt = conn.createStatement();
//            ResultSet rsCountEveryOne = stmt.executeQuery("select count(counter) from users");
//
//            while(rsCountEveryOne.next()){
//                System.out.println(rsCountEveryOne.getInt("counter"));
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
    }

    @Override
    public void clearAllUsers() {
        conn = getConnection();
        String CLEAR_EVERYONE = "delete from users";

        try {
            PreparedStatement psClear = conn.prepareStatement(CLEAR_EVERYONE); //psClear ---> uses/holds the query
            psClear.execute(); //runs it/ clears



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearPerUser(String user) {

    }



    @Override
    public void out() {

    }

}
