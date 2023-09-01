package com.nhnacademy.mart;

public class Customer {

    // 고객 구매 목록
    private final BuyList buyList;

    // 고객 장바구니
    private Basket basket;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }

    // TODO pickFoods 메서드 구현
    public void pickFoods(FoodStand foodStand) {
        for (int i = 0; i < buyList.getItems().size(); i++){
            int price=1;
            for(int j = 0; j < foodStand.getFoods().size(); j++){
                if(foodStand.getFoods().get(j).getName().equals(buyList.getItems().get(i).getName())) {
                    price=foodStand.getFoods().get(j).getPrice() * buyList.getItems().get(i).getAmount();
                    for(int k=0; k<buyList.getItems().get(i).getAmount(); k++){
                        foodStand.remove(buyList.getItems().get(i).getName());
                    }
                    break;
                }
            }
            basket.add(new Food(buyList.getItems().get(i).getName(), price));
        }
    }


    // TODO payTox 메서드 구현
    public void payTox(Counter counter) {
        if(counter.pay(basket)>20000) throw new IllegalArgumentException("돈을 초과하는 상품 구매입니다.");
        System.out.println("종 가격은 "+ counter.pay(basket)+ "원 입니다.");
        System.out.println("고객님 결제 후 잔액 : "+ (20000-counter.pay(basket)));
    }


}
