package com.ikurek.pwr;

import android.os.StrictMode;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Igor on 29.08.2016.
 */
public class ParseWebSite {

    //Tworzy array zawierający konstrukcje ParsedWebData
    //Zwraca ten sam array, wypełniony danymi z Jsoup
    public static ArrayList<ParsedWebData> parseWebSite() throws IOException {

        //TODO: StrictMode jest niebezpieczne, to powinno być w AsyncTask!!!
        //Omija blokady androida związane z dostępem do sieci w MainActivity
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Lecimy z parsowaniem
        String url = "http://www.portal.pwr.wroc.pl/box_main_page_news,241.dhtml?limit=10";
        String baseURL = "http://www.portal.pwr.wroc.pl/";
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select(".title_1 > a");
        Elements descriptions = doc.select(".nitemcell2 > div");

        ArrayList<ParsedWebData> listOfLinks = new ArrayList<ParsedWebData>();


        for (int i = 0; i < links.size() && i < descriptions.size(); i++) {
            ParsedWebData data = new ParsedWebData();
            data.title = links.get(i).text().trim();
            data.url = baseURL + links.get(i).attr("href");
            data.description = descriptions.get(i).text().trim();
            listOfLinks.add(data);

        }


        return listOfLinks;
    }

}
