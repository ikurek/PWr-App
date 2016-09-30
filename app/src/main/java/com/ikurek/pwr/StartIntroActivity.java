package com.ikurek.pwr;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

import layout.IntroBeginFragment;

public class StartIntroActivity extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
        addSlide(AppIntroFragment.newInstance(getResources().getString(R.string.hi), getResources().getString(R.string.introSlide1), R.drawable.icon256, ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryPWr)));
        addSlide(AppIntroFragment.newInstance("tytuł2", "opis2", R.drawable.ic_arrow_back_white, ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryPWr)));
        addSlide(IntroBeginFragment.newInstance(R.layout.fragment_intro_begin));

    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.

        this.finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.

        this.finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}