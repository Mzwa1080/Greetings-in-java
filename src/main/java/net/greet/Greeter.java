package net.greet;

import java.util.*;

public class Greeter {
    private String userName,lang;
    private Map<String, Integer> users;
    private int count;

    public Greeter(String name, String language){
        userName = name;
        lang = language;
        users = new HashMap<String, Integer>();
    }


    public static void main(String args[]) {

        try {
            Scanner userText = new Scanner(System.in);
            GreetInterface user = new GreetJDBC("jdbc:h2:file:./target/greetings-in-java");
//            Greet user = new Greet();


            System.out.println("Greet _name_ _language_ e.g 'Greet Shawn IsiXhosa'");
            System.out.println("Enter a command: " );

            while (true) {
                String name = userText.nextLine();
                String[] store = name.split(" ");
                try{
                    if (store[0].equalsIgnoreCase("greet") && store.length == 3) { //3 commands
                        user.addUsers(store[1]);
                        String language = store[2];
                        try{
                            System.out.println(Languages.valueOf(language).getNames(" " + store[1]));
                        }catch(IllegalArgumentException ex){
                            ex.printStackTrace();
                        }
                    } else if (store[0].equalsIgnoreCase("greet") && store.length == 1) {
                        System.out.println("Greet who in which language between IsiXhosa/English/Afrikaans?");
                    } else if (store[0].equalsIgnoreCase("greet") && store.length == 2) {
                        System.out.println("Greet " + store[1].toUpperCase() + " in Which Language?");
                    } else if (store[0].equalsIgnoreCase("greeted") && store.length == 1) {
                        user.greetedUsers();
                    }
                    else if(store[0].equalsIgnoreCase("greeted") && store.length == 2){
                        user.getCountForUser( store[1] ); //I CAN'T IGNORECASE FOR NAME ENTERED
                    }
                    else if (store[0].equalsIgnoreCase("counter") && store.length == 1) {
                        user.getCountForAllUsers();
                    } else if (store[0].equalsIgnoreCase("clear") && store.length == 1) {
                        user.clearAllUsers();
                        System.out.println("All users are cleared");
                    } else if (store[0].equalsIgnoreCase("remove") && store.length == 2) {
                        user.clearPerUser(store[1]);
                        System.out.println(store[1] + " has been removed!");
                    } else if (store[0].equalsIgnoreCase("exit") && store.length == 1) {
//                        user.out();
                        userText.close();
                    } else if (store[0].equalsIgnoreCase("help") && store.length == 1) {
                        System.out.println("-*-*-Available Commands-*-*-");
                        System.out.println("Command : 'Greet' _Name_ _Language_ <");
                        System.out.println("Command : 'Greeted' -Returns all names");
                        System.out.println("Command : 'Clear' -Clears everyone");
                        System.out.println("Command : 'Clear _name_ - Clear the _name_");
                        System.out.println("Command : 'Exit' -Exits");
                    } else if(userText == null){
                        try{
                            userText.close();

                        }catch (IllegalArgumentException ex){
                            ex.printStackTrace();
                        }
                    }

                    else {
                        System.out.println("Invalid Command(s)--- Type 'Help' for info");
                    }
                }catch(IllegalArgumentException e){
                        e.printStackTrace();
                }


            }

        } catch (IllegalStateException e){
            System.out.println(e);
        }



    }
}
