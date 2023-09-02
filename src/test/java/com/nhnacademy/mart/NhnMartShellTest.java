package com.nhnacademy.mart;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NhnMartShellTest {
    @Test
    @DisplayName("BuyList 생성 확인")
    void validInputToBuyList() {
        String input = "양파 2 계란 2 파 4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        BuyList buyList = NhnMartShell.inputBuyListFromShell();

        Assertions.assertEquals("양파", buyList.getItems().get(0).getName());
        Assertions.assertEquals(2, buyList.getItems().get(0).getAmount());
        Assertions.assertEquals("계란", buyList.getItems().get(1).getName());
        Assertions.assertEquals(2, buyList.getItems().get(1).getAmount());
        Assertions.assertEquals("파", buyList.getItems().get(2).getName());
        Assertions.assertEquals(4, buyList.getItems().get(2).getAmount());
    }
    @Test
    @DisplayName("입력 엔터")
    void InputIsEnter(){
        String input = "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThrows(IllegalArgumentException.class, NhnMartShell::inputBuyListFromShell);

    }
    @Test
    @DisplayName("입력 공백")
    void InputIsNull(){
        String input = " ";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThrows(IllegalArgumentException.class, NhnMartShell::inputBuyListFromShell);

    }
}
