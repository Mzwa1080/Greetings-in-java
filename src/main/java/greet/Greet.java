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




    public String greetInLanguage(){
        if(lang == "IsiXhosa"){
            return String.format("Molo %s!", userName);
        }
        if(lang == "Afrikaans"){
            return String.format("Goeie dag %s!", userName);
        }
        if(lang == "English"){
            return String.format("Hello %s!", userName);
        }

        return String.format("Type your name %s!!!" , userName.toUpperCase() + " with a language!");
    }



    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        Greet name = new Greet("Mzwa", "English");
        System.out.println(name.lang + scan.nextLine());
    }

//What ever its in the scanner or typed === must be the one added with the language && name should be added to list
//     Then it should be printed out both of them


}
