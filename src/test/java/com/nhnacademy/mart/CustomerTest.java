package com.nhnacademy.mart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    private Customer customer;
    private BuyList buyList;
    private FoodStand foodStand;
    private Basket basket;
    private Counter counter;
    private NhnMart nhnMart;

    @BeforeEach
    void setUp() {
        buyList = new BuyList();
        buyList.add(new BuyList.Item("양파", 2));
        buyList.add(new BuyList.Item("계란", 2));
        buyList.add(new BuyList.Item("파", 5));

        nhnMart = new NhnMart();
        nhnMart.prepareMart();

        basket = new Basket();

        customer = new Customer(buyList);
        customer.bring(basket);

        counter = new Counter();
    }

    @Test
    @DisplayName("pickFoods 작동 테스트")
    void testPickFoods() {

        customer.pickFoods(nhnMart.getFoodStand());

        assertEquals(3, basket.getFoods().size());
        assertEquals("양파", basket.getFoods().get(0).getName());
        assertEquals("계란", basket.getFoods().get(1).getName());
        assertEquals("파", basket.getFoods().get(2).getName());
    }

    @Test
    @DisplayName("FoodStand에 없는 상품 구매")
    void testPickFoodsWithMissingFood() {
        buyList.add(new BuyList.Item("고구마", 8));

        assertThrows(IllegalArgumentException.class, () -> customer.pickFoods(nhnMart.getFoodStand()));
    }

    @Test
    @DisplayName("PayTox의 가격과 Counter최종 가격 확인")
    void testPayTox() {

        customer.pickFoods(nhnMart.getFoodStand());

        customer.payTox(counter);

        assertEquals(14_500, counter.getTotalPrice() / 2);
    }

    @Test
    @DisplayName("hasMoney보다 Basket의 상품이 비싼경우 테스트")
    void testPayToxNotEnoughtMoney() {

        buyList.add(new BuyList.Item("계란", 3));
        customer.pickFoods(nhnMart.getFoodStand());

        assertThrows(IllegalArgumentException.class, () -> customer.payTox(counter));
    }
}
