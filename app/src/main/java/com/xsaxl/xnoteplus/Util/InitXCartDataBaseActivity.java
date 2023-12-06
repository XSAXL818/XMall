package com.xsaxl.xnoteplus.Util;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.xsaxl.xnoteplus.MainActivity;
import com.xsaxl.xnoteplus.MyApplication;
import com.xsaxl.xnoteplus.R;
import com.xsaxl.xnoteplus.dao.AddressDao;
import com.xsaxl.xnoteplus.dao.BrandDao;
import com.xsaxl.xnoteplus.dao.CartDao;
import com.xsaxl.xnoteplus.dao.CommentDao;
import com.xsaxl.xnoteplus.dao.ImageDao;
import com.xsaxl.xnoteplus.dao.OrderDao;
import com.xsaxl.xnoteplus.dao.OrderDetailDao;
import com.xsaxl.xnoteplus.dao.SkuAttrDao;
import com.xsaxl.xnoteplus.dao.SkuDao;
import com.xsaxl.xnoteplus.dao.SpuAttrDao;
import com.xsaxl.xnoteplus.dao.SpuDao;
import com.xsaxl.xnoteplus.dao.UserDao;
import com.xsaxl.xnoteplus.entity.Address;
import com.xsaxl.xnoteplus.entity.Brand;
import com.xsaxl.xnoteplus.entity.Cart;
import com.xsaxl.xnoteplus.entity.Image;
import com.xsaxl.xnoteplus.entity.Order;
import com.xsaxl.xnoteplus.entity.OrderDetail;
import com.xsaxl.xnoteplus.entity.Sku;
import com.xsaxl.xnoteplus.entity.SkuAttr;
import com.xsaxl.xnoteplus.entity.Spu;
import com.xsaxl.xnoteplus.entity.SpuAttr;
import com.xsaxl.xnoteplus.entity.User;

