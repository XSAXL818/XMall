package com.xsaxl.xnoteplus.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Order {

    @PrimaryKey(autoGenerate = true)
    private int order_id;
    private int user_id;//用户id
    private String addr_name;//收货人姓名
    private String addr_phone;//收货人电话
    private String addr_addr;//收件人地址
    private double order_money;
    private String order_time;//下单时间
    private String order_status;//订单状态

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", addr_name='" + addr_name + '\'' +
                ", addr_phone='" + addr_phone + '\'' +
                ", addr_addr='" + addr_addr + '\'' +
                ", order_money=" + order_money +
                ", order_time='" + order_time + '\'' +
                ", order_status='" + order_status + '\'' +
                '}';
    }

    public String getAddr_name() {
        return addr_name;
    }

    public void setAddr_name(String addr_name) {
        this.addr_name = addr_name;
    }

    public String getAddr_phone() {
        return addr_phone;
    }

    public void setAddr_phone(String addr_phone) {
        this.addr_phone = addr_phone;
    }

    public String getAddr_addr() {
        return addr_addr;
    }

    public void setAddr_addr(String addr_addr) {
        this.addr_addr = addr_addr;
    }

    public double getOrder_money() {
        return order_money;
    }

    public void setOrder_money(double order_money) {
        this.order_money = order_money;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

}
