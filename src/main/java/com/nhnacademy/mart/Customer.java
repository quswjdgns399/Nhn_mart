package com.nhnacademy.mart;

public class Customer {

    // 고객 구매 목록
    private final BuyList buyList;

    // 고객 장바구니
    private Basket basket;

    public Basket getBasket() {
        return basket;
    }

    private final int hasMoney = 20_000;


    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }



    // 장바구니 챙기기
    public void bring(Basket basket) {

        this.basket = basket;
    }

    // TODO pickFoods 메서드 구현
    public void pickFoods(FoodStand foodStand) {
        for(BuyList.Item buylist : buyList.getItems()){
            for(int i=0; i<foodStand.getFoods().size(); i++){
                if (foodStand.getFoods().get(i).getName().equals(buylist.getName())) {
                    basket.add(foodStand.getFoods().get(i));
                    break;
                }
            }
        }
    }

    // TODO payTox 메서드 구현
    public void payTox(Counter counter) {
        new Counter();
    }


}
