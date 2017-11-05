package com.axis.vision.vision.activites;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.axis.vision.vision.R;
import com.axis.vision.vision.helper.FontsOverride;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
//        ActionBar action = getSupportActionBar();
//        action.hide();
        YoYo.with(Techniques.DropOut)
                .duration(700)
                .repeat(0)
                .playOn(findViewById(R.id.logo));


        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        Log.e("tag", "This'll run 300 milliseconds later");
                        Intent myIntent = new Intent(Splash.this, Intro.class);
                        Splash.this.startActivity(myIntent);
                    }
                },
                1000);

    }
}
