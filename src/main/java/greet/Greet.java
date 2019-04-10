package greet;

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
// --------------------I MUST CREATE A LIST PUTTING WORDS IN IT------------------------------

        while(true){
            String name = userText.nextLine();
            String [] store = name.split(" ");

            if(store[0].equalsIgnoreCase("greet") && store.length == 3){ //3 commands
                user.addUsers(store[1]);
                String language = store[2];
                System.out.println(Languages.valueOf(language).getNames(" " + store[1]));
            }else if(store[0].equalsIgnoreCase("greet") && store.length == 1){
                System.out.println("Greet who in which language between IsiXhosa/English/Afrikaans?");
            }
            else if(store[0].equalsIgnoreCase("greet") && store.length == 2){
                System.out.println("Greet "+ store[1].toUpperCase() + " in Which Language?");
            }else if(store[0].equalsIgnoreCase("greeted") && store.length == 1){
                user.greetedUsers();
            }else if(store[0].equalsIgnoreCase("counter") && store.length == 1 ){
                user.getCountForAllUsers();
            }else if(store[0].equalsIgnoreCase("clear") && store.length == 1){
                user.clearAllUsers();
                System.out.println("All users are cleared");
            }
            else if(store[0].equalsIgnoreCase("clear") && store.length == 2 ){
                System.out.println("Enter A Name Of The Person You Want To Remove!");
                user.clearPerUser(store[1]);
            }
            else if(store[0].equalsIgnoreCase("exit") && store.length ==1 ){
                userText.close();
            }
            else{
                String.format("fokof!!!");
            }
        }

    }
//What ever its in the scanner or typed === must be the one added with the language && name should be added to list
//     Then it should be printed out both of them



}
