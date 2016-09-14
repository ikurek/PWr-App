package com.ikurek.pwr;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

import layout.NewsFragment;

/**
 * Created by Igor on 10.09.2016.
 */

//Ten AsycTask to jakiś żart
    //Ale działa więc na razie zostanie
    //TODO: POPRAW TO!!! CALE!!!!
public class AsyncXMLParser extends AsyncTask<Void, Integer, ArrayList<ParsedWebData>> {


    Context context;
    ListView listView;
    ProgressBar progressBar;


    //Przekazywane z BuildingsFragment
    public AsyncXMLParser(Context context, ListView listView, ProgressBar progressBar) {

        this.context = context;
        this.listView = listView;
        this.progressBar = progressBar;
    }


    @Override
    protected void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);


    }

    //Tutaj sa funkcje parsujące strony PWr
    //Straszny syf jest z datami, bo w RRS są w formacie UNIXa
    //Zrobiłem konwerter na daty w standardzie normalnym
    //Stąd te dziwne linijki w przetwarzaniu daty
    @Override
    protected ArrayList<ParsedWebData> doInBackground(Void... params) {
        ArrayList<ParsedWebData> list = new ArrayList<ParsedWebData>();
        ParsedWebData data = new ParsedWebData();
        String text = null;


        //Parser dla strony głównej
        try {

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(false);
            XmlPullParser xpp = factory.newPullParser();

            InputStream inputmain = new URL("http://www.portal.pwr.wroc.pl/rss,241.xml").openStream();
            xpp.setInput(inputmain, "UTF_8");

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
                        if (tagname.equalsIgnoreCase("item") && data.title.trim() != "Kanał RSS" && data.title.trim() != null && data.description.trim() != null && data.description.trim() != "Aktualności" && data.date != null) {
                            data.source = "Cała Politechnika";
                            list.add(data);
                        } else if (tagname.equalsIgnoreCase("title")) {
                            data.title = text.trim().replaceAll(" +", " ");;
                        } else if (tagname.equalsIgnoreCase("link")) {
                            data.url = text.trim();
                        } else if (tagname.equalsIgnoreCase("description")) {
                            text = Jsoup.parse(text).text();
                            data.description = text.trim().replaceAll(" +", " ");;
                        } else if (tagname.equalsIgnoreCase("pubDate")) {

                            //Przycina niepotrzebne części daty
                            text = text.substring(0, text.length() - 15);

                            Date date = null;
                            String newDateString = null;
                            //Zamiana formatu daty na normalny
                            final String NEW_FORMAT = "dd/MM/yyyy";
                            final String OLD_FORMAT = "EEE, dd MMM yyyy";

                            try {
                                //Parsowanie daty z XML
                                SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT, Locale.ENGLISH);
                                Date d = sdf.parse(text);
                                sdf.applyPattern(NEW_FORMAT);
                                newDateString = sdf.format(d);
                                date = d;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }


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
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Parser dla stron wydziału
        try {

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(false);
            XmlPullParser xpp = factory.newPullParser();
            InputStream inputlocal = new URL("http://www.weka.pwr.edu.pl/rss,41.xml").openStream();
            xpp.setInput(inputlocal, "UTF_8");

            int eventTypeLocal = xpp.getEventType();

            while (eventTypeLocal != XmlPullParser.END_DOCUMENT) {
                String tagname = xpp.getName();

                switch (eventTypeLocal) {

                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("item")) {

                            data = new ParsedWebData();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = xpp.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase("item") && data.title.trim() != "Kanał RSS" && data.title.trim() != null && data.description.trim() != null && data.description.trim() != "Aktualności") {

                            data.source = "Wydział Elektroniki";
                            list.add(data);


                        } else if (tagname.equalsIgnoreCase("title")) {
                            data.title = text.trim().replaceAll(" +", " ");;
                        } else if (tagname.equalsIgnoreCase("link")) {
                            data.url = text;
                        } else if (tagname.equalsIgnoreCase("description")) {
                            text = Jsoup.parse(text).text();
                            data.description = text.trim().replaceAll(" +", " ");;
                        } else if (tagname.equalsIgnoreCase("pubDate")) {

                            //Przycina niepotrzebne części daty
                            text = text.substring(0, text.length() - 15);

                            if(text.startsWith("http")) text = "Mon, 01 Jan 1111";

                            Date date = null;
                            String newDateString = null;
                            //Zamiana formatu daty na normalny
                            final String NEW_FORMAT = "dd/MM/yyyy";
                            final String OLD_FORMAT = "EEE, dd MMM yyyy";

                            try {
                                //Parsowanie daty z XML
                                SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT, Locale.ENGLISH);
                                Date d = sdf.parse(text);
                                sdf.applyPattern(NEW_FORMAT);
                                newDateString = sdf.format(d);
                                date = d;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }


                            //Dwie daty na wyjściu jedna w formacie dla użytkownika
                            //Druga w formacie unixa do sortowania danych
                            data.date = date;
                            data.dateString = newDateString;
                        }
                        break;

                    default:
                        break;
                }
                eventTypeLocal = xpp.next();
            }


        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
