package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ikurek.pwr.GetDetailedBuildingInfo;
import com.ikurek.pwr.R;


public class BuildingDetailsFragment extends Fragment {

    private static final String BUILDING_NAME = null;

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
        GetDetailedBuildingInfo buildingInfoCatcher = new GetDetailedBuildingInfo();

        Bundle bundleFromBuildingsFragment = getArguments();

        //Wartości które później zostaną przekazane do textiew
        String buildingName = bundleFromBuildingsFragment.getString("BUILDING_NAME");
        String buildingAdress = buildingInfoCatcher.getBuildingAdress(buildingName);
        String buildingInfo = buildingInfoCatcher.getBuildingInfo(buildingName);


        //Przekazanie wartości do textview
        TextView textViewBuildingName = (TextView) view.findViewById(R.id.textViewBuildingName);
        textViewBuildingName.setText(buildingName);

        TextView textViewBuildingAdress = (TextView) view.findViewById(R.id.textViewBuildingAdress);
        textViewBuildingAdress.setText(buildingAdress);

        TextView textViewBuildingInfo = (TextView) view.findViewById(R.id.textViewBuildingInfo);
        textViewBuildingInfo.setText(buildingInfo);

        return view;
    }

}
