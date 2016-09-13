package com.ikurek.pwr;

import android.os.Bundle;
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
import android.widget.Toast;

import layout.AppInfoFragment;
import layout.BuildingsFragment;
import layout.ContactFragment;
import layout.CatFragment;
import layout.NewsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        //Ustawia ftagment widoczny po odpaleniu aplikacji
        //TODO: ekran ładowanie to nie był by zły pomysł
        Fragment fragment = null;
        Class fragmentClass = null;
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

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    //Handler do obsługi kliknięcia wstecz
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //Kontrolki menu opcji, raczej zbędne
    //TODO: Znajdź zastosowanie, albo wywal
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
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
        int id = item.getItemId();

        if (id == R.id.nav_news) {
            fragmentClass = NewsFragment.class;

        } else if (id == R.id.nav_map) {
            fragmentClass = CatFragment.class;

        } else if (id == R.id.nav_buildings) {
            fragmentClass = BuildingsFragment.class;

        } else if (id == R.id.nav_manage) {
            fragmentClass = CatFragment.class;

            Toast.makeText(MainActivity.this, "Nie mam pomysłu co mogło by się tu znaleźć ", Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_info) {
            fragmentClass = AppInfoFragment.class;


        } else if (id == R.id.nav_bugreport) {
            fragmentClass = ContactFragment.class;

        }

        //Obowiązkowe sprawdzenie błędów
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Zamiana fragmentów
        //TODO: Jeżeli w jakimś dziwnym zbiegu okoliczności nie zostanie wykonany żaden z if'ów, commit powoduje nullPointerException
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frameLayoutForFragments, fragment).commit();

        //Zamyka drawer do lewej strony ekranu
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
