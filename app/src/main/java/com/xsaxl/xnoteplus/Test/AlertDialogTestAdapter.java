package com.xsaxl.xnoteplus.Test;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.entity.SpuAttr;

import java.util.List;

public class AlertDialogTestAdapter extends RecyclerView.Adapter<AlertDialogTestAdapter.MyHolder> {

    private List<SpuAttr> data;

    public AlertDialogTestAdapter(List<SpuAttr> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public AlertDialogTestAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.alert_item_layout,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlertDialogTestAdapter.MyHolder holder, int position) {
        holder.alert_item_name.setText(data.get(position).getSpu_attr_name());
        holder.alert_item_value.setText(data.get(position).getSpu_attr_value());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView alert_item_name;
        private TextView alert_item_value;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            alert_item_name = itemView.findViewById(R.id.alert_item_name);
            alert_item_value = itemView.findViewById(R.id.alert_item_value);
        }
    }
}
