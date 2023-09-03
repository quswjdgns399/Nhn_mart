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
    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    public void deleteFoods(String deleteFoods) {

        boolean find = false;
        for (Food foodStand : getFoods()) {
            if (foodStand.getName().equals(deleteFoods)) {
                foods.remove(foodStand);
                find = true;
                break;
            }
        }
        if (!find) {
            throw new IllegalArgumentException("매대에 식품이 없습니다.");
        }
    }
}