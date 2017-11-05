package com.axis.vision.vision.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.axis.vision.vision.R;
import com.axis.vision.vision.helper.FontsOverride;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

/**
 * Created by Anas Alsaadi on 10/28/2017.
 */

public class SignUp extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FontsOverride.setDefaultFont(this, "serif", "fonts/bree.ttf");
        setContentView(R.layout.splash_activity);
//        ActionBar action = getSupportActionBar();
//        action.hide();

        setContentView(R.layout.signup_activity);
    }

    public void onClickSignIn(View v) {
        Intent intent = new Intent(SignUp.this, Login.class);
        SignUp.this.startActivity(intent);
    }

}
