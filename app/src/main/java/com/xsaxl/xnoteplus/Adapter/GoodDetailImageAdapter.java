package com.xsaxl.xnoteplus.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xsaxl.xnoteplus.Test.DataBean;
import com.xsaxl.xnoteplus.Test.ImageAdapter;
import com.xsaxl.xnoteplus.entity.Image;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.holder.BannerImageHolder;

import java.util.List;

public abstract class GoodDetailImageAdapter extends BannerAdapter<Image, GoodDetailImageAdapter.BannerViewHolder> {

    public GoodDetailImageAdapter(List<Image> images) {
        super(images);
    }

    @Override
    public GoodDetailImageAdapter.BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new GoodDetailImageAdapter.BannerViewHolder(imageView);
    }

    @Override
    public void onBindView(BannerViewHolder holder, Image data, int position, int size) {
        holder.imageView.setImageResource(data.getImage_url());
    }

    public abstract void onBindView(BannerImageHolder holder, Image data, int position, int size);


    public class BannerViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public BannerViewHolder(@NonNull ImageView itemView) {
            super(itemView);
            this.imageView = itemView;
        }
    }
}
