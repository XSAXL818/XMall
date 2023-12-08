package com.xsaxl.xnoteplus.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.entity.Address;

import java.util.List;

public class AddressItemAdapter extends RecyclerView.Adapter<AddressItemAdapter.ViewHolder>  {

    private List<Address> data;

    public AddressItemAdapter(List<Address> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.address_manager_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.addr_manager_item_name_image.setText(data.get(position).getAddr_name().substring(0,1));
        holder.addr_manager_item_name_phone.setText(data.get(position).getAddr_name()+" "+data.get(position).getAddr_phone());
        holder.addr_manager_item_address.setText(data.get(position).getAddr_region()+" "+ data.get(position).getAddr_city());



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private Button addr_manager_item_name_image;
        private TextView addr_manager_item_name_phone;
        private TextView addr_manager_item_address;
        private Button addr_manager_item_edit_button;
        private Button addr_manager_item_delete_button;
        private Button addr_manager_item_set_default;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            addr_manager_item_name_image = itemView.findViewById(R.id.addr_manager_item_name_image);
            addr_manager_item_name_phone = itemView.findViewById(R.id.addr_manager_item_name_phone);
            addr_manager_item_address = itemView.findViewById(R.id.addr_manager_item_address);
            addr_manager_item_edit_button = itemView.findViewById(R.id.addr_manager_item_edit_button);
            addr_manager_item_delete_button = itemView.findViewById(R.id.addr_manager_item_delete_button);
            addr_manager_item_set_default = itemView.findViewById(R.id.addr_manager_item_set_default);



        }
    }
}
