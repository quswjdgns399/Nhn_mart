package com.nhnacademy.mart;

@SuppressWarnings("checkstyle:MissingJavadocType")
public class Food {


    private final String name;
    private final int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
