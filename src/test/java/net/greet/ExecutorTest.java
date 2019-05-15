package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExecutorTest {

    @Test
    public void shouldGreetShawnInEnglish(){
        Executor greet = new Executor(new GreetJDBC());

        CommandBuilder commandBuilder = new CommandBuilder("greet shawn english");

        System.out.println(greet.execute(commandBuilder));

        assertEquals(greet.execute(commandBuilder),"Hello Shawn");
    }


    @Test
    public void shouldShowGreetedUsers(){
        Executor greet = new Executor(new GreetJDBC());

        CommandBuilder commandBuilder = new CommandBuilder("greeted shawn");
//        System.out.println(commandBuild);
        assertEquals(greet.execute(commandBuilder), "Goeie dag Shawn");
    }
}
