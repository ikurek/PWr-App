package layout;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ikurek.pwr.ParseWebSite;
import com.ikurek.pwr.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StartFragment extends Fragment {

    public StartFragment() {
        // Required empty public constructor
    }


    public static StartFragment newInstance(Context context) {
        StartFragment fragment = new StartFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_start, container, false);
        final ListView listView = (ListView) view.findViewById(R.id.listViewNews);
        ParseWebSite parser = new ParseWebSite();
        ArrayList<String> links = new ArrayList<String>();

        try{

            links = parser.parseWebSite();

        } catch (Exception e)
        {
            e.printStackTrace();
        }


        //Przypisanie adaptera do listview
        //Dodałem custom layout bo czcionka w rzędach była biała
        listView.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.list_view_news_row, links));


        return view;
    }

}
