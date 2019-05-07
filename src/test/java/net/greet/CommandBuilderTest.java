package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandBuilderTest {

    @Test
    void getCommand() {
        CommandBuilder commandBuilder = new CommandBuilder("greet yegan venda");

        assertEquals("Greet", commandBuilder.getCommand());
        assertEquals("Yegan", commandBuilder.getUsername());
        assertEquals("Venda", commandBuilder.getLanguage());
    }

    @Test
    void getCommand_2() {
        CommandBuilder commandBuilder = new CommandBuilder("greet yegan");

        assertEquals("Greet", commandBuilder.getCommand());
        assertEquals("Yegan", commandBuilder.getUsername());
        assertEquals("Zulu", commandBuilder.getLanguage());
    }

    @Test
    void getCommand_3() {
        CommandBuilder commandBuilder = new CommandBuilder("greet");

        assertEquals("Greet", commandBuilder.getCommand());
        assertEquals("", commandBuilder.getUsername());
        assertEquals("Zulu", commandBuilder.getLanguage());
    }

    @Test
    void getCommandGreeted() {
        CommandBuilder commandBuilder = new CommandBuilder("greeted yegan");

        assertEquals("Greeted", commandBuilder.getCommand());
        assertEquals("Yegan", commandBuilder.getUsername());
    }

    @Test
    void ggetCommandGreeted_2() {
        CommandBuilder commandBuilder = new CommandBuilder("greeted");

        assertEquals("Greeted", commandBuilder.getCommand());
        assertEquals("", commandBuilder.getUsername());
        assertEquals("Zulu", commandBuilder.getLanguage());
    }

    @Test
    void getCommandGreeted_3() {
        CommandBuilder commandBuilder = new CommandBuilder("clear yegan");

        assertEquals("Clear", commandBuilder.getCommand());
        assertEquals("Yegan", commandBuilder.getUsername());
        assertEquals("Zulu", commandBuilder.getLanguage());
    }

    @Test
    void hasName(){
        CommandBuilder commandBuilder = new CommandBuilder("clear yegan");

        assertEquals(commandBuilder.hasName(), true);

    }

    @Test
    void hasNameFalse(){
        CommandBuilder commandBuilder = new CommandBuilder("clear");
        assertEquals(commandBuilder.hasName(), false);

    }
}