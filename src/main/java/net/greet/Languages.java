package net.greet;


public enum Languages {
    Afrikaans("Goeie dag"),
    English("Hello"),
    IsiXhosa("Molo");

    private String langs;

    Languages(String langs) {
        try {
            this.langs = langs;
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }

    }

    public String getNames(String user) {
            return langs + user.substring(0,1).toUpperCase().charAt(0) + user.substring(1);

    }
}
