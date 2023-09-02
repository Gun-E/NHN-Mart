package com.nhnacademy.mart;

public class NhnMart {

    private final FoodStand foodStand = new FoodStand();
    private final Counter counter= new Counter();

    public FoodStand getFoodStand() {
        return foodStand;
    }
    public Counter getCounter() {
        return counter;
    }

    public void prepareMart() {
        fillFoodStand();
        MyLogger.getLogger().info("prepareMart()");
    }

    // 음식 세팅
    private void fillFoodStand() {
        for (int i = 0; i < 2; i++) {
            foodStand.add(new Food("양파", 1_000));
        }
        for (int i = 0; i < 5; i++) {
            foodStand.add(new Food("계란", 5_000));
        }
        for (int i = 0; i < 10; i++) {
            foodStand.add(new Food("파", 500));
        }
        for (int i = 0; i < 20; i++) {
            foodStand.add(new Food("사과", 2_000));
        }
        MyLogger.getLogger().info("fillFoodStand()");
    }

    public Basket provideBasket() {
        MyLogger.getLogger().info("provideBasket()");
        return new Basket();
    }
}
