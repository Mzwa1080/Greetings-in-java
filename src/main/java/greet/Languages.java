package greet;

public enum Languages {
    IsiXhosa("Molo"),
    English("Hello"),
    Afrikaans("Goeie dag");

    private final String langs;

    Languages(String langs){
        this.langs = langs;
    }

    public String getNames(String user){
        return langs + user;
    }
}
