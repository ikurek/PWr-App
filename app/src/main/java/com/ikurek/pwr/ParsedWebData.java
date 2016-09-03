package com.ikurek.pwr;

/**
 * Created by Igor on 03.09.2016.
 */

//Klasa zawiera informacje przekazane przez parser
    //Zrobiłem to , żeby łatwo można było przechwytywać całe zestawy danych ze strony
public class ParsedWebData {

    String title;
    String url;

    public ParsedWebData(){

    }

    public ParsedWebData(String title, String url){
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }


    public String getUrl() {
        return url;
    }


}
