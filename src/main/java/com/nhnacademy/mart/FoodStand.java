package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("checkstyle:MissingJavadocType")
public class FoodStand {

    public List<Food> getFoods() {
        return foods;
    }

    private final ArrayList<Food> foods = new ArrayList<>();

    // TODO add 메서드 구현
    public void add(Food food) {
        foods.add(food);
    }



    // TODO 장바구니에 담은 Food 삭제 구현
}
