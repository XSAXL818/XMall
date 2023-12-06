package com.xsaxl.xnoteplus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xsaxl.xnoteplus.Adapter.GoodAdapter;
import com.xsaxl.xnoteplus.Adapter.StoreAdapter;
import com.xsaxl.xnoteplus.Adapter.recyclerAdapter;
import com.xsaxl.xnoteplus.Util.Util;
import com.xsaxl.xnoteplus.dao.BrandDao;
import com.xsaxl.xnoteplus.dao.OrderDao;
import com.xsaxl.xnoteplus.dao.OrderDetailDao;
import com.xsaxl.xnoteplus.entity.Brand;
import com.xsaxl.xnoteplus.entity.Cart;
import com.xsaxl.xnoteplus.entity.Order;
import com.xsaxl.xnoteplus.entity.OrderDetail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderHomeActivity extends AppCompatActivity {

    private EditText order_input;
    private Button order_ensure;
    private Button order_all;
    private Button order_pay;
    private Button order_fahuo;
    private Button order_shouhuo;
    private Button order_shouhou;
    private RecyclerView order_recycler;

//    private recyclerAdapter adapter;
    private StoreAdapter storeAdapter;
    private RecyclerView.LayoutManager manager;
    private List<Store> stores;
    private List<Good> goods1,goods2,goods3;

    private List<OrderDetail> orderDetails;
    private List<Order> orders;
    private OrderDao orderDao;
    private OrderDetailDao orderDetailsDao;
    private BrandDao brandDao;

    private int user_id;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_home);

        order_input = findViewById(R.id.order_input);
        order_ensure = findViewById(R.id.order_ensure);
        order_all = findViewById(R.id.order_all);
        order_pay = findViewById(R.id.order_pay);
        order_fahuo = findViewById(R.id.order_fahuo);
        order_shouhuo = findViewById(R.id.order_shouhuo);
        order_shouhou = findViewById(R.id.order_shouhou);
        order_recycler = findViewById(R.id.order_recycler);

        orderDao = MyApplication.getInstance().getXCartDatabase().getOrderDao();
        orderDetailsDao = MyApplication.getInstance().getXCartDatabase().getOrderDetailDao();
        brandDao = MyApplication.getInstance().getXCartDatabase().getBrandDao();
        user_id = MyApplication.getInstance().getUser().getUser_id();

        stores = new ArrayList<Store>();
        orders = new ArrayList<Order>();
        orderDetails = new ArrayList<OrderDetail>();

//        List<Integer> integers = orderDetailsDao.queryBrandIdByUserId(MyApplication.getInstance().getUser().getUser_id());
        // 获取用户的所有订单号
        List<Integer> orderIds = orderDao.queryOrderIdByUserId(user_id);


        for (int i = 0;i < orderIds.size();i++){

            // 获取该订单的所有商品
            List<OrderDetail> orderDetails = orderDetailsDao.queryByOrderId(orderIds.get(i));
            // 通过某个订单找到店铺
            Brand brand = brandDao.queryById(orderDetails.get(0).getBrand_id());

            // 获取店铺的名称等信息
            Store store = new Store();

            // 转移给store 和 good
            store.setBrand_id(brand.getBrand_id());
            store.setBrand_name(brand.getBrand_name());

            List<Good> goods = new ArrayList<>();
            for (int j = 0;j < orderDetails.size();j++){
                Good good = new Good();
                good.setGood_name(orderDetails.get(j).getGood_name());
                good.setGood_image(orderDetails.get(j).getGood_image());
                good.setGood_sku(orderDetails.get(j).getGood_sku());
                good.setGood_price(orderDetails.get(j).getGood_price());
                good.setGood_number(orderDetails.get(j).getGood_number());
                good.setSpu_id(orderDetails.get(j).getSpu_id());
                goods.add(good);
            }
            store.setGoods(goods);
            stores.add(store);
        }



//        // 第一个店铺的数据
//        goods1 = new ArrayList<Good>();
//        Good good1 = new Good("小米10", 1, R.drawable.laoshu,"16G+256G",3999);
//        Good good2 = new Good("小米10", 1, R.drawable.laoshu,"16G+256G",3999);
//        Good good3 = new Good("小米10", 1, R.drawable.laoshu,"16G+256G",3999);
//        goods1.add(good1);
//        goods1.add(good2);
//        goods1.add(good3);
//        Store store1 = new Store(1,"店名1", goods1);
//
//        // 第二个店铺的数据
//        goods2 = new ArrayList<Good>();
//        Good good4 = new Good("小米10", 1, R.drawable.laoshu,"16G+256G",3999);
//        Good good5 = new Good("小米10", 1, R.drawable.laoshu,"16G+256G",3999);
//        Good good6 = new Good("小米10", 1, R.drawable.laoshu,"16G+256G",3999);
//        goods2.add(good4);
//        goods2.add(good5);
//        goods2.add(good6);
//        Store store2 = new Store(2,"店名2", goods2);
//
//        // 将店铺加入到列表中
//        stores.add(store1);
//        stores.add(store2);


        manager = new LinearLayoutManager(this);
        order_recycler.setLayoutManager(manager);
        //优化性能
        order_recycler.setHasFixedSize(true);
        storeAdapter = new StoreAdapter(stores,this);
        order_recycler.setAdapter(storeAdapter);

        storeAdapter.setCallBack(new StoreAdapter.allCheck() {

            @Override
            public void OnCheckListener(boolean isSelected, int position) {

            }

            @Override
            public void OnItemCheckListener(boolean isSelected, int parentposition, int chaildposition) {
                Intent intent = new Intent(OrderHomeActivity.this,OrderDetailActivity.class);
                Bundle bundle = new Bundle();
                // 传入订单单号
                bundle.putInt("order_id",orderIds.get(parentposition));
//                bundle.putSerializable("store", (Serializable) stores.get(parentposition));
                intent.putExtras(bundle);
                startActivity(intent);
            }

        });




    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}