package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExecutorTest {

    @Test
    public void shouldGreetShawnInEnglish(){
        Executor greet = new Executor(new GreetJDBC());

        CommandBuilder commandBuilder = new CommandBuilder("greet shawn english");

        assertEquals(greet.execute(commandBuilder),"Hello Shawn");
    }


}
