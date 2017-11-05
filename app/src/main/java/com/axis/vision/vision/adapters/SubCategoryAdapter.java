package com.axis.vision.vision.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.axis.vision.vision.activites.Main;
import com.axis.vision.vision.models.Category;

import java.util.List;

import com.axis.vision.vision.R;
import com.bumptech.glide.Glide;

/**
 * Created by new laptoop on 31/10/2017.
 */

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.MyViewHolder> {

    private Context mContext;
    private final List<Category> category_list;

    public SubCategoryAdapter(Context mContext, List<Category> albumList) {
        this.mContext = mContext;
        this.category_list = albumList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.elem_sub_category_title);
            thumbnail = (ImageView) view.findViewById(R.id.elem_sub_category_image);
        }
    }

    @Override
    public int getItemCount() {
        return category_list.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.element_sub_category, parent, false);

        return new MyViewHolder(itemView);
    }//

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Category album = category_list.get(position);
        holder.title.setText(album.name);

        // loading album cover using Glide library
        // Glider.with(mContext).load(album.image).into(holder.thumbnail);
        Glide.with(mContext).load(album.image).centerCrop().into(holder.thumbnail);
        final int pos = position;
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyViewHolder holder = (MyViewHolder) view.getTag();

                Bundle b = new Bundle();
                b.putString("Key", category_list.get(pos).name + "");

                com.axis.vision.vision.fragments.main.Product ProductFragment = new com.axis.vision.vision.fragments.main.Product();
                ProductFragment.setArguments(b);
                ((Main) mContext).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_containt, ProductFragment)
                        .addToBackStack("products")
                        .commit();

                Toast.makeText(mContext, category_list.get(pos).name, Toast.LENGTH_LONG).show();
            }
        });
    }
}
