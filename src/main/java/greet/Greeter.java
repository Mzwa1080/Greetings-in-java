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
        System.out.println(count);
        return count;
    }

    public int getCountForUser(String user){
        System.out.println(users.get(user));
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
//    public String clearUsersValue(String user){
//        //DELETE THE USER VALUE
//        int keep = users.get(user); //GETS ALL THE USER'S VALUE
//        System.out.printf("Gets all values : --> "+ keep);
//
//
//        System.out.println("----------------------------------------------------------------");
//
//
//        System.out.println((keep) -- );
//
////        System.out.println();
////        System.out.println();
////        System.out.println(users.containsValue(keep));
//        return "I want to decrement the value of the guy";
//    }
//    ///I MUST CLEAR THE VALUE BY -1


}