public class InitXCartDataBaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_xcart_data_base);

        UserDao userDao = MyApplication.getInstance().getXCartDatabase().getUserDao();
        AddressDao addressDao = MyApplication.getInstance().getXCartDatabase().getAddressDao();
        BrandDao brandDao = MyApplication.getInstance().getXCartDatabase().getBrandDao();
        CartDao cartDao = MyApplication.getInstance().getXCartDatabase().getCartDao();
        CommentDao commentDao = MyApplication.getInstance().getXCartDatabase().getCommentDao();
        ImageDao imageDao = MyApplication.getInstance().getXCartDatabase().getImageDao();
        OrderDao orderDao = MyApplication.getInstance().getXCartDatabase().getOrderDao();
        OrderDetailDao orderDetailDao = MyApplication.getInstance().getXCartDatabase().getOrderDetailDao();
        SkuAttrDao skuAttrDao = MyApplication.getInstance().getXCartDatabase().getSkuAttrDao();
        SkuDao skuDao = MyApplication.getInstance().getXCartDatabase().getSkuDao();
        SpuAttrDao spuAttrDao = MyApplication.getInstance().getXCartDatabase().getSpuAttrDao();
        SpuDao spuDao = MyApplication.getInstance().getXCartDatabase().getSpuDao();




        // user_id = 1
        User user1 = new User();
        user1.setUser_acc("15136057793");
        user1.setUser_passwd("xsaxl");
        user1.setUser_gender('男');
        user1.setUser_info("这是一个测试用户");
        user1.setUser_phone("15136057793");
        user1.setUser_register_time(Util.getSystemTime());
        userDao.insert(user1);

        // addr_id = 1
        Address address1 = new Address();
        address1.setUser_id(1);
        address1.setAddr_name("邹炒饭酱");
        address1.setAddr_region("甘肃省 兰州市 安宁区");
        address1.setAddr_city("西北师范大学");
        address1.setAddr_default(1);
        address1.setAddr_phone("15136057793");
        addressDao.insert(address1);
        // addr_id = 2
        Address address2 = new Address();
        address2.setUser_id(1);
        address2.setAddr_name("邹炒饭酱");
        address2.setAddr_region("甘肃省 兰州市 城关区");
        address2.setAddr_city("兰州大学");
        address2.setAddr_default(1);
        address2.setAddr_phone("15136057793");
        addressDao.insert(address2);

        // brand_id = 1
        Brand brand1 = new Brand();
        brand1.setBrand_name("Vans");
        brand1.setBrand_info("Vans是美国著名的极限运动鞋品牌，主要生产滑板鞋、运动鞋、服装和配件。");
        brand1.setBrand_logo(R.drawable.brand2);
        brandDao.insert(brand1);
        // brand_id = 2
        Brand brand2 = new Brand();
        brand2.setBrand_name("小米");
        brand2.setBrand_info("小米是一家专注于智能硬件和电子产品研发的创新型科技企业。");
        brand2.setBrand_logo(R.drawable.brand3);
        brandDao.insert(brand2);
        // brand_id = 3
        Brand brand3 = new Brand();
        brand3.setBrand_name("西窗亮");
        brand3.setBrand_info("西窗亮是一家专注于智能硬件和电子产品研发的创新型科技企业。");
        brand3.setBrand_logo(R.drawable.brand1);
        brandDao.insert(brand3);
        // brand_id = 4
        Brand brand4 = new Brand();
        brand4.setBrand_name("珍视明");
        brand4.setBrand_info("珍视明是一家专注于智能硬件和电子产品研发的创新型科技企业。");
        brand4.setBrand_logo(R.drawable.brand4);
        brandDao.insert(brand4);
        // brand_id = 5
        Brand brand5 = new Brand();
        brand5.setBrand_name("谷初源");
        brand5.setBrand_info("谷初源是一家专注于智能硬件和电子产品研发的创新型科技企业。");
        brand5.setBrand_logo(R.drawable.brand5);
        brandDao.insert(brand5);

        // brand_id = 6
        Brand brand6 = new Brand();
        brand6.setBrand_name("x练习两年半");
        brand6.setBrand_info("谷初源是一家专注于智能硬件和电子产品研发的创新型科技企业。");
        brand6.setBrand_logo(R.drawable.brand5);
        brandDao.insert(brand6);



        // 上衣1

        // spu_id = 1
        Spu spu1 = new Spu();
        spu1.setSpu_price(149);
        spu1.setSpu_name("2023年春季新款夏法式设计高级感小众西装长袖修身黑色连衣裙女装");
        spu1.setSpu_sales(1000);
        spu1.setBrand_id(1);
        spu1.setSpu_image(R.drawable.spu1);
        spuDao.insert(spu1);
        // image_id = 1
        Image image1 = new Image();
        image1.setSpu_id(1);
        image1.setImage_url(R.drawable.spu1_1);
        imageDao.insert(image1);

        // image_id = 2
        Image image2 = new Image();
        image2.setSpu_id(1);
        image2.setImage_url(R.drawable.spu1_2);
        imageDao.insert(image2);

        // image_id = 3
        Image image3 = new Image();
        image3.setSpu_id(1);
        image3.setImage_url(R.drawable.spu1_3);
        imageDao.insert(image3);

        // spu_attr_id = 1
        SpuAttr spuAttr1 = new SpuAttr();
        spuAttr1.setSpu_attr_name("品牌");
        spuAttr1.setSpu_id(1);
        spuAttr1.setSpu_attr_value("other");
        spuAttr1.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr1);

        // spu_attr_id = 2
        SpuAttr spuAttr2 = new SpuAttr();
        spuAttr2.setSpu_attr_name("风格");
        spuAttr2.setSpu_id(1);
        spuAttr2.setSpu_attr_value("甜美");
        spuAttr2.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr2);

        // spu_attr_id = 3
        SpuAttr spuAttr3 = new SpuAttr();
        spuAttr3.setSpu_attr_name("袖长");
        spuAttr3.setSpu_id(1);
        spuAttr3.setSpu_attr_value("长袖");
        spuAttr3.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr3);

        // spu_attr_id = 4
        SpuAttr spuAttr4 = new SpuAttr();
        spuAttr4.setSpu_attr_name("领型");
        spuAttr4.setSpu_id(1);
        spuAttr4.setSpu_attr_value("西装领");
        spuAttr4.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr4);

        // sku_id = 1
        Sku sku1 = new Sku();
        sku1.setSpu_id(1);
        sku1.setSku_name("颜色");
        skuDao.insert(sku1);

        // sku_id = 2
        Sku sku2 = new Sku();
        sku2.setSpu_id(1);
        sku2.setSku_name("尺码");
        skuDao.insert(sku2);

        //sku_attr_id = 1
        SkuAttr skuAttr1 = new SkuAttr();
        skuAttr1.setSku_id(1);
        skuAttr1.setSku_attr_name("粉拼黑");
        skuAttr1.setSku_attr_image(R.drawable.sku_attr1_1);
        skuAttrDao.insert(skuAttr1);

        //sku_attr_id = 2
        SkuAttr skuAttr2 = new SkuAttr();
        skuAttr2.setSku_id(1);
        skuAttr2.setSku_attr_name("白拼黑");
        skuAttr2.setSku_attr_image(R.drawable.sku_attr1_2);
        skuAttrDao.insert(skuAttr2);

        //sku_attr_id = 3
        SkuAttr skuAttr3 = new SkuAttr();
        skuAttr3.setSku_id(2);
        skuAttr3.setSku_attr_name("S");
        skuAttrDao.insert(skuAttr3);

        //sku_attr_id = 4
        SkuAttr skuAttr4 = new SkuAttr();
        skuAttr4.setSku_id(2);
        skuAttr4.setSku_attr_name("M");
        skuAttrDao.insert(skuAttr4);

        //sku_attr_id = 5
        SkuAttr skuAttr5 = new SkuAttr();
        skuAttr5.setSku_id(2);
        skuAttr5.setSku_attr_name("L");
        skuAttrDao.insert(skuAttr5);

        // 上衣2

        // spu_id = 2
        Spu spu2 = new Spu();
        spu2.setSpu_price(139);
        spu2.setSpu_name("2023年春秋新款韩系时尚咖色宽松显瘦小香风pu皮衣外套女棕色爆款");
        spu2.setSpu_sales(3000);
        spu2.setBrand_id(1);
        spu2.setSpu_image(R.drawable.spu2);
        spuDao.insert(spu2);

        // image_id = 4
        Image image4 = new Image();
        image4.setSpu_id(2);
        image4.setImage_url(R.drawable.spu2_1);
        imageDao.insert(image4);

        // image_id = 5
        Image image5 = new Image();
        image5.setSpu_id(2);
        image5.setImage_url(R.drawable.spu2_2);
        imageDao.insert(image5);

        // spu_attr_id = 5
        SpuAttr spuAttr5 = new SpuAttr();
        spuAttr5.setSpu_attr_name("风格");
        spuAttr5.setSpu_id(2);
        spuAttr5.setSpu_attr_value("通勤");
        spuAttr5.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr5);

        // spu_attr_id = 6
        SpuAttr spuAttr6 = new SpuAttr();
        spuAttr6.setSpu_attr_name("袖长");
        spuAttr6.setSpu_id(2);
        spuAttr6.setSpu_attr_value("长袖");
        spuAttr6.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr6);

        // spu_attr_id = 7
        SpuAttr spuAttr7 = new SpuAttr();
        spuAttr7.setSpu_attr_name("袖长");
        spuAttr7.setSpu_id(2);
        spuAttr7.setSpu_attr_value("长袖");
        spuAttr7.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr7);

        // spu_attr_id = 8
        SpuAttr spuAttr8 = new SpuAttr();
        spuAttr8.setSpu_attr_name("款式");
        spuAttr8.setSpu_id(2);
        spuAttr8.setSpu_attr_value("常规");
        spuAttr8.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr8);

        // sku_id = 3
        Sku sku6 = new Sku();
        sku6.setSpu_id(2);
        sku6.setSku_name("颜色");
        skuDao.insert(sku6);

        // sku_id = 4
        Sku sku7 = new Sku();
        sku7.setSpu_id(2);
        sku7.setSku_name("尺码");
        skuDao.insert(sku7);

        //sku_attr_id = 8
        SkuAttr skuAttr8 = new SkuAttr();
        skuAttr8.setSku_id(3);
        skuAttr8.setSku_attr_name("黑色");
        skuAttr8.setSku_attr_image(R.drawable.sku_attr2_1);
        skuAttrDao.insert(skuAttr8);

        //sku_attr_id = 9
        SkuAttr skuAttr9 = new SkuAttr();
        skuAttr9.setSku_id(3);
        skuAttr9.setSku_attr_name("咖色");
        skuAttr9.setSku_attr_image(R.drawable.sku_attr2_2);
        skuAttrDao.insert(skuAttr9);

        //sku_attr_id = 10
        SkuAttr skuAttr10 = new SkuAttr();
        skuAttr10.setSku_id(4);
        skuAttr10.setSku_attr_name("XS");
        skuAttrDao.insert(skuAttr10);

        //sku_attr_id = 11
        SkuAttr skuAttr11 = new SkuAttr();
        skuAttr11.setSku_id(4);
        skuAttr11.setSku_attr_name("S");
        skuAttrDao.insert(skuAttr11);

        //sku_attr_id = 12
        SkuAttr skuAttr12 = new SkuAttr();
        skuAttr12.setSku_id(4);
        skuAttr12.setSku_attr_name("M");
        skuAttrDao.insert(skuAttr12);


        // 上衣3

        // spu_id = 3
        Spu spu3 = new Spu();
        spu3.setSpu_price(115);
        spu3.setSpu_name("2023年春秋新款韩系时尚咖色宽松显瘦小香风pu皮衣外套女棕色爆款");
        spu3.setSpu_sales(9000);
        spu3.setBrand_id(1);
        spu3.setSpu_image(R.drawable.spu3);
        spuDao.insert(spu3);

        // image_id = 6
        Image image6 = new Image();
        image6.setSpu_id(3);
        image6.setImage_url(R.drawable.spu3_1);
        imageDao.insert(image6);

        // image_id = 7
        Image image7 = new Image();
        image7.setSpu_id(3);
        image7.setImage_url(R.drawable.spu3_2);
        imageDao.insert(image7);

        // spu_attr_id = 9
        SpuAttr spuAttr9 = new SpuAttr();
        spuAttr9.setSpu_attr_name("风格");
        spuAttr9.setSpu_id(3);
        spuAttr9.setSpu_attr_value("原创设计");
        spuAttr9.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr9);

        // spu_attr_id = 10
        SpuAttr spuAttr10 = new SpuAttr();
        spuAttr10.setSpu_attr_name("袖长");
        spuAttr10.setSpu_id(3);
        spuAttr10.setSpu_attr_value("长袖");
        spuAttr10.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr10);

        // spu_attr_id = 11
        SpuAttr spuAttr11 = new SpuAttr();
        spuAttr11.setSpu_attr_name("领型");
        spuAttr11.setSpu_id(3);
        spuAttr11.setSpu_attr_value("POLO领");
        spuAttr11.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr11);

        // spu_attr_id = 12
        SpuAttr spuAttr12 = new SpuAttr();
        spuAttr12.setSpu_attr_name("服装版型");
        spuAttr12.setSpu_id(3);
        spuAttr12.setSpu_attr_value("宽松型");
        spuAttr12.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr12);

        // sku_id = 5
        Sku sku13 = new Sku();
        sku13.setSpu_id(3);
        sku13.setSku_name("颜色");
        skuDao.insert(sku13);

        // sku_id = 6
        Sku sku14 = new Sku();
        sku14.setSpu_id(3);
        sku14.setSku_name("尺码");
        skuDao.insert(sku14);

        //sku_attr_id = 15
        SkuAttr skuAttr15 = new SkuAttr();
        skuAttr15.setSku_id(5);
        skuAttr15.setSku_attr_name("绿色");
        skuAttr15.setSku_attr_image(R.drawable.sku_attr3_1);
        skuAttrDao.insert(skuAttr15);

        //sku_attr_id = 16
        SkuAttr skuAttr16 = new SkuAttr();
        skuAttr16.setSku_id(5);
        skuAttr16.setSku_attr_name("杏色");
        skuAttr16.setSku_attr_image(R.drawable.sku_attr3_2);
        skuAttrDao.insert(skuAttr16);

        //sku_attr_id = 17
        SkuAttr skuAttr17 = new SkuAttr();
        skuAttr17.setSku_id(6);
        skuAttr17.setSku_attr_name("S");
        skuAttrDao.insert(skuAttr17);

        //sku_attr_id = 18
        SkuAttr skuAttr18 = new SkuAttr();
        skuAttr18.setSku_id(6);
        skuAttr18.setSku_attr_name("M");
        skuAttrDao.insert(skuAttr18);

        //sku_attr_id = 19
        SkuAttr skuAttr19 = new SkuAttr();
        skuAttr19.setSku_id(6);
        skuAttr19.setSku_attr_name("L");
        skuAttrDao.insert(skuAttr19);

        //sku_attr_id = 20
        SkuAttr skuAttr20 = new SkuAttr();
        skuAttr20.setSku_id(6);
        skuAttr20.setSku_attr_name("XL");
        skuAttrDao.insert(skuAttr20);

        // 上衣4

        // spu_id = 4
        Spu spu4 = new Spu();
        spu4.setSpu_price(128);
        spu4.setSpu_name("BIGGOLD蜘蛛麦当劳连帽卫衣女美式复古潮牌情侣秋冬oversize外套");
        spu4.setSpu_sales(500);
        spu4.setBrand_id(2);
        spu4.setSpu_image(R.drawable.spu4);
        spuDao.insert(spu4);

        // image_id = 8
        Image image8 = new Image();
        image8.setSpu_id(4);
        image8.setImage_url(R.drawable.spu4_1);
        imageDao.insert(image8);

        // image_id = 9
        Image image9 = new Image();
        image9.setSpu_id(4);
        image9.setImage_url(R.drawable.spu4_2);
        imageDao.insert(image9);

        // spu_attr_id = 13
        SpuAttr spuAttr13 = new SpuAttr();
        spuAttr13.setSpu_attr_name("风格");
        spuAttr13.setSpu_id(4);
        spuAttr13.setSpu_attr_value("街头");
        spuAttr13.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr13);

        // spu_attr_id = 14
        SpuAttr spuAttr14 = new SpuAttr();
        spuAttr14.setSpu_attr_name("袖长");
        spuAttr14.setSpu_id(4);
        spuAttr14.setSpu_attr_value("长袖");
        spuAttr14.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr14);

        // spu_attr_id = 15
        SpuAttr spuAttr15 = new SpuAttr();
        spuAttr15.setSpu_attr_name("服装版型");
        spuAttr15.setSpu_id(4);
        spuAttr15.setSpu_attr_value("口袋，印花，抽绳");
        spuAttr15.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr15);

        // spu_attr_id = 16
        SpuAttr spuAttr16 = new SpuAttr();
        spuAttr16.setSpu_attr_name("款式");
        spuAttr16.setSpu_id(4);
        spuAttr16.setSpu_attr_value("套头");
        spuAttr16.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr16);

        // sku_id = 7
        Sku sku15 = new Sku();
        sku15.setSpu_id(4);
        sku15.setSku_name("颜色");
        skuDao.insert(sku15);

        // sku_id = 8
        Sku sku16 = new Sku();
        sku16.setSpu_id(4);
        sku16.setSku_name("尺码");
        skuDao.insert(sku16);

        //sku_attr_id = 27
        SkuAttr skuAttr27 = new SkuAttr();
        skuAttr27.setSku_id(7);
        skuAttr27.setSku_attr_name("绿色");
        skuAttr27.setSku_attr_image(R.drawable.sku_attr4_1);
        skuAttrDao.insert(skuAttr27);

        //sku_attr_id = 28
        SkuAttr skuAttr28 = new SkuAttr();
        skuAttr28.setSku_id(7);
        skuAttr28.setSku_attr_name("杏色");
        skuAttr28.setSku_attr_image(R.drawable.sku_attr4_2);
        skuAttrDao.insert(skuAttr28);

        //sku_attr_id = 29
        SkuAttr skuAttr29 = new SkuAttr();
        skuAttr29.setSku_id(8);
        skuAttr29.setSku_attr_name("S");
        skuAttrDao.insert(skuAttr29);

        //sku_attr_id = 30
        SkuAttr skuAttr30 = new SkuAttr();
        skuAttr30.setSku_id(8);
        skuAttr30.setSku_attr_name("M");
        skuAttrDao.insert(skuAttr30);

        //sku_attr_id = 31
        SkuAttr skuAttr31 = new SkuAttr();
        skuAttr31.setSku_id(8);
        skuAttr31.setSku_attr_name("L");
        skuAttrDao.insert(skuAttr31);

        //sku_attr_id = 32
        SkuAttr skuAttr32 = new SkuAttr();
        skuAttr32.setSku_id(8);
        skuAttr32.setSku_attr_name("XL");
        skuAttrDao.insert(skuAttr32);

        // 服装5
        // spu_id = 5
        Spu spu5 = new Spu();
        spu5.setSpu_price(199);
        spu5.setSpu_name("罗蒙毛呢大衣男春秋冬季风衣中长款过膝韩版潮流商务加厚夹克外套");
        spu5.setSpu_sales(159);
        spu5.setBrand_id(2);
        spu5.setSpu_image(R.drawable.spu5);
        spuDao.insert(spu5);

        // image_id = 10
        Image image10 = new Image();
        image10.setSpu_id(5);
        image10.setImage_url(R.drawable.spu5_1);
        imageDao.insert(image10);

        // image_id = 11
        Image image11 = new Image();
        image11.setSpu_id(5);
        image11.setImage_url(R.drawable.spu5_2);
        imageDao.insert(image11);

        // image_id = 12
        Image image12 = new Image();
        image12.setSpu_id(5);
        image12.setImage_url(R.drawable.spu5_3);
        imageDao.insert(image12);


        // spu_attr_id = 17
        SpuAttr spuAttr17 = new SpuAttr();
        spuAttr17.setSpu_attr_name("风格");
        spuAttr17.setSpu_id(5);
        spuAttr17.setSpu_attr_value("街头");
        spuAttr17.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr17);

        // spu_attr_id = 18
        SpuAttr spuAttr18 = new SpuAttr();
        spuAttr18.setSpu_attr_name("袖长");
        spuAttr18.setSpu_id(5);
        spuAttr18.setSpu_attr_value("长袖");
        spuAttr18.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr18);

        // spu_attr_id = 19
        SpuAttr spuAttr19 = new SpuAttr();
        spuAttr19.setSpu_attr_name("服装版型");
        spuAttr19.setSpu_id(5);
        spuAttr19.setSpu_attr_value("口袋，印花，抽绳");
        spuAttr19.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr19);

        // spu_attr_id = 20
        SpuAttr spuAttr20 = new SpuAttr();
        spuAttr20.setSpu_attr_name("款式");
        spuAttr20.setSpu_id(5);
        spuAttr20.setSpu_attr_value("套头");
        spuAttr20.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr20);

        // sku_id = 9
        Sku sku17 = new Sku();
        sku17.setSpu_id(5);
        sku17.setSku_name("颜色");
        skuDao.insert(sku17);

        // sku_id = 10
        Sku sku18 = new Sku();
        sku18.setSpu_id(5);
        sku18.setSku_name("尺码");
        skuDao.insert(sku18);

        //sku_attr_id = 33
        SkuAttr skuAttr33 = new SkuAttr();
        skuAttr33.setSku_id(9);
        skuAttr33.setSku_attr_name("绿色");
        skuAttr33.setSku_attr_image(R.drawable.sku_attr5_2);
        skuAttrDao.insert(skuAttr33);

        //sku_attr_id = 34
        SkuAttr skuAttr34 = new SkuAttr();
        skuAttr34.setSku_id(9);
        skuAttr34.setSku_attr_name("杏色");
        skuAttr34.setSku_attr_image(R.drawable.sku_attr5_3);
        skuAttrDao.insert(skuAttr34);

        //sku_attr_id = 35
        SkuAttr skuAttr35 = new SkuAttr();
        skuAttr35.setSku_id(10);
        skuAttr35.setSku_attr_name("S");
        skuAttrDao.insert(skuAttr35);

        //sku_attr_id = 36
        SkuAttr skuAttr36 = new SkuAttr();
        skuAttr36.setSku_id(10);
        skuAttr36.setSku_attr_name("M");
        skuAttrDao.insert(skuAttr36);

        //sku_attr_id = 37
        SkuAttr skuAttr37 = new SkuAttr();
        skuAttr37.setSku_id(10);
        skuAttr37.setSku_attr_name("L");
        skuAttrDao.insert(skuAttr37);

        //sku_attr_id = 38
        SkuAttr skuAttr38 = new SkuAttr();
        skuAttr38.setSku_id(10);
        skuAttr38.setSku_attr_name("XL");
        skuAttrDao.insert(skuAttr38);

        // 服装6
        // spu_id = 6
        Spu spu6 = new Spu();
        spu6.setSpu_price(173);
        spu6.setSpu_name("花花公子卫衣男士秋冬季新款宽松连帽长袖t恤潮牌青少年休闲衣服");
        spu6.setSpu_sales(1000);
        spu6.setBrand_id(2);
        spu6.setSpu_image(R.drawable.spu6);
        spuDao.insert(spu6);

        // image_id = 13
        Image image13 = new Image();
        image13.setSpu_id(6);
        image13.setImage_url(R.drawable.spu6_1);
        imageDao.insert(image13);

        // image_id = 14
        Image image14 = new Image();
        image14.setSpu_id(6);
        image14.setImage_url(R.drawable.spu6_2);
        imageDao.insert(image14);



        // spu_attr_id = 21
        SpuAttr spuAttr21 = new SpuAttr();
        spuAttr21.setSpu_attr_name("风格");
        spuAttr21.setSpu_id(6);
        spuAttr21.setSpu_attr_value("青春流行");
        spuAttr21.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr21);

        // spu_attr_id = 22
        SpuAttr spuAttr22 = new SpuAttr();
        spuAttr22.setSpu_attr_name("品牌");
        spuAttr22.setSpu_id(6);
        spuAttr22.setSpu_attr_value("花花公子");
        spuAttr22.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr22);

        // spu_attr_id = 23
        SpuAttr spuAttr23 = new SpuAttr();
        spuAttr23.setSpu_attr_name("服装版型");
        spuAttr23.setSpu_id(6);
        spuAttr23.setSpu_attr_value("宽松型");
        spuAttr23.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr23);

        // spu_attr_id = 24
        SpuAttr spuAttr24 = new SpuAttr();
        spuAttr24.setSpu_attr_name("款式");
        spuAttr24.setSpu_id(6);
        spuAttr24.setSpu_attr_value("套头");
        spuAttr24.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr24);

        // sku_id = 11
        Sku sku19 = new Sku();
        sku19.setSpu_id(6);
        sku19.setSku_name("颜色");
        skuDao.insert(sku19);

        // sku_id = 12
        Sku sku20 = new Sku();
        sku20.setSpu_id(6);
        sku20.setSku_name("尺码");
        skuDao.insert(sku20);

        //sku_attr_id = 39
        SkuAttr skuAttr39 = new SkuAttr();
        skuAttr39.setSku_id(11);
        skuAttr39.setSku_attr_name("绿色");
        skuAttr39.setSku_attr_image(R.drawable.sku_attr6_1);
        skuAttrDao.insert(skuAttr39);

        //sku_attr_id = 40
        SkuAttr skuAttr40 = new SkuAttr();
        skuAttr40.setSku_id(11);
        skuAttr40.setSku_attr_name("杏色");
        skuAttr40.setSku_attr_image(R.drawable.sku_attr6_2);
        skuAttrDao.insert(skuAttr40);

        //sku_attr_id = 41
        SkuAttr skuAttr41 = new SkuAttr();
        skuAttr41.setSku_id(12);
        skuAttr41.setSku_attr_name("S");
        skuAttrDao.insert(skuAttr41);

        //sku_attr_id = 42
        SkuAttr skuAttr42 = new SkuAttr();
        skuAttr42.setSku_id(12);
        skuAttr42.setSku_attr_name("M");
        skuAttrDao.insert(skuAttr42);

        //sku_attr_id = 43
        SkuAttr skuAttr43 = new SkuAttr();
        skuAttr43.setSku_id(12);
        skuAttr43.setSku_attr_name("L");
        skuAttrDao.insert(skuAttr43);

        //sku_attr_id = 44
        SkuAttr skuAttr44 = new SkuAttr();
        skuAttr44.setSku_id(12);
        skuAttr44.setSku_attr_name("XL");
        skuAttrDao.insert(skuAttr44);

        // 服装7

        // spu_id = 7
        Spu spu7 = new Spu();
        spu7.setSpu_price(359);
        spu7.setSpu_name("三合一可拆卸冲锋衣外套男2023新款春秋冬季防水防风户外三防夹克");
        spu7.setSpu_sales(10000);
        spu7.setBrand_id(3);
        spu7.setSpu_image(R.drawable.spu7);
        spuDao.insert(spu7);

        // image_id = 15
        Image image15 = new Image();
        image15.setSpu_id(7);
        image15.setImage_url(R.drawable.spu7_1);
        imageDao.insert(image15);

        // image_id = 16
        Image image16 = new Image();
        image16.setSpu_id(7);
        image16.setImage_url(R.drawable.spu7_2);
        imageDao.insert(image16);



        // spu_attr_id = 25
        SpuAttr spuAttr25 = new SpuAttr();
        spuAttr25.setSpu_attr_name("风格");
        spuAttr25.setSpu_id(7);
        spuAttr25.setSpu_attr_value("青春流行");
        spuAttr25.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr25);

        // spu_attr_id = 26
        SpuAttr spuAttr26 = new SpuAttr();
        spuAttr26.setSpu_attr_name("品牌");
        spuAttr26.setSpu_id(7);
        spuAttr26.setSpu_attr_value("MontVoo");
        spuAttr26.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr26);

        // spu_attr_id = 27
        SpuAttr spuAttr27 = new SpuAttr();
        spuAttr27.setSpu_attr_name("服装版型");
        spuAttr27.setSpu_id(7);
        spuAttr27.setSpu_attr_value("宽松型");
        spuAttr27.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr27);

        // spu_attr_id = 28
        SpuAttr spuAttr28 = new SpuAttr();
        spuAttr28.setSpu_attr_name("款式");
        spuAttr28.setSpu_id(7);
        spuAttr28.setSpu_attr_value("套头");
        spuAttr28.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr28);

        // sku_id = 13
        Sku sku21 = new Sku();
        sku21.setSpu_id(7);
        sku21.setSku_name("颜色");
        skuDao.insert(sku21);

        // sku_id = 14
        Sku sku22 = new Sku();
        sku22.setSpu_id(7);
        sku22.setSku_name("尺码");
        skuDao.insert(sku22);

        //sku_attr_id = 45
        SkuAttr skuAttr45 = new SkuAttr();
        skuAttr45.setSku_id(13);
        skuAttr45.setSku_attr_name("绿色");
        skuAttr45.setSku_attr_image(R.drawable.sku_attr7_1);
        skuAttrDao.insert(skuAttr45);

        //sku_attr_id = 46
        SkuAttr skuAttr46 = new SkuAttr();
        skuAttr46.setSku_id(13);
        skuAttr46.setSku_attr_name("杏色");
        skuAttr46.setSku_attr_image(R.drawable.sku_attr7_2);
        skuAttrDao.insert(skuAttr46);

        //sku_attr_id = 47
        SkuAttr skuAttr47 = new SkuAttr();
        skuAttr47.setSku_id(14);
        skuAttr47.setSku_attr_name("S");
        skuAttrDao.insert(skuAttr47);

        //sku_attr_id = 48
        SkuAttr skuAttr48 = new SkuAttr();
        skuAttr48.setSku_id(14);
        skuAttr48.setSku_attr_name("M");
        skuAttrDao.insert(skuAttr48);

        //sku_attr_id = 49
        SkuAttr skuAttr49 = new SkuAttr();
        skuAttr49.setSku_id(14);
        skuAttr49.setSku_attr_name("L");
        skuAttrDao.insert(skuAttr49);

        //sku_attr_id = 50
        SkuAttr skuAttr50 = new SkuAttr();
        skuAttr50.setSku_id(14);
        skuAttr50.setSku_attr_name("XL");
        skuAttrDao.insert(skuAttr50);

        // 服装8

        // spu_id = 8
        Spu spu8 = new Spu();
        spu8.setSpu_price(229);
        spu8.setSpu_name("JHYQ工装系列美式重磅复古工装牛仔裤男秋季潮牌宽松直筒做旧长裤");
        spu8.setSpu_sales(1027);
        spu8.setBrand_id(3);
        spu8.setSpu_image(R.drawable.spu8);
        spuDao.insert(spu8);

        // image_id = 17
        Image image17 = new Image();
        image17.setSpu_id(8);
        image17.setImage_url(R.drawable.spu8_1);
        imageDao.insert(image17);

        // image_id = 18
        Image image18 = new Image();
        image18.setSpu_id(8);
        image18.setImage_url(R.drawable.spu8_2);
        imageDao.insert(image18);



        // spu_attr_id = 29
        SpuAttr spuAttr29 = new SpuAttr();
        spuAttr29.setSpu_attr_name("风格");
        spuAttr29.setSpu_id(8);
        spuAttr29.setSpu_attr_value("青春流行");
        spuAttr29.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr29);

        // spu_attr_id = 30
        SpuAttr spuAttr30 = new SpuAttr();
        spuAttr30.setSpu_attr_name("品牌");
        spuAttr30.setSpu_id(8);
        spuAttr30.setSpu_attr_value("MontVoo");
        spuAttr30.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr30);

        // spu_attr_id = 31
        SpuAttr spuAttr31 = new SpuAttr();
        spuAttr31.setSpu_attr_name("服装版型");
        spuAttr31.setSpu_id(8);
        spuAttr31.setSpu_attr_value("宽松型");
        spuAttr31.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr31);

        // spu_attr_id = 32
        SpuAttr spuAttr32 = new SpuAttr();
        spuAttr32.setSpu_attr_name("款式");
        spuAttr32.setSpu_id(8);
        spuAttr32.setSpu_attr_value("套头");
        spuAttr32.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr32);

        // sku_id = 15
        Sku sku23 = new Sku();
        sku23.setSpu_id(8);
        sku23.setSku_name("颜色");
        skuDao.insert(sku23);

        // sku_id = 16
        Sku sku24 = new Sku();
        sku24.setSpu_id(8);
        sku24.setSku_name("尺码");
        skuDao.insert(sku24);

        //sku_attr_id = 51
        SkuAttr skuAttr51 = new SkuAttr();
        skuAttr51.setSku_id(15);
        skuAttr51.setSku_attr_name("绿色");
        skuAttr51.setSku_attr_image(R.drawable.sku_attr8_1);
        skuAttrDao.insert(skuAttr51);

        //sku_attr_id = 52
        SkuAttr skuAttr52 = new SkuAttr();
        skuAttr52.setSku_id(15);
        skuAttr52.setSku_attr_name("杏色");
        skuAttr52.setSku_attr_image(R.drawable.sku_attr8_2);
        skuAttrDao.insert(skuAttr52);

        //sku_attr_id = 53
        SkuAttr skuAttr53 = new SkuAttr();
        skuAttr53.setSku_id(16);
        skuAttr53.setSku_attr_name("S");
        skuAttrDao.insert(skuAttr53);

        //sku_attr_id = 54
        SkuAttr skuAttr54 = new SkuAttr();
        skuAttr54.setSku_id(16);
        skuAttr54.setSku_attr_name("M");
        skuAttrDao.insert(skuAttr54);

        //sku_attr_id = 55
        SkuAttr skuAttr55 = new SkuAttr();
        skuAttr55.setSku_id(16);
        skuAttr55.setSku_attr_name("L");
        skuAttrDao.insert(skuAttr55);

        //sku_attr_id = 56
        SkuAttr skuAttr56 = new SkuAttr();
        skuAttr56.setSku_id(16);
        skuAttr56.setSku_attr_name("XL");
        skuAttrDao.insert(skuAttr56);


        // 服装 9

        // spu_id = 9
        Spu spu9 = new Spu();
        spu9.setSpu_price(199);
        spu9.setSpu_name("NOTAWEAR 锋芒 不拖地的拖地裤 多口袋直筒宽松阔腿工装裤皮裤");
        spu9.setSpu_sales(159);
        spu9.setBrand_id(3);
        spu9.setSpu_image(R.drawable.spu9);
        spuDao.insert(spu9);

        // image_id = 19
        Image image19 = new Image();
        image19.setSpu_id(9);
        image19.setImage_url(R.drawable.spu9_1);
        imageDao.insert(image19);

        // image_id = 20
        Image image20 = new Image();
        image20.setSpu_id(9);
        image20.setImage_url(R.drawable.spu9_2);
        imageDao.insert(image20);



        // spu_attr_id = 33
        SpuAttr spuAttr33 = new SpuAttr();
        spuAttr33.setSpu_attr_name("风格");
        spuAttr33.setSpu_id(9);
        spuAttr33.setSpu_attr_value("青春流行");
        spuAttr33.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr33);

        // spu_attr_id = 34
        SpuAttr spuAttr34 = new SpuAttr();
        spuAttr34.setSpu_attr_name("品牌");
        spuAttr34.setSpu_id(9);
        spuAttr34.setSpu_attr_value("MontVoo");
        spuAttr34.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr34);

        // spu_attr_id = 35
        SpuAttr spuAttr35 = new SpuAttr();
        spuAttr35.setSpu_attr_name("服装版型");
        spuAttr35.setSpu_id(9);
        spuAttr35.setSpu_attr_value("宽松型");
        spuAttr35.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr35);

        // spu_attr_id = 36
        SpuAttr spuAttr36 = new SpuAttr();
        spuAttr36.setSpu_attr_name("款式");
        spuAttr36.setSpu_id(9);
        spuAttr36.setSpu_attr_value("套头");
        spuAttr36.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr36);

        // sku_id = 17
        Sku sku25 = new Sku();
        sku25.setSpu_id(9);
        sku25.setSku_name("颜色");
        skuDao.insert(sku25);

        // sku_id = 18
        Sku sku26 = new Sku();
        sku26.setSpu_id(9);
        sku26.setSku_name("尺码");
        skuDao.insert(sku26);

        //sku_attr_id = 57
        SkuAttr skuAttr57 = new SkuAttr();
        skuAttr57.setSku_id(17);
        skuAttr57.setSku_attr_name("绿色");
        skuAttr57.setSku_attr_image(R.drawable.sku_attr9_1);
        skuAttrDao.insert(skuAttr57);

        //sku_attr_id = 58
        SkuAttr skuAttr58 = new SkuAttr();
        skuAttr58.setSku_id(17);
        skuAttr58.setSku_attr_name("杏色");
        skuAttr58.setSku_attr_image(R.drawable.sku_attr9_2);
        skuAttrDao.insert(skuAttr58);

        //sku_attr_id = 59
        SkuAttr skuAttr59 = new SkuAttr();
        skuAttr59.setSku_id(18);
        skuAttr59.setSku_attr_name("S");
        skuAttrDao.insert(skuAttr59);

        //sku_attr_id = 60
        SkuAttr skuAttr60 = new SkuAttr();
        skuAttr60.setSku_id(18);
        skuAttr60.setSku_attr_name("M");
        skuAttrDao.insert(skuAttr60);

        //sku_attr_id = 61
        SkuAttr skuAttr61 = new SkuAttr();
        skuAttr61.setSku_id(18);
        skuAttr61.setSku_attr_name("L");
        skuAttrDao.insert(skuAttr61);

        //sku_attr_id = 62
        SkuAttr skuAttr62 = new SkuAttr();
        skuAttr62.setSku_id(18);
        skuAttr62.setSku_attr_name("XL");
        skuAttrDao.insert(skuAttr62);


        // 服装 10

        // spu_id = 10
        Spu spu10 = new Spu();
        spu10.setSpu_price(239);
        spu10.setSpu_name("NOTAWEAR 沙漠公路 万能裤装 版型至上 米白色美式高腰直筒工装裤");
        spu10.setSpu_sales(233);
        spu10.setBrand_id(3);
        spu10.setSpu_image(R.drawable.spu10);
        spuDao.insert(spu10);

        // image_id = 21
        Image image21 = new Image();
        image21.setSpu_id(10);
        image21.setImage_url(R.drawable.spu10_1);
        imageDao.insert(image21);

        // image_id = 22
        Image image22 = new Image();
        image22.setSpu_id(10);
        image22.setImage_url(R.drawable.spu10_2);
        imageDao.insert(image22);



        // spu_attr_id = 37
        SpuAttr spuAttr37 = new SpuAttr();
        spuAttr37.setSpu_attr_name("风格");
        spuAttr37.setSpu_id(10);
        spuAttr37.setSpu_attr_value("青春流行");
        spuAttr37.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr37);

        // spu_attr_id = 38
        SpuAttr spuAttr38 = new SpuAttr();
        spuAttr38.setSpu_attr_name("品牌");
        spuAttr38.setSpu_id(10);
        spuAttr38.setSpu_attr_value("MontVoo");
        spuAttr38.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr38);

        // spu_attr_id = 39
        SpuAttr spuAttr39 = new SpuAttr();
        spuAttr39.setSpu_attr_name("服装版型");
        spuAttr39.setSpu_id(10);
        spuAttr39.setSpu_attr_value("宽松型");
        spuAttr39.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr39);

        // spu_attr_id = 40
        SpuAttr spuAttr40 = new SpuAttr();
        spuAttr40.setSpu_attr_name("款式");
        spuAttr40.setSpu_id(10);
        spuAttr40.setSpu_attr_value("套头");
        spuAttr40.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr40);

        // sku_id = 19
        Sku sku27 = new Sku();
        sku27.setSpu_id(10);
        sku27.setSku_name("颜色");
        skuDao.insert(sku27);

        // sku_id = 20
        Sku sku28 = new Sku();
        sku28.setSpu_id(10);
        sku28.setSku_name("尺码");
        skuDao.insert(sku28);

        //sku_attr_id = 63
        SkuAttr skuAttr63 = new SkuAttr();
        skuAttr63.setSku_id(19);
        skuAttr63.setSku_attr_name("绿色");
        skuAttr63.setSku_attr_image(R.drawable.sku_attr10_1);
        skuAttrDao.insert(skuAttr63);

        //sku_attr_id = 64
        SkuAttr skuAttr64 = new SkuAttr();
        skuAttr64.setSku_id(19);
        skuAttr64.setSku_attr_name("杏色");
        skuAttr64.setSku_attr_image(R.drawable.sku_attr10_2);
        skuAttrDao.insert(skuAttr64);

        //sku_attr_id = 65
        SkuAttr skuAttr65 = new SkuAttr();
        skuAttr65.setSku_id(20);
        skuAttr65.setSku_attr_name("S");
        skuAttrDao.insert(skuAttr65);

        //sku_attr_id = 66
        SkuAttr skuAttr66 = new SkuAttr();
        skuAttr66.setSku_id(20);
        skuAttr66.setSku_attr_name("M");
        skuAttrDao.insert(skuAttr66);

        //sku_attr_id = 67
        SkuAttr skuAttr67 = new SkuAttr();
        skuAttr67.setSku_id(20);
        skuAttr67.setSku_attr_name("L");
        skuAttrDao.insert(skuAttr67);

        //sku_attr_id = 68
        SkuAttr skuAttr68 = new SkuAttr();
        skuAttr68.setSku_id(20);
        skuAttr68.setSku_attr_name("XL");
        skuAttrDao.insert(skuAttr68);


        // 服装 11

        // spu_id = 11
        Spu spu11 = new Spu();
        spu11.setSpu_price(549);
        spu11.setSpu_name("underpassX芭比barbie联名款复古奶粉工装V腰显瘦微喇牛仔休闲裤");
        spu11.setSpu_sales(7876);
        spu11.setBrand_id(3);
        spu11.setSpu_image(R.drawable.spu11);
        spuDao.insert(spu11);

        // image_id = 23
        Image image23 = new Image();
        image23.setSpu_id(11);
        image23.setImage_url(R.drawable.spu11_1);
        imageDao.insert(image23);

        // image_id = 24
        Image image24 = new Image();
        image24.setSpu_id(11);
        image24.setImage_url(R.drawable.spu11_2);
        imageDao.insert(image24);

        // spu_attr_id = 41
        SpuAttr spuAttr41 = new SpuAttr();
        spuAttr41.setSpu_attr_name("风格");
        spuAttr41.setSpu_id(11);
        spuAttr41.setSpu_attr_value("青春流行");
        spuAttr41.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr41);

        // spu_attr_id = 42
        SpuAttr spuAttr42 = new SpuAttr();
        spuAttr42.setSpu_attr_name("品牌");
        spuAttr42.setSpu_id(11);
        spuAttr42.setSpu_attr_value("MontVoo");
        spuAttr42.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr42);

        // spu_attr_id = 43
        SpuAttr spuAttr43 = new SpuAttr();
        spuAttr43.setSpu_attr_name("服装版型");
        spuAttr43.setSpu_id(11);
        spuAttr43.setSpu_attr_value("宽松型");
        spuAttr43.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr43);

        // spu_attr_id = 44
        SpuAttr spuAttr44 = new SpuAttr();
        spuAttr44.setSpu_attr_name("款式");
        spuAttr44.setSpu_id(11);
        spuAttr44.setSpu_attr_value("套头");
        spuAttr44.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr44);

        // sku_id = 21
        Sku sku29 = new Sku();
        sku29.setSpu_id(11);
        sku29.setSku_name("颜色");
        skuDao.insert(sku29);

        // sku_id = 22
        Sku sku30 = new Sku();
        sku30.setSpu_id(11);
        sku30.setSku_name("尺码");
        skuDao.insert(sku30);

        //sku_attr_id = 69
        SkuAttr skuAttr69 = new SkuAttr();
        skuAttr69.setSku_id(21);
        skuAttr69.setSku_attr_name("绿色");
        skuAttr69.setSku_attr_image(R.drawable.sku_attr11_1);
        skuAttrDao.insert(skuAttr69);

        //sku_attr_id = 70
        SkuAttr skuAttr70 = new SkuAttr();
        skuAttr70.setSku_id(21);
        skuAttr70.setSku_attr_name("杏色");
        skuAttr70.setSku_attr_image(R.drawable.sku_attr11_2);
        skuAttrDao.insert(skuAttr70);

        //sku_attr_id = 71
        SkuAttr skuAttr71 = new SkuAttr();
        skuAttr71.setSku_id(22);
        skuAttr71.setSku_attr_name("S");
        skuAttrDao.insert(skuAttr71);

        //sku_attr_id = 72
        SkuAttr skuAttr72 = new SkuAttr();
        skuAttr72.setSku_id(22);
        skuAttr72.setSku_attr_name("M");
        skuAttrDao.insert(skuAttr72);

        //sku_attr_id = 73
        SkuAttr skuAttr73 = new SkuAttr();
        skuAttr73.setSku_id(22);
        skuAttr73.setSku_attr_name("L");
        skuAttrDao.insert(skuAttr73);

        //sku_attr_id = 74
        SkuAttr skuAttr74 = new SkuAttr();
        skuAttr74.setSku_id(22);
        skuAttr74.setSku_attr_name("XL");
        skuAttrDao.insert(skuAttr74);

        // 服装 12

        // spu_id = 12
        Spu spu12 = new Spu();
        spu12.setSpu_price(355);
        spu12.setSpu_name("MODITEC蝴蝶印花喇叭牛仔裤双色百搭阔腿裤男女");
        spu12.setSpu_sales(2431);
        spu12.setBrand_id(3);
        spu12.setSpu_image(R.drawable.spu12);
        spuDao.insert(spu12);

        // image_id = 25
        Image image25 = new Image();
        image25.setSpu_id(12);
        image25.setImage_url(R.drawable.spu12_1);
        imageDao.insert(image25);

        // image_id = 26
        Image image26 = new Image();
        image26.setSpu_id(12);
        image26.setImage_url(R.drawable.spu12_2);
        imageDao.insert(image26);

        // spu_attr_id = 45
        SpuAttr spuAttr45 = new SpuAttr();
        spuAttr45.setSpu_attr_name("风格");
        spuAttr45.setSpu_id(12);
        spuAttr45.setSpu_attr_value("青春流行");
        spuAttr45.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr45);

        // spu_attr_id = 46
        SpuAttr spuAttr46 = new SpuAttr();
        spuAttr46.setSpu_attr_name("品牌");
        spuAttr46.setSpu_id(12);
        spuAttr46.setSpu_attr_value("MontVoo");
        spuAttr46.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr46);

        // spu_attr_id = 47
        SpuAttr spuAttr47 = new SpuAttr();
        spuAttr47.setSpu_attr_name("服装版型");
        spuAttr47.setSpu_id(12);
        spuAttr47.setSpu_attr_value("宽松型");
        spuAttr47.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr47);

        // spu_attr_id = 48
        SpuAttr spuAttr48 = new SpuAttr();
        spuAttr48.setSpu_attr_name("款式");
        spuAttr48.setSpu_id(12);
        spuAttr48.setSpu_attr_value("套头");
        spuAttr48.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr48);

        // sku_id = 23
        Sku sku31 = new Sku();
        sku31.setSpu_id(12);
        sku31.setSku_name("颜色");
        skuDao.insert(sku31);

        // sku_id = 24
        Sku sku32 = new Sku();
        sku32.setSpu_id(12);
        sku32.setSku_name("尺码");
        skuDao.insert(sku32);

        //sku_attr_id = 75
        SkuAttr skuAttr75 = new SkuAttr();
        skuAttr75.setSku_id(23);
        skuAttr75.setSku_attr_name("绿色");
        skuAttr75.setSku_attr_image(R.drawable.sku_attr12_1);
        skuAttrDao.insert(skuAttr75);

        //sku_attr_id = 76
        SkuAttr skuAttr76 = new SkuAttr();
        skuAttr76.setSku_id(23);
        skuAttr76.setSku_attr_name("杏色");
        skuAttr76.setSku_attr_image(R.drawable.sku_attr12_2);
        skuAttrDao.insert(skuAttr76);

        //sku_attr_id = 77
        SkuAttr skuAttr77 = new SkuAttr();
        skuAttr77.setSku_id(24);
        skuAttr77.setSku_attr_name("S");
        skuAttrDao.insert(skuAttr77);

        //sku_attr_id = 78
        SkuAttr skuAttr78 = new SkuAttr();
        skuAttr78.setSku_id(24);
        skuAttr78.setSku_attr_name("M");
        skuAttrDao.insert(skuAttr78);

        //sku_attr_id = 79
        SkuAttr skuAttr79 = new SkuAttr();
        skuAttr79.setSku_id(24);
        skuAttr79.setSku_attr_name("L");
        skuAttrDao.insert(skuAttr79);

        //sku_attr_id = 80
        SkuAttr skuAttr80 = new SkuAttr();
        skuAttr80.setSku_id(24);
        skuAttr80.setSku_attr_name("XL");
        skuAttrDao.insert(skuAttr80);


        // 服装 13

        // spu_id = 13
        Spu spu13 = new Spu();
        spu13.setSpu_price(445);
        spu13.setSpu_name("NUTHDrawstring Pants 抽绳设计工装裤宽松直筒休闲裤");
        spu13.setSpu_sales(123);
        spu13.setBrand_id(3);
        spu13.setSpu_image(R.drawable.spu13);
        spuDao.insert(spu13);

        // image_id = 27
        Image image27 = new Image();
        image27.setSpu_id(13);
        image27.setImage_url(R.drawable.spu13_1);
        imageDao.insert(image27);

        // image_id = 28
        Image image28 = new Image();
        image28.setSpu_id(13);
        image28.setImage_url(R.drawable.spu13_2);
        imageDao.insert(image28);

        // spu_attr_id = 49
        SpuAttr spuAttr49 = new SpuAttr();
        spuAttr49.setSpu_attr_name("风格");
        spuAttr49.setSpu_id(13);
        spuAttr49.setSpu_attr_value("青春流行");
        spuAttr49.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr49);

        // spu_attr_id = 50
        SpuAttr spuAttr50 = new SpuAttr();
        spuAttr50.setSpu_attr_name("品牌");
        spuAttr50.setSpu_id(13);
        spuAttr50.setSpu_attr_value("MontVoo");
        spuAttr50.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr50);

        // spu_attr_id = 51
        SpuAttr spuAttr51 = new SpuAttr();
        spuAttr51.setSpu_attr_name("服装版型");
        spuAttr51.setSpu_id(13);
        spuAttr51.setSpu_attr_value("宽松型");
        spuAttr51.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr51);

        // spu_attr_id = 52
        SpuAttr spuAttr52 = new SpuAttr();
        spuAttr52.setSpu_attr_name("款式");
        spuAttr52.setSpu_id(13);
        spuAttr52.setSpu_attr_value("套头");
        spuAttr52.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr52);

        // sku_id = 25
        Sku sku33 = new Sku();
        sku33.setSpu_id(13);
        sku33.setSku_name("颜色");
        skuDao.insert(sku33);

        // sku_id = 26
        Sku sku34 = new Sku();
        sku34.setSpu_id(13);
        sku34.setSku_name("尺码");
        skuDao.insert(sku34);

        //sku_attr_id = 81
        SkuAttr skuAttr81 = new SkuAttr();
        skuAttr81.setSku_id(25);
        skuAttr81.setSku_attr_name("绿色");
        skuAttr81.setSku_attr_image(R.drawable.sku_attr13_1);
        skuAttrDao.insert(skuAttr81);

        //sku_attr_id = 82
        SkuAttr skuAttr82 = new SkuAttr();
        skuAttr82.setSku_id(25);
        skuAttr82.setSku_attr_name("杏色");
        skuAttr82.setSku_attr_image(R.drawable.sku_attr13_2);
        skuAttrDao.insert(skuAttr82);

        //sku_attr_id = 83
        SkuAttr skuAttr83 = new SkuAttr();
        skuAttr83.setSku_id(26);
        skuAttr83.setSku_attr_name("S");
        skuAttrDao.insert(skuAttr83);

        //sku_attr_id = 84
        SkuAttr skuAttr84 = new SkuAttr();
        skuAttr84.setSku_id(26);
        skuAttr84.setSku_attr_name("M");
        skuAttrDao.insert(skuAttr84);

        //sku_attr_id = 85
        SkuAttr skuAttr85 = new SkuAttr();
        skuAttr85.setSku_id(26);
        skuAttr85.setSku_attr_name("L");
        skuAttrDao.insert(skuAttr85);

        //sku_attr_id = 86
        SkuAttr skuAttr86 = new SkuAttr();
        skuAttr86.setSku_id(26);
        skuAttr86.setSku_attr_name("XL");
        skuAttrDao.insert(skuAttr86);


        // 服装 14

        // spu_id = 14
        Spu spu14 = new Spu();
        spu14.setSpu_price(445);
        spu14.setSpu_name("JHYQ工装系列美式拼接条纹伞兵裤男秋季潮牌抽绳运动直筒冲锋长裤");
        spu14.setSpu_sales(123);
        spu14.setBrand_id(3);
        spu14.setSpu_image(R.drawable.spu14);
        spuDao.insert(spu14);

        // image_id = 29
        Image image29 = new Image();
        image29.setSpu_id(14);
        image29.setImage_url(R.drawable.spu14_1);
        imageDao.insert(image29);

        // image_id = 30
        Image image30 = new Image();
        image30.setSpu_id(14);
        image30.setImage_url(R.drawable.spu14_2);
        imageDao.insert(image30);

        // spu_attr_id = 53
        SpuAttr spuAttr53 = new SpuAttr();
        spuAttr53.setSpu_attr_name("风格");
        spuAttr53.setSpu_id(14);
        spuAttr53.setSpu_attr_value("青春流行");
        spuAttr53.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr53);

        // spu_attr_id = 54
        SpuAttr spuAttr54 = new SpuAttr();
        spuAttr54.setSpu_attr_name("品牌");
        spuAttr54.setSpu_id(14);
        spuAttr54.setSpu_attr_value("MontVoo");
        spuAttr54.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr54);

        // spu_attr_id = 55
        SpuAttr spuAttr55 = new SpuAttr();
        spuAttr55.setSpu_attr_name("服装版型");
        spuAttr55.setSpu_id(14);
        spuAttr55.setSpu_attr_value("宽松型");
        spuAttr55.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr55);

        // spu_attr_id = 56
        SpuAttr spuAttr56 = new SpuAttr();
        spuAttr56.setSpu_attr_name("款式");
        spuAttr56.setSpu_id(14);
        spuAttr56.setSpu_attr_value("套头");
        spuAttr56.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr56);

        // sku_id = 27
        Sku sku35 = new Sku();
        sku35.setSpu_id(14);
        sku35.setSku_name("颜色");
        skuDao.insert(sku35);

        // sku_id = 28
        Sku sku36 = new Sku();
        sku36.setSpu_id(14);
        sku36.setSku_name("尺码");
        skuDao.insert(sku36);

        //sku_attr_id = 87
        SkuAttr skuAttr87 = new SkuAttr();
        skuAttr87.setSku_id(27);
        skuAttr87.setSku_attr_name("绿色");
        skuAttr87.setSku_attr_image(R.drawable.sku_attr14_1);
        skuAttrDao.insert(skuAttr87);

        //sku_attr_id = 88
        SkuAttr skuAttr88 = new SkuAttr();
        skuAttr88.setSku_id(27);
        skuAttr88.setSku_attr_name("杏色");
        skuAttr88.setSku_attr_image(R.drawable.sku_attr14_2);
        skuAttrDao.insert(skuAttr88);

        //sku_attr_id = 89
        SkuAttr skuAttr89 = new SkuAttr();
        skuAttr89.setSku_id(28);
        skuAttr89.setSku_attr_name("S");
        skuAttrDao.insert(skuAttr89);

        //sku_attr_id = 90
        SkuAttr skuAttr90 = new SkuAttr();
        skuAttr90.setSku_id(28);
        skuAttr90.setSku_attr_name("M");
        skuAttrDao.insert(skuAttr90);

        //sku_attr_id = 91
        SkuAttr skuAttr91 = new SkuAttr();
        skuAttr91.setSku_id(28);
        skuAttr91.setSku_attr_name("L");
        skuAttrDao.insert(skuAttr91);

        //sku_attr_id = 92
        SkuAttr skuAttr92 = new SkuAttr();
        skuAttr92.setSku_id(28);
        skuAttr92.setSku_attr_name("XL");
        skuAttrDao.insert(skuAttr92);

        // 服装 15

        // spu_id = 15
        Spu spu15 = new Spu();
        spu15.setSpu_price(255);
        spu15.setSpu_name("CENTRAL & KITTY 合成革厚底法式裤管靴短靴女款黑色");
        spu15.setSpu_sales(666);
        spu15.setBrand_id(4);
        spu15.setSpu_image(R.drawable.spu15);
        spuDao.insert(spu15);

        // image_id = 31
        Image image31 = new Image();
        image31.setSpu_id(15);
        image31.setImage_url(R.drawable.spu15_1);
        imageDao.insert(image31);

        // image_id = 32
        Image image32 = new Image();
        image32.setSpu_id(15);
        image32.setImage_url(R.drawable.spu15_2);
        imageDao.insert(image32);

        // spu_attr_id = 57
        SpuAttr spuAttr57 = new SpuAttr();
        spuAttr57.setSpu_attr_name("风格");
        spuAttr57.setSpu_id(15);
        spuAttr57.setSpu_attr_value("青春流行");
        spuAttr57.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr57);

        // spu_attr_id = 58
        SpuAttr spuAttr58 = new SpuAttr();
        spuAttr58.setSpu_attr_name("品牌");
        spuAttr58.setSpu_id(15);
        spuAttr58.setSpu_attr_value("MontVoo");
        spuAttr58.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr58);

        // spu_attr_id = 59
        SpuAttr spuAttr59 = new SpuAttr();
        spuAttr59.setSpu_attr_name("服装版型");
        spuAttr59.setSpu_id(15);
        spuAttr59.setSpu_attr_value("宽松型");
        spuAttr59.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr59);

        // spu_attr_id = 60
        SpuAttr spuAttr60 = new SpuAttr();
        spuAttr60.setSpu_attr_name("款式");
        spuAttr60.setSpu_id(15);
        spuAttr60.setSpu_attr_value("套头");
        spuAttr60.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr60);

        // sku_id = 29
        Sku sku37 = new Sku();
        sku37.setSpu_id(15);
        sku37.setSku_name("颜色");
        skuDao.insert(sku37);

        // sku_id = 30
        Sku sku38 = new Sku();
        sku38.setSpu_id(15);
        sku38.setSku_name("尺码");
        skuDao.insert(sku38);

        //sku_attr_id = 93
        SkuAttr skuAttr93 = new SkuAttr();
        skuAttr93.setSku_id(29);
        skuAttr93.setSku_attr_name("绿色");
        skuAttr93.setSku_attr_image(R.drawable.sku_attr15_1);
        skuAttrDao.insert(skuAttr93);

        //sku_attr_id = 94
        SkuAttr skuAttr94 = new SkuAttr();
        skuAttr94.setSku_id(29);
        skuAttr94.setSku_attr_name("杏色");
        skuAttr94.setSku_attr_image(R.drawable.sku_attr15_2);
        skuAttrDao.insert(skuAttr94);

        //sku_attr_id = 95
        SkuAttr skuAttr95 = new SkuAttr();
        skuAttr95.setSku_id(30);
        skuAttr95.setSku_attr_name("S");
        skuAttrDao.insert(skuAttr95);

        //sku_attr_id = 96
        SkuAttr skuAttr96 = new SkuAttr();
        skuAttr96.setSku_id(30);
        skuAttr96.setSku_attr_name("M");
        skuAttrDao.insert(skuAttr96);

        //sku_attr_id = 97
        SkuAttr skuAttr97 = new SkuAttr();
        skuAttr97.setSku_id(30);
        skuAttr97.setSku_attr_name("L");
        skuAttrDao.insert(skuAttr97);

        //sku_attr_id = 98
        SkuAttr skuAttr98 = new SkuAttr();
        skuAttr98.setSku_id(30);
        skuAttr98.setSku_attr_name("XL");
        skuAttrDao.insert(skuAttr98);


        // 服装 16

        // spu_id = 16
        Spu spu16 = new Spu();
        spu16.setSpu_price(255);
        spu16.setSpu_name("WALES BONNER x adidas originals ");
        spu16.setSpu_sales(666);
        spu16.setBrand_id(4);
        spu16.setSpu_image(R.drawable.spu16);
        spuDao.insert(spu16);

        // image_id = 33
        Image image33 = new Image();
        image33.setSpu_id(16);
        image33.setImage_url(R.drawable.spu16_1);
        imageDao.insert(image33);

        // image_id = 34
        Image image34 = new Image();
        image34.setSpu_id(16);
        image34.setImage_url(R.drawable.spu16_2);
        imageDao.insert(image34);

        // spu_attr_id = 61
        SpuAttr spuAttr61 = new SpuAttr();
        spuAttr61.setSpu_attr_name("风格");
        spuAttr61.setSpu_id(16);
        spuAttr61.setSpu_attr_value("青春流行");
        spuAttr61.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr61);

        // spu_attr_id = 62
        SpuAttr spuAttr62 = new SpuAttr();
        spuAttr62.setSpu_attr_name("品牌");
        spuAttr62.setSpu_id(16);
        spuAttr62.setSpu_attr_value("MontVoo");
        spuAttr62.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr62);

        // spu_attr_id = 63
        SpuAttr spuAttr63 = new SpuAttr();
        spuAttr63.setSpu_attr_name("服装版型");
        spuAttr63.setSpu_id(16);
        spuAttr63.setSpu_attr_value("宽松型");
        spuAttr63.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr63);

        // spu_attr_id = 64
        SpuAttr spuAttr64 = new SpuAttr();
        spuAttr64.setSpu_attr_name("款式");
        spuAttr64.setSpu_id(16);
        spuAttr64.setSpu_attr_value("套头");
        spuAttr64.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr64);

        // sku_id = 31
        Sku sku39 = new Sku();
        sku39.setSpu_id(16);
        sku39.setSku_name("颜色");
        skuDao.insert(sku39);

        // sku_id = 32
        Sku sku40 = new Sku();
        sku40.setSpu_id(16);
        sku40.setSku_name("尺码");
        skuDao.insert(sku40);

        //sku_attr_id = 99
        SkuAttr skuAttr99 = new SkuAttr();
        skuAttr99.setSku_id(31);
        skuAttr99.setSku_attr_name("绿色");
        skuAttr99.setSku_attr_image(R.drawable.sku_attr16_1);
        skuAttrDao.insert(skuAttr99);

        //sku_attr_id = 100
        SkuAttr skuAttr100 = new SkuAttr();
        skuAttr100.setSku_id(31);
        skuAttr100.setSku_attr_name("杏色");
        skuAttr100.setSku_attr_image(R.drawable.sku_attr16_2);
        skuAttrDao.insert(skuAttr100);

        //sku_attr_id = 101
        SkuAttr skuAttr101 = new SkuAttr();
        skuAttr101.setSku_id(32);
        skuAttr101.setSku_attr_name("S");
        skuAttrDao.insert(skuAttr101);

        //sku_attr_id = 102
        SkuAttr skuAttr102 = new SkuAttr();
        skuAttr102.setSku_id(32);
        skuAttr102.setSku_attr_name("M");
        skuAttrDao.insert(skuAttr102);

        //sku_attr_id = 103
        SkuAttr skuAttr103 = new SkuAttr();
        skuAttr103.setSku_id(32);
        skuAttr103.setSku_attr_name("L");
        skuAttrDao.insert(skuAttr103);

        //sku_attr_id = 104
        SkuAttr skuAttr104 = new SkuAttr();
        skuAttr104.setSku_id(32);
        skuAttr104.setSku_attr_name("XL");
        skuAttrDao.insert(skuAttr104);

        // 服装 17

        // spu_id = 17
        Spu spu17 = new Spu();
        spu17.setSpu_price(567);
        spu17.setSpu_name("UGG2023冬季男士休闲舒适时尚平底纯色短筒迷你短靴雪地靴1115565");
        spu17.setSpu_sales(666);
        spu17.setBrand_id(5);
        spu17.setSpu_image(R.drawable.spu17);
        spuDao.insert(spu17);

        // image_id = 35
        Image image35 = new Image();
        image35.setSpu_id(17);
        image35.setImage_url(R.drawable.spu17_1);
        imageDao.insert(image35);

        // image_id = 36
        Image image36 = new Image();
        image36.setSpu_id(17);
        image36.setImage_url(R.drawable.spu17_2);
        imageDao.insert(image36);

        // spu_attr_id = 65
        SpuAttr spuAttr65 = new SpuAttr();
        spuAttr65.setSpu_attr_name("风格");
        spuAttr65.setSpu_id(17);
        spuAttr65.setSpu_attr_value("青春流行");
        spuAttr65.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr65);

        // spu_attr_id = 66
        SpuAttr spuAttr66 = new SpuAttr();
        spuAttr66.setSpu_attr_name("品牌");
        spuAttr66.setSpu_id(17);
        spuAttr66.setSpu_attr_value("MontVoo");
        spuAttr66.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr66);

        // spu_attr_id = 67
        SpuAttr spuAttr67 = new SpuAttr();
        spuAttr67.setSpu_attr_name("服装版型");
        spuAttr67.setSpu_id(17);
        spuAttr67.setSpu_attr_value("宽松型");
        spuAttr67.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr67);

        // spu_attr_id = 68
        SpuAttr spuAttr68 = new SpuAttr();
        spuAttr68.setSpu_attr_name("款式");
        spuAttr68.setSpu_id(17);
        spuAttr68.setSpu_attr_value("套头");
        spuAttr68.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr68);

        // sku_id = 33
        Sku sku41 = new Sku();
        sku41.setSpu_id(17);
        sku41.setSku_name("颜色");
        skuDao.insert(sku41);

        // sku_id = 34
        Sku sku42 = new Sku();
        sku42.setSpu_id(17);
        sku42.setSku_name("尺码");
        skuDao.insert(sku42);

        //sku_attr_id = 105
        SkuAttr skuAttr105 = new SkuAttr();
        skuAttr105.setSku_id(33);
        skuAttr105.setSku_attr_name("绿色");
        skuAttr105.setSku_attr_image(R.drawable.sku_attr17_1);
        skuAttrDao.insert(skuAttr105);

        //sku_attr_id = 106
        SkuAttr skuAttr106 = new SkuAttr();
        skuAttr106.setSku_id(33);
        skuAttr106.setSku_attr_name("杏色");
        skuAttr106.setSku_attr_image(R.drawable.sku_attr17_2);
        skuAttrDao.insert(skuAttr106);

        //sku_attr_id = 107
        SkuAttr skuAttr107 = new SkuAttr();
        skuAttr107.setSku_id(34);
        skuAttr107.setSku_attr_name("S");
        skuAttrDao.insert(skuAttr107);

        //sku_attr_id = 108
        SkuAttr skuAttr108 = new SkuAttr();
        skuAttr108.setSku_id(34);
        skuAttr108.setSku_attr_name("M");
        skuAttrDao.insert(skuAttr108);

        //sku_attr_id = 109
        SkuAttr skuAttr109 = new SkuAttr();
        skuAttr109.setSku_id(34);
        skuAttr109.setSku_attr_name("L");
        skuAttrDao.insert(skuAttr109);

        //sku_attr_id = 110
        SkuAttr skuAttr110 = new SkuAttr();
        skuAttr110.setSku_id(34);
        skuAttr110.setSku_attr_name("XL");
        skuAttrDao.insert(skuAttr110);


        // 服装 18

        // spu_id = 18
        Spu spu18 = new Spu();
        spu18.setSpu_price(399);
        spu18.setSpu_name("Dickies马丁靴男款高帮冬季加绒男鞋复古工装靴子防滑户外登山鞋");
        spu18.setSpu_sales(666);
        spu18.setBrand_id(5);
        spu18.setSpu_image(R.drawable.spu18);
        spuDao.insert(spu18);

        // image_id = 37
        Image image37 = new Image();
        image37.setSpu_id(18);
        image37.setImage_url(R.drawable.spu18_1);
        imageDao.insert(image37);

        // image_id = 38
        Image image38 = new Image();
        image38.setSpu_id(18);
        image38.setImage_url(R.drawable.spu18_2);
        imageDao.insert(image38);

        // spu_attr_id = 69
        SpuAttr spuAttr69 = new SpuAttr();
        spuAttr69.setSpu_attr_name("风格");
        spuAttr69.setSpu_id(18);
        spuAttr69.setSpu_attr_value("青春流行");
        spuAttr69.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr69);

        // spu_attr_id = 70
        SpuAttr spuAttr70 = new SpuAttr();
        spuAttr70.setSpu_attr_name("品牌");
        spuAttr70.setSpu_id(18);
        spuAttr70.setSpu_attr_value("MontVoo");
        spuAttr70.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr70);

        // spu_attr_id = 71
        SpuAttr spuAttr71 = new SpuAttr();
        spuAttr71.setSpu_attr_name("服装版型");
        spuAttr71.setSpu_id(18);
        spuAttr71.setSpu_attr_value("宽松型");
        spuAttr71.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr71);

        // spu_attr_id = 72
        SpuAttr spuAttr72 = new SpuAttr();
        spuAttr72.setSpu_attr_name("款式");
        spuAttr72.setSpu_id(18);
        spuAttr72.setSpu_attr_value("套头");
        spuAttr72.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr72);

        // sku_id = 35
        Sku sku43 = new Sku();
        sku43.setSpu_id(18);
        sku43.setSku_name("颜色");
        skuDao.insert(sku43);

        // sku_id = 36
        Sku sku44 = new Sku();
        sku44.setSpu_id(18);
        sku44.setSku_name("尺码");
        skuDao.insert(sku44);

        //sku_attr_id = 111
        SkuAttr skuAttr111 = new SkuAttr();
        skuAttr111.setSku_id(35);
        skuAttr111.setSku_attr_name("绿色");
        skuAttr111.setSku_attr_image(R.drawable.sku_attr18_1);
        skuAttrDao.insert(skuAttr111);

        //sku_attr_id = 112
        SkuAttr skuAttr112 = new SkuAttr();
        skuAttr112.setSku_id(35);
        skuAttr112.setSku_attr_name("杏色");
        skuAttr112.setSku_attr_image(R.drawable.sku_attr18_2);
        skuAttrDao.insert(skuAttr112);

        //sku_attr_id = 113
        SkuAttr skuAttr113 = new SkuAttr();
        skuAttr113.setSku_id(36);
        skuAttr113.setSku_attr_name("S");
        skuAttrDao.insert(skuAttr113);

        //sku_attr_id = 114
        SkuAttr skuAttr114 = new SkuAttr();
        skuAttr114.setSku_id(36);
        skuAttr114.setSku_attr_name("M");
        skuAttrDao.insert(skuAttr114);

        //sku_attr_id = 115
        SkuAttr skuAttr115 = new SkuAttr();
        skuAttr115.setSku_id(36);
        skuAttr115.setSku_attr_name("L");
        skuAttrDao.insert(skuAttr115);

        //sku_attr_id = 116
        SkuAttr skuAttr116 = new SkuAttr();
        skuAttr116.setSku_id(36);
        skuAttr116.setSku_attr_name("XL");
        skuAttrDao.insert(skuAttr116);


        // 服装 19

        // spu_id = 19
        Spu spu19 = new Spu();
        spu19.setSpu_price(299);
        spu19.setSpu_name("骆驼鞋子女2023新款爆款冬季真皮复古松糕靴厚底靴子女短靴马丁靴");
        spu19.setSpu_sales(666);
        spu19.setBrand_id(5);
        spu19.setSpu_image(R.drawable.spu19);
        spuDao.insert(spu19);

        // image_id = 39
        Image image39 = new Image();
        image39.setSpu_id(19);
        image39.setImage_url(R.drawable.spu19_1);
        imageDao.insert(image39);

        // image_id = 40
        Image image40 = new Image();
        image40.setSpu_id(19);
        image40.setImage_url(R.drawable.spu19_2);
        imageDao.insert(image40);

        // spu_attr_id = 73
        SpuAttr spuAttr73 = new SpuAttr();
        spuAttr73.setSpu_attr_name("风格");
        spuAttr73.setSpu_id(19);
        spuAttr73.setSpu_attr_value("青春流行");
        spuAttr73.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr73);

        // spu_attr_id = 74
        SpuAttr spuAttr74 = new SpuAttr();
        spuAttr74.setSpu_attr_name("品牌");
        spuAttr74.setSpu_id(19);
        spuAttr74.setSpu_attr_value("MontVoo");
        spuAttr74.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr74);

        // spu_attr_id = 75
        SpuAttr spuAttr75 = new SpuAttr();
        spuAttr75.setSpu_attr_name("服装版型");
        spuAttr75.setSpu_id(19);
        spuAttr75.setSpu_attr_value("宽松型");
        spuAttr75.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr75);

        // spu_attr_id = 76
        SpuAttr spuAttr76 = new SpuAttr();
        spuAttr76.setSpu_attr_name("款式");
        spuAttr76.setSpu_id(19);
        spuAttr76.setSpu_attr_value("套头");
        spuAttr76.setSpu_attr_image(R.drawable.baseline_style_24);
        spuAttrDao.insert(spuAttr76);

        // sku_id = 37
        Sku sku45 = new Sku();
        sku45.setSpu_id(19);
        sku45.setSku_name("颜色");
        skuDao.insert(sku45);

        // sku_id = 38
        Sku sku46 = new Sku();
        sku46.setSpu_id(19);
        sku46.setSku_name("尺码");
        skuDao.insert(sku46);

        //sku_attr_id = 117
        SkuAttr skuAttr117 = new SkuAttr();
        skuAttr117.setSku_id(37);
        skuAttr117.setSku_attr_name("绿色");
        skuAttr117.setSku_attr_image(R.drawable.sku_attr19_1);
        skuAttrDao.insert(skuAttr117);

        //sku_attr_id = 118
        SkuAttr skuAttr118 = new SkuAttr();
        skuAttr118.setSku_id(37);
        skuAttr118.setSku_attr_name("杏色");
        skuAttr118.setSku_attr_image(R.drawable.sku_attr19_2);
        skuAttrDao.insert(skuAttr118);

        //sku_attr_id = 119
        SkuAttr skuAttr119 = new SkuAttr();
        skuAttr119.setSku_id(38);
        skuAttr119.setSku_attr_name("S");
        skuAttrDao.insert(skuAttr119);

        //sku_attr_id = 120
        SkuAttr skuAttr120 = new SkuAttr();
        skuAttr120.setSku_id(38);
        skuAttr120.setSku_attr_name("M");
        skuAttrDao.insert(skuAttr120);

        //sku_attr_id = 121
        SkuAttr skuAttr121 = new SkuAttr();
        skuAttr121.setSku_id(38);
        skuAttr121.setSku_attr_name("L");
        skuAttrDao.insert(skuAttr121);

        //sku_attr_id = 122
        SkuAttr skuAttr122 = new SkuAttr();
        skuAttr122.setSku_id(38);
        skuAttr122.setSku_attr_name("XL");
        skuAttrDao.insert(skuAttr122);


