package layout;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ikurek.pwr.GetDetailedBuildingInfo;
import com.ikurek.pwr.R;

import java.util.Locale;


public class BuildingDetailsFragment extends Fragment {


    public BuildingDetailsFragment() {
        // Required empty public constructor
    }


    public static BuildingDetailsFragment newInstance() {
        BuildingDetailsFragment fragment = new BuildingDetailsFragment();
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
        View view = inflater.inflate(R.layout.fragment_building_details, container, false);
        GetDetailedBuildingInfo buildingInfoCatcher = new GetDetailedBuildingInfo(getContext());

        Bundle bundleFromBuildingsFragment = getArguments();

        //Wartości które później zostaną przekazane do textiew
        final String buildingName = bundleFromBuildingsFragment.getString("BUILDING_NAME");
        final String[] buildingData = buildingInfoCatcher.getBuildingData(buildingName);
        String latLongJoined = buildingData[1] + " , " + buildingData[2];

        //Przypisanie do TextView
        TextView textViewBuildingName = (TextView) view.findViewById(R.id.building_details_name);
        textViewBuildingName.setText(buildingName);
        TextView textViewBuildingAdress = (TextView) view.findViewById(R.id.building_details_adress);
        textViewBuildingAdress.setText(buildingData[0]);
        TextView textViewBuildingLatLong = (TextView) view.findViewById(R.id.building_details_latlong);
        textViewBuildingLatLong.setText(latLongJoined);

        //Konfiguracja FAB'a
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.floatingActionButtonBuildingDetails);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Buduje Uri do map
                String prepareUri = "geo:" + buildingData[1] + "," + buildingData[2];

                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%s,%s (%s)", buildingData[1], buildingData[2], "Wejście do " + buildingName);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                //Jeżeli użytkownik ma zainstalowane Google Maps to odpal
                //Jak nie mato dialog
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {

                    startActivity(intent);

                } else {

                    AlertDialog alertDialogNoInternet = new AlertDialog.Builder(getActivity()).create();
                    alertDialogNoInternet.setTitle(getString(R.string.something_is_broken));
                    alertDialogNoInternet.setMessage(getString(R.string.alertDialog_noGoogleMapsInstalled));


                    alertDialogNoInternet.setButton(AlertDialog.BUTTON_NEUTRAL, getString(R.string.ok_sad),
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
