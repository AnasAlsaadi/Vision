package com.axis.vision.vision.fragments.main;

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.axis.vision.vision.R;
import com.axis.vision.vision.adapters.CategoryAdapter;
import com.axis.vision.vision.adapters.ProductAdapter;
import com.axis.vision.vision.models.*;
import com.gigamole.navigationtabstrip.NavigationTabStrip;

import java.util.ArrayList;
import java.util.List;

//import devlight.io.library.ntb.NavigationTabBar;

/**
 * Created by Anas Alsaadi on 10/30/2017.
 */

public class Product extends android.support.v4.app.Fragment {

    private RecyclerView recyclerCategory;
    private ProductAdapter adapter_;
    private List<com.axis.vision.vision.models.Product> product_list;

    private ViewPager mViewPager;

    private NavigationTabStrip mTopNavigationTabStrip;
    private NavigationTabStrip mCenterNavigationTabStrip;
    private NavigationTabStrip mBottomNavigationTabStrip;

    private void findViews(View rootView) {
        recyclerCategory = (RecyclerView) rootView.findViewById(R.id.recycler_product);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle b = this.getArguments();
        if (b != null) {
            String s = b.getString("Key");
            Log.e("sss", s);
        }
        View v = inflater.inflate(R.layout.fragment_product, container, false);
        //   initUI(v);


        //   mCenterNavigationTabStrip = (NavigationTabStrip) v.findViewById(R.id.nts_center);
        //  mBottomNavigationTabStrip = (NavigationTabStrip) v.findViewById(R.id.nts_bottom);
        initUI(v);
        setUI(v);
        return v;
    }


    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.residential,
                R.drawable.commercial,
                R.drawable.exterior,};

        com.axis.vision.vision.models.Product a = new com.axis.vision.vision.models.Product("RESIDENTIAL", "", "", R.drawable.residential);
        com.axis.vision.vision.models.Product b = new com.axis.vision.vision.models.Product("COMMERCIAL", "", "", R.drawable.commercial);
        com.axis.vision.vision.models.Product c = new com.axis.vision.vision.models.Product("EXTERIOR", "", "", R.drawable.exterior);
        product_list.add(a);
        product_list.add(b);
        product_list.add(c);
        adapter_.notifyDataSetChanged();
    }

    private void prepareAlbums2() {
        int[] covers = new int[]{
                R.drawable.residential,
                R.drawable.commercial,
                R.drawable.exterior,};


        com.axis.vision.vision.models.Product a = new com.axis.vision.vision.models.Product("RESIDENTIAL", "", "", R.drawable.residential);
        com.axis.vision.vision.models.Product b = new com.axis.vision.vision.models.Product("COMMERCIAL", "", "", R.drawable.commercial);
        com.axis.vision.vision.models.Product c = new com.axis.vision.vision.models.Product("EXTERIOR", "", "", R.drawable.exterior);
        product_list.add(a);
        product_list.add(b);
        adapter_.notifyDataSetChanged();
    }

    private void initUI(View view) {
        mViewPager = (ViewPager) view.findViewById(R.id.vp_horizontal_ntb);
        //   mTopNavigationTabStrip = (NavigationTabStrip) view.findViewById(R.id.nts_top);
        mCenterNavigationTabStrip = (NavigationTabStrip) view.findViewById(R.id.nts_center);
        //   mBottomNavigationTabStrip = (NavigationTabStrip) view.findViewById(R.id.nts_bottom);
    }

    private void setUI(View view) {
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public boolean isViewFromObject(final View view, final Object object) {
                return view.equals(object);
            }

            @Override
            public void destroyItem(final View container, final int position, final Object object) {
                ((ViewPager) container).removeView((View) object);
            }

            @Override
            public Object instantiateItem(final ViewGroup container, final int position) {
                final View view = LayoutInflater.from(
                        getActivity()).inflate(R.layout.fragment_product_recycle, null, false);
                findViews(view);
                product_list = new ArrayList<>();

                adapter_ = new ProductAdapter(getContext(), product_list);
                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
                recyclerCategory.setLayoutManager(mLayoutManager);
                recyclerCategory.setAdapter(adapter_);
                if (position == 0) {

                    prepareAlbums2();
                }
                if (position == 2) {

                    prepareAlbums();
                }
                if (position == 1) {

                    prepareAlbums2();
                }
                container.addView(view);
                return view;
            }
        });
        mCenterNavigationTabStrip.setTitles("Classic", "New Classic", "Modern");
        // mTopNavigationTabStrip.setTabIndex(1, true);
        mCenterNavigationTabStrip.setViewPager(mViewPager, 1);

        mCenterNavigationTabStrip.setInactiveColor(getResources().getColor(R.color.colorWhite));
        mCenterNavigationTabStrip.setActiveColor(getResources().getColor(R.color.colorGolden));
        mCenterNavigationTabStrip.setStripColor(getResources().getColor(R.color.colorGolden));
        mCenterNavigationTabStrip.setBackgroundColor(getResources().getColor(R.color.colorBlackDark));
