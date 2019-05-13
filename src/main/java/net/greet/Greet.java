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
        System.out.println(count);
        return count;
    }
    @Override
    public String getCountForUser(String user){
        if(users.containsKey(user)){
            user = user.toUpperCase().substring(0,1).charAt(0) + user.substring(1);
            System.out.println(user + " has been greeted " +users.get(user)+" time(s)");
        }else
            System.out.println(user + " has been greeted " + 0 + " time(s)");

        return user + " has been greeted "+ users.get(user);
    }

    public void clearAllUsers() {
        users.clear();
    }
    @Override
    public Map<String, Integer> clearPerUser(String user) {
        if(users.remove(user) != null){
            user = user.toUpperCase().substring(0,1).charAt(0) + user.substring(1);
            System.out.println(users.remove(user));
        }else
            System.out.println("There's no " + user);

        return users;
    }
    @Override
    public Map<String, Integer> greetedUsers(){
        System.out.println(users);
        return users;
    }
    @Override
    public void exit() {
    System.exit(0);
    }
}










