package com.nhnacademy.mart;

import java.util.ArrayList;

public class Counter {

    private int total_price;

    public Counter() {
        this.total_price = 0;
    }

    // 지불 받기
    public void receive_price(int price) {
        total_price += price;
    }

    // 총 매출액 반환
    public int getTotal_price() {
        return total_price;
    }



}
