package com.ikurek.pwr;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Igor on 03.09.2016.
 */
class CustomListViewAdapter extends ArrayAdapter<ParsedWebData> {


    private final boolean[] animationStates;
    private final ArrayList<ParsedWebData> dataSet;


    public CustomListViewAdapter(Context context, int textViewResourceId, ArrayList<ParsedWebData> objects) {
        super(context, textViewResourceId, objects);
        animationStates = new boolean[objects.size()];
        this.dataSet = objects;
    }


    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //Wybór między layoutem kart i listy
            if (preferences.getBoolean("news_layout", true)) {
                v = inflater.inflate(R.layout.list_view_news_row_cards, null);
            } else {
                v = inflater.inflate(R.layout.list_view_news_row_list, null);
            }

            //Animacja pojawienia elementów
            if (!animationStates[position]) {
                animationStates[position] = true;

                //Wybór animacj w preferencjach
                String usedAnimation = preferences.getString("news_animation", "slide");
                Animation animation = null;

                if (usedAnimation.equals("slide")) {
                    animation = AnimationUtils.makeInAnimation(getContext(), true);

                }

                if (usedAnimation.equals("btt")) {
                    animation = AnimationUtils.loadAnimation(getContext(), R.anim.bottom_to_top);

                }

                if (usedAnimation.equals("fade")) {
                    animation = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);

                }

                if (!usedAnimation.equals("none")) {
                    assert animation != null;

                    //Animacje tylko dla elementów widocznych na ekranie startowym
                    if (position < 5) {
                        animation.setStartOffset(position * 100);
                    } else {
                        animation.setStartOffset(position);
                    }

                    v.startAnimation(animation);
                }


            }
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
