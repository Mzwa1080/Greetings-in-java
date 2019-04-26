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
            GreetInterface user = new GreetJDBC();
//            Greet user = new Greet();


            System.out.println("Greet _name_ _language_ e.g 'Greet Shawn IsiXhosa'");
            System.out.println("Enter a command: " );

            while (true) {
                String name = userText.nextLine();
                String[] store = name.trim().split(" ");
//                try{
                    if (store[0].equalsIgnoreCase("greet") && store.length == 3) { //3 commands
                        user.addUsers(store[1]);
                        String language = store[2].substring(0,1).toUpperCase().charAt(0) + store[2].substring(1);

                        if(language.equals("English") || language.equals("Afrikaans") || language.equals("IsiXhosa")){
                            System.out.println(Languages.valueOf(language).getNames(" " + store[1]));
                        }
                        else{
                            System.out.println("Please use a valid language.... English,IsiXhosa & Afrikaans");
                        }
                    } else if (store[0].equalsIgnoreCase("greet") && store.length == 2 ) {
                        user.addUsers(store[1]);
                        System.out.println("Hello "+ store[1]);
                    }else if (store[0].equalsIgnoreCase("greet") && store.length == 1 ) {
                        System.out.println("Hello ");
                    }
                    else if (store[0].equalsIgnoreCase("greeted") && store.length == 1) {
                        user.greetedUsers();
                    } else if(store[0].equalsIgnoreCase("greeted") && store.length == 2){
                        user.getCountForUser( store[1] ); //I CAN'T IGNORECASE FOR NAME ENTERED
                    } else if (store[0].equalsIgnoreCase("counter")) {
                        user.getCountForAllUsers();
                    } else if (store[0].equalsIgnoreCase("clear") && store.length == 1) {
                        user.clearAllUsers();
                        System.out.println("All users are cleared");
                    } else if (store[0].equalsIgnoreCase("clear") && store.length == 2) {
                        if(store[1].contentEquals(store[1])){
                            user.clearPerUser(store[1]);
                            System.out.println(store[1].toUpperCase().substring(0,1).charAt(0) + store[1].substring(1) + " has been removed!");
                        }else
                            System.out.println(store[1].toUpperCase().substring(0,1).charAt(0) + store[1].substring(1) + " not removed!");;
                    } else if (store[0].equalsIgnoreCase("exit") && store.length == 1) {
                                System.out.println("Signing out!!!");
                                userText.close();
                    } else if (store[0].equalsIgnoreCase("help") && store.length == 1) {
                        System.out.println("-*-*-Available Commands-*-*-");
                        System.out.println("Command : 'Greet' Mzwa _English_ ");
                        System.out.println("Command : 'Greeted' - Returns all names");
                        System.out.println("Command : 'Greeted Mzwa' - Returns how many times Mzwa greeted");
                        System.out.println("Command : 'Clear' -Clears everyone");
                        System.out.println("Command : 'Clear Mzwa' - Clears' Mzwa");
                        System.out.println("Command : 'Exit' - Exits and Stops the program");
                    }


                    else {
                        if(store[0].isEmpty()){
//                            System.out.println();
                        }
                        else if(store.length > 0){
                            System.out.println("Invalid command type 'help' for available commands!");
                        }
                        else if(store[0].equalsIgnoreCase("greet")){
                            System.out.println("WTF!!!");
                        }
                    }
            }

        } catch (IllegalStateException e){
            System.out.println(e);
        }



    }
}
