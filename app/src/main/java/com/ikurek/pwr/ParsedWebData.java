package com.ikurek.pwr;

/**
 * Created by Igor on 03.09.2016.
 */

//Klasa zawiera informacje przekazane przez parser
//Zrobiłem to , żeby łatwo można było przechwytywać całe zestawy danych ze strony
public class ParsedWebData {

    String title;
    String url;
    String description;

    public ParsedWebData() {

    }

    public ParsedWebData(String title, String url, String description) {
        this.title = title;
        this.url = url;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }


    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }


}
