package com.xsaxl.xnoteplus.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.xsaxl.xnoteplus.R;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

public class BannerActivity extends AppCompatActivity {

    private Banner banner;

    @SuppressLint("SuspiciousIndentation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        banner = findViewById(R.id.banner1);


            //--------------------------简单使用-------------------------------
//            banner.addBannerLifecycleObserver(this)//添加生命周期观察者
//                    .setAdapter(new BannerExampleAdapter(DataBean.getTestData()))
//                    .setIndicator(new CircleIndicator(this));

            //—————————————————————————如果你想偷懒，而又只是图片轮播————————————————————————
            banner.setAdapter(new BannerImageAdapter<DataBean>(DataBean.getTestData3()) {
                        @Override
                        public void onBindView(BannerImageHolder holder, DataBean data, int position, int size) {
                            //图片加载自己实现
                            Glide.with(holder.itemView)
                                    .load(data.imageUrl)
                                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                                    .into(holder.imageView);
                        }
                    })
                    .addBannerLifecycleObserver(this)//添加生命周期观察者
                    .setIndicator(new CircleIndicator(this));
            //更多使用方法仔细阅读文档，或者查看demo

    }
}