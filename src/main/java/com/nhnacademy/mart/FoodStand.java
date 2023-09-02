package com.nhnacademy.mart;

import java.util.ArrayList;

public class FoodStand {

    public ArrayList<Food> getFoods() {
        return foods;
    }

    private final ArrayList<Food> foods = new ArrayList<>();

    // TODO add 메서드 구현
    public void add(Food food) {
        foods.add(food);
    }



    // TODO 장바구니에 담은 Food 삭제 구현
}
