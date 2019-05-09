package net.greet;

import java.util.*;

public class Greeter {


    GreetInterface user;

    public Greeter(GreetInterface user){
        this.user = user;
    }


    public String execute(String command){

        CommandBuilder builder = new CommandBuilder(command); 
                if("greet".equalsIgnoreCase(builder.getCommand()) && builder.hasName() ) {
                    user.addUsers(builder.getUsername());
                    return Languages.valueOf(builder.getLanguage()).getNames(" " + builder.getUsername());
                }
                else if("greeted".equalsIgnoreCase(builder.getCommand())){
                    if (!builder.hasName()){
                        user.greetedUsers();
                    }else{
                        user.getCountForUser(builder.getUsername());
                    }
                }
                else if ("counter".equalsIgnoreCase(builder.getCommand())){
                    user.getCountForAllUsers();
                }
                else if("clear".equalsIgnoreCase(builder.getCommand())){
                    if(builder.hasName()){
                        user.clearPerUser(builder.getUsername());
                    }else
                        user.clearAllUsers();
                }
                else if("exit".equalsIgnoreCase(builder.getCommand())){
                    user.exit();
                }
                else if ("help".equalsIgnoreCase(builder.getCommand())) {
                    System.out.println(" ______________________Available Commands__________________________");
                    System.out.println("|Available Languages: IsiXhosa,English,Afrikaans");
                    System.out.println("|Command : |    [Greet name + English] ");
                    System.out.println("|Command : |    [Greeted] - returns all names");
                    System.out.println("|Command : |[Greeted name] - returns how many times name greeted");
                    System.out.println("|Command : |    [Clear] - clears everyone");
                    System.out.println("|Command : |    [Clear name] - clears name");
                    System.out.println("|Command : |    [Exit] - exits and stops the program");
                    System.out.println("|__________|_______________________________________________________");
                }
                else
                    return "Type 'HELP' for more guidance/commands";

        return " ";
    }

    public static void main(String args[]) {
        System.out.println("           Greetings In Java         ");
        System.out.println("  ___________________________________");
        System.out.println("       e.g 'Greet Shawn IsiXhosa'    ");
        System.out.println("  ___________________________________");

        Scanner userText = new Scanner(System.in);
        GreetInterface greet = new GreetJDBC();
//      Greet greet = new Greet();
        Greeter greetings = new Greeter(greet);

        System.out.println("Enter a command: " );

        while (true) {
            String newCOmmand = userText.nextLine();
            System.out.println(greetings.execute(newCOmmand));
            }
        }
    }

