package com.ikurek.pwr;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import layout.AppInfoFragment;
import layout.BuildingsFragment;
import layout.CatFragment;
import layout.ContactFragment;
import layout.LinksFragment;
import layout.NewsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        setSupportActionBar(toolbar);


        //Sprawdź czy dostępne jest połączenie internetowe
        //Jeżeli nie, poinformuj użytkownika
        if (!preferences.getBoolean("Offline_mode_prompt", false)) {

            boolean isConnected = InternetConnectionChecker.isNetworkAvailable(getApplicationContext());

            if (!isConnected) {
                AlertDialog alertDialogNoInternet = new AlertDialog.Builder(MainActivity.this).create();
                alertDialogNoInternet.setTitle(getString(R.string.something_is_broken));
                alertDialogNoInternet.setMessage(getString(R.string.alertDialog_noInternetConnection));


                alertDialogNoInternet.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.offlineMode),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                alertDialogNoInternet.setButton(AlertDialog.BUTTON_NEGATIVE, getString(R.string.exit),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                System.exit(0);
                            }
                        });
                alertDialogNoInternet.show();
            }
        }

        //Ustawia ftagment widoczny po odpaleniu aplikacji
        Fragment fragment = null;
        Class fragmentClass = null;
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        fragmentClass = NewsFragment.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutForFragments, fragment);

        fragmentTransaction.commit();


        //Kontrolki navigationdrawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    //Handler do obsługi kliknięcia wstecz
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (backStackEntryCount != 0) {

            super.onBackPressed();

        } else {

            AlertDialog alertDialogExit = new AlertDialog.Builder(MainActivity.this).create();
            alertDialogExit.setTitle(getString(R.string.exit));
            alertDialogExit.setMessage(getString(R.string.alertDialog_areYouSureYouWantToExit));


            alertDialogExit.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.cancel),
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

            alertDialogExit.setButton(AlertDialog.BUTTON_NEGATIVE, getString(R.string.exit),
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            System.exit(0);
                        }
                    });
            alertDialogExit.show();

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //Otwiera ekran ustawień
        if (id == R.id.action_settings) {

            Intent startSettings = new Intent(this, SettingsActivity.class);
            startActivity(startSettings);

            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        //Wybory elementów w navigationdrawer
        Fragment fragment = null;
        Class fragmentClass = null;
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        int id = item.getItemId();

        if (id == R.id.nav_news) {
            fragmentClass = NewsFragment.class;

        } else if (id == R.id.nav_cats) {
            fragmentClass = CatFragment.class;

        } else if (id == R.id.nav_buildings) {
            fragmentClass = BuildingsFragment.class;

        } else if (id == R.id.nav_settings) {
            Intent startSettings = new Intent(this, SettingsActivity.class);
            startActivity(startSettings);

        } else if (id == R.id.nav_links) {
            fragmentClass = LinksFragment.class;
            navigationView.setCheckedItem(R.id.nav_links);


        } else if (id == R.id.nav_info) {
            fragmentClass = AppInfoFragment.class;
            navigationView.setCheckedItem(R.id.nav_info);


        } else if (id == R.id.nav_bugreport) {
            fragmentClass = ContactFragment.class;
            navigationView.setCheckedItem(R.id.nav_bugreport);

        }

        //Obowiązkowe sprawdzenie błędów
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //Zamiana fragmentów
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frameLayoutForFragments, fragment).commit();
        }

        //Zamyka drawer do lewej strony ekranu
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
