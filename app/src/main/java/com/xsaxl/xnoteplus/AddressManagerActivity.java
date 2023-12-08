package com.xsaxl.xnoteplus;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.xsaxl.xnoteplus.Adapter.AddressItemAdapter;
import com.xsaxl.xnoteplus.Adapter.SpuAdapter;
import com.xsaxl.xnoteplus.Adapter.recyclerAdapter;
import com.xsaxl.xnoteplus.Util.GridSpacingItemDecoration;
import com.xsaxl.xnoteplus.Util.Util;
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

    private ActivityResultLauncher<Intent> result;
    private ActivityResultContracts.StartActivityForResult activityResult ;
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


        activityResult = new ActivityResultContracts.StartActivityForResult();


        //添加笔记后返回
        result = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if ( result != null && result.getData() != null ) {
                // 获取返回的数据
                Intent data = result.getData();
                // 获取返回的结果note
                if( result.getResultCode() == RESULT_OK ){// 返回结果正确,增加笔记页面返回结果
                    Address address = new Address();
                    Bundle bundle1 = data.getExtras();
                    address.setAddr_default(bundle1.getInt("default"));
                    address.setAddr_city(bundle1.getString("city"));
                    address.setAddr_region(bundle1.getString("region"));
                    address.setAddr_name(bundle1.getString("name"));
                    address.setAddr_phone(bundle1.getString("phone"));
                    address.setUser_id(user.getUser_id());

                    addressDao.insert(address);
                    addressList.add(address);
                    UpdateRecyclerView();


                } else if(  result.getResultCode() == Activity.BIND_ADJUST_WITH_ACTIVITY){// 查看笔记页面返回结果

//                    Bundle bundle1 = result.getData().getExtras();
//                    Util.showToast(this,"从查看笔记页面返回,position:"+bundle1.getInt("position"));
//
//                    Note note = notes.get(bundle1.getInt("position"));
//                    note.setNote_title(bundle1.getString("title"));
//                    note.setNote_content(bundle1.getString("content"));
//                    note.setNote_time(bundle1.getString("time"));
//                    notes.remove(bundle1.getInt("position"));
//                    notes.add(note);
//                    note_recyclerView.getAdapter().notifyDataSetChanged();
//                    noteDao.updateNote(note);
                }
            } else {
                Util.showToast(this,"添加失败");
            }
//            if (result != null){
//                Util.showToast(this,"添加成功1");
//            } else {
//                Util.showToast(this,"添加失败1");
//            }
//            if( result.getData() != null ){
//                Util.showToast(this,"添加成功2");
//            } else {
//                Util.showToast(this,"添加失败2");
//            }
        });


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

                Address clickAddress = addressList.get(postion);
                if ( defaultAddress.compareTo(clickAddress) == 0 || defaultAddress == null  ){
                    Toast.makeText(AddressManagerActivity.this, "已经是默认地址", Toast.LENGTH_SHORT).show();
                    return;
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


//                addressDao.update(addressList.get(postion));
                UpdateRecyclerView();
            }

            @Override
            public void OnDeleteListener(int postion) {
                Toast.makeText(AddressManagerActivity.this, "删除地址", Toast.LENGTH_SHORT).show();

                addressDao.delete(addressList.get(postion));
                addressList.remove(postion);
                UpdateRecyclerView();
            }
        });


        addr_manager_back_button.setOnClickListener(v -> {
            finish();
        });
        addr_manager_add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                result.launch(new Intent(AddressManagerActivity.this,AddAddressActivity.class));
            }
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