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

import androidx.recyclerview.widget.RecyclerView;

import com.xsaxl.xnoteplus.Good;
import com.xsaxl.xnoteplus.R;

import java.util.List;

public class recyclerAdapter1 extends RecyclerView.Adapter<recyclerAdapter1.MyHolder> {
//    private List<cbean> cbeanList, cbeanList1;
    private List<Good> goods;
    public recyclerAdapter1(List<Good> goods) {
        this.goods = goods;
//        cbeanList1 = cbeanList;
    }
    public static class MyHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private CheckBox checkBox;
        private ImageView check_iv;
        private TextView check_name;
        private TextView check_sku;
        private TextView check_price;
        private LinearLayout check_info;
        private TextView check_num;

        public MyHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.check_name);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox1);
            check_iv = (ImageView) itemView.findViewById(R.id.check_iv);
            check_name = (TextView) itemView.findViewById(R.id.check_name);
            check_sku = (TextView) itemView.findViewById(R.id.check_sku);
            check_price = (TextView) itemView.findViewById(R.id.check_price);
            check_info = (LinearLayout) itemView.findViewById(R.id.check_info);
            check_num = (TextView) itemView.findViewById(R.id.check_num);
        }
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.check_item, null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(final MyHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.checkBox.setChecked(goods.get(position).isIscheck());
        holder.check_iv.setImageResource(goods.get(position).getGood_image());
        holder.check_name.setText(goods.get(position).getGood_name());
        holder.check_sku.setText(goods.get(position).getGood_sku());
        holder.check_price.setText(goods.get(position).getGood_price()+"");
        holder.check_num.setText("数量："+goods.get(position).getGood_number()+"");

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //将商品的checkbox的点击变化事件进行回调给第一个Recyclerview
                if (mCallBack != null) {
                    mCallBack.OnCheckListener(isChecked, position);
                }
            }
        });

        holder.check_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onImageClickListener != null) {
                    onImageClickListener.onImageClick(position);
                }
            }
        });
        holder.check_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onImageClickListener != null) {
                    onImageClickListener.onImageClick(position);
                }
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

    private OnImageClickListener onImageClickListener;
    public void setOnImageClickListener(OnImageClickListener onImageClickListener) {
        this.onImageClickListener = onImageClickListener;
    }
    public interface OnImageClickListener {
        public void onImageClick( int childpostion );
    }
}