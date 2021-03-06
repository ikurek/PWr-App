package com.ikurek.pwr;

import java.util.Date;

/**
 * Created by Igor on 03.09.2016.
 */

//Klasa zawiera informacje przekazane przez parser
//Zrobiłem to , żeby łatwo można było przechwytywać całe zestawy danych ze strony
public class ParsedWebData {

    String title;
    String url;
    String description;
    String source;

    //date zawiera datę w formacie UNIXa
    //dateString zawiera datę w użytkowym formacie jako string
    Date date;
    String dateString;

    public ParsedWebData() {

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

    public Date getDate() {
        return date;
    }

    public String getDateString() {
        return dateString;
    }

    public String getSource() {
        return source;
    }


}
