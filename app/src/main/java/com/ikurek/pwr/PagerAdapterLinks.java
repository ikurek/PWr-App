package com.ikurek.pwr;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import layout.LinksDefaultTabFragment;
import layout.LinksSocialTabFragment;

/**
 * Created by igor on 27.09.16.
 */

//Prosta klasa jest adapterem dla widoku zakładek w informacjach o uczelnii
//Zwraca ilość kart oraz wybraną kartę

public class PagerAdapterLinks extends FragmentStatePagerAdapter {

    private final int numberOfTabs;

    public PagerAdapterLinks(FragmentManager fragmentManager, int NumOfTabs) {
        super(fragmentManager);
        this.numberOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new LinksDefaultTabFragment();
            case 1:
                return new LinksSocialTabFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Ogólne";
            case 1:
                return "Społeczności";
            default:
                return null;
        }


    }
}
