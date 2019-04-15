import net.greet.Greet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GreetTest {

//    @Test
//    public void greetUsersInIsixhosa() {
//        Greet name = new Greet("Mzwa", "IsiXhosa");
//        assertEquals("Molo Mzwa!", name.greetInLanguage());
//    }
//
//    @Test
//    public void greetUserInEnglish(){
//        Greet greetInEnglish = new Greet("Shawn", "English");
//        assertEquals("Hello Shawn!", greetInEnglish.greetInLanguage());
//    }
//
//    @Test
//    public void greetUserInAfrikaans(){
//        Greet greetInAfrikaans = new Greet("Mzwa", "Afrikaans");
//        assertEquals("Goeie dag Mzwa!", greetInAfrikaans.greetInLanguage());
//    }

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

        assertEquals(user1.getCountForUser("Mzwa"),4);
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
//        System.out.println(clearUser.clearPerUser("Mzwa"));
//        System.out.println(clearUser.getCountForAllUsers());
        assertEquals(clearUser.getCountForAllUsers(),2);
    }

//    @Test
//    public void clearUserValue(){
//        Greet clearValue  = new Greet();
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