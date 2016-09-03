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

    public static ArrayList <String> parseWebSite() throws IOException {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);


        String url = "http://www.portal.pwr.wroc.pl/box_main_page_news,241.dhtml?limit=10";
        String baseURL = "http://www.portal.pwr.wroc.pl/";
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select(".title_1 > a");

        ArrayList <String> listOfLinks = new ArrayList <String> ();


        for (Element link : links) {

            listOfLinks.add(link.text());

        }


        return listOfLinks;
    }

    }
