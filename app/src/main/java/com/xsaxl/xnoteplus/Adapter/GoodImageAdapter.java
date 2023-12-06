package com.xsaxl.xnoteplus.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.xsaxl.xnoteplus.entity.Image;

import java.util.ArrayList;
import java.util.List;

public class GoodImageAdapter extends PagerAdapter {

    private List<Image> images;
    private Context context;
    private List<ImageView> imageViews = new ArrayList<>();

    public GoodImageAdapter(List<Image> images, Context context) {
        this.images = images;
        this.context = context;
        for( Image image : images){
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(image.getImage_url());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageViews.add(imageView);
        }
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView item = imageViews.get(position);
        container.addView(item);
        return item;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(imageViews.get(position));
    }
}
