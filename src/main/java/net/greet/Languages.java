package net.greet;

public enum Languages {
    Afrikaans("Goeie dag"),
    English("Hello"),
    IsiXhosa("Molo");

    private String langs;

    Languages(String langs) {
            this.langs = langs;
    }

    public String getNames(String user) {
            return langs + user;
    }

//    public boolean containsLanguage(){
//        return !L
//    }
}
