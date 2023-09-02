package com.nhnacademy.mart;

public class Counter {

    public int pay(Basket basket){
        int payPrice=0;

        for(int i=0; i<basket.getFoods().size(); i++){
            payPrice+=basket.getFoods().get(i).getPrice();
        }

        if(payPrice>20000) {
            MyLogger.getLogger().warning("상품 구매 에러(보유 금액 부족)");
            throw new IllegalArgumentException("돈을 초과하는 상품 구매입니다.");
        }

        MyLogger.getLogger().info("pay()");
        return payPrice;
    }

}
