package com.xsaxl.xnoteplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.xsaxl.xnoteplus.Adapter.GenerateOrderStoreAdapter;
import com.xsaxl.xnoteplus.Adapter.StoreAdapter;
import com.xsaxl.xnoteplus.Adapter.recyclerAdapter;
import com.xsaxl.xnoteplus.Util.MyList;
import com.xsaxl.xnoteplus.dao.AddressDao;
import com.xsaxl.xnoteplus.dao.BrandDao;
import com.xsaxl.xnoteplus.dao.CartDao;
import com.xsaxl.xnoteplus.dao.OrderDao;
import com.xsaxl.xnoteplus.dao.OrderDetailDao;
import com.xsaxl.xnoteplus.dao.SkuDao;
import com.xsaxl.xnoteplus.dao.SpuDao;
import com.xsaxl.xnoteplus.entity.Address;
import com.xsaxl.xnoteplus.entity.Brand;
import com.xsaxl.xnoteplus.entity.Cart;
import com.xsaxl.xnoteplus.entity.Order;
import com.xsaxl.xnoteplus.entity.OrderDetail;
import com.xsaxl.xnoteplus.entity.Sku;
import com.xsaxl.xnoteplus.entity.Spu;

import java.lang.reflect.Array;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class GenerateOrderActivity extends AppCompatActivity {

    private Button generate_order_back;
//    private RecyclerView generate_order_addr;
    private RecyclerView generate_order_store;
    private TextView generate_order_price;
    private Button generate_order_pay;

    private List<OrderDetail> orderDetails;
    private String store_name;
    private List<Order> orders;
    private CartDao cartDao;
    private BrandDao brandDao;
    private AddressDao addressDao;
    private OrderDao orderDao;
    private List<Store> stores;
    private SpuDao spuDap;
    private TextView generate_order_addr;
    private double money;
    private OrderDetailDao orderDetailDao;

    private GenerateOrderStoreAdapter adapter;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_order);


        generate_order_back = findViewById(R.id.generate_order_back);
        generate_order_addr = findViewById(R.id.generate_order_addr);
        generate_order_store = findViewById(R.id.generate_order_store);
        generate_order_price = findViewById(R.id.generate_order_price);
        generate_order_pay = findViewById(R.id.generate_order_pay);
        cartDao = MyApplication.getInstance().getXCartDatabase().getCartDao();
        brandDao = MyApplication.getInstance().getXCartDatabase().getBrandDao();
        spuDap = MyApplication.getInstance().getXCartDatabase().getSpuDao();
        addressDao = MyApplication.getInstance().getXCartDatabase().getAddressDao();
        orderDao = MyApplication.getInstance().getXCartDatabase().getOrderDao();
        orderDetailDao = MyApplication.getInstance().getXCartDatabase().getOrderDetailDao();

        orderDetails = new ArrayList<OrderDetail>();
        orders = new ArrayList<Order>();
        stores = new ArrayList<Store>();;


        List<MyList> myLists = (List<MyList>) getIntent().getSerializableExtra("myLists");
        List<String> skus = getIntent().getStringArrayListExtra("skus");
        List<Integer> numbers = getIntent().getIntegerArrayListExtra("numbers");

