package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ikurek.pwr.R;

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
        return inflater.inflate(R.layout.fragment_links_social_tab, container, false);
    }

}