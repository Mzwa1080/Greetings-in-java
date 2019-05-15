package net.greet;

import java.util.*;

public class Greeter {

    private static GreetInterface greet;

    private GreetInterface user;

    private Executor execute;

    public Greeter(GreetInterface user){
        this.user = user;
    }


    public static void main(String args[]) {
        System.out.println("           Greetings In Java         ");
        System.out.println("  ___________________________________");
        System.out.println("       e.g 'Greet Shawn IsiXhosa'    ");
        System.out.println("  ___________________________________");

        Scanner userText = new Scanner(System.in);
         greet = new GreetJDBC();
//         greet = new Greet();
        Greeter greetings = new Greeter(greet);

        while (true) {
            System.out.println("Enter a command:" );
            String userCommand = userText.nextLine();

            CommandBuilder commandBuilder = new CommandBuilder(userCommand);

            System.out.println(greetings.execute.execute( commandBuilder ) );
            }
        }
}

