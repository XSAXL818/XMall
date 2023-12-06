package com.xsaxl.xnoteplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.xsaxl.xnoteplus.Adapter.GoodImageAdapter;
import com.xsaxl.xnoteplus.Adapter.SpuAttrAdapter;
import com.xsaxl.xnoteplus.dao.ImageDao;
import com.xsaxl.xnoteplus.dao.SpuAttrDao;
import com.xsaxl.xnoteplus.dao.SpuDao;
import com.xsaxl.xnoteplus.entity.Image;
import com.xsaxl.xnoteplus.entity.Spu;
import com.xsaxl.xnoteplus.entity.SpuAttr;

import java.util.ArrayList;
import java.util.List;

public class GoodDetailActivity extends AppCompatActivity {

    private TextView goodDetail_price;//价格
    private TextView goodDetail_name;//商品名
    private TextView goodDetail_sale;//销量
    private RecyclerView goodDetail_typeRecycleView;
    private TextView goodDetail_comment;
    private TextView goodDetail_userNmae;
    private TextView goodDetail_userComment;
    private ImageButton goodDetail_store;
    private ImageButton goodDetail_fav;
    private Button goodDetail_addSCart;
    private Button goodDetail_buyGood;

    private List<SpuAttr> spuAttrs;
    private int commentNumber;
    private String commentName;
    private String commentContent;
    private ViewPager goodDetail_viewPager;
    private List<Image> images;
    private Spu spu;
    private ImageDao imageDao;
    private SpuDao spuDao;

    private SpuAttrDao spuAttrDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_detail);

        goodDetail_price = findViewById(R.id.goodDetail_price);
        goodDetail_name = findViewById(R.id.goodDetail_name);
        goodDetail_sale = findViewById(R.id.goodDetail_sale);
        goodDetail_typeRecycleView = findViewById(R.id.goodDetail_typeRecycleView);
        goodDetail_comment = findViewById(R.id.goodDetail_comment);
        goodDetail_userNmae = findViewById(R.id.goodDetail_userNmae);
        goodDetail_userComment = findViewById(R.id.goodDetail_userComment);
        goodDetail_store = findViewById(R.id.goodDetail_store);
        goodDetail_fav = findViewById(R.id.goodDetail_fav);
        goodDetail_viewPager = findViewById(R.id.goodDetail_viewPager);

        goodDetail_addSCart = findViewById(R.id.goodDetail_addSCart);
        goodDetail_buyGood = findViewById(R.id.goodDetail_buyGood);
        imageDao = MyApplication.getInstance().getXCartDatabase().getImageDao();
        spuDao = MyApplication.getInstance().getXCartDatabase().getSpuDao();
        spuAttrDao = MyApplication.getInstance().getXCartDatabase().getSpuAttrDao();
        spuAttrs = new ArrayList<>();
        images = new ArrayList<>();

//        Image image1 = new Image();
//        image1.setImage_url(R.drawable.spu3_1);
//
//        Image image2 = new Image();
//        image2.setImage_url(R.drawable.spu3_2);
//
//        Image image3 = new Image();
//        image3.setImage_url(R.drawable.spu3_3);
//
//        images.add(image1);
//        images.add(image2);
//        images.add(image3);


        Bundle bundle = getIntent().getExtras();
        int spu_id = bundle.getInt("spu_id");
//        Toast.makeText(this, "spu_id:" + spu_id, Toast.LENGTH_SHORT).show();

        spu = spuDao.querySpuById(spu_id);
        images = imageDao.queryBySkuID(spu_id);

        GoodImageAdapter goodImageAdapter = new GoodImageAdapter(images,this);
        goodDetail_viewPager.setAdapter(goodImageAdapter);




        commentNumber = 300;
        commentName = "xsaxl";
        commentContent = "这个手机真好用";

        goodDetail_price.setText("￥" + spu.getSpu_price());
        goodDetail_name.setText(spu.getSpu_name());
        goodDetail_sale.setText("销量：" + spu.getSpu_sales());
        goodDetail_comment.setText("评论（" + commentNumber + "+）");
        goodDetail_userNmae.setText("用户名:"+commentName);
        goodDetail_userComment.setText("   "+"这款手环真是太棒了！功能齐全，界面简洁清晰，戴着舒适不压手，还能监测心率、睡眠质量和运动数据。总之，性价比超高，强烈推荐！");

//        SpuAttr spuAttr1 = new SpuAttr();
//        spuAttr1.setSpu_attr_name("风格");
//        spuAttr1.setSpu_attr_value("简约");
//        spuAttr1.setSpu_attr_image(R.drawable.baseline_style_24);
//
//        SpuAttr spuAttr2 = new SpuAttr();
//        spuAttr2.setSpu_attr_name("风格");
//        spuAttr2.setSpu_attr_value("简约");
//        spuAttr2.setSpu_attr_image(R.drawable.baseline_style_24);
//
//        SpuAttr spuAttr3 = new SpuAttr();
//        spuAttr3.setSpu_attr_name("风格");
//        spuAttr3.setSpu_attr_value("简约");
//        spuAttr3.setSpu_attr_image(R.drawable.baseline_style_24);
//
//        spuAttrs.add(spuAttr1);
//        spuAttrs.add(spuAttr2);
//        spuAttrs.add(spuAttr3);

        spuAttrs = spuAttrDao.queryBySpuID(spu_id);

        SpuAttrAdapter spuAttrAdapter = new SpuAttrAdapter(spuAttrs,this);

        // 文件夹RecyclerView
        goodDetail_typeRecycleView.setAdapter(spuAttrAdapter);
        goodDetail_typeRecycleView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));



        goodDetail_addSCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GoodDetailActivity.this, AddToCartActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("spu_id",spu_id);
                bundle.putInt("brand_id",spu.getBrand_id());
                bundle.putInt("user_id",MyApplication.getInstance().getUser().getUser_id());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });



        
    }
}