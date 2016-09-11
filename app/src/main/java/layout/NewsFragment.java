package layout;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ikurek.pwr.AsyncXMLParser;
import com.ikurek.pwr.CustomListViewAdapter;
import com.ikurek.pwr.ParsedWebData;
import com.ikurek.pwr.R;

import java.util.ArrayList;


public class NewsFragment extends Fragment {

    public static ArrayList <ParsedWebData> list = new ArrayList<ParsedWebData>();



    public NewsFragment() {
        // Required empty public constructor
    }


    public static NewsFragment newInstance(Context context) {
        NewsFragment fragment = new NewsFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Start AsyncTask w momencie ładowania fragmentu

        AsyncXMLParser parser = new AsyncXMLParser();
        parser.execute();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listViewNews);

        CustomListViewAdapter customListViewAdapter = new CustomListViewAdapter(getContext(), R.id.listViewNews, list);
        listView.setAdapter(customListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                ParsedWebData singleData = list.get(position);
                String url = singleData.getUrl();

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);


            }
        });




        return view;
    }

}
