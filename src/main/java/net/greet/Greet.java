package net.greet;

import java.util.*;

public class Greet {
    private String userName,lang;
//    private Map<String, Integer> users;
//    private int count;

    public Greet(String name, String language){
        userName = name;
        lang = language;
//        users = new HashMap<String, Integer>();
    }


    public static void main(String args[]) {
        Scanner userText = new Scanner(System.in);
        Greeter user = new Greeter();
        System.out.println("Greet _name_ _language_ e.g 'Greet Shawn IsiXhosa'");

        while(true){
            String name = userText.nextLine();
            String [] store = name.split(" ");

            if(store[0].equalsIgnoreCase("net/greet") && store.length == 3){ //3 commands
                user.addUsers(store[1]);
                String language = store[2];
                System.out.println(Languages.valueOf(language).getNames(" " + store[1]));
            }else if(store[0].equalsIgnoreCase("net/greet") && store.length == 1){
                System.out.println("Greet who in which language between IsiXhosa/English/Afrikaans?");
            }else if(store[0].equalsIgnoreCase("net/greet") && store.length == 2){
                System.out.println("Greet "+ store[1].toUpperCase() + " in Which Language?");
            }else if(store[0].equalsIgnoreCase("greeted") && store.length == 1){
                user.greetedUsers();
            }else if(store[0].equalsIgnoreCase("counter") && store.length == 1 ){
                user.getCountForAllUsers();
            }else if(store[0].equalsIgnoreCase("clear") && store.length == 1){
                user.clearAllUsers();
                System.out.println("All users are cleared");
            }else if(store[0].equalsIgnoreCase("clear") && store.length == 2 ){
                user.clearPerUser(store[1]);
                System.out.println(store[1] + " has been removed!");
            }else if(store[0].equalsIgnoreCase("exit") && store.length ==1 ){
                user.out();
                userText.close();
            }else if(store[0].equalsIgnoreCase("help") && store.length == 1){
                System.out.println("-*-*-Available Commands-*-*-");
                System.out.println("Command : 'Greet' _Name_ _Language_ <");
                System.out.println("Command : 'Greeted' -Returns all names");
                System.out.println("Command : 'Clear' -Clears everyone");
                System.out.println("Command : 'Clear _name_ - Clear the _name_");
                System.out.println("Command : 'Exit' -Exits");
            }else{
                System.out.println("Invalid Commands--- Type 'Help'");
            }
        }

    }

}
