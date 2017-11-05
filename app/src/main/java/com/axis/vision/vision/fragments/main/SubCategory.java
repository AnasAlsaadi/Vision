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
import com.axis.vision.vision.adapters.SubCategoryAdapter;
import com.axis.vision.vision.models.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Anas Alsaadi on 10/30/2017.
 */

public class SubCategory extends android.support.v4.app.Fragment {

    private RecyclerView recyclerCategory;
    private SubCategoryAdapter adapter_;
    private List<com.axis.vision.vision.models.Category> albumList;

    private void findViews(View rootView) {
        recyclerCategory = (RecyclerView) rootView.findViewById(R.id.recycler_category);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle b = this.getArguments();
        if (b != null) {
            String s = b.getString("Key");
            Log.e("sss", s);
        }
        View v = inflater.inflate(R.layout.fragment_category, container, false);
        findViews(v);
        albumList = new ArrayList<>();

        adapter_ = new SubCategoryAdapter(this.getContext(), albumList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerCategory.setLayoutManager(mLayoutManager);
        recyclerCategory.setAdapter(adapter_);


        prepareAlbums();
        return v;
    }



    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.residential,
                R.drawable.commercial,
                R.drawable.exterior,};

        com.axis.vision.vision.models.Category a = new com.axis.vision.vision.models.Category("RESIDENTIAL", R.drawable.residential);
        com.axis.vision.vision.models.Category b = new com.axis.vision.vision.models.Category("COMMERCIAL", R.drawable.commercial);
        com.axis.vision.vision.models.Category c = new com.axis.vision.vision.models.Category("EXTERIOR", R.drawable.exterior);
        albumList.add(a);
        albumList.add(b);
        albumList.add(c);
        com.axis.vision.vision.models.Category a1 = new com.axis.vision.vision.models.Category("RESIDENTIAL", R.drawable.residential);
        com.axis.vision.vision.models.Category b1 = new com.axis.vision.vision.models.Category("COMMERCIAL", R.drawable.commercial);
        com.axis.vision.vision.models.Category c1 = new com.axis.vision.vision.models.Category("EXTERIOR", R.drawable.exterior);
        albumList.add(a1);
        albumList.add(b1);
        albumList.add(c1);
        adapter_.notifyDataSetChanged();
    }

    private void prepareAlbums2() {
        int[] covers = new int[]{
                R.drawable.residential,
                R.drawable.commercial,
                R.drawable.exterior,};

        com.axis.vision.vision.models.Category a = new com.axis.vision.vision.models.Category("RESIDENTIAL", R.drawable.residential);
        com.axis.vision.vision.models.Category b = new com.axis.vision.vision.models.Category("COMMERCIAL", R.drawable.commercial);
        com.axis.vision.vision.models.Category c = new com.axis.vision.vision.models.Category("EXTERIOR", R.drawable.exterior);
        albumList.add(a);
        adapter_.notifyDataSetChanged();
    }

}