package com.xsaxl.xnoteplus.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

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
import com.xsaxl.xnoteplus.entity.Comment;
import com.xsaxl.xnoteplus.entity.Image;
import com.xsaxl.xnoteplus.entity.Order;
import com.xsaxl.xnoteplus.entity.OrderDetail;
import com.xsaxl.xnoteplus.entity.Sku;
import com.xsaxl.xnoteplus.entity.SkuAttr;
import com.xsaxl.xnoteplus.entity.Spu;
import com.xsaxl.xnoteplus.entity.SpuAttr;
import com.xsaxl.xnoteplus.entity.User;

//  Addr.class, Brand.class, Cart.class, Comment.class, Image.class, Order.class, OrderDetail.class, Sku.class, SkuAttr.class, Spu.class, SpuAttr.class

@Database(entities = { User.class, Address.class, Brand.class, Cart.class, Comment.class, Image.class, Order.class, OrderDetail.class, Sku.class, SkuAttr.class, Spu.class, SpuAttr.class  }, version = 1, exportSchema = false)
public abstract class XMallDatabase extends RoomDatabase {

    public abstract UserDao getUserDao();
    public abstract AddressDao getAddressDao();
    public abstract BrandDao getBrandDao();
    public abstract CartDao getCartDao();
    public abstract CommentDao getCommentDao();
    public abstract ImageDao getImageDao();
    public abstract OrderDao getOrderDao();
    public abstract OrderDetailDao getOrderDetailDao();
    public abstract SkuDao getSkuDao();
    public abstract SkuAttrDao getSkuAttrDao();
    public abstract SpuDao getSpuDao();
    public abstract SpuAttrDao getSpuAttrDao();


}
