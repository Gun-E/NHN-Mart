package com.nhnacademy.mart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {
    @Test
    @DisplayName("식품 매대에 없는 상품 구매")
    void MissingProduact(){
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = new BuyList();
        buyList.add(new BuyList.Item("라면", 1));

        Customer customer = new Customer(buyList);
        customer.bring(new Basket());

        Assertions.assertThrows(IllegalArgumentException.class, () -> customer.pickFoods(mart.getFoodStand()));
    }
}
