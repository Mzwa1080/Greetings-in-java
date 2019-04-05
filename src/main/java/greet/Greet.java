package greet;

import java.util.*;

public class Greet {
    private String userName,lang;
    private Map<String, Integer> users;
//    private int count;

    public Greet(String name, String language){
        userName = name;
        lang = language;
        users = new HashMap<String, Integer>();
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
        Greet name  =  new Greet("Shawn", "English");
        Scanner username = new Scanner(System.in);
        String ret = name.greetInLanguage() + username.next();
        System.out.println(ret);
    }

}
