package net.greet;

public enum Languages {
    Afrikaans("Goeie dag"),
    English("Hello"),
    Isixhosa("Molo");

    private String langs;

    Languages(String langs) {
            this.langs = langs;
    }

    public String getNames(String user) {
            return langs + user;
    }
}
