package layout;


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
import android.widget.ImageButton;

import com.ikurek.pwr.R;


public class AppInfoFragment extends Fragment {

    private SharedPreferences preferences;

    public AppInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        getActivity().setTitle(getString(R.string.about));
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_app_info, container, false);


        ImageButton gitButton = (ImageButton) view.findViewById(R.id.imageButtonVisitGitHub);
        gitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

                if (preferences.getBoolean("news_use_chrome", true)) {

                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    builder.setToolbarColor(Color.parseColor("#B22315"));
                    CustomTabsIntent customTabsIntent = builder.build();
                    customTabsIntent.launchUrl(getActivity(), Uri.parse("https://github.com/ikurek/PWr-App/"));

                } else {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ikurek/PWr-App/"));
                    startActivity(browserIntent);
                }
            }
        });


        ImageButton betaLinkButton = (ImageButton) view.findViewById(R.id.imageButtonShareBetaLink);
        betaLinkButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");

                share.putExtra(Intent.EXTRA_SUBJECT, "Hej! Dołącz do testów wersji beta PWr-App");
                share.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/apps/testing/com.ikurek.pwr");

                startActivity(Intent.createChooser(share, "Zaproś do testów"));


            }
        });

        return view;
    }

}
