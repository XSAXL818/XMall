package com.xsaxl.xnoteplus.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xsaxl.xnoteplus.Adapter.recyclerAdapter;
import com.xsaxl.xnoteplus.GenerateOrderActivity;
import com.xsaxl.xnoteplus.Good;
import com.xsaxl.xnoteplus.GoodActivity;
import com.xsaxl.xnoteplus.GoodDetailActivity;
import com.xsaxl.xnoteplus.MainActivity;
import com.xsaxl.xnoteplus.MyApplication;
import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.Store;
import com.xsaxl.xnoteplus.Util.MyList;
import com.xsaxl.xnoteplus.dao.AddressDao;
import com.xsaxl.xnoteplus.dao.BrandDao;
import com.xsaxl.xnoteplus.dao.CartDao;
import com.xsaxl.xnoteplus.dao.OrderDao;
import com.xsaxl.xnoteplus.dao.SkuDao;
import com.xsaxl.xnoteplus.entity.Address;
import com.xsaxl.xnoteplus.entity.Brand;
import com.xsaxl.xnoteplus.entity.Cart;
import com.xsaxl.xnoteplus.entity.Order;
import com.xsaxl.xnoteplus.entity.Spu;
import com.xsaxl.xnoteplus.inter.FragCallback2;

import java.util.ArrayList;
import java.util.List;

public class BlankFragment2 extends Fragment {

    private View root;
    private RecyclerView recyclerView;
    private TextView cart_money;
    private CheckBox checkBox;
    private recyclerAdapter adapter;
    private RecyclerView.LayoutManager manager;
    private List<Store> stores;
    private Button btn_buy;
    private CartDao cartDao;
    private BrandDao brandDao;
    private TextView cart_address;
    private AddressDao addressDao;



    private List<Spu> spus;

    private FragCallback2 fragCallback2;
    private double goodMoney;
    private String moneySign = "￥:";

    public void setFragCallback2(FragCallback2 iFragmentCallback) {
        this.fragCallback2 = iFragmentCallback;
    }

    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (root == null){
            root = inflater.inflate(R.layout.fragment_blank2, container, false);
        }
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerview);
        checkBox = (CheckBox) root.findViewById(R.id.shop_checkbox);
        btn_buy = root.findViewById(R.id.btn_buy);
        cart_money = root.findViewById(R.id.cart_money);
        cartDao = MyApplication.getInstance().getXCartDatabase().getCartDao();
        brandDao = MyApplication.getInstance().getXCartDatabase().getBrandDao();
        cart_address = root.findViewById(R.id.cart_address);

        addressDao = MyApplication.getInstance().getXCartDatabase().getAddressDao();

        // 该用户的购物车的所有店铺
        List<Integer> integers = cartDao.queryBrandIdByUserId(MyApplication.getInstance().getUser().getUser_id());
        stores = new ArrayList<Store>();

//        List<Cart> cc = cartDao.query();
//        Toast.makeText(root.getContext(), cc.size()+"+cart", Toast.LENGTH_SHORT).show();
//        Toast.makeText(root.getContext(), "int:"+integers.size(), Toast.LENGTH_SHORT).show();
        // 找到所有店铺的商品
        for (int i = 0;i < integers.size();i++){
            // 获取店铺的名称等信息
            Store store = new Store();
            Brand brand = brandDao.queryById(integers.get(i));
            // 获取该店铺的所有商品
            List<Cart> carts = cartDao.queryByBrandId(brand.getBrand_id());
//            Toast.makeText(root.getContext(), carts.size()+"", Toast.LENGTH_SHORT).show();
            // 转移给store 和 good
            store.setBrand_id(brand.getBrand_id());
            store.setBrand_name(brand.getBrand_name());
            List<Good> goods = new ArrayList<>();
            for (int j = 0;j < carts.size();j++){
                Good good = new Good();
                good.setGood_name(carts.get(j).getGood_name());
                good.setGood_image(carts.get(j).getGood_url());
                good.setGood_sku(carts.get(j).getGood_sku());
                good.setGood_price(carts.get(j).getGood_price());
                good.setGood_number(carts.get(j).getGood_number());
                good.setSpu_id(carts.get(j).getSpu_id());
                goods.add(good);
            }
            store.setGoods(goods);
            stores.add(store);
        }

        Address address = addressDao.queryByDefault(MyApplication.getInstance().getUser().getUser_id());
        cart_address.setText( address.getAddr_region() +" " + address.getAddr_city() );

//        stores = new ArrayList<Store>();
        goodMoney = 0;
        cart_money.setText(moneySign+goodMoney);

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


//不能添加有重复变量的数据
//        list.add(b);
//        list.add(b1);

        // 将店铺加入到列表中
