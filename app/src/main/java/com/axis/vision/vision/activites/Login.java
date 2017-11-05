package com.axis.vision.vision.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.axis.vision.vision.R;
import com.axis.vision.vision.helper.FontsOverride;
import com.unstoppable.submitbuttonview.SubmitButton;

/**
 * Created by Anas Alsaadi on 10/28/2017.
 */

public class Login extends AppCompatActivity implements View.OnClickListener {

    SubmitButton login_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        FontsOverride.setDefaultFont(this, "serif", "fonts/bree.ttf");
        setContentView(R.layout.splash_activity);
//        ActionBar action = getSupportActionBar();
//        action.hide();
        setContentView(R.layout.login_activity);

        login_submit = (SubmitButton) findViewById(R.id.login_submit);
        login_submit.setOnClickListener(this);
    }

    public void onClickSkip(View v) {
        Intent intent = new Intent(Login.this, Main.class);

        Login.this.startActivity(intent);
    }

    public void onClickSignUp(View v) {
        Intent intent = new Intent(Login.this, SignUp.class);

        Login.this.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_submit:
                Toast.makeText(this, "SubmitButton be clicked", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) > 5
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            Log.d("CDA", "onKeyDown Called");
            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
        Intent setIntent = new Intent(Intent.ACTION_MAIN);
        setIntent.addCategory(Intent.CATEGORY_HOME);
        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(setIntent);
    }
}
