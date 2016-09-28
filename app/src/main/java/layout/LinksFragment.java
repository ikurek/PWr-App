package layout;


import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ikurek.pwr.PagerAdapterLinks;
import com.ikurek.pwr.R;


public class LinksFragment extends Fragment {



    public LinksFragment() {
        // Required empty public constructor
    }


    public static LinksFragment newInstance() {
        LinksFragment fragment = new LinksFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(getString(R.string.links));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_links, container, false);

        //Konfiguracja paska z kartami
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout_info);
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);



        //Konfiguracja zmiany fragmentów
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager_info);
        PagerAdapterLinks adapter = new PagerAdapterLinks(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setupWithViewPager(viewPager);


        return view;
    }

}

