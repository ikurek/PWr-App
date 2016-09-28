package layout;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.kapss.pwr.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LinksSocialTabFragment extends Fragment {


    public LinksSocialTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_links_social_tab, container, false);

        ImageButton imageButtonVisitFacebook = (ImageButton) view.findViewById(R.id.imageButtonVisitFacebook);
        ImageButton imageButtonVisitGooglePlus = (ImageButton) view.findViewById(R.id.imageButtonVisitGooglePlus);
        ImageButton imageButtonVisitInstagram = (ImageButton) view.findViewById(R.id.imageButtonVisitInstagram);
        ImageButton imageButtonVisitLinkedIn = (ImageButton) view.findViewById(R.id.imageButtonVisitLinkedIn);
        ImageButton imageButtonVisitTwitter = (ImageButton) view.findViewById(R.id.imageButtonVisitTwitter);
        ImageButton imageButtonVisitSnapchat = (ImageButton) view.findViewById(R.id.imageButtonVisitSnapchat);
        ImageButton imageButtonVisitYouTube = (ImageButton) view.findViewById(R.id.imageButtonVisitYouTube);

        imageButtonVisitFacebook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/181882145193660"));
                    startActivity(intent);

                } catch (Exception e) {

                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/politechnika")));

                }
            }
        });

        imageButtonVisitGooglePlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/+politechnika")));

            }
        });

        //Instagram, GET YOUR SHIT TOGETHER!!!!
        //Nie ma API, nie ma otwierania w aplikacji :-(
        //TODO: Poczekaj aż insta doda api i będzie się dało odpalić link w przeglądarce
        imageButtonVisitInstagram.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/politechnika_wroclawska")));
            }

        });

        imageButtonVisitLinkedIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://15981"));
                    startActivity(intent);

                } catch (Exception e) {

                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/edu/school?id=15981")));

                }

            }
        });

        imageButtonVisitTwitter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=PWr_Wroclaw"));
                    startActivity(intent);

                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://twitter.com/PWr_Wroclaw")));
                }

            }
        });


        imageButtonVisitSnapchat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.snapchat.com/add/politechnika")));

            }
        });


        imageButtonVisitYouTube.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/pwrmojeklimaty")));

            }
        });

        return view;
    }

}