//        Toast.makeText(this, "myLists:"+myLists.get(0).getSku_ids().get(0), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "skus:"+skus.size(), Toast.LENGTH_SHORT).show();
        int index = 0;
        List<Spu> spuList = new ArrayList<>();
        for (int i = 0; i < myLists.size(); i++) {
            // 店铺·信息
            Store store = new Store();
            Brand brand = brandDao.queryById(myLists.get(i).getBrand_id());
            store.setBrand_name(brand.getBrand_name());
//            Toast.makeText(this, "brand:"+brand.getBrand_name(), Toast.LENGTH_SHORT).show();
            store.setBrand_id(brand.getBrand_id());
            // 商品信息
            List<Good> goods = new ArrayList<>();
            for (int j = 0; j < myLists.get(i).getSku_ids().size(); j++) {
                Spu spu = spuDap.queryById( myLists.get(i).getSku_ids().get(j));
                spuList.add(spu);
//                Toast.makeText(this, "spu:"+spu.getSpu_name(), Toast.LENGTH_SHORT).show();
                Good good = new Good();
                good.setGood_name(spu.getSpu_name());
                good.setGood_image(spu.getSpu_image());
                good.setGood_sku(skus.get(index));
                good.setGood_price(spu.getSpu_price());
                good.setGood_number(numbers.get(index));
                good.setSpu_id(spu.getSpu_id());
                money += spu.getSpu_price() * numbers.get(index);
//                index++;
                goods.add(good);
            }
            store.setGoods(goods);
            stores.add(store);
        }

        generate_order_price.setText("价格：￥"+money);
        Address address = addressDao.querycCityByDefault( 1 );
        String addr = address.getAddr_name() +" " + address.getAddr_phone() + " " + address.getAddr_region() + " " + address.getAddr_city();
        generate_order_addr.setText("收货地址："+addr);

//        List<Integer> integers = cartDao.queryBrandIdByUserId(MyApplication.getInstance().getUser().getUser_id());
//        stores = new ArrayList<Store>();
//
//        List<Cart> cc = cartDao.query();
//
//        // 找到所有店铺的商品
//        for (int i = 0;i < integers.size();i++){
//            // 获取店铺的名称等信息
//            Store store = new Store();
//
//            Brand brand = brandDao.queryById(integers.get(i));
//            // 获取该店铺的所有商品
//            List<Cart> carts = cartDao.queryByBrandId(brand.getBrand_id());
//            // 转移给store 和 good
//            store.setBrand_id(brand.getBrand_id());
//            store.setBrand_name(brand.getBrand_name());
//            List<Good> goods = new ArrayList<>();
//            for (int j = 0;j < carts.size();j++){
//                Good good = new Good();
//                good.setGood_name(carts.get(j).getGood_name());
//                good.setGood_image(carts.get(j).getGood_url());
//                good.setGood_sku(carts.get(j).getGood_sku());
//                good.setGood_price(carts.get(j).getGood_price());
//                good.setGood_number(carts.get(j).getGood_number());
//                good.setSpu_id(carts.get(j).getSpu_id());
//                goods.add(good);
//            }
//            store.setGoods(goods);
//            stores.add(store);
//        }


        manager = new LinearLayoutManager(this);
        generate_order_store.setLayoutManager(manager);
        //优化性能
        generate_order_store.setHasFixedSize(true);
        adapter = new GenerateOrderStoreAdapter(stores);
        generate_order_store.setAdapter(adapter);

        generate_order_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < stores.size(); i++) {
                    Order order = new Order();
                    order.setUser_id(MyApplication.getInstance().getUser().getUser_id());
                    order.setAddr_name(address.getAddr_name());
                    order.setAddr_phone(address.getAddr_phone());
                    order.setAddr_addr(address.getAddr_region() + " " + address.getAddr_city());
                    order.setOrder_money(money);
                    order.setOrder_time("测试时间");
                    order.setOrder_status("已付款");
                    orderDao.insert(order);

                    int order_id = orderDao.queryMaxNumber();
                    for (int j = 0; j < stores.get(i).getGoods().size(); j++) {
                        Good good = stores.get(i).getGoods().get(j);

                        OrderDetail orderDetail = new OrderDetail();
                        orderDetail.setOrder_id(order_id);
                        orderDetail.setBrand_id(stores.get(i).getBrand_id());
                        orderDetail.setSpu_id(good.getSpu_id());
                        orderDetail.setGood_name(good.getGood_name());
                        orderDetail.setGood_number(good.getGood_number());
                        orderDetail.setGood_price(good.getGood_price());
                        orderDetail.setGood_image(good.getGood_image());
                        orderDetail.setGood_sku(good.getGood_sku());

                        orderDetailDao.insert(orderDetail);
                    }

                }
                Toast.makeText(GenerateOrderActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });





        generate_order_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}