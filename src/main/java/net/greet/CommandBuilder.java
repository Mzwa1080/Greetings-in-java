package net.greet;

public class CommandBuilder {

    private String command,language,username;
     String []store;

    public CommandBuilder(String command){
        store = command.split(" ");

    }

    public String getCommand() {
        try{
            this.command = Capitalize(store[0]);
        }catch(StringIndexOutOfBoundsException ex){
            System.out.println( "Enter 'help' to see available commands!");
        }
        return command;
    }

    private String Capitalize(String store) {
      return store.substring(0,1).toUpperCase().charAt(0) + store.substring(1);
    }

    public String getUsername() {
        try{
            this.username = Capitalize(store[1]);
        }catch(ArrayIndexOutOfBoundsException ex){
//            System.out.println("Enter a user you want to be greeted!");
//            System.out.println("e.g: greet 'name' english");
            this.username = "";
        }
        return username;

    }

    public String getLanguage() {
        try{
            this.language = Capitalize(store[2]);
        }catch(ArrayIndexOutOfBoundsException ex){
//            System.out.println("Enter a language you want a user to be greeted in!");
            this.language = "Afrikaans"; //default languge
        }

        return language;
    }

    public boolean hasName(){
            return !getUsername().isEmpty();
    }

    public boolean hasLanguage(){
            return !getLanguage().isEmpty();
    }


}
