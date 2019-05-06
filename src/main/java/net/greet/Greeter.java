package net.greet;

import java.util.*;

public class Greeter {


    GreetInterface user;

    public Greeter(GreetInterface user){
        this.user = user;
    }


    public String execute(String command){

        CommandBuilder builder = new CommandBuilder(command); //USING THE COMMAND BUILDER

            try{
                if (builder.getCommand().equalsIgnoreCase("greet") && builder.store.length ==3 ) {
                    user.addUsers(builder.getUsername());
                    String language = builder.getLanguage();
                    if(language.equals("English") || language.equals("Afrikaans") || language.equals("IsiXhosa")){
                        return (Languages.valueOf(language).getNames(" " + builder.getUsername())) ;
                    }else
                        return "Choose language between English/Isixhosa/Afrikaans!";
                }
                else if (builder.getCommand().equalsIgnoreCase("greet") && builder.store.length == 2) {
                    user.addUsers( builder.getUsername() );
                    return "Hello "+ builder.getUsername();
                }
                else if (builder.getCommand().equalsIgnoreCase("greeted") && builder.store.length == 1 ) {
                    user.greetedUsers();
                }
                else if(builder.getCommand().equalsIgnoreCase("greeted") && builder.store.length == 2){
                    user.getCountForUser( builder.getUsername() );
                }
                else if (builder.getCommand().equalsIgnoreCase("counter") ) {
                    user.getCountForAllUsers();
                }
                else if (builder.getCommand().equalsIgnoreCase("clear") && builder.store.length == 1) {
                    user.clearAllUsers();
                }

                else if(builder.getCommand().equalsIgnoreCase("exit") ){
                    user.exit();
                }

                else if (builder.getCommand().equalsIgnoreCase("clear") && builder.store.length == 2) {
                    if(builder.getUsername().contentEquals(builder.getUsername())){
                        user.clearPerUser(builder.getUsername());
//                System.out.println(builder.getUsername() + " has been removed!");
                    }else
                        System.out.println(builder.getUsername() + " not available!");
                }


                else if (builder.getCommand().equalsIgnoreCase("help") && builder.store.length == 1) {
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
            }
            catch (NullPointerException ex){
                System.out.println(ex);
            }


        return " ";
    }

    public static void main(String args[]) {
        System.out.println("           Greetings In Java         ");
        System.out.println("  ___________________________________");
        System.out.println("       e.g 'Greet Shawn IsiXhosa'    ");
        System.out.println("  ___________________________________");

            Scanner userText = new Scanner(System.in);

            GreetInterface greet = new GreetJDBC(); //---- Interface >> db
//            Greet greet = new Greet();
            Greeter greetings = new Greeter(greet);


            System.out.println("Enter a command: " );

            while (true) {
                String newCOmmand = userText.nextLine();
                System.out.println(greetings.execute(newCOmmand));

            }
        }
    }

