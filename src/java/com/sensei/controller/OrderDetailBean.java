package com.sensei.controller;

import com.sensei.model.Product;
import java.util.HashMap;
import java.util.Map;


public class OrderDetailBean {
    private double totalHarga;
    private Map<Integer, Product> orderList = new HashMap<Integer, Product>();

    public OrderDetailBean() {
    }

    /**
     * @return the totalHarga
     */
    public double getTotalHarga() {
        return totalHarga;
    }

    /**
     * @param totalHarga the totalHarga to set
     */
    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    /**
     * @return the orderList
     */
    public Map<Integer, Product> getOrderList() {
        return orderList;
    }

    /**
     * @param orderList the orderList to set
     */
    public void setOrderList(Map<Integer, Product> orderList) {
        this.orderList = orderList;
    }
    
}
