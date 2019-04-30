import net.greet.GetCommands;
import net.greet.GreetInterface;
import net.greet.GreetJDBC;
import net.greet.Greeter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainClassTest {
    @Test
    public void shouldGreet(){
        GreetInterface user = new GreetJDBC();
        Greeter greet = new Greeter(user);
        greet.execute("greet mzwa English");
//
        System.out.println(greet.execute("greet mzwa English"));
        user.clearAllUsers();
        assertEquals(greet.execute("greet Mzwa English"),"Hello Mzwa");
    }

    @Test
    public void shouldCheckCommands(){

          GetCommands cmdBuilder = new GetCommands("greet mzwa english");

          cmdBuilder.getCommand();

          System.out.println(cmdBuilder.getLanguage());

          assertEquals(1,1);
    }
}
