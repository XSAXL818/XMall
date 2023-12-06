package com.xsaxl.xnoteplus;

import android.app.Application;

import androidx.room.Room;

import com.xsaxl.xnoteplus.database.XMallDatabase;
import com.xsaxl.xnoteplus.entity.User;

import java.util.Map;

// 实现APP全局变量保存
public class MyApplication extends Application {
    // 单例模式--饿汉式
    private static MyApplication instance;

    // 需要用到的全局变量，比如数据库
     private static XMallDatabase xMallDatabase;
    // 一些变量,保存字符串信息
    private Map<String,String> infoMap;

    private static User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static MyApplication getInstance() {
        return instance;
    }

    // 创建时，保存实例，并初始化数据库等操作
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;//初始化单例
        // 创建数据库 xnote
        xMallDatabase = Room.databaseBuilder(this, XMallDatabase.class,"xmall.db")
                .allowMainThreadQueries()
                .build();
    }

    // 构建返回数据库的方法
    public XMallDatabase getXCartDatabase() {
        return xMallDatabase;
    }



}
