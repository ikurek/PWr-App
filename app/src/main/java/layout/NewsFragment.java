package layout;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.ikurek.pwr.AsyncXMLParser;
import com.ikurek.pwr.ParsedWebData;
import com.ikurek.pwr.R;

import java.util.ArrayList;


public class NewsFragment extends Fragment {

    public static ArrayList<ParsedWebData> list = new ArrayList<>();
    ProgressBar progressBar;
    AsyncXMLParser parser;
    ListView listView;
    SharedPreferences preferences;


    public NewsFragment() {
        // Required empty public constructor
    }


    public static NewsFragment newInstance(Context context) {
        NewsFragment fragment = new NewsFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        getActivity().setTitle(getString(R.string.news));
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        View view = null;
        // Inflate the layout for this fragment
        if (preferences.getBoolean("news_layout", true)) {
            view = inflater.inflate(R.layout.fragment_news_cards, container, false);
        } else {
            view = inflater.inflate(R.layout.fragment_news_list, container, false);
        }
        listView = (ListView) view.findViewById(R.id.listViewNews);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBarNewsDownload);
        parser = new AsyncXMLParser(this.getContext(), listView, progressBar);
        parser.execute();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                ParsedWebData singleData = NewsFragment.list.get(position);
                String url = singleData.getUrl();

                if (preferences.getBoolean("news_use_chrome", true)) {

                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    builder.setToolbarColor(Color.parseColor("#B22315"));
                    CustomTabsIntent customTabsIntent = builder.build();
                    customTabsIntent.launchUrl(getActivity(), Uri.parse(url));

                } else {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);
                }


            }
        });


        return view;
    }

}
