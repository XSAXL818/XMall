package com.xsaxl.xnoteplus.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.xsaxl.xnoteplus.Good;
import com.xsaxl.xnoteplus.R;

import java.util.List;

public class GoodAdapter extends RecyclerView.Adapter<GoodAdapter.MyHolder> {
    private List<Good> goods;
    public GoodAdapter(List<Good> goods) {
        this.goods = goods;
    }
    public static class MyHolder extends RecyclerView.ViewHolder {
        private TextView good_name;
        private ImageView good_image;
        private TextView good_sku;
        private TextView good_price;

        public MyHolder(View itemView) {
            super(itemView);
            good_name = (TextView) itemView.findViewById(R.id.good_name);
            good_image = (ImageView) itemView.findViewById(R.id.good_image);
            good_sku = (TextView) itemView.findViewById(R.id.good_sku);
            good_price = (TextView) itemView.findViewById(R.id.good_price);

        }
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.good_item, null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(final MyHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.good_image.setImageResource(goods.get(position).getGood_image());
        holder.good_name.setText(goods.get(position).getGood_name());
        holder.good_sku.setText(goods.get(position).getGood_sku());
        holder.good_price.setText(goods.get(position).getGood_price()+"");

        holder.good_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.OnCheckListener(true,position);
            }
        });
        holder.good_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.OnCheckListener(true,position);
            }
        });
        holder.good_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.OnCheckListener(true,position);
            }
        });
        holder.good_sku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.OnCheckListener(true,position);
            }
        });




        holder.itemView.setId(position);
    }
    @Override
    public int getItemCount() {
        return goods.size();
    }


    private allCheck mCallBack;
    public void setCallBack(allCheck callBack) {
        mCallBack = callBack;
    }
    public interface allCheck {
        //回调函数 将店铺商品的checkbox的点击变化事件进行回调
        public void OnCheckListener(boolean isChecked, int childpostion);
    }


}