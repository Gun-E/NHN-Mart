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

    public static BuyList inputBuyListFromShell() {

        Scanner sc = new Scanner(System.in);
        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");

        BuyList buyList = new BuyList();
        String input = sc.nextLine();
        if (input.isEmpty() || input.equals(" ")) {
            MyLogger.getLogger().warning("입력 오류");
            throw new IllegalArgumentException("입력 오류입니다.");
        }
        MyLogger.getLogger().info("고객이 입력한 구매 리스트 -> " + input);
        String[] part = input.split(" ");


        for (int i = 0; i < part.length; i += 2) {
            BuyList.Item item = new BuyList.Item(part[i], Integer.parseInt(part[i + 1]));

            buyList.add(item);
        }

        MyLogger.getLogger().info("inputBuyListFromShell");
        return buyList;
    }
}
