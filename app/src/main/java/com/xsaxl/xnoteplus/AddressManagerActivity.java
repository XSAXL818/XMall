package com.xsaxl.xnoteplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.Toast;

import com.xsaxl.xnoteplus.Adapter.AddressItemAdapter;
import com.xsaxl.xnoteplus.Adapter.SpuAdapter;
import com.xsaxl.xnoteplus.Adapter.recyclerAdapter;
import com.xsaxl.xnoteplus.Util.GridSpacingItemDecoration;
import com.xsaxl.xnoteplus.dao.AddressDao;
import com.xsaxl.xnoteplus.dao.UserDao;
import com.xsaxl.xnoteplus.entity.Address;
import com.xsaxl.xnoteplus.entity.User;

import java.util.List;

public class AddressManagerActivity extends AppCompatActivity {

    private Button  addr_manager_back_button;
    private Button  addr_manager_add_button;
    private RecyclerView addr_manager_recycler;
    private AddressItemAdapter adapter;
    private RecyclerView.LayoutManager manager;
    private List<Address> addressList;
    private AddressDao addressDao;
    private UserDao userDao;
    private User user;
    private AddressItemAdapter addressItemAdapter;
    private Address defaultAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_manager);


        addr_manager_back_button = findViewById(R.id.addr_manager_back_button);
        addr_manager_add_button = findViewById(R.id.addr_manager_add_button);
        addr_manager_recycler = findViewById(R.id.addr_manager_recycler);

        addressDao = MyApplication.getInstance().getXCartDatabase().getAddressDao();
        userDao = MyApplication.getInstance().getXCartDatabase().getUserDao();

        user = MyApplication.getInstance().getUser();

        addressList = addressList = addressDao.queryById(user.getUser_id());


//        manager = new LinearLayoutManager(this);
//        addr_manager_recycler.setLayoutManager(manager);
//        //优化性能
//        addr_manager_recycler.setHasFixedSize(true);
//        adapter = new AddressItemAdapter(addressList);
//        addr_manager_recycler.setAdapter(adapter);

        addressItemAdapter = new AddressItemAdapter(addressList);
        addr_manager_recycler.setAdapter(addressItemAdapter);
        int spacing = (int) getResources().getDisplayMetrics().density * 10;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        addr_manager_recycler.setLayoutManager(gridLayoutManager);
        addr_manager_recycler.addItemDecoration(new GridSpacingItemDecoration(spacing));
        defaultAddress = addressDao.queryByDefault(user.getUser_id());

        addressItemAdapter.setCallBack(new AddressItemAdapter.allCheck() {
            @Override
            public void OnSetDefaultListener(boolean isChecked, int childpostion) {
                Toast.makeText(AddressManagerActivity.this, "设置默认地址", Toast.LENGTH_SHORT).show();
                UpdateRecyclerView();
            }

            @Override
            public void OnEditListener(int childpostion) {
                Toast.makeText(AddressManagerActivity.this, "编辑地址", Toast.LENGTH_SHORT).show();
                UpdateRecyclerView();
            }

            @Override
            public void OnDeleteListener(int childpostion) {
                Toast.makeText(AddressManagerActivity.this, "删除地址", Toast.LENGTH_SHORT).show();
                UpdateRecyclerView();

                addressDao.delete(addressList.get(childpostion));

            }
        });


        addr_manager_back_button.setOnClickListener(v -> {
            finish();
        });


    }
    private void UpdateRecyclerView() {
        Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                adapter.notifyDataSetChanged();
            }
        };
        handler.post(r);
    }
}