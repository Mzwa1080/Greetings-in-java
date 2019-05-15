package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExecutorTest {

    @Test
    public void shouldGreetShawn(){
        Executor greet = new Executor(new GreetJDBC());

        CommandBuilder commandBuilder = new CommandBuilder("greet shawn english");

        System.out.println(greet.execute(commandBuilder));

        assertEquals(greet.execute(commandBuilder),"Hello Shawn");
    }

    @Test
    public void shouldShowGreetedUsers(){
        Executor greet = new Executor(new GreetJDBC());

        CommandBuilder commandBuilder = new CommandBuilder("greet shawn");
        System.out.println(greet.execute(commandBuilder));
//        assertEquals(greet.execute(commandBuilder),"Hello Shawn");
    }
}
