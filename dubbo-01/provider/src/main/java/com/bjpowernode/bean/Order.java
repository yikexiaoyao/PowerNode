package com.bjpowernode.bean;

import java.io.Serializable;

/**
 * @author cty
 * @date 2021/12/3 20:39
 */
public class Order implements Serializable {

    private static final long serialVersionUID = -6516565152647986715L;

    private String id;

    private String goodName;

    private double price;

    private Integer amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" + "id='" + id + '\'' + ", goodName='" + goodName + '\'' + ", price=" + price + ", amount=" + amount + '}';
    }
}