//        // spu_id = 20
//        Spu spu20 = new Spu();
//        spu20.setSpu_price(9999);
//        spu20.setSpu_name("郝奕辰三姐宠爱版");
//        spu20.setSpu_sales(99999);
//        spu20.setBrand_id(6);
//        spu20.setSpu_image(R.drawable.hyc);
//        spuDao.insert(spu20);
//
//        // spu_id = 21
//        Spu spu21 = new Spu();
//        spu21.setSpu_price(0);
//        spu21.setSpu_name("爱吃炒饭");
//        spu21.setSpu_sales(99999);
//        spu21.setBrand_id(6);
//        spu21.setSpu_image(R.drawable.zcf);
//        spuDao.insert(spu21);


        // cart_id = 1
        Cart cart1 = new Cart();
        cart1.setUser_id(1);
        cart1.setGood_name("Dickies马丁靴男款高帮冬季加绒男鞋复古工装靴子防滑户外登山鞋");
        cart1.setSpu_id(18);
        cart1.setBrand_id(5);
        cart1.setGood_number(1);
        cart1.setGood_url(R.drawable.spu18);
        cart1.setGood_price(399);
        cart1.setGood_sku("黄色 38码");
        cartDao.insert(cart1);

        // order_id = 1
        Order order1 = new Order();
        order1.setUser_id(1);
        order1.setAddr_name("邹炒饭酱");
        order1.setAddr_addr("甘肃省 兰州市 安宁区 十里店街道 西北师范大学知行学院");
        order1.setAddr_phone("88888888888");
        order1.setOrder_money(19998);
        order1.setOrder_time("2023-11-29");
        order1.setOrder_status("已付款");
        orderDao.insert(order1);


        // order_detail_id = 1
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setOrder_id(1);
        orderDetail1.setBrand_id(5);
        orderDetail1.setSpu_id(18);
        orderDetail1.setGood_name("Dickies马丁靴男款高帮冬季加绒男鞋复古工装靴子防滑户外登山鞋");
        orderDetail1.setGood_number(1);
        orderDetail1.setGood_price(9999);
        orderDetail1.setGood_image(R.drawable.spu18);
        orderDetail1.setGood_sku("黄色 38码");
        orderDetailDao.insert(orderDetail1);
        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setOrder_id(1);
        orderDetail2.setBrand_id(5);
        orderDetail2.setSpu_id(18);
        orderDetail2.setGood_name("Dickies马丁靴男款高帮冬季加绒男鞋复古工装靴子防滑户外登山鞋");
        orderDetail2.setGood_number(1);
        orderDetail2.setGood_price(9999);
        orderDetail2.setGood_image(R.drawable.spu18);
        orderDetail2.setGood_sku("黄色 38码");
        orderDetailDao.insert(orderDetail2);




        startActivity(new Intent(InitXCartDataBaseActivity.this, MainActivity.class));


    }
}