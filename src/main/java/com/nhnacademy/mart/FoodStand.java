package com.nhnacademy.mart;

import java.util.ArrayList;

public class FoodStand {

    private final ArrayList<Food> foods = new ArrayList<>();

    public void add(Food food) {
        MyLogger.getLogger().info("FoodStand add()");
        foods.add(food);
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    // TODO 장바구니에 담은 Food 삭제 구현
    public void remove(String name) {
        for(int i=0; i< foods.size(); i++){
            if(name.equals(foods.get(i).getName())) {
                foods.remove(i);
                break;
            }

            if (foods.size() -1 == i) {
                MyLogger.getLogger().warning("상품 구매 에러(재고 부족)");
                throw new IllegalArgumentException("재고가 부족합니다.");
            }
        }
        MyLogger.getLogger().info("remove()");
    }
}
