package com.ikurek.pwr;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;

import layout.IntroBeforeWeStart;
import layout.IntroHello;
import layout.IntroThankYou;

//Zaczyna intro
//Zapisuje do SharedPreferences wybrany przez użytkownika wydział
public class StartIntroActivity extends AppIntro {

    //Zmienna wskazuje wydział wybrany przez użytkownika
    //Modyfikowana przez IntroBeforeWeStart.java
    public static int selectedDepartment = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
        addSlide(IntroHello.newInstance());
        addSlide(IntroBeforeWeStart.newInstance());
        addSlide(IntroThankYou.newInstance());

    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.

        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_OK, returnIntent);
        this.finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.

        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_OK, returnIntent);
        this.finish();
    }

    //Przy zmianie slajdu zapisuje wartość true do wybranego wydziału
    //Na końcu zeruje żeby nie zapisywać przy każdej zmianie
    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor edit = preferences.edit();


        switch (selectedDepartment) {
            case 0:
                break;

            case 1:
                edit.putBoolean("news_w1", true);
                edit.apply();
                break;

            case 2:
                edit.putBoolean("news_w2", true);
                edit.apply();
                break;

            case 3:
                edit.putBoolean("news_w3", true);
                edit.apply();
                break;

            case 4:
                edit.putBoolean("news_w4", true);
                edit.apply();
                break;

            case 5:
                edit.putBoolean("news_w5", true);
                edit.apply();
                break;

            case 6:
                edit.putBoolean("news_w6", true);
                edit.apply();
                break;

            case 7:
                edit.putBoolean("news_w7", true);
                edit.apply();
                break;

            case 8:
                edit.putBoolean("news_w8", true);
                edit.apply();
                break;

            case 9:
                edit.putBoolean("news_w9", true);
                edit.apply();
                break;

            case 10:
                edit.putBoolean("news_w10", true);
                edit.apply();
                break;

            case 11:
                edit.putBoolean("news_w11", true);
                edit.apply();
                break;

            case 12:
                edit.putBoolean("news_w12", true);
                edit.apply();
                break;

            case 13:
                edit.putBoolean("news_w13", true);
                edit.apply();
                break;

        }

    }
}