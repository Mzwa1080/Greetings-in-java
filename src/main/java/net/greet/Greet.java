package net.greet;

import java.util.*;

public class Greet {  //MUST USE THE INTERFACE
    private Map<String, Integer>users;

    public Greet(){
        users = new HashMap<>();
    }

    public Map<String, Integer> addUsers(String perUser){
        perUser = perUser.toUpperCase().substring(0,1).charAt(0) + perUser.substring(1);
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
        user = user.toUpperCase().substring(0,1).charAt(0) + user.substring(1);
        System.out.println(user + " has been greeted " +users.get(user)+"time(s)");
        return users.get(user);
    }

    public void clearAllUsers() {
        users.clear();
    }

    public int clearPerUser(String user) {
        user = user.toUpperCase().substring(0,1).charAt(0) + user.substring(1);
        return users.remove(user);

    }

    public void greetedUsers(){
        System.out.println(users);
    }
    public void out(){
        System.out.println("Exiting!");
    }


}










