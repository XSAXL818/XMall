package com.xsaxl.xnoteplus.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.recyclerview.widget.RecyclerView;

import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.entity.Spu;

import java.util.List;

public class SpuAdapter extends RecyclerView.Adapter<SpuAdapter.ViewHolder> {

    private List<Spu> data;

    private Context context;

    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(SpuAdapter.OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public SpuAdapter(List<Spu> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.spu_layout,null);
        return new SpuAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpuAdapter.ViewHolder holder, int position) {
        holder.sku_name.setText(data.get(position).getSpu_name());
        holder.sku_image.setImageResource(data.get(position).getSpu_image());
        holder.sku_image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.sku_price.setText("￥"+data.get(position).getSpu_price()+"");
        holder.sku_sales.setText("销量："+data.get(position).getSpu_sales());
        //判断是否设置了监听器
        if(mOnItemClickListener != null){
            //为ItemView设置监听器
            holder.itemView.setOnClickListener(v -> {
                int position1 = holder.getLayoutPosition(); // 1
                mOnItemClickListener.onItemClick(holder.itemView, position1); // 2
            });
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView sku_name;
        ImageFilterView sku_image;
        TextView sku_price;
        TextView sku_sales;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sku_name = itemView.findViewById(R.id.sku_name);
            sku_image = itemView.findViewById(R.id.sku_image);
            sku_price = itemView.findViewById(R.id.sku_price);
            sku_sales = itemView.findViewById(R.id.sku_sales);

        }
    }


}
