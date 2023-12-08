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

//        user = MyApplication.getInstance().getUser();
        user = new User();
        user.setUser_id(1);

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
            public void OnSetDefaultListener(boolean isChecked, int postion) {
                Toast.makeText(AddressManagerActivity.this, "设置默认地址", Toast.LENGTH_SHORT).show();
                Address clickAddress = addressList.get(postion);
                if ( defaultAddress.compareTo(clickAddress) == 0 || defaultAddress == null  ){
                    Toast.makeText(AddressManagerActivity.this, "已经是默认地址", Toast.LENGTH_SHORT).show();
                } else {

                    // 更新recyclerview
                    for (int i = 0; i < addressList.size(); i++) {
                        addressList.get(i).setAddr_default(0);
                    }
                    addressList.get(postion).setAddr_default(1);

                    // 更新数据库
                    defaultAddress.setAddr_default(0);
                    clickAddress.setAddr_default(1);
                    addressDao.update(defaultAddress);
                    addressDao.update(clickAddress);
                    defaultAddress = clickAddress;
                }


                UpdateRecyclerView();
            }

            @Override
            public void OnEditListener(int postion) {
                Toast.makeText(AddressManagerActivity.this, "编辑地址", Toast.LENGTH_SHORT).show();
                UpdateRecyclerView();
            }

            @Override
            public void OnDeleteListener(int postion) {
                Toast.makeText(AddressManagerActivity.this, "删除地址", Toast.LENGTH_SHORT).show();
                UpdateRecyclerView();

                addressDao.delete(addressList.get(postion));

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
                addressItemAdapter.notifyDataSetChanged();
            }
        };
        handler.post(r);
    }
}