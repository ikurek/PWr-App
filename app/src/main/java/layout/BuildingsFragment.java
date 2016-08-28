package layout;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ikurek.pwr.BuildingDetailsFragment;
import com.ikurek.pwr.R;


public class BuildingsFragment extends Fragment {


    public BuildingsFragment() {
        // Required empty public constructor
    }


    public static BuildingsFragment newInstance(Context context) {
        BuildingsFragment fragment = new BuildingsFragment();

        return fragment;
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
        final ListView listView = (ListView) view.findViewById(R.id.listViewBuildings);

        //Array zawierający listę wszystkich budynków na PWr.
        //TODO: Nie warto marnować zasobów, może by to statycznie zrobić w xml?
        //TODO: Brakuje budynków
        String[] budynki = new String[]{
                "A-1",
                "A-2",
                "A-3",
                "A-5",
                "A-7",
                "B-1",
                "B-4",
                "B-5",
                "C-1",
                "C-2",
                "C-3",
                "C-4",
                "C-5",
                "C-6"
        };


        //Przypisanie adaptera do listview
        //Dodałem custom layout bo czcionka w rzędach była biała
        listView.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.list_view_buildings_row_layout, budynki));

        //Obsługa kliknięć na element listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Pozycja na listView
                int listViewItemPosition = position;

                //Wartość w danym rzedzie
                String listViewItemValue = (String) listView.getItemAtPosition(position);

                //Toast do debugu
                Toast.makeText(getActivity().getApplicationContext(), "Pozycja : " + listViewItemPosition + "  Zawiera : " + listViewItemValue, Toast.LENGTH_SHORT).show();

                //Zamiana fragmentu na fragment z detailview
                Fragment fragment = null;
                Class fragmentClass = BuildingDetailsFragment.class;


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
                args.putString("BUILDING_NAME", listViewItemValue);
                fragment.setArguments(args);

                //Zamiana fragmentu na nowy
                trans.replace(R.id.frameLayoutForFragments, fragment);

                //Handler do przycisku wstecz
                trans.addToBackStack(null);

                //Zamiana fragmentów
                trans.commit();
            }

        });

        return view;
    }

}
