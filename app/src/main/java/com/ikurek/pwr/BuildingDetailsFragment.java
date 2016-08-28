package com.ikurek.pwr;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class BuildingDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
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

        Bundle bundleFromBuildingsFragment = getArguments();
        String buildingName = bundleFromBuildingsFragment.getString("BUILDING_NAME");

        //Toast do debugu
        Toast.makeText(getActivity().getApplicationContext(), "Przekazane z BuildingsFragment : " + buildingName, Toast.LENGTH_SHORT).show();

        TextView textViewBuildingName = (TextView) view.findViewById(R.id.textViewBuildingName);
        textViewBuildingName.setText(buildingName);

        return view;
    }

}
