import greet.Greet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetTest {

    @Test
    public void insertNames() {
        Greet name = new Greet("Mzwa", "IsiXhosa");
        System.out.println(name.greetInLanguage());
        assertEquals(1, 1);

    }
}