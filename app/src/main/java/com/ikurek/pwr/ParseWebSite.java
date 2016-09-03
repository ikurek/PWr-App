package com.ikurek.pwr;

import android.os.StrictMode;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Igor on 29.08.2016.
 */
public class ParseWebSite {

    //Tworzy array zawierający konstrukcje ParsedWebData
    //Zwraca ten sam array, wypełniony danymi z Jsoup
    public static ArrayList <ParsedWebData> parseWebSite() throws IOException {

        //TODO: StrictMode jest niebezpieczne, to powinno być w AsyncTask!!!
        //Omija blokady androida związane z dostępem do sieci w MainActivity
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Lecimy z parsowaniem
        String url = "http://www.portal.pwr.wroc.pl/box_main_page_news,241.dhtml?limit=10";
        String baseURL = "http://www.portal.pwr.wroc.pl/";
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select(".title_1 > a");

        ArrayList <ParsedWebData> listOfLinks = new ArrayList <ParsedWebData> ();


        for (Element link : links) {
            ParsedWebData data = new ParsedWebData();

            data.title = link.text().trim();
            //Wartość href to tylko ostatni częś linku, trzeba połączyć stringi
            data.url = baseURL + link.attr("href");
            listOfLinks.add(data);

        }


        return listOfLinks;
    }

    }
