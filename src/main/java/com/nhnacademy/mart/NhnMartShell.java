package com.nhnacademy.mart;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("checkstyle:MissingJavadocType")
public class NhnMartShell {

    private static final Logger logger = LoggerFactory.getLogger(NhnMartShell.class);

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();

        // TODO 본인이름 영어로 변수명 작성!
        // 본인이름을 각자 맞게 영어로 변경
        // 홍길동 학생
        // -> hongGilDong or gilDong
        Customer jungHun = new Customer(buyList);

        // 장바구니를 챙긴다.
        jungHun.bring(mart.provideBasket());

        // 식품을 담는다.
        jungHun.pickFoods(mart.getFoodStand());

        // 카운터에서 계산한다.
        jungHun.payTox(mart.getCounter());
    }


    private static BuyList inputBuyListFromShell() {
        // TODO Scanner 입력을 받아 buyList 만들기
        Scanner sc = new Scanner(System.in);
        logger.info("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");

        BuyList buyList = new BuyList();

        String input = sc.nextLine();
        String[] items = input.split(" ");

        for (int i = 0; i < items.length; i += 2) {
            String name = items[i];
            int amount = Integer.parseInt(items[i + 1]);
            buyList.add(new BuyList.Item(name, amount));
        }

        sc.close();
        return buyList;

    }
}
