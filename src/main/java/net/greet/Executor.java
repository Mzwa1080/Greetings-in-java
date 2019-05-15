package net.greet;

public class Executor {
    GreetInterface user;

    public Executor(GreetInterface user){
        this.user = user;
    }

    public String execute(CommandBuilder builder){

        if("greet".equalsIgnoreCase(builder.getCommand()) && builder.hasName() ) {
            user.addUsers(builder.getUsername());
            try{
                return Languages.valueOf(builder.getLanguage()).getNames(" " + builder.getUsername());
            } catch (IllegalArgumentException e){
                System.out.println("Available languages are English/Afrikaans & Isixhosa!");
            }
        }
        else if("greeted".equalsIgnoreCase(builder.getCommand())){
            if (!builder.hasName()){
                user.greetedUsers();
            }else{
                user.getCountForUser(builder.getUsername());
            }
        }
        else if ("counter".equalsIgnoreCase(builder.getCommand())){
            user.getCountForAllUsers();
        }
        else if("clear".equalsIgnoreCase(builder.getCommand())){
            if(builder.hasName()){
                user.clearPerUser(builder.getUsername());
            }else
                user.clearAllUsers();
        }
        else if("exit".equalsIgnoreCase(builder.getCommand())){
            user.exit();
        }
        else if ("help".equalsIgnoreCase(builder.getCommand())) {
            System.out.println(" ______________________Available Commands__________________________");
            System.out.println("|Available Languages: IsiXhosa,English,Afrikaans");
            System.out.println("|Command : |    [Greet name + English] ");
            System.out.println("|Command : |    [Greeted] - returns all names");
            System.out.println("|Command : |[Greeted name] - returns how many times name greeted");
            System.out.println("|Command : |    [Clear] - clears everyone");
            System.out.println("|Command : |    [Clear name] - clears name");
            System.out.println("|Command : |    [Exit] - exits and stops the program");
            System.out.println("|__________|_______________________________________________________");
        }
        else
            return "Type 'HELP' for more guidance/commands";

        return " ";
    }

}
