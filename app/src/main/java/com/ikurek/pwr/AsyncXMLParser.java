package com.ikurek.pwr;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import layout.NewsFragment;

/**
 * Created by Igor on 10.09.2016.
 */
public class AsyncXMLParser extends AsyncTask <Void, Integer, ArrayList<ParsedWebData>> {



        @Override
        protected void onPreExecute() {

        }

        @Override
        protected ArrayList<ParsedWebData> doInBackground(Void... params) {

            ArrayList<ParsedWebData> list = new ArrayList<ParsedWebData>();

            try {

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(false);
                XmlPullParser xpp = factory.newPullParser();

                //Zbieranie danych z xml
                InputStream input = new URL("http://www.portal.pwr.wroc.pl/rss,241.xml").openStream();
                xpp.setInput(input, "UTF_8");

                int eventType = xpp.getEventType();
                String text = null;
                ParsedWebData data = new ParsedWebData();

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    String tagname = xpp.getName();

                    switch (eventType) {

                        case XmlPullParser.START_TAG:
                            if (tagname.equalsIgnoreCase("item")) {

                                data = new ParsedWebData();
                            }
                            break;

                        case XmlPullParser.TEXT:
                            text = xpp.getText();
                            break;

                        case XmlPullParser.END_TAG:
                            if (tagname.equalsIgnoreCase("item")) {
                                // add employee object to list
                                list.add(data);
                            } else if (tagname.equalsIgnoreCase("title")) {
                                data.title = text;
                            } else if (tagname.equalsIgnoreCase("link")) {
                                data.url = text;
                            } else if (tagname.equalsIgnoreCase("description")) {
                                text = Jsoup.parse(text).text();
                                data.description = text;
                            } else if (tagname.equalsIgnoreCase("pubDate")) {

                                //Przycina niepotrzebne części daty
                                text = text.substring(0, text.length() - 15);

                                Date date = null;
                                String newDateString = null;
                                //Zamiana formatu daty na normalny
                                final String NEW_FORMAT = "dd/MM/yyyy";
                                final String OLD_FORMAT = "EEE, dd MMM yyyy";

                                try
                                {
                                    //Parsowanie daty z XML
                                    SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT, Locale.ENGLISH);
                                    Date d = sdf.parse(text);
                                    sdf.applyPattern(NEW_FORMAT);
                                    newDateString = sdf.format(d);
                                    date = d;
                                }
                                catch (Exception e)
                                {
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
                    eventType = xpp.next();



                }
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            NewsFragment.list = list;

            return list;
}

        @Override
        protected void onPostExecute(ArrayList <ParsedWebData> result) {

        }

}