//        stores.add(store1);
//        stores.add(store2);


        manager = new LinearLayoutManager(root.getContext());
        recyclerView.setLayoutManager(manager);
        //优化性能
        recyclerView.setHasFixedSize(true);
        adapter = new recyclerAdapter(stores);
        recyclerView.setAdapter(adapter);
        //全选CheckBox监听
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){  // 选中全选
                    for (int i = 0;i < stores.size();i++){
                        //选择店铺
                        if (!stores.get(i).isIscheck()){
                            stores.get(i).setIscheck(true);
                        }
                        for (int j = 0;j < stores.get(i).getGoods().size();j++){
                            //选择店铺的商品
                            if (!stores.get(i).getGoods().get(j).isIscheck()){
                                stores.get(i).getGoods().get(j).setIscheck(true);
                                goodMoney += stores.get(i).getGoods().get(j).getGood_price();
                            }
                        }
                    }
                }else {
                    //只有当点击全不选时才执行
                    // 解决点击取消选择店铺或商品时，
                    // 全选按钮取消选择状态，不会不变成全不选
                    if (allSelect() == stores.size()){
                        for (int i = 0;i < stores.size();i++){
                            if (stores.get(i).isIscheck()){
                                stores.get(i).setIscheck(false);
                            }
                            for (int j = 0;j < stores.get(i).getGoods().size();j++){
                                if (stores.get(i).getGoods().get(j).isIscheck()){
                                    stores.get(i).getGoods().get(j).setIscheck(false);
                                }
                            }
                        }
                        goodMoney = 0;
                    }
                }
                cart_money.setText(moneySign+goodMoney);
                //更新
                UpdateRecyclerView();
            }
        });
        adapter.setCallBack(new recyclerAdapter.allCheck() {
            @Override
            public void OnCheckListener(boolean isSelected, int position) {
                //保存店铺点击状态
                stores.get(position).setIscheck(isSelected);
                //通知全选CheckBox的选择状态
                if (allSelect() == stores.size()){
                    checkBox.setChecked(true);
                }else {
                    checkBox.setChecked(false);
                }
                if (isSelected){
                    for (int i = 0;i < stores.get(position).getGoods().size();i++){
                        if (!stores.get(position).getGoods().get(i).isIscheck()){
                            stores.get(position).getGoods().get(i).setIscheck(true);
                            goodMoney += stores.get(position).getGoods().get(i).getGood_price();
                        }
                    }
                }else {
                    // 解决点击取消选择商品时，
                    // 店铺全选按钮取消选择状态，不会不变成全不选
                    if (allChildSelect(position) == stores.get(position).getGoods().size()){
                        for (int i = 0;i < stores.get(position).getGoods().size();i++){
                            if (stores.get(position).getGoods().get(i).isIscheck()){
                                stores.get(position).getGoods().get(i).setIscheck(false);
                                goodMoney -= stores.get(position).getGoods().get(i).getGood_price();
                            }
                        }
                    }
                }
                cart_money.setText(moneySign+goodMoney);
                //更新
                UpdateRecyclerView();
            }
            @Override
            public void OnItemCheckListener(boolean isSelected, int parentposition, int chaildposition) {
                //保存商品点击状态
                stores.get(parentposition).getGoods().get(chaildposition).setIscheck(isSelected);
                if( isSelected ){
                    goodMoney += stores.get(parentposition).getGoods().get(chaildposition).getGood_price();
                } else {
                    goodMoney -= stores.get(parentposition).getGoods().get(chaildposition).getGood_price();
                }
                //通知店铺选择的状态
                if (allChildSelect(parentposition) == stores.get(parentposition).getGoods().size()){
                    stores.get(parentposition).setIscheck(true);
                }else {
                    stores.get(parentposition).setIscheck(false);
                }
                cart_money.setText(moneySign+goodMoney);
                UpdateRecyclerView();
            }
        });

        adapter.setOnImageClickListener(new recyclerAdapter.OnImageClickListener() {
            @Override
            public void onImageClick(int parentpostion, int childpostion) {
                Intent intent = new Intent(root.getContext(), GoodDetailActivity.class);
                Bundle bundle = new Bundle();
                int spu_id = stores.get(parentpostion).getGoods().get(childpostion).getSpu_id();
                bundle.putInt("spu_id",spu_id);
                intent.putExtras(bundle);
                startActivity(intent);
//                Toast.makeText(root.getContext(), "点击了第" + parentpostion + "个店铺的第" + childpostion + "个商品", Toast.LENGTH_SHORT).show();
            }
        });
        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(root.getContext(), GenerateOrderActivity.class);
                List<MyList> myLists = new ArrayList<>();
                List<String> skus = new ArrayList<>();
                List<Integer> numbers = new ArrayList<>();
                for (int i = 0;i < stores.size();i++){
                    int cnt = 0;
                    MyList myList = new MyList();
                    myList.setBrand_id( stores.get(i).getBrand_id() );
                    List<Integer> sku_ids = new ArrayList<>();
                    for (int j = 0;j < stores.get(i).getGoods().size();j++){
                        if (stores.get(i).getGoods().get(j).isIscheck()){
                            sku_ids.add(stores.get(i).getGoods().get(j).getSpu_id());
                            cnt = 1;
                            skus.add(stores.get(i).getGoods().get(j).getGood_sku());
                            numbers.add(stores.get(i).getGoods().get(j).getGood_number());
                        }
                    }
                    if( cnt == 1 ){
                        myList.setSku_ids(sku_ids);
                        myLists.add(myList);
                    }
                }

                Bundle bundle = new Bundle();
                bundle.putSerializable("myLists", (ArrayList<MyList>) myLists);
                bundle.putStringArrayList("skus", (ArrayList<String>) skus);
                bundle.putIntegerArrayList("numbers", (ArrayList<Integer>) numbers);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });



        return root;
    }

    /*
     *解决Recycleyview刷新报错问题
     */
    private void UpdateRecyclerView() {
        Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                adapter.notifyDataSetChanged();
            }
        };
        handler.post(r);
    }
    //计算店铺的选择数量
    private int allSelect(){
        int sum = 0;
        for (int i = 0; i < stores.size(); i++) {
            if (stores.get(i).isIscheck()){
                sum++;
            }
        }
        System.out.println(sum);
        return sum;
    }
    //计算每个店铺商品的选择数量
    private int allChildSelect(int position){
        int sum = 0;
        for (int i = 0; i < stores.get(position).getGoods().size(); i++) {
            if (stores.get(position).getGoods().get(i).isIscheck()){
                sum++;
                System.out.println(position+":"+i+":"+stores.get(position).getGoods().get(i).isIscheck());
            }
        }
        return sum;
    }
}