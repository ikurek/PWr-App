package layout;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ikurek.pwr.R;


public class ContactFragment extends Fragment {


    public ContactFragment() {
        // Required empty public constructor
    }


    public static ContactFragment newInstance() {
        ContactFragment fragment = new ContactFragment();

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
        final View view =  inflater.inflate(R.layout.fragment_contact, container, false);

        Button gitButton = (Button) view.findViewById(R.id.SubmitViaGitHub);
        gitButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ikurek/PWr-App/issues/new"));
                startActivity(browserIntent);
            }
        });

        Button emailButton = (Button) view.findViewById(R.id.SubmitViaEmailButton);
        emailButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");


                emailIntent.putExtra(Intent.EXTRA_EMAIL, "igorkurek96@gmail.com");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "[BUG REPORT]");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "[BUG DESCRIPTION]\n\n\n[ADDITIONAL INFO]\n");

                try {
                    startActivity(Intent.createChooser(emailIntent, "Wysyłanie raportu..."));
                } catch (android.content.ActivityNotFoundException ex) {

                }
            }
        });




        return view;
    }

}
