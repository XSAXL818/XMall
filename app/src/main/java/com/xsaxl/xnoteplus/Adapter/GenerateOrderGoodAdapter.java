package com.xsaxl.xnoteplus.Adapter;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.recyclerview.widget.RecyclerView;

import com.xsaxl.xnoteplus.Good;
import com.xsaxl.xnoteplus.R;

import java.util.List;

public class GenerateOrderGoodAdapter extends RecyclerView.Adapter<GenerateOrderGoodAdapter.MyHolder>{
    private List<Good> goods;


    public GenerateOrderGoodAdapter(List<Good> goods) {
        this.goods = goods;
    }

    @NonNull
    @Override
    public GenerateOrderGoodAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.generate_order_good_layout,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenerateOrderGoodAdapter.MyHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.generate_order_good_image.setImageResource(goods.get(position).getGood_image());
        holder.generate_order_good_image_name.setText(goods.get(position).getGood_name());
        holder.generate_order_good_image_sku.setText(goods.get(position).getGood_sku());
        holder.generate_order_good_image_price.setText(goods.get(position).getGood_price()+"");
        holder.generate_order_good_image_number.setText(goods.get(position).getGood_number()+"");

        holder.generate_order_good_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.OnCheckListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return goods.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private ImageFilterView generate_order_good_image;
        private TextView generate_order_good_image_name;
        private TextView generate_order_good_image_sku;
        private TextView generate_order_good_image_price;
        private TextView generate_order_good_image_number;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            generate_order_good_image = itemView.findViewById(R.id.generate_order_good_image);
            generate_order_good_image_name = itemView.findViewById(R.id.generate_order_good_image_name);
            generate_order_good_image_sku = itemView.findViewById(R.id.generate_order_good_image_sku);
            generate_order_good_image_price = itemView.findViewById(R.id.generate_order_good_image_price);
            generate_order_good_image_number = itemView.findViewById(R.id.generate_order_good_image_number);


        }
    }

    private allCheck mCallBack;
    public void setCallBack(allCheck callBack) {
        mCallBack = callBack;
    }
    public interface allCheck {
        //回调函数 将店铺商品的checkbox的点击变化事件进行回调
        public void OnCheckListener(int childpostion);
    }
}
