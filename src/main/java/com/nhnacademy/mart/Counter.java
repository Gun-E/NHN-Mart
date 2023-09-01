package com.nhnacademy.mart;

public class Counter {

    // TODO pay 메서드 구현 (카운터에서 계산 처리 메서드)
    public int pay(Basket basket){
        int payPrice=0;
        for(int i=0; i<basket.getFoods().size(); i++){
            payPrice+=basket.getFoods().get(i).getPrice();
        }
        return payPrice;
    }

}
