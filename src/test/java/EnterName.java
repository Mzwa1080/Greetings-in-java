import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnterName {
    @Test
    public void insertNames(){
        Greet name = new Greet();

        System.out.println(name.getName(Collections.singletonList("Mzwa"), 5));
        System.out.println(name.getName(Collections.singletonList("Sbu"), 2));
//        System.out.println(name.getName(Collections.singletonList("MzWa"), 4));

        assertEquals(1,1);
    }
}
