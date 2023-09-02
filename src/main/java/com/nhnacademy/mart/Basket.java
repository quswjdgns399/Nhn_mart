package com.nhnacademy.mart;

import java.util.ArrayList;

@SuppressWarnings("checkstyle:MissingJavadocType")
public class Basket {
    private final ArrayList<Food> foods = new ArrayList<>();

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void add(Food food) {
        foods.add(food);
    }


}
