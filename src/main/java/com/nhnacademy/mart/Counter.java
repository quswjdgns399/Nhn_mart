package com.nhnacademy.mart;


@SuppressWarnings("checkstyle:MissingJavadocType")
public class Counter {

    private int totalPrice;

    public Counter() {
        this.totalPrice = 0;
    }

    // 지불 받기
    public void receivePrice(int price) {
        totalPrice += price;
    }

    // 총 매출액 반환
    public int getTotalPrice() {
        return totalPrice;
    }



}
