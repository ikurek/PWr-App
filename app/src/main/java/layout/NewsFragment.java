package layout;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.ikurek.pwr.AsyncXMLParser;
import com.ikurek.pwr.MainActivity;
import com.ikurek.pwr.ParsedWebData;
import com.ikurek.pwr.R;

import java.util.ArrayList;


public class NewsFragment extends Fragment {

    public static ArrayList<ParsedWebData> list = new ArrayList<>();
    private ProgressBar progressBar;
    private AsyncXMLParser parser;
    private ListView listView;
    private SharedPreferences preferences;
    private View viewForSnackbar;


    public NewsFragment() {
        // Required empty public constructor
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

        viewForSnackbar = view;


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                ParsedWebData singleData = NewsFragment.list.get(position);
                String url = singleData.getUrl();

                if (preferences.getBoolean("news_use_chrome", true)) {

                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    builder.setToolbarColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryPWr));
                    CustomTabsIntent customTabsIntent = builder.build();
                    customTabsIntent.launchUrl(getActivity(), Uri.parse(url));

                } else {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);
                }


            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View v, int position, long id) {

                ParsedWebData singleData = NewsFragment.list.get(position);
                final String url = singleData.getUrl();
                final String title = singleData.getTitle();

                PopupMenu popup = new PopupMenu(getContext(), v);
                MenuInflater inflater = popup.getMenuInflater();

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.menu_copy:

                                ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                                ClipData clip = ClipData.newPlainText(title, url);
                                clipboard.setPrimaryClip(clip);


                                Snackbar snackbar = Snackbar.make(viewForSnackbar, "Skopiowano do schowka!", Snackbar.LENGTH_SHORT);

                                snackbar.show();

                                return true;

                            case R.id.menu_share:

                                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                                share.setType("text/plain");

                                share.putExtra(Intent.EXTRA_SUBJECT, title);
                                share.putExtra(Intent.EXTRA_TEXT, url);

                                startActivity(Intent.createChooser(share, "Udostępnij"));

                                return true;

                            case R.id.menu_open_in_browser:

                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                                startActivity(browserIntent);

                                return true;

                            default:
                                return false;
                        }

                    }
                });

                inflater.inflate(R.menu.newsfeed_long_click_popup_menu, popup.getMenu());
                popup.show();


                return true;
            }
        });




        return view;
    }
}
