package net.greet;


import java.util.Map;

public interface GreetInterface {
     void addUsers(String name);
     void getCountForAllUsers();
     void clearAllUsers();
     void clearPerUser(String user);
     void getCountForUser(String user);
     Map<String, Integer> greetedUsers();
     void out();
}
