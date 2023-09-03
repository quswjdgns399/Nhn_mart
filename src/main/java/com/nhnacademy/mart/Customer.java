package com.nhnacademy.mart;

@SuppressWarnings("checkstyle:MissingJavadocType")
public class Customer {

    // 고객 구매 목록
    private final BuyList buyList;

    // 고객 장바구니
    private Basket basket;

    public Basket getBasket() {
        return basket;
    }

    private int hasMoney = 20_000;


    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }



    // 장바구니 챙기기
    public void bring(Basket basket) {

        this.basket = basket;
    }


    // TODO pickFoods 메서드 구현
    // pickFoods 초기 구현
    /*
    public void pickFoods(FoodStand foodStand) {
        for (BuyList.Item buylist : buyList.getItems()) {
            for (int i = 0; i < foodStand.getFoods().size(); i++) {
                if (foodStand.getFoods().get(i).getName().equals(buylist.getName())) {
                    basket.add(foodStand.getFoods().get(i));
                    break;
                } else {
                    throw new IllegalArgumentException("식품 매대에 없는 상품입니다.");
                }
            }
        }
    }
    */

    //가장 잘 나온 pickFoods

    //기능구현은 했지만 3중 for문은 좀...
    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    public void pickFoods(FoodStand foodStand) {

        for (BuyList.Item buylist : buyList.getItems()) {
            boolean find = false;
            for (Food foodStand1 : foodStand.getFoods()) {
                if (foodStand1.getName().equals(buylist.getName())) {
                    basket.add(foodStand1);
                    find = true;
                    for (int i = 0; i < buylist.getAmount(); i++) {
                        foodStand.deleteFoods(foodStand1.getName());
                    }
                    break;
                }
            }
            if (!find) {
                throw new IllegalArgumentException("매대에 없는 식품 입니다.");
            }
        }
    }

    // TODO payTox 메서드 구현
    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    public void payTox(Counter counter) {

        //buyList의 amount를 가져와야 함.
        //foodstand 값과 item 값이 같을 때, foodstand의 item price를 가져와야 함.
        // item값이 같아야 하는 조건은 pickFoods에서 만족하기 때문에 price값만 가져오면 됨.
        // basket에 저장되어 있음

        // 장바구니에 있는 물건들의 가격 합계 계산

        /*

//        for(BuyList.Item buyListitem : buyList.getItems()){
//            for(int i=0; i<buyList.getItems().size(); i++){
//                int price = basket.getFoods().get(i).getPrice();
//                int amount = buyListitem.getAmount();
//                counter.receive_price(price * amount);
//            }
//        }
s
         */

        /*

//        for (BuyList.Item buyListitem : buyList.getItems()) {
//            int price = 0;
//
//            for(int i=0; i<buyList.getItems().size(); i++){
//                price = basket.getFoods().get(i).getPrice();
//            }
//            counter.receive_price(price * buyListitem.getAmount());
//        }
         */

        // 살아남은 코드
        for (int i = 0; i < buyList.getItems().size(); i++) {
            counter.receivePrice(basket.getFoods().get(i).getPrice() * buyList.getItems().get(i).getAmount());
        }

        /*
//
//        for(BuyList.Item buyListitem : buyList.getItems()){
//            for(Food basket1 : basket.getFoods()){
//
//            }
//            counter.receive_price( * buyListitem.getAmount());
//        }

         */

        //무수한 시도와 실패 ㅠㅠ

        final int total_price = counter.getTotalPrice();

        // 가격을 확인하고 충분한 돈이 있는지 확인
        if (total_price <= hasMoney) {
            // 충분한 돈이 있을 경우 지불하고 hasMoney 갱신
            counter.receivePrice(total_price);
            hasMoney -= total_price;
            MyLogger.getLogger().info("총 가격은 " + total_price + "입니다.");
            MyLogger.getLogger().info("고객님 결제 후 잔액 : " + hasMoney);
        } else {
            MyLogger.getLogger().warning("돈이 부족합니다. 구매할 수 없습니다.");
            throw new IllegalArgumentException("total price > hasMoney");
        }


    }


}
