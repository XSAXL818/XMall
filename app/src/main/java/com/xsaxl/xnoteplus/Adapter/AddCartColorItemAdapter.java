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

public class AddCartColorItemAdapter extends RecyclerView.Adapter<AddCartColorItemAdapter.ViewHolder>{


    private List<SkuAttr> data;
    private Context context;

    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener( OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }
    public interface OnItemClickListener{
        void onItemClick(LinearLayout layout,int position);
    }


    public AddCartColorItemAdapter(List<SkuAttr> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public AddCartColorItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.add_cart_color_item_layout,null);
        return new AddCartColorItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddCartColorItemAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.add_cart_item_color_image.setImageResource(data.get(position).getSku_attr_image());
        holder.add_cart_item_color_name.setText(data.get(position).getSku_attr_name());
        holder.add_cart_item_color_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(holder.add_cart_item_color_layout,position);
//                holder.add_cart_item_color_layout.setBackgroundResource(R.drawable.add_cart_color_click_shape);
            }
        });
        holder.add_cart_item_color_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(holder.add_cart_item_color_layout,position);
            }
        });
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageFilterView add_cart_item_color_image;
        private TextView add_cart_item_color_name;
        private LinearLayout add_cart_item_color_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            add_cart_item_color_image = itemView.findViewById(R.id.add_cart_item_color_image);
            add_cart_item_color_name = itemView.findViewById(R.id.add_cart_item_color_name);
            add_cart_item_color_layout = itemView.findViewById(R.id.add_cart_item_color_layout);


        }
    }
}
