package com.nhnacademy.mart;

import java.util.Scanner;

public class NhnMartShell {

    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();

        Customer geon = new Customer(buyList);

        // 장바구니를 챙긴다.
        geon.bring(mart.provideBasket());

        // 식품을 담는다.
        geon.pickFoods(mart.getFoodStand());

        // 카운터에서 계산한다.
        geon.payTox(mart.getCounter());
    }

    private static BuyList inputBuyListFromShell() {

        Scanner sc = new Scanner(System.in);
        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");



        BuyList buyList = new BuyList();

        String input = sc.nextLine();
        String [] part = input.split(" ");


        for(int i=0; i<part.length; i+=2){
            if (!part[i].equals("양파") && !part[i].equals("계란") && !part[i].equals("파") && !part[i].equals("사과")) {
                throw new IllegalArgumentException("식품 매대에 없는 상품 구매입니다.");
            }
            
            BuyList.Item item = new BuyList.Item(part[i],Integer.parseInt(part[i+1]));

            buyList.add(item);
        }

        return buyList;
    }
}
