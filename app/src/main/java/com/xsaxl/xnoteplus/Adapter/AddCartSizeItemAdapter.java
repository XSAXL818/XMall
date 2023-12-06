package com.xsaxl.xnoteplus.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.recyclerview.widget.RecyclerView;

import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.entity.SkuAttr;

import java.util.List;

public class AddCartSizeItemAdapter extends RecyclerView.Adapter<AddCartSizeItemAdapter.ViewHolder>{


    private List<SkuAttr> data;
    private Context context;

    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener( OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }
    public interface OnItemClickListener{
        void onItemClick(LinearLayout layout,int position);
    }


    public AddCartSizeItemAdapter(List<SkuAttr> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public AddCartSizeItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.add_cart_size_item_layout,null);
        return new AddCartSizeItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddCartSizeItemAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.add_cart_item_size_name.setText(data.get(position).getSku_attr_name());

        holder.add_cart_item_size_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(holder.add_cart_item_size_layout,position);
            }
        });
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView add_cart_item_size_name;
        private LinearLayout add_cart_item_size_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            add_cart_item_size_name = itemView.findViewById(R.id.add_cart_item_size_name);
            add_cart_item_size_layout = itemView.findViewById(R.id.add_cart_item_size_layout);


        }
    }
}
