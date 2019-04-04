package greet;

import java.util.*;

public class Greeter {
    private Map<String, Integer>users;

    public Greeter(){
        users = new HashMap<>();
    }

    public Map<String, Integer> addUsers(String perUser){
        if(users.containsKey(perUser)){
            int count = users.get(perUser);
            users.put(perUser, count + 1);
        }
        else {
            users.put(perUser,1);
        }
        return users;
    }


    public int getCountForAllUsers(){
        int count = users.size();
        return count;
    }

    public Map<String, Integer>getGreetedUsers(){
        Map<String, Integer> everyone = users;
        return everyone;
    }

    public void clearAllUsers() {
        users.clear();
    }

    public Map<String, Integer> clearPerUser(String user) {
//        users.remove(user);
//        IF USER IN THE LIST IS 2X REMOVE THE USER AND DECREEMENNT THE COUNTER
//        ELSE REMOVE EACH USER
        if(users.containsKey(user)){
            users.remove(user);
        }
        return users;
    }

//    public Integer cleaPerUser(String user){
//        System.out.println(users.remove(user));
//        return users.remove(users.remove(user));
//    }

//    public Map<String, Integer> howManySingleUserBeenGreeted(Map<String, Integer> eachUser){
//    Map<String,Integer>demo = eachUser;
//    return demo;
//    }


}
