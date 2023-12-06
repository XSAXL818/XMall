package com.xsaxl.xnoteplus.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xsaxl.xnoteplus.OrderHomeActivity;
import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.Store;
import com.xsaxl.xnoteplus.Util.Util;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyHolder> {
    private List<Store> stores;
    public StoreAdapter(List<Store> list){
        this.stores = list;
    }
    private Context context;
    private GoodAdapter adapter;
    private RecyclerView.LayoutManager manager;

    public StoreAdapter(List<Store> stores, Context context) {
        this.stores = stores;
        this.context = context;
    }


    public static class MyHolder extends RecyclerView.ViewHolder{
        private RecyclerView store_goods;
        private TextView store_name;
        private GoodAdapter goodAdapter;
        private RecyclerView.LayoutManager manager;

        public MyHolder(View itemView) {
            super(itemView);
            store_goods = (RecyclerView) itemView.findViewById(R.id.store_goods);
            manager = new LinearLayoutManager(itemView.getContext());
            store_goods.setLayoutManager(manager);
            store_name = itemView.findViewById(R.id.store_name);
            manager = new LinearLayoutManager(itemView.getContext());
            store_goods.setLayoutManager(manager);

        }
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_item,null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(final MyHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.goodAdapter = new GoodAdapter(stores.get(position).getGoods());
        holder.store_goods.setAdapter(holder.goodAdapter);
        holder.store_name.setText(stores.get(position).getBrand_name());


        //实现第二层RecyclerView的回调接口
        holder.goodAdapter.setCallBack(new GoodAdapter.allCheck() {
            @Override
            public void OnCheckListener(boolean isChecked, int childpostion) {
                //将店铺商品的checkbox的点击变化事件进行回调
                if (mCallBack!=null){
                    mCallBack.OnItemCheckListener(isChecked,position,childpostion);
                }
            }
        });



        holder.itemView.setTag(stores.get(position));
    }
    @Override
    public int getItemCount() {
        return stores.size();
    }

    private allCheck mCallBack;
    public void setCallBack( allCheck callBack) {
        mCallBack = callBack;
    }
    public interface allCheck{
        //回调函数 将店铺的checkbox的点击变化事件进行回调
        public void OnCheckListener(boolean isSelected,int position);
        //回调函数 将店铺商品的checkbox的点击变化事件进行回调
        public void OnItemCheckListener(boolean isSelected,int parentposition,int chaildposition);
    }

}