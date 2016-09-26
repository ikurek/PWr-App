package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.ikurek.pwr.CustomExpandableListAdapter;
import com.ikurek.pwr.ExpandableListDataPump;
import com.ikurek.pwr.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class BuildingsFragment extends Fragment {


    public BuildingsFragment() {
        // Required empty public constructor
    }


    public static BuildingsFragment newInstance() {

        return new BuildingsFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buildings, container, false);

        //Jak jest final to działa
        //Jak nie to nie
        final ExpandableListView expandableListView = (ExpandableListView) view.findViewById(R.id.expandableListViewBuildings);
        LinkedHashMap<String, List<String>> expandableListDetail = ExpandableListDataPump.getData();
        List<String> expandableListTitle = new ArrayList<>(expandableListDetail.keySet());
        final ExpandableListAdapter expandableListAdapter = new CustomExpandableListAdapter(getContext(), expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                //Zamiana fragmentu na fragment z detailview
                Fragment fragment = null;
                Class fragmentClass = BuildingDetailsFragment.class;
                String buildingName = expandableListAdapter.getChild(groupPosition, childPosition).toString();


                //Raczej nie powinien wystąpić tutaj błąd, ale czemu by nie
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //Definicja transakcji fragmentów
                FragmentTransaction trans = getFragmentManager().beginTransaction();

                //Przekazanie argumentu do kolejnego fragmentu
                Bundle args = new Bundle();
                args.putString("BUILDING_NAME", buildingName);
                fragment.setArguments(args);

                //Zamiana fragmentu na nowy
                trans.replace(R.id.frameLayoutForFragments, fragment);

                //Handler do przycisku wstecz
                trans.addToBackStack(null);

                //Zamiana fragmentów
                trans.commit();


                return false;
            }
        });


        return view;
    }
}
