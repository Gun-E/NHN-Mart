package com.nhnacademy.mart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CounterTest {
    @Test
    @DisplayName("돈을 초과하는 상품 구매")
    void ExceedMoney(){
        Basket basket = new Basket();
        basket.add(new Food("사과", 22000));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Counter().pay(basket));
    }
}
