package net.greet;

public class CommandBuilder {

    private String command,language,username;
     String []store;

    public CommandBuilder(String command){
        store = command.split(" ");
    }

    public String getCommand() {
        try{
            this.command = store[0].substring(0,1).toUpperCase().charAt(0) + store[0].substring(1);
        }catch(StringIndexOutOfBoundsException ex){
            System.out.println( "Enter 'help' to see available commands!");
        }
        return command;
    }

    public String getUsername() {
        try{
            this.username = store[1].substring(0,1).toUpperCase().charAt(0) + store[1].substring(1);
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Enter a user you want to be greeted!");
            System.out.println("e.g: greet 'name' english");
        }
        return username;

    }

    public String getLanguage() {
        try{
            this.language = store[2].substring(0,1).toUpperCase().charAt(0) + store[2].substring(1);
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Enter a language you want a user to be greeted in!");
        }

        return language;
    }


}
