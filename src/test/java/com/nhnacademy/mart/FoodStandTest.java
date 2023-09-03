package com.nhnacademy.mart;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FoodStandTest {

    private FoodStand foodStand;

    @BeforeEach
    void setUp() {
        foodStand = new FoodStand();
        foodStand.add(new Food("양파", 1_000));
        foodStand.add(new Food("계란", 5_000));
        foodStand.add(new Food("파", 500));
    }

    @Test
    @DisplayName("deleteFoods 작동 테스트")
    void testDeleteFoods() {
        String foodToDelete = "양파";

        foodStand.deleteFoods(foodToDelete);

        List<Food> foods = foodStand.getFoods();
        boolean found = false;
        for (Food food : foods) {
            if (food.getName().equals(foodToDelete)) {
                found = true;
                break;
            }
        }
        // assertFasle => boolean 검사
        assertFalse(found);
    }

    @Test
    @DisplayName("FoodStand에 없는 식품 삭제 테스트")
    void testDeleteNonExistentFood() {
        String foodToDelete = "사과";

        assertThrows(IllegalArgumentException.class, () -> foodStand.deleteFoods(foodToDelete));
    }
}
