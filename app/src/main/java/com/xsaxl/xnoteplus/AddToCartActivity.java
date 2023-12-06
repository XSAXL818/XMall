package com.xsaxl.xnoteplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xsaxl.xnoteplus.Adapter.AddCartColorItemAdapter;
import com.xsaxl.xnoteplus.Adapter.AddCartSizeItemAdapter;
import com.xsaxl.xnoteplus.Util.GridSpacingItemDecoration;
import com.xsaxl.xnoteplus.dao.CartDao;
import com.xsaxl.xnoteplus.dao.SkuAttrDao;
import com.xsaxl.xnoteplus.dao.SkuDao;
import com.xsaxl.xnoteplus.dao.SpuDao;
import com.xsaxl.xnoteplus.entity.Cart;
import com.xsaxl.xnoteplus.entity.SkuAttr;
import com.xsaxl.xnoteplus.entity.Spu;

import java.util.ArrayList;
import java.util.List;

public class AddToCartActivity extends AppCompatActivity {

    private ImageFilterView add_cart_image;
    private TextView add_cart_name;
    private RecyclerView add_cart_color;
    private RecyclerView add_cart_size;
    private Button add_cart_minus;
    private Button add_cart_plus;
    private TextView add_cart_num;
    private Button add_cart_button;

    private List<SkuAttr> colors;
    private List<SkuAttr> sizes;
    private SkuAttrDao skuAttrDao;
    private CartDao cartDao;
    private SpuDao spuDao;
    private SkuDao skuDao;
    private LinearLayout colorLayout;
    private LinearLayout sizeLayout;
    private int colorPosition = -1;
    private int sizePosition = -1;
    private int spu_id;
    private int brand_id;

    private int number = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);

        add_cart_image = findViewById(R.id.add_cart_image);
        add_cart_name = findViewById(R.id.add_cart_name);
        add_cart_color = findViewById(R.id.add_cart_color);
        add_cart_size = findViewById(R.id.add_cart_size);
        add_cart_minus = findViewById(R.id.add_cart_minus);
        add_cart_plus = findViewById(R.id.add_cart_plus);
        add_cart_num = findViewById(R.id.add_cart_num);
        add_cart_button = findViewById(R.id.add_cart_button);
        cartDao = MyApplication.getInstance().getXCartDatabase().getCartDao();
        spuDao = MyApplication.getInstance().getXCartDatabase().getSpuDao();
        cartDao = MyApplication.getInstance().getXCartDatabase().getCartDao();
        skuDao = MyApplication.getInstance().getXCartDatabase().getSkuDao();
        skuAttrDao = MyApplication.getInstance().getXCartDatabase().getSkuAttrDao();

        colors = new ArrayList<>();
        sizes = new ArrayList<>();



        spu_id = getIntent().getIntExtra("spu_id",-1);
        int color_id = skuDao.querySkuIdBySpuIdAndSkuName( spu_id, "颜色");
        int size_id = skuDao.querySkuIdBySpuIdAndSkuName( spu_id, "尺码");
        add_cart_image.setImageResource(spuDao.queryImageBySpuId(spu_id));
        add_cart_name.setText(spuDao.queryNameBySpuId(spu_id));

        colors = skuAttrDao.queryBySkuAttrId( color_id );
        sizes = skuAttrDao.queryBySkuAttrId( size_id );


        AddCartColorItemAdapter addCartColorItemAdapter = new AddCartColorItemAdapter(colors,this);
        AddCartSizeItemAdapter addCartSizeItemAdapter = new AddCartSizeItemAdapter(sizes,this);

        add_cart_color.setAdapter(addCartColorItemAdapter);
        add_cart_size.setAdapter(addCartSizeItemAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        add_cart_color.setLayoutManager(gridLayoutManager);
        int spacing = (int) getResources().getDisplayMetrics().density * 10;
        add_cart_color.addItemDecoration(new GridSpacingItemDecoration(spacing));

        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(this, 5);
        add_cart_size.setLayoutManager(gridLayoutManager1);
        int spacing1 = (int) getResources().getDisplayMetrics().density * 10;
        add_cart_size.addItemDecoration(new GridSpacingItemDecoration(spacing1));

        addCartColorItemAdapter.setOnItemClickListener(new AddCartColorItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(LinearLayout layout, int position) {
                if ( colorLayout != null ){
                    colorLayout.setBackgroundResource(R.drawable.add_cart_color_normal_shape);
                }
                colorLayout = layout;
//                Toast toast = new Toast(AddToCartActivity.this);
//                toast.setText(position+"");
//                toast.show();
                colorPosition = position;
//                Toast.makeText(AddToCartActivity.this, position+"", Toast.LENGTH_SHORT).show();
                colorLayout.setBackgroundResource(R.drawable.add_cart_color_click_shape);
//                Toast.makeText(AddToCartActivity.this, position, Toast.LENGTH_SHORT).show();
            }
        });

        addCartSizeItemAdapter.setOnItemClickListener(new AddCartSizeItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(LinearLayout layout, int position) {
                if (sizeLayout != null){
                    sizeLayout.setBackgroundResource(R.drawable.add_cart_size_normal_shape);
                }
                sizeLayout = layout;
                sizePosition = position;
                sizeLayout.setBackgroundResource(R.drawable.add_cart_size_click_shape);
            }
        });


        add_cart_minus.setOnClickListener(v -> {
            int num = Integer.parseInt(add_cart_num.getText().toString());
            if (num > 1){
                num--;
                add_cart_num.setText(num+"");
            }
        });

        add_cart_plus.setOnClickListener(v -> {
            int num = Integer.parseInt(add_cart_num.getText().toString());
            num++;
            add_cart_num.setText(num+"");
        });

        add_cart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (colorPosition == -1 || sizePosition == -1){
//                    Toast.makeText(AddToCartActivity.this, "请选择颜色和尺码", Toast.LENGTH_SHORT).show();
                    return;
                }

                if( spu_id == -1 || brand_id == -1){
//                    Toast.makeText(AddToCartActivity.this, "添加失败", Toast.LENGTH_SHORT).show();
                    return;
                }
                Spu spu = spuDao.querySpuById(spu_id);

                Cart cart = new Cart();
                cart.setUser_id(getIntent().getIntExtra("user_id",-1));
                cart.setSpu_id(spu_id);
                cart.setBrand_id(spu.getBrand_id());
                cart.setGood_number(Integer.parseInt(add_cart_num.getText().toString()));
                cart.setGood_name(spu.getSpu_name());
                cart.setGood_url(spu.getSpu_image());
                cart.setGood_price(spu.getSpu_price());
                cart.setGood_sku("颜色："+colors.get(colorPosition).getSku_attr_name()+"   尺码："+sizes.get(sizePosition).getSku_attr_name());
                cartDao.insert(cart);
//                Toast.makeText(AddToCartActivity.this, cart.toString(), Toast.LENGTH_SHORT).show();
                finish();
            }
        });



    }
}