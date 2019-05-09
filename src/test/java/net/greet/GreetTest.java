package net.greet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GreetTest {

    @Test
    public void getAllUsers(){
        Greet user = new Greet();
        user.addUsers("Mzwa");
    }
    @Test
    public void addUsersAndCountEveryUser(){
        Greet user = new Greet();
         user.addUsers("Mzwa");
         user.addUsers("Ben");
         user.addUsers("Steve");

        assertEquals(user.getCountForAllUsers(),3);
    }
    @Test
    public void howManyTimesSingleUserRepeated(){
        Greet user1 = new Greet();
        user1.addUsers("Mzwa");
        user1.addUsers("Mzwa");
        user1.addUsers("Mzwa");
        user1.addUsers("Mzwa");
        user1.addUsers("Tzoo");

        assertEquals(user1.getCountForUser("Mzwa"),"Mzwa has been greeted 4");
    }
    @Test
    public void clearAllUsers(){
        Greet clearUsers = new Greet();
        clearUsers.addUsers("Shawn");
        clearUsers.addUsers("John");
        clearUsers.addUsers("Sakhi");
        clearUsers.addUsers("Mzwa");
        clearUsers.addUsers("Mzwa");

        clearUsers.clearAllUsers();

        assertEquals(clearUsers.getCountForAllUsers(), 0);
    }
    @Test
    public void clearUserEach(){
        Greet clearUser = new Greet();
        clearUser.addUsers("Mzwa");
        clearUser.addUsers("Shawn");
        clearUser.addUsers("Sakhi");

        clearUser.clearPerUser("Mzwa");

        assertEquals(clearUser.getCountForAllUsers(),2);
    }
}