//import net.greet.CommandBuilder;
//import net.greet.GreetInterface;
//import net.greet.GreetJDBC;
//import net.greet.Greeter;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//
//public class MainClassTest {
//    @Test
//    public void shouldGreetInEnhglish(){
//        GreetInterface user = new GreetJDBC();
//        Greeter greet = new Greeter(user);
//        greet.execute("greet mzwa English");
////
//        System.out.println(greet.execute("greet mzwa English"));
//        user.clearAllUsers();
//        assertEquals(greet.execute("greet Mzwa English"),"Hello Mzwa");
//    }
//
//    @Test
//    public void shouldGreetInIsiXhosa(){
//        GreetInterface user = new GreetJDBC();
//        Greeter greet = new Greeter(user);
//        greet.execute("greet Bhuta isixhosa");
//        user.clearAllUsers();
//        assertEquals(greet.execute("greet Bhuta IsiXhosa"),"Molo Bhuta");
//    }
//
//    @Test
//    public void shouldGreetInAfrikaans(){
//        GreetInterface user = new GreetJDBC();
//        Greeter greet = new Greeter(user);
//        greet.execute("greet Bhuta isixhosa");
//        user.clearAllUsers();
//        assertEquals(greet.execute("greet Bhuta Afrikaans"),"Goeie dag Bhuta");
//    }
//
//
//    @Test
//    public void shouldCheckGreetCommand(){
//        CommandBuilder command = new CommandBuilder("greet Shawn english");
//        assertEquals("Greet",command.getCommand());
//    }
//
//    @Test
//    public void shouldCheckLanguageCommand(){
//          CommandBuilder cmdBuilder = new CommandBuilder("greet Mzwa english");
//          assertEquals("English",cmdBuilder.getLanguage());
//    }
//
//    @Test
//    public void shouldCheckUsernameCommand(){
//        CommandBuilder command = new CommandBuilder("greeted Mzwa English");
//        assertEquals("Mzwa", command.getUsername());
//    }
//
////    @Test
////    public void shouldGetTheBooleanTypeOfHasName(){
//////        GreetInterface user = new GreetJDBC();
//////        Greeter greet = new Greeter/(user);
////////        greet.execute("greet mzwa english");
////        CommandBuilder greet = new CommandBuilder("greet shawn english");
////
////        System.out.println();
////        System.out.println(greet.hasName(greet.getUsername()));
////
////
////
////        assertEquals(1,1);
////    }
////
////    @Test
////    public void shouldReturnTrueIFTypeOfLanguageIsAvailable(){
////        CommandBuilder greet = new CommandBuilder("greet Sipho afrikaans");
////
////        System.out.println(greet.hasLanguage(greet.getLanguage()));
////
////        assertEquals(1,1);
////    }
//}
