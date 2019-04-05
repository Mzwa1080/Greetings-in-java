import greet.Greet;
import greet.Greeter;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetTest<before> {

    @Test
    public void greetUsers() {
        Greet name = new Greet("Mzwa", "IsiXhosa");
        assertEquals("Molo Mzwa!", name.greetInLanguage());
    }

    @Test
    public void addUsersAndCountEveryUser(){
        Greeter user = new Greeter();
         user.addUsers("Mzwa");
         user.addUsers("Ben");
         user.addUsers("Steve");

        assertEquals(user.getCountForAllUsers(),3);
    }

//    @Test
//    public void countEveryone(){
//        Greeter user1 = new Greeter();
//        user1.addUsers("Mzwa");
//        user1.addUsers("Mzwa");
//        user1.addUsers("Mzwa");
//        user1.addUsers("Mzwa");
//
//        user1.addUsers("Bhuta");
//        user1.addUsers("Shawn");
//        user1.addUsers("Tzoo");
//
////        System.out.println(user1.addUsers("Mzwa")); //Checking how many users are there
////        System.out.println(user1.getCountForAllUsers());
//
//        assertEquals(user1.getCountForAllUsers(),4);
//    }

//    ------ VALUES OF THE >>>>>>>>USERS<<<<<<<<<<<<<<
    @Test
    public void howManyTimesSingleUserRepeated(){
        Greeter user1 = new Greeter();
        user1.addUsers("Mzwa");
        user1.addUsers("Mzwa");
        user1.addUsers("Mzwa");
        user1.addUsers("Mzwa");
        user1.addUsers("Tzoo");

        System.out.println(user1.getCountForUser("Mzwa"));
        assertEquals(user1.getCountForUser("Mzwa"),4);
    }


    @Test
    public void clearAllUsers(){
        Greeter clearUsers = new Greeter();
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
        Greeter clearUser = new Greeter();
        clearUser.addUsers("Mzwa");
        clearUser.addUsers("Shawn");
        clearUser.addUsers("Sakhi");

        clearUser.clearPerUser("Mzwa");
//        System.out.println(clearUser.clearPerUser("Mzwa"));
//        System.out.println(clearUser.getCountForAllUsers());
        assertEquals(clearUser.getCountForAllUsers(),2);
    }

//    @Test
//    public void clearUserValue(){
//        Greeter clearValue  = new Greeter();
//        clearValue.addUsers("Mzwa");
//        clearValue.addUsers("Mzwa");
//        clearValue.addUsers("Mzwa");
//        clearValue.addUsers("Shawn");
//        clearValue.addUsers("Shawn");
//
//        System.out.println(clearValue.clearUsersValue("Mzwa"));
//        System.out.println(clearValue.clearUsersValue("Mzwa"));
//
//
//        assertEquals(1,1);
//    }

}