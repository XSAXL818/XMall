package com.xsaxl.xnoteplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

public class AddressManagerActivity extends AppCompatActivity {

    private Button  addr_manager_back_button;
    private Button  addr_manager_add_button;
    private RecyclerView addr_manager_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_manager);


        addr_manager_back_button = findViewById(R.id.addr_manager_back_button);
        addr_manager_add_button = findViewById(R.id.addr_manager_add_button);
        addr_manager_recycler = findViewById(R.id.addr_manager_recycler);

        addr_manager_back_button.setOnClickListener(v -> {
            finish();
        });


    }
}