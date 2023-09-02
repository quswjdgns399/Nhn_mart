package com.nhnacademy.mart;

import java.util.ArrayList;

public class BuyList {



    private final ArrayList<Item> items = new ArrayList<>();


    // TODO add 메서드 생성
    public void add(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }


    public static class Item {
        private final String name;
        private final int amount;


        public Item(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }

        public String getName() {
            return name;
        }
    }
}
