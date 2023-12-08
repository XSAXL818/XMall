package com.xsaxl.xnoteplus.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.entity.SpuAttr;

import java.util.List;

public class SpuAttrAdapter extends RecyclerView.Adapter<SpuAttrAdapter.ViewHolder> {

    private List<SpuAttr> data;
    private Context context;


    public SpuAttrAdapter(List<SpuAttr> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public SpuAttrAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.spu_attr_layout,null);
        return new SpuAttrAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpuAttrAdapter.ViewHolder holder, int position) {
        holder.attr_image.setImageResource(data.get(position).getSpu_attr_image());
        holder.attr_value.setText(data.get(position).getSpu_attr_value());
        holder.attr_name.setText(data.get(position).getSpu_attr_name());
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView attr_image;
        private TextView attr_name;
        private TextView attr_value;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            attr_image = itemView.findViewById(R.id.attr_image);
            attr_name = itemView.findViewById(R.id.attr_name);
            attr_value = itemView.findViewById(R.id.attr_value);

            attr_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickListener != null){
                        onClickListener.OnClick();
                    }
                }
            });


        }
    }

    private OnClickListener onClickListener;
    public void setOnClickListener(OnClickListener clickListener) {
        this.onClickListener = clickListener;
    }
    public interface OnClickListener{
        //回调函数
        public void OnClick();
    }
}
