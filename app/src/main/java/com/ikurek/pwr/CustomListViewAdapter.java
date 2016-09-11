package com.ikurek.pwr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Igor on 03.09.2016.
 */
public class CustomListViewAdapter extends ArrayAdapter<ParsedWebData> {


    private ArrayList<ParsedWebData> dataSet;


    public CustomListViewAdapter(Context context, int textViewResourceId, ArrayList<ParsedWebData> objects) {
        super(context, textViewResourceId, objects);
        this.dataSet = objects;
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_view_news_row, null);
        }


        ParsedWebData data = dataSet.get(position);

        if (dataSet != null) {


            TextView title = (TextView) v.findViewById(R.id.listViewNewsTitle);
            TextView description = (TextView) v.findViewById(R.id.listViewNewsDescription);
            TextView source = (TextView) v.findViewById(R.id.listViewNewsSource);
            TextView date = (TextView) v.findViewById(R.id.listViewNewsDate);


            if (title != null) {
                title.setText(data.getTitle());
            }
            if (description != null) {
                description.setText(data.getDescription());
            }
            if (date != null) {
                date.setText(data.getDateString());
                source.setText(data.getSource());
            }
            if (source != null) {
                source.setText(data.getSource());
            }

        }

        return v;

    }


}
