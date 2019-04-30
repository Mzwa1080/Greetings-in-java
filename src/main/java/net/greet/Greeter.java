package net.greet;

import java.util.*;

public class Greeter {


    GreetInterface user;
    GetCommands builder;

    public Greeter(GreetInterface user){
    this.user = user;
    }

    public String execute(String command){

        GetCommands builder = new GetCommands(command); //USING THE COMMAND BUILDER/GET COMMANDS CLASS

        if (builder.getCommand().equalsIgnoreCase("greet") && builder.store.length == 3) { //3 commands
            user.addUsers(builder.getUsername());
            String language = builder.getLanguage();
            if(language.equals("English") || language.equals("Afrikaans") || language.equals("IsiXhosa")){
                return (Languages.valueOf(language).getNames(" " + builder.getUsername()));
            }
            else{
                return ("Please use a valid language....Between English/IsiXhosa/Afrikaans");
            }
        } else if (builder.getCommand().equalsIgnoreCase("greet") && builder.store.length == 2) {
            user.addUsers( builder.getCommand());
            return "Hello "+ builder.getUsername();
        }
        else if (builder.getCommand().equalsIgnoreCase("greeted") && builder.store.length == 1) {
            user.greetedUsers();
        }
        else if(builder.getCommand().equalsIgnoreCase("greeted") && builder.store.length == 2){
            user.getCountForUser( builder.getUsername() ); //I CAN'T IGNORECASE FOR NAME ENTERED
        }
//        else if (store[0].equalsIgnoreCase("counter")) {
//            user.getCountForAllUsers();
//        }
        else if (builder.getCommand().equalsIgnoreCase("clear") && builder.store.length == 1) {
            user.clearAllUsers();
            System.out.println("All users are cleared");
        }
//        else if (store[0].equalsIgnoreCase("clear") && store.length == 2) {
//            if(store[1].contentEquals(store[1])){
//                user.clearPerUser(store[1]);
//                System.out.println(store[1].toUpperCase().substring(0,1).charAt(0) + store[1].substring(1) + " has been removed!");
//            }else
//                System.out.println(store[1].toUpperCase().substring(0,1).charAt(0) + store[1].substring(1) + " not removed!");;
//        }
//        else if (store[0].equalsIgnoreCase("exit") && store.length == 1) {
//            System.out.println("Signing out!!!");
//            userText.close();
//        }
//        else if (store[0].equalsIgnoreCase("help") && store.length == 1) {
//            System.out.println(" ______________________Available Commands__________________________");
//            System.out.println("|__________________________________________________________________|");
//            System.out.println("|Available Languages: IsiXhosa,English,Afrikaans");
//            System.out.println("|__________|_______________________________________________________|");
//            System.out.println("|Command : |    [Greet Mzwa + English] ");
//            System.out.println("|__________|_______________________________________________________|");
//            System.out.println("|Command : |    [Greeted] - Returns all names");
//            System.out.println("|__________|_______________________________________________________|");
//            System.out.println("|Command : |[Greeted Mzwa] - Returns how many times Mzwa greeted");
//            System.out.println("|__________|_______________________________________________________|");
//            System.out.println("|Command : |    [Clear] - Clears everyone");
//            System.out.println("|__________|_______________________________________________________|");
//            System.out.println("|Command : |    [Clear Mzwa] - Clears' Mzwa");
//            System.out.println("|__________|_______________________________________________________|");
//            System.out.println("|Command : |    [Exit] - Exits and Stops the program");
//            System.out.println("|__________|_______________________________________________________|");
//
//        }

        else {
            if(builder.getCommand().isEmpty()){
//                            System.out.println();
            }
            else if(builder.store.length > 0){
                return "Invalid command type 'help' for available commands!";
            }
        }
        return "Type 'HELP' for more guidance/commands";
    }
    public static void main(String args[]) {
        System.out.println(" _____________________________________");
        System.out.println("|           Greetings In Java         |");
        System.out.println("|_____________________________________|");
        System.out.println("|       e.g 'Greet Shawn IsiXhosa'    |");
        System.out.println("|_____________________________________|");
        try {

            Scanner userText = new Scanner(System.in);

            GreetInterface user = new GreetJDBC(); //---- Interface >> db

            Greeter greetings = new Greeter(user);


            System.out.println("Enter a command: " );

            while (true) {
                String newCOmmand = userText.nextLine();
                greetings.execute(newCOmmand);
            }

        } catch (IllegalStateException e){
            System.out.println(e);
        }



    }
}