//        mBottomNavigationTabStrip.setTabIndex(1, true);

//        final NavigationTabStrip navigationTabStrip = (NavigationTabStrip) findViewById(R.id.nts);
//
//        navigationTabStrip.setTabIndex(0, true);
//        navigationTabStrip.setTitleSize(15);
//        navigationTabStrip.setStripColor(Color.RED);
//        navigationTabStrip.setStripWeight(6);
//        navigationTabStrip.setStripFactor(2);
//        navigationTabStrip.setStripType(NavigationTabStrip.StripType.LINE);
//        navigationTabStrip.setStripGravity(NavigationTabStrip.StripGravity.BOTTOM);
//        navigationTabStrip.setTypeface("fonts/typeface.ttf");
//        navigationTabStrip.setCornersRadius(3);
//        navigationTabStrip.setAnimationDuration(300);
//        navigationTabStrip.setInactiveColor(Color.GRAY);
//        navigationTabStrip.setActiveColor(Color.WHITE);
//        navigationTabStrip.setOnPageChangeListener(...);
//        navigationTabStrip.setOnTabStripSelectedIndexListener(...);
    }
   /* private void initUI(View view) {
        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.vp_horizontal_ntb);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public boolean isViewFromObject(final View view, final Object object) {
                return view.equals(object);
            }

            @Override
            public void destroyItem(final View container, final int position, final Object object) {
                ((ViewPager) container).removeView((View) object);
            }


            @Override
            public Object instantiateItem(final ViewGroup container, final int position) {
                final View view = LayoutInflater.from(
                        getActivity()).inflate(R.layout.fragment_product_recycle, null, false);
                findViews(view);
                product_list = new ArrayList<>();

                adapter_ = new ProductAdapter(getContext(), product_list);
                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
                recyclerCategory.setLayoutManager(mLayoutManager);
                recyclerCategory.setAdapter(adapter_);
                if (position == 0) {

                    prepareAlbums2();
                }
                if (position == 2) {

                    prepareAlbums();
                }
                container.addView(view);
                return view;
            }
        });

        final String[] colors = getResources().getStringArray(R.array.default_preview);

        final NavigationTabBar navigationTabBar = (NavigationTabBar) view.findViewById(R.id.ntb_horizontal);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();


        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_finish),
                        Color.parseColor(colors[1]))

                        .title("Classic")
                        .build()
        );

        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_finish),
                        Color.parseColor(colors[1]))
                        .title("New Classic")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_finish),
                        Color.parseColor(colors[1]))
                        .title("Modern")
                        .build()
        );
        navigationTabBar.setModels(models);
        navigationTabBar.setInactiveColor(getResources().getColor(R.color.colorWhite));
        navigationTabBar.setBgColor(getResources().getColor(R.color.colorBlack));
        navigationTabBar.setActiveColor(getResources().getColor(R.color.colorBlack));
        navigationTabBar.setViewPager(viewPager, 2);
        navigationTabBar.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
                Log.e("onPageScrolled", "onPageScrolled: " + position);

            }
            @Override
            public void onPageSelected(final int position) {
                navigationTabBar.getModels().get(position).hideBadge();
            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });

        navigationTabBar.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < navigationTabBar.getModels().size(); i++) {
                    final NavigationTabBar.Model model = navigationTabBar.getModels().get(i);
                    navigationTabBar.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            model.showBadge();
                        }
                    }, i * 100);
                }
            }
        }, 500);
    }*/
}