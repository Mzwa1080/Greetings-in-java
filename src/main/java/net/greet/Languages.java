package net.greet;

import com.sun.xml.internal.txw2.IllegalAnnotationException;

public enum Languages {
    IsiXhosa("Molo"),
    English("Hello"),
    Afrikaans("Goeie dag");

    private String langs;

    Languages(String langs){
        try{
            this.langs = langs;
        }catch (IllegalArgumentException ex){
            ex.printStackTrace();
        }

    }

    public String getNames(String user){
        try{
            return langs + user;
        }catch (IllegalArgumentException ex){
            ex.printStackTrace();
        }
        finally {
            return langs + user;
        }
    }
}
