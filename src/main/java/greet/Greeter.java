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

    public int clearAllUsers() {
        Map<String, Integer>del = users;
        System.out.println(del.remove(users));
//        users.clear();
        return 1;
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