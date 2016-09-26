package com.ikurek.pwr;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import org.jsoup.Jsoup;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import layout.NewsFragment;

/**
 * Created by Igor on 10.09.2016.
 */

//Zawiera parser do stron PWr
//Cała funkcja to AsyncTask żeby utrzymać zgodność ze standardem Androida
public class AsyncXMLParser extends AsyncTask<Void, Integer, ArrayList<ParsedWebData>> {


    private final Context context;
    private final ListView listView;
    private final ProgressBar progressBar;
    private final ArrayList<ParsedWebData> list = new ArrayList<>();
    private SharedPreferences preferences;


    //Przekazywane z BuildingsFragment
    public AsyncXMLParser(Context context, ListView listView, ProgressBar progressBar) {

        this.context = context;
        this.listView = listView;
        this.progressBar = progressBar;
    }

    //Funkcja zawiea parser zdejmujący dane z jednego linku xml
    //Przekazuje do niej link i nazwę linku jako źródło
    //Tym co jest zczytane z linku wypełnia ArrayList
    private Void singleLinkParser(String link, String source) {

        ParsedWebData data = new ParsedWebData();
        String text = "";

        try {

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(false);
            XmlPullParser xpp = factory.newPullParser();

            InputStream input = new URL(link).openStream();
            xpp.setInput(input, "UTF_8");

            int eventTypeMain = xpp.getEventType();


            while (eventTypeMain != XmlPullParser.END_DOCUMENT) {
                String tagname = xpp.getName();

                switch (eventTypeMain) {

                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("item")) {

                            data = new ParsedWebData();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = xpp.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase("item") && !Objects.equals(data.title, "Kanał RSS") && !data.title.startsWith("The Freescale Cup 2014") && data.title != null && data.description != null && !Objects.equals(data.description, "Aktualności") && data.date != null) {
                            data.source = source;
                            list.add(data);

                            //Zczytanie tytułu
                        } else if (tagname.equalsIgnoreCase("title")) {
                            data.title = text.trim().replaceAll(" +", " ");

                            //Zczytanie linku
                        } else if (tagname.equalsIgnoreCase("link")) {
                            data.url = text.trim();

                            //Zczytanie opisu
                        } else if (tagname.equalsIgnoreCase("description")) {
                            text = Jsoup.parse(text).text();
                            data.description = text.trim().replaceAll(" +", " ");

                            //Zczytanie daty
                        } else if (tagname.equalsIgnoreCase("pubDate")) {

                            //Przycina niepotrzebne części daty
                            //Dla PWr osobno bo ma inny format...
                            if (Objects.equals(source, "PWr")) {
                                text = text.substring(0, text.length() - 14);
                            } else {
                                text = text.substring(0, text.length() - 15);
                            }

                            //Jakby przypadkiem wczytało link do daty (zdarza sie)
                            if (text.startsWith("http")) text = "Mon, 01 Jan 1111";

                            Date date = null;
                            String newDateString = null;
                            //Zamiana formatu daty na normalny
                            final String NEW_FORMAT = "dd/MM/yyyy";
                            final String OLD_FORMAT = "EEE, dd MMM yyyy";


                            //Parsowane daty z XML
                            try {
                                SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT, Locale.ENGLISH);
                                Date d = sdf.parse(text);
                                sdf.applyPattern(NEW_FORMAT);
                                newDateString = sdf.format(d);
                                date = d;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            if (Objects.equals(text, "Mon, 01 Jan 1111"))
                                newDateString = "Brak daty";


                            //Dwie daty na wyjściu jedna w formacie dla użytkownika
                            //Druga w formacie unixa do sortowania danych
                            data.date = date;
                            data.dateString = newDateString;
                        }
                        break;

                    default:
                        break;
                }
                eventTypeMain = xpp.next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }


        return null;
    }


    @Override
    protected void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);
        preferences = PreferenceManager.getDefaultSharedPreferences(context);


    }

    //Tutaj sa funkcje parsujące strony PWr
    //Straszny syf jest z datami, bo w RRS są w formacie UNIXa
    //Zrobiłem konwerter na daty w standardzie normalnym
    //Stąd te dziwne linijki w przetwarzaniu daty
    @Override
    protected ArrayList<ParsedWebData> doInBackground(Void... params) {
        if (preferences.getBoolean("news_all", true)) {
            singleLinkParser("http://pwr.edu.pl/rss/pl/24.xml", "PWr");
        }
        if (preferences.getBoolean("news_w1", false)) {
            singleLinkParser("http://wa.pwr.edu.pl/rss,21.xml", "WA");
        }
        if (preferences.getBoolean("news_w2", false)) {
            singleLinkParser("http://wbliw.pwr.edu.pl/rss,31.xml", "WBLIW");
        }
        if (preferences.getBoolean("news_w3", false)) {
            singleLinkParser("http://wch.pwr.edu.pl/rss,11.xml", "WCH");
        }
        if (preferences.getBoolean("news_w4", true)) {
            singleLinkParser("http://weka.pwr.edu.pl/rss,41.xml", "WEKA");
        }
        if (preferences.getBoolean("news_w5", false)) {
            singleLinkParser("http://weny.pwr.edu.pl/rss,51.xml", "WENY");
        }
        if (preferences.getBoolean("news_w6", false)) {
            singleLinkParser("http://wggg.pwr.edu.pl/rss,61.xml", "WGGG");
        }
        if (preferences.getBoolean("news_w7", false)) {
            singleLinkParser("http://wis.pwr.edu.pl/rss,71.xml", "WIS");
        }
        if (preferences.getBoolean("news_w8", false)) {
            singleLinkParser("http://wiz.pwr.edu.pl/rss,1.xml", "WIZ");
        }
        if (preferences.getBoolean("news_w9", false)) {
            singleLinkParser("http://wme.pwr.edu.pl/rss,81.xml", "WME");
        }
        if (preferences.getBoolean("news_w10", false)) {
            singleLinkParser("http://wm.pwr.edu.pl/rss,91.xml", "WM");
        }
        if (preferences.getBoolean("news_w11", false)) {
            singleLinkParser("http://wppt.pwr.edu.pl/rss,101.xml", "WPPT");
        }
        if (preferences.getBoolean("news_w12", false)) {
            singleLinkParser("http://wemif.pwr.edu.pl/rss,111.xml", "WEMiF");
        }
        if (preferences.getBoolean("news_w13", false)) {
            singleLinkParser("http://wmat.pwr.edu.pl/rss,231.xml", "WMAT");
        }

        return list;
    }

    @Override
    protected void onPostExecute(ArrayList<ParsedWebData> result) {

        //Sortuje cały ten array po datach
        //Wykorzystuje daty UNIXa czyli list.data nie list.dataString

        Collections.sort(result, new Comparator<ParsedWebData>() {
            @Override
            public int compare(ParsedWebData o1, ParsedWebData o2) {
                return o2.getDate().compareTo(o1.getDate());
            }
        });

        CustomListViewAdapter customListViewAdapter = new CustomListViewAdapter(context, R.id.listViewNews, result);
        listView.setAdapter(customListViewAdapter);
        NewsFragment.list = result;

        progressBar.setVisibility(View.GONE);


    }

}
