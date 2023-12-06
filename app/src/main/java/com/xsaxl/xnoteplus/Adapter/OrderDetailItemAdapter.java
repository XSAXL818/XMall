package com.xsaxl.xnoteplus.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.entity.OrderDetail;

import java.util.List;

public class OrderDetailItemAdapter extends RecyclerView.Adapter<OrderDetailItemAdapter.ViewHolder>{

    private List<OrderDetail> orderDetails;
    private Context context;

    public OrderDetailItemAdapter(List<OrderDetail> orderDetails, Context context) {
        this.orderDetails = orderDetails;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderDetailItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.order_detail_item_layout,null);
        return new OrderDetailItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderDetailItemAdapter.ViewHolder holder, int position) {
        holder.order_detail_item_image.setImageResource(orderDetails.get(position).getGood_image());
        holder.order_detail_item_name.setText(orderDetails.get(position).getGood_name());
        holder.order_detail_item_sku.setText(orderDetails.get(position).getGood_sku());
        holder.order_detail_item_price.setText("实付￥"+orderDetails.get(position).getGood_price()+"");
        holder.order_detail_item_number.setText("数量："+orderDetails.get(position).getGood_number()+"");
    }

    @Override
    public int getItemCount() {
        return orderDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView order_detail_item_image;
        private TextView order_detail_item_name;
        private TextView order_detail_item_sku;
        private TextView order_detail_item_price;
        private TextView order_detail_item_number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            order_detail_item_image = itemView.findViewById(R.id.order_detail_item_image);
            order_detail_item_name = itemView.findViewById(R.id.order_detail_item_name);
            order_detail_item_sku = itemView.findViewById(R.id.order_detail_item_sku);
            order_detail_item_price = itemView.findViewById(R.id.order_detail_item_price);
            order_detail_item_number = itemView.findViewById(R.id.order_detail_item_number);


        }
    }
}
