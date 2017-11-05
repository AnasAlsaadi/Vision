package com.axis.vision.vision.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import com.axis.vision.vision.R;
import com.axis.vision.vision.models.Product;
import com.bumptech.glide.Glide;

/**
 * Created by new laptoop on 31/10/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private Context mContext;
    private final List<Product> product_list;

    public ProductAdapter(Context mContext, List<Product> product_list) {
        this.mContext = mContext;
        this.product_list = product_list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.elem_product_title);
            thumbnail = (ImageView) view.findViewById(R.id.elem_product_image);
        }
    }

    @Override
    public int getItemCount() {
        return product_list.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.element_product, parent, false);

        return new MyViewHolder(itemView);
    }//

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Product album = product_list.get(position);
        holder.title.setText(album.name);

        // loading album cover using Glide library
        // Glider.with(mContext).load(album.image).into(holder.thumbnail);
        Glide.with(mContext).load(album.image).centerCrop().into(holder.thumbnail);
        final int pos = position;
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(mContext, product_list.get(pos).name, Toast.LENGTH_LONG).show();
            }
        });
    }
}
