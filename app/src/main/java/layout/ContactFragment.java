package layout;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.kapss.pwr.R;


public class ContactFragment extends Fragment {


    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        getActivity().setTitle(getString(R.string.contact));
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_contact, container, false);

        final EditText editTextTitle = (EditText) view.findViewById(R.id.editTextBugTitle);
        final EditText editTextDescription = (EditText) view.findViewById(R.id.editTextBugDescription);
        final EditText editTextSpecs = (EditText) view.findViewById(R.id.editTextBugPhoneSpecs);


        Button emailButton = (Button) view.findViewById(R.id.buttonSendEmail);
        emailButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String address[] = {"igorkurek96@gmail.com"};

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "igorkurek96@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, address);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "[PWr APP] " + editTextTitle.getText());
                emailIntent.putExtra(Intent.EXTRA_TEXT, "[BUG REPORT / FEATURE REQUEST]\n" + editTextDescription.getText() + "\n\n[DEVICE]\n" + editTextSpecs.getText());

                try {
                    startActivity(Intent.createChooser(emailIntent, "Wysyłanie raportu..."));
                } catch (android.content.ActivityNotFoundException ex) {

                    AlertDialog alertDialogNoEmailApp = new AlertDialog.Builder(getActivity()).create();
                    alertDialogNoEmailApp.setTitle(getString(R.string.something_is_broken));
                    alertDialogNoEmailApp.setMessage(getString(R.string.alertDialog_noEmailAppInstalled));


                    alertDialogNoEmailApp.setButton(AlertDialog.BUTTON_NEUTRAL, getString(R.string.ok_sad),
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });

                }
            }
        });


        return view;
    }

}
