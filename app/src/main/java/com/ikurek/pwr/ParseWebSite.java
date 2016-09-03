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


        String url = "http://www.portal.pwr.wroc.pl/index,241.dhtml";
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("table.cwrapper .tbody .tr td.ccol2 div.cwrapper_padd div#box_main_page_news.cbox.grey div#dyn_main_news.cbox.padd2 div.nitem table.nitemt .tbody .tr td.nitemcell2 span.title_1");
        ArrayList <String> listOfLinks = new ArrayList <String> ();
        int counter = 0;


        for (Element link : links) {

            listOfLinks.add(link.text());

        }


        return listOfLinks;
    }

    }
