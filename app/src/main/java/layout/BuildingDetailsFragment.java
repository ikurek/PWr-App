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
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.ikurek.pwr.GetDetailedBuildingInfo;
import com.ikurek.pwr.R;

import java.util.Locale;


public class BuildingDetailsFragment extends Fragment {

    public String[] buildingData;
    public String latLongJoined;
    public String buildingName;
    //Handler do clicków elementów menu
    //Zbiera id klikniętego elementu i wykonuje akcje
    //Pokazuje dialog jezeli nie ma google maps
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%s,%s (%s)", buildingData[1], buildingData[2], "Wejście do " + buildingName);
            Intent navigateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            navigateIntent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");

            String prepareUriForLocation = "geo:" + buildingData[1] + "," + buildingData[2] + "?q="
                    + buildingData[1] + "," + buildingData[2] + "(" + buildingName + ")";
            Uri mapIntentUri = Uri.parse(prepareUriForLocation);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");

            if (navigateIntent.resolveActivity(getActivity().getPackageManager()) != null) {


                switch (v.getId()) {

                    //Otwiera mapy w trybie nawigacji
                    case R.id.fabNavigate:

                        startActivity(navigateIntent);

                        break;

                    //Pokaż budynek na mapie
                    case R.id.fabMap:

                        startActivity(mapIntent);

                        break;

                }


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
    };


    public BuildingDetailsFragment() {
        // Required empty public constructor
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
        buildingName = bundleFromBuildingsFragment.getString("BUILDING_NAME");
        buildingData = buildingInfoCatcher.getBuildingData(buildingName);
        latLongJoined = buildingData[1] + " , " + buildingData[2];

        //Przypisanie do TextView
        getActivity().setTitle(buildingName);
        TextView textViewBuildingAdress = (TextView) view.findViewById(R.id.building_details_adress);
        textViewBuildingAdress.setText(buildingData[0]);
        TextView textViewBuildingLatLong = (TextView) view.findViewById(R.id.building_details_latlong);
        textViewBuildingLatLong.setText(latLongJoined);

        //Konfiguracja FAB'a
        FloatingActionMenu floatingActionMenu = (FloatingActionMenu) view.findViewById(R.id.floatingActionMenu);
        FloatingActionButton floatingActionButtonNavigate = (FloatingActionButton) view.findViewById(R.id.fabNavigate);
        FloatingActionButton floatingActionButtonMap = (FloatingActionButton) view.findViewById(R.id.fabMap);
        floatingActionMenu.setIconAnimated(false);
        floatingActionButtonNavigate.setOnClickListener(this.clickListener);
        floatingActionButtonMap.setOnClickListener(this.clickListener);


        return view;
    }

    //Przywraca nazwę górnego paska po powrocie do listy
    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().setTitle("Budynki");
    }

}
