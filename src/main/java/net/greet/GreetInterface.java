package net.greet;

import java.util.Map;

public interface GreetInterface {
     void addUsers(String name);
     int getCountForAllUsers();
     void clearAllUsers();
     String clearPerUser(String user);
     String getCountForUser (String user);
     Map<String, Integer> greetedUsers();
     void exit();
}
