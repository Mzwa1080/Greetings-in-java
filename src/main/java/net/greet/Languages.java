package net.greet;


public enum Languages {
    Afrikaans("Goeie dag"),
    English("Hello"),
    IsiXhosa("Molo");

    private String langs;


    Languages(String langs) {
        try{
            this.langs = langs;
        }catch (IllegalArgumentException ex){
            ex.printStackTrace();
        }
    }

    public String getNames(String user) {

            return langs + user;

    }

    public String defaultMethod(String name){


        return "Molo " + name;
    }



}
