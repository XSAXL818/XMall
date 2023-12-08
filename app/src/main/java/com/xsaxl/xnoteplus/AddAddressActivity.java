package com.xsaxl.xnoteplus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.xsaxl.xnoteplus.entity.Address;

public class AddAddressActivity extends AppCompatActivity {
    private EditText addr_manager_item_name;
    private EditText addr_manager_item_phone;
    private EditText addr_manager_item_city;
    private EditText addr_manager_item_detail;
    private Button addr_manager_item_save;
    private CheckBox addr_manager_item_set_default;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        addr_manager_item_city = findViewById(R.id.addr_manager_item_city);
        addr_manager_item_detail = findViewById(R.id.addr_manager_item_detail);
        addr_manager_item_name = findViewById(R.id.addr_manager_item_name);
        addr_manager_item_phone = findViewById(R.id.addr_manager_item_phone);
        addr_manager_item_save = findViewById(R.id.addr_manager_item_save);
        addr_manager_item_set_default = findViewById(R.id.addr_manager_item_set_default);




        addr_manager_item_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Address address = new Address();
//                address.setAddr_default(addr_manager_item_set_default.isChecked() ? 1 : 0);
//                address.setAddr_city(addr_manager_item_city.getText().toString());
//                address.setAddr_region(addr_manager_item_detail.getText().toString());
//                address.setAddr_name(addr_manager_item_name.getText().toString());
//                address.setAddr_phone(addr_manager_item_phone.getText().toString());
//                address.setUser_id(1);



                Intent intent = new Intent();
                Bundle bundle1 = new Bundle();
                bundle1.putInt("default",addr_manager_item_set_default.isChecked() ? 1 : 0);
                bundle1.putString("city",addr_manager_item_city.getText().toString());
                bundle1.putString("region",addr_manager_item_detail.getText().toString());
//            bundle1.putInt("note_id",note_id);
//            bundle1.putInt("user_id",user_id);
//            bundle1.putInt("dir_id",dir_id);
                bundle1.putString("name",addr_manager_item_name.getText().toString());
                bundle1.putString("phone",addr_manager_item_phone.getText().toString());
                intent.putExtras(bundle1);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });






    }
}