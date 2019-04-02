import java.util.HashMap;

public class Greetings {
//    I need a var list to store names
//    the username should add a string of a selected language type
//    I need a counter for each person greeted - so I need a method n if statement that will increment if same name == same name

    private HashMap<String, Integer> users = new HashMap<String, Integer>();
    // WILL GET THE SIZE OF ALL USERS
   //WILL COUNT FOR SAME USER ENTERED AND INCREMENT BY ONE IF REPEATED
     //EACH PERSON --- I'LL PUSH HIM TO USERS

    public Greetings(){
//        user = username;
//        count = personCount;
    }
// ----I WANT TO ADD EACH PERSON ON THE LIST AND GET THE SIZE OF PEOPLE IN THE LIST
//***** I NEED A ENUM(extended) THAT WILL HAVE TYPES OF LANGUAGES AND A CLASS OVERRIDING THOSE LANGUAGES BY ADDING ****
//******************* BY ADDING ANY NAME + SELECTED LANGUAGE *********************

    public HashMap<String, Integer> addUsers(String name, int counter){
        int counterForEachPerson = counter;
        if(users.size() == 0 ){
            users.put(name, counterForEachPerson);
            if(users.containsKey(users==users)){
                counterForEachPerson++;
            }
        }
        return users;
    }

//--**-- HERE I WANT TO RETURN ALL THE USERS THAT ARE ADDED --**--//
    public static void main(String [] args){
        Greetings greet = new Greetings();
        Greetings greet2 = new Greetings();
        Greetings greet3 = new Greetings();

        System.out.println(greet.addUsers("Mzwa", 4));
        System.out.println(greet2.addUsers("Sipho", 22));
        System.out.println(greet3.addUsers("Sakhi", 1));
        System.out.println(greet.addUsers("Sakhi", 1));
        Greetings greets = new Greetings();
        System.out.println(greet.users.keySet());
        System.out.println(greets.greets("Mzwa", "IsiXhosa"));

    }

//----I WANT TO CREATE A METHOD THAT WILL RETURN NAMES +++ LANGUAGES --------
    public String greets(String username, String language){
        if(language == "IsiXhosa"){
            String.format("Molo %s", username);
            System.out.println(String.format("Molo %s", username, "!"));
        }
        else if (language == "English"){
            String.format("Hello %s", username, "!");
        }else if(language == "Afrikaans"){
            String.format("goeie dag %s", username, "!");
        }
           return String.format("Add a Language!");
    }
//-----------------------   TEST   USING   MAIN   --------------------
// -----------------------
}
