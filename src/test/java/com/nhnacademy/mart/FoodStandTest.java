package com.nhnacademy.mart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FoodStandTest {
    @Test
    @DisplayName("재고 부족")
    void InsufficientInventory(){
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = new BuyList();
        buyList.add(new BuyList.Item("양파", 3));

        Customer customer = new Customer(buyList);
        customer.bring(new Basket());

        Assertions.assertThrows(IllegalArgumentException.class, () -> customer.pickFoods(mart.getFoodStand()));
    }
}
