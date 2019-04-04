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


//        public int getCountForEachUser(String user){
////-------IT MUST CHECK THE NAME IN THE LIST IF ITS THERE AND COUNT IT HOW MANY TIMES IT HAS BEEN ENTERED
////------ I MUST HAVE A COUNTER SET TO EQUAL TO ZERO
////----- IF THE >>USERS<< CONTAINKEY OF >>USER PARAM<< SHOULD RETURN THE COUNTER NUMBER
//
//        int counter = users.get(user); //2  counter++
//        return counter;
//    }


}
