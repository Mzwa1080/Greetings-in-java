package net.greet;

import java.util.*;

public class Greet implements GreetInterface {
    private Map<String, Integer>users;

    public Greet(){
        users = new HashMap<>();
    }
    @Override
    public void addUsers(String perUser){
        perUser = perUser.toUpperCase().substring(0,1).charAt(0) + perUser.substring(1);
        if(users.containsKey(perUser)){
            int count = users.get(perUser);
            users.put(perUser, count + 1);
        }
        else {
            users.put(perUser,1);
        }
    }

    @Override
    public int getCountForAllUsers(){
        int count = users.size();
        return count;
    }
    @Override
    public String getCountForUser(String user){
        if(users.containsKey(user)){
            user = user.toUpperCase().substring(0,1).charAt(0) + user.substring(1);
            return user + " has been greeted "+ users.get(user) + " time(s)";
        }else
            return user + " has been greeted " + 0 + " time(s)";
    }

    public void clearAllUsers() {
        users.clear();
    }
    @Override
    public String clearPerUser(String user) {
        if(users.remove(user) != null){
            user = user.toUpperCase().substring(0,1).charAt(0) + user.substring(1);
            users.remove(user);
        }else
            return "There's no " + user;

        return users.toString();
    }
    @Override
    public Map<String, Integer> greetedUsers(){
        return users;
    }
    @Override
    public void exit() {
    System.exit(0);
    }

}










