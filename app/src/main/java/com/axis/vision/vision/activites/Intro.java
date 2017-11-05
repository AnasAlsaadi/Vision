package com.axis.vision.vision.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.axis.vision.vision.fragments.intro.Commercial;
import com.axis.vision.vision.fragments.intro.Exterior;
import com.axis.vision.vision.helper.FontsOverride;
import com.axis.vision.vision.fragments.intro.Residential;
import com.axis.vision.vision.fragments.intro.Welcome;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.animations.IViewTranslation;

/**
 * Created by Anas Alsaadi on 10/27/2017.
 */
public class Intro extends MaterialIntroActivity {

    TextView welcome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FontsOverride.setDefaultFont(this, "serif", "fonts/bree.ttf");
        enableLastSlideAlphaExitTransition(true);
//        ActionBar action = getSupportActionBar();
//        action.hide();


        getBackButtonTranslationWrapper()
                .setEnterTranslation(new IViewTranslation() {
                    @Override
                    public void translate(View view, @FloatRange(from = 0, to = 1.0) float percentage) {
                        view.setAlpha(percentage);
                    }
                });

        addSlide(new Welcome());
        addSlide(new Residential());
        addSlide(new Commercial());
        addSlide(new Exterior());


    }

    @Override
    public void onFinish() {
        super.onFinish();
        Intent myIntent = new Intent(Intro.this, Login.class);
        Intro.this.startActivity(myIntent);
    }


}


