package com.xsaxl.xnoteplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.xsaxl.xnoteplus.Adapter.OrderDetailItemAdapter;
import com.xsaxl.xnoteplus.Adapter.SpuAttrAdapter;
import com.xsaxl.xnoteplus.dao.BrandDao;
import com.xsaxl.xnoteplus.dao.OrderDao;
import com.xsaxl.xnoteplus.dao.OrderDetailDao;
import com.xsaxl.xnoteplus.entity.Order;
import com.xsaxl.xnoteplus.entity.OrderDetail;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailActivity extends AppCompatActivity {

    private RecyclerView order_detail_recyclerview;
    private TextView order_detail_money;
    private TextView order_detail_address;
    private TextView order_detail_id;
    private List<OrderDetail> orderDetails;
    private TextView order_detail_store;
    private String store_name;

    private List<Order> orders;
    private OrderDao   orderDao;
    private OrderDetailDao orderDetailDao;
    private int user_id;
    private int order_id;
    private BrandDao brandDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);


        order_detail_recyclerview = findViewById(R.id.order_detail_recyclerview);
        order_detail_money = findViewById(R.id.order_detail_money);
        order_detail_address = findViewById(R.id.order_detail_address);
        order_detail_id = findViewById(R.id.order_detail_id);
        order_detail_store = findViewById(R.id.order_detail_store);

        orderDetails = new ArrayList<OrderDetail>();
        orders = new ArrayList<Order>();
        orderDao = MyApplication.getInstance().getXCartDatabase().getOrderDao();
        orderDetailDao = MyApplication.getInstance().getXCartDatabase().getOrderDetailDao();
        brandDao = MyApplication.getInstance().getXCartDatabase().getBrandDao();

        user_id = MyApplication.getInstance().getUser().getUser_id();

        order_id = getIntent().getIntExtra("order_id",0);
//        Toast.makeText(this, "order_id:"+order_id, Toast.LENGTH_SHORT).show();

        Order order = orderDao.queryOrderById(order_id);
//        Toast.makeText(this, order.toString(), Toast.LENGTH_SHORT).show();
        orderDetails = orderDetailDao.queryByOrderId(order_id);


//        Order order = new Order();
//        order.setOrder_id(112312);
//        order.setOrder_money(123213.0);
//        order.setAddr_name("收件人");
//        order.setAddr_phone("12321312312312");
//        order.setAddr_addr("甘肃省啊哈哈哈");


        int brand_id = orderDetails.get(0).getBrand_id();
        store_name = brandDao.queryById(brand_id).getBrand_name();


//        OrderDetail orderDetail1 = new OrderDetail();
//        orderDetail1.setGood_image(R.drawable.laoshu);
//        orderDetail1.setGood_name("小米10");
//        orderDetail1.setGood_sku("16G+256G");
//        orderDetail1.setGood_price(3999.0);
//        orderDetail1.setGood_number(1);
//
//        OrderDetail orderDetail2 = new OrderDetail();
//        orderDetail2.setGood_image(R.drawable.laoshu);
//        orderDetail2.setGood_name("小米11");
//        orderDetail2.setGood_sku("16G+256G");
//        orderDetail2.setGood_price(3999.0);
//        orderDetail2.setGood_number(1);
//
//        OrderDetail orderDetail3 = new OrderDetail();
//        orderDetail3.setGood_image(R.drawable.laoshu);
//        orderDetail3.setGood_name("小米12");
//        orderDetail3.setGood_sku("16G+256G");
//        orderDetail3.setGood_price(3999.0);
//        orderDetail3.setGood_number(1);
//
//        orderDetails.add(orderDetail1);
//        orderDetails.add(orderDetail2);
//        orderDetails.add(orderDetail3);

        order_detail_money.setText("￥"+order.getOrder_money());
        order_detail_store.setText(store_name);
        order_detail_address.setText(order.getAddr_name()+","+order.getAddr_phone()+","+order.getAddr_addr());
        order_detail_id.setText(""+order.getOrder_id());

        OrderDetailItemAdapter orderDetailItemAdapter = new OrderDetailItemAdapter(orderDetails,this);

        // 文件夹RecyclerView
        order_detail_recyclerview.setAdapter(orderDetailItemAdapter);
        order_detail_recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));








    }
}