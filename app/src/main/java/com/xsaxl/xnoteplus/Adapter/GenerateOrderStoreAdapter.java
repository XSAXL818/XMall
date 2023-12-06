package com.xsaxl.xnoteplus.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.Store;

import java.util.List;

public class GenerateOrderStoreAdapter extends RecyclerView.Adapter<GenerateOrderStoreAdapter.MyHolder> {

    private List<Store> stores;

    public GenerateOrderStoreAdapter(List<Store> stores) {
        this.stores = stores;
    }

    @NonNull
    @Override
    public GenerateOrderStoreAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.generate_order_store_layout,null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GenerateOrderStoreAdapter.MyHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.generate_order_store_name.setText(stores.get(position).getBrand_name());
        holder.generateOrderGoodAdapter = new GenerateOrderGoodAdapter(stores.get(position).getGoods());
        holder.generate_order_store_goods.setAdapter(holder.generateOrderGoodAdapter);

        //实现第二层RecyclerView的回调接口
        holder.generateOrderGoodAdapter.setCallBack(new GenerateOrderGoodAdapter.allCheck() {
            @Override
            public void OnCheckListener(int position) {
                mCallBack.OnItemCheckListener(position,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stores.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView generate_order_store_name;
        private RecyclerView generate_order_store_goods;
        private GenerateOrderGoodAdapter generateOrderGoodAdapter;
        private RecyclerView.LayoutManager manager;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            generate_order_store_goods = itemView.findViewById(R.id.generate_order_goods);
            generate_order_store_name = itemView.findViewById(R.id.generate_order_store_name);


            manager = new LinearLayoutManager(itemView.getContext());
            generate_order_store_goods.setLayoutManager(manager);



        }
    }
    private allCheck mCallBack;
    public void setCallBack( allCheck callBack) {
        mCallBack = callBack;
    }
    public interface allCheck{
        //回调函数 将店铺的checkbox的点击变化事件进行回调
        public void OnCheckListener(int position);
        //回调函数 将店铺商品的checkbox的点击变化事件进行回调
        public void OnItemCheckListener(int parentposition,int chaildposition);
    }
}
