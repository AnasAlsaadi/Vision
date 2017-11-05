package com.axis.vision.vision.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;

import com.axis.vision.vision.R;
import com.axis.vision.vision.fragments.main.Category;
import com.axis.vision.vision.fragments.main.SubCategory;
import com.axis.vision.vision.helper.FontsOverride;
import com.axis.vision.vision.helper.OnSwipeTouchListener;
import com.yalantis.guillotine.animation.GuillotineAnimation;

/**
 * Created by new laptoop on 30/10/2017.
 */

public class Main extends AppCompatActivity {
    private static final long RIPPLE_DURATION = 1;


    Toolbar toolbar;
    FrameLayout root;
    View contentHamburger;
    View guillotineMenu;
    GuillotineAnimation Menu;
    TextView title_main_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FontsOverride.setDefaultFont(this, "serif", "fonts/bree.ttf");
        setContentView(R.layout.main_activity);
        root = (FrameLayout) findViewById(R.id.root__);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        contentHamburger = (View) findViewById(R.id.content_hamburger);
        title_main_activity = (TextView) findViewById(R.id.title_main_activity);
        ButterKnife.bind(this);


        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
        }

        guillotineMenu = LayoutInflater.from(this).inflate(R.layout.menu, null);

        root.addView(guillotineMenu);

        Menu = new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();

        root.setOnTouchListener(new OnSwipeTouchListener(Main.this) {
            public void onSwipeTop() {
                Toast.makeText(Main.this, "top", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRight() {

                Menu.open();
            }

            public void onSwipeLeft() {

                Menu.close();
            }

            public void onSwipeBottom() {
                Toast.makeText(Main.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });

        Category CategoryFragment = new Category();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_containt, CategoryFragment)
                .commit();
        title_main_activity.setText(getString(R.string.category));

        this.Inactive_all_item_menu();
        this.Active_item_menu((LinearLayout) findViewById(R.id.category));
    }

    public void OnClickMenu(View v) {

        this.Inactive_all_item_menu();
        this.Active_item_menu((LinearLayout) v);
        switch (v.getId()) {
            case R.id.category:
                Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_LONG).show();

                Category CategoryFragment = new Category();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_containt, CategoryFragment)
                        .commit();
                title_main_activity.setText(getString(R.string.category));
                Menu.close();

                break;

            case R.id.category2:
                SubCategory Category2Fragment = new SubCategory();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_containt, Category2Fragment)

                        .commit();
                title_main_activity.setText(getString(R.string.category2));
                Menu.close();
                break;
        }


    }

    public void Active_item_menu(LinearLayout linear) {

        linear.setBackgroundColor(getResources().getColor(R.color.colorBlack));

    }

    public void Inactive_all_item_menu() {

        LinearLayout category = (LinearLayout) findViewById(R.id.category);
        category.setBackgroundColor(getResources().getColor(R.color.transparent));

        LinearLayout category2 = (LinearLayout) findViewById(R.id.category2);
        category2.setBackgroundColor(getResources().getColor(R.color.transparent));

    }


//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (Integer.parseInt(android.os.Build.VERSION.SDK) > 5
//                && keyCode == KeyEvent.KEYCODE_BACK
//                && event.getRepeatCount() == 0) {
//            Log.d("CDA", "onKeyDown Called");
//            onBackPressed();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//
//
//    @Override
//    public void onBackPressed() {
//        Log.d("CDA", "onBackPressed Called");
//        Intent setIntent = new Intent(Intent.ACTION_MAIN);
//        setIntent.addCategory(Intent.CATEGORY_HOME);
//        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(setIntent);
//    }

}
