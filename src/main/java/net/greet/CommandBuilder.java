package net.greet;

public class CommandBuilder {

    private String command,language,username;
    private String [] store;

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
      return store.substring(0,1).toUpperCase().charAt(0) + store.substring(1).toLowerCase();
    }

    public String getUsername() {
        try{
            this.username = Capitalize(store[1]);
        }catch(ArrayIndexOutOfBoundsException ex){
            this.username = "";
        }
        return username;
    }

    public String getLanguage() {
        try{
            this.language = Capitalize(store[2]);
        }catch(ArrayIndexOutOfBoundsException ex){
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
