package net.greet;

import java.util.*;

public class Greet {
    private Map<String, Integer>users;

    public Greet(){
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
        System.out.println(count);
        return count;
    }

    public int getCountForUser(String user){
        System.out.println(user + " has been greeted " +users.get(user)+"time(s)");
        return users.get(user);
    }

    public void clearAllUsers() {
        users.clear();
    }

    public int clearPerUser(String user) {
        return users.remove(user);

    }

    public void greetedUsers(){
        System.out.println(users);
    }
    public void out(){
        System.out.println("Exiting!");
    }


}










