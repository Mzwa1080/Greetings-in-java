package net.greet;

import java.util.*;

public class Greeter {


    GreetInterface user;

    public Greeter(GreetInterface user){
        this.user = user;
    }


    public String execute(String command){

        CommandBuilder builder = new CommandBuilder(command); //USING THE COMMAND BUILDER/GET COMMANDS CLASS

//            try{
                if (builder.getCommand().equalsIgnoreCase("greet") && builder.store.length == 3) { //3 commands
                    user.addUsers(builder.getUsername());
                    String language = builder.getLanguage();
                    if(language.equals("English") || language.equals("Afrikaans") || language.equals("IsiXhosa")){
                        return (Languages.valueOf(language).getNames(" " + builder.getUsername())) ;
                    }
                }
                else if (builder.getCommand().equalsIgnoreCase("greet") && builder.store.length == 2) {
                    user.addUsers( builder.getUsername() );
                    return "Hello "+ builder.getUsername();
                }
                else if (builder.getCommand().equalsIgnoreCase("greeted") ) {
                    user.greetedUsers();
                }
                else if(builder.getCommand().equalsIgnoreCase("greeted") && builder.store.length == 1){
                    user.getCountForUser( builder.getUsername() );
                }
                else if (builder.getCommand().equalsIgnoreCase("counter")) {
                    user.getCountForAllUsers();
                }
                else if (builder.getCommand().equalsIgnoreCase("clear") && builder.store.length == 1) {
                    user.clearAllUsers();
                }

                else if(builder.getCommand().equalsIgnoreCase("exit")){
                    System.out.println("BYE");
                }

//                else if (builder.getCommand().equalsIgnoreCase("clear") && builder.store.length == 2) {
//                    if(builder.getUsername().contentEquals(builder.getUsername())){
//                        user.clearPerUser(builder.getUsername());
////                System.out.println(builder.getUsername() + " has been removed!");
//                    }else
//                        System.out.println(builder.getUsername() + " not available!");
//                }

//        else if (builder.getCommand().equalsIgnoreCase("exit") && builder.store.length == 1) {
//            System.out.println("Signing out!!!");
//
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

//                else {
//                    if(builder.getCommand().isEmpty()){
////                            System.out.println();
//                    }
//                    else if(builder.store.length > 0){
//                        return "Invalid command type 'help' for available commands!";
//                    }
//                }

                else
                    return "Type 'HELP' for more guidance/commands";
//            }
//            catch (NullPointerException ex){
//                System.out.println();
//            }


        return "LAST RETURN PART WHICH I'M ON IT!!!";
    }

    public static void main(String args[]) {
        System.out.println(" _____________________________________");
        System.out.println("|           Greetings In Java         |");
        System.out.println("|_____________________________________|");
        System.out.println("|       e.g 'Greet Shawn IsiXhosa'    |");
        System.out.println("|_____________________________________|");

            Scanner userText = new Scanner(System.in);

            GreetInterface user = new GreetJDBC(); //---- Interface >> db

            Greeter greetings = new Greeter(user);


            System.out.println("Enter a command: " );

            while (true) {
                String newCOmmand = userText.nextLine();
                greetings.execute(newCOmmand);

//                if(greetings.execute(newCOmmand).contains(newCOmmand)){
                    System.out.println(greetings.execute(newCOmmand));

//                }else if (greetings.execute(newCOmmand).contains("exit")){
//                    break;
//                }
            }

        }

    }

