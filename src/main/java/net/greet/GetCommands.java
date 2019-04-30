package net.greet;

public class GetCommands {

    private String command,language,username;
     String []store;

    public GetCommands(String command){
        store = command.split(" ");
    }

    public String getCommand() {
        try{
            this.command = store[0].substring(0,1).toUpperCase().charAt(0) + store[0].substring(1);
        }catch(StringIndexOutOfBoundsException ex){
            System.out.println( ex);
        }
        return command;
    }

    public String getUsername() {
        this.username = store[1].substring(0,1).toUpperCase().charAt(0) + store[1].substring(1);
        return username;
    }

    public String getLanguage() {
        this.language = store[2].substring(0,1).toUpperCase().charAt(0) + store[2].substring(1);
        return language;
    }


}
