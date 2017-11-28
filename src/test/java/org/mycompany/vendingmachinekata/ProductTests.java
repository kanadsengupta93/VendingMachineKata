package org.mycompany.vendingmachinekata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTests {
    @Test
    public void GivenUserChoosesChipsReturnChipsPrice() {
        Product chips = new Product();
        double price = chips.getProductPrice(1);
        double toCompare = 50.0;
        assertEquals(toCompare, price, 0);
    }

    @Test
    public void GivenUserChoosesColaReturnColaPrice() {
        Product cola = new Product();
        double price = cola.getProductPrice(2);
        double toCompare = 150.0;
        assertEquals(toCompare, price, 0);
    }

    @Test
    public void GivenUserChoosesCandyReturnCandyPrice() {
        Product candy = new Product();
        double price = candy.getProductPrice(3);
        double toCompare = 65.0;
        assertEquals(toCompare, price, 0);
    }

    @Test
    public void GivenUserSetsStockReturnCorrectStock() {
        Product stock = new Product();
        stock.setStock(1, 10);
        stock.setStock(2, 15);
        stock.setStock(3, 20);
        int chips = stock.getStock(1);
        int cola = stock.getStock(2);
        int candy = stock.getStock(3);
        assertEquals(10, chips);
        assertEquals(15, cola);
        assertEquals(20, candy);


    }

    @Test
    public void GivenUserSelectsChipsReduceStockBy1() {
        Product stock = new Product();
        stock.dispense(1);
        int chips = stock.getStock(1);
        assertEquals(4, chips);
    }

    @Test
    public void GivenUserSelectsColaThreeTimesreduceStockBy3() {
        Product stock = new Product();
        stock.setStock(2, 15);
        stock.dispense(2);
        stock.dispense(2);
        stock.dispense(2);
        int cola = stock.getStock(2);
        assertEquals(12, cola);
    }

    @Test
    public void GivenUserSelectsCandyTenTimesreduceStockBy10() {
        Product stock = new Product();
        stock.setStock(3, 20);
        stock.dispense(3);
        stock.dispense(3);
        stock.dispense(3);
        stock.dispense(3);
        stock.dispense(3);
        stock.dispense(3);
        stock.dispense(3);
        stock.dispense(3);
        stock.dispense(3);
        stock.dispense(3);

        int candy = stock.getStock(3);
        assertEquals(10, candy);
    }

    @Test
    public void GivenUserselectschipsSoldOutReturnitsStatus() {
        Product stock = new Product();
        stock.setSoldOut(1);
        assertEquals(true, stock.getSoldOut(1));

    }

    @Test
    public void GivenUserselectschipsSoldOutReturnitsStocktobeZero() {
        Product stock = new Product();
        stock.setSoldOut(1);
        assertEquals(0, stock.getStock(1));

    }

    @Test
    public void GivenUserselectschipsSoldOutandunselectsSoldoutReturnitsStocktobedefault() {
        Product stock = new Product();
        int original = stock.getStock(1);
        stock.setSoldOut(1);
        stock.setSoldOut(1);
        int updated = stock.getStock(1);
        assertEquals(original, updated);

    }

    @Test
    public void GivenUserselectscolaSoldOutReturnitsStocktobeZero() {
        Product stock = new Product();
        stock.setSoldOut(2);
        assertEquals(0, stock.getStock(2));

    }

    @Test
    public void GivenUserselectscolaSoldOutandunselectsSoldoutReturnitsStocktobedefault() {
        Product stock = new Product();
        int original = stock.getStock(2);
        stock.setSoldOut(1);
        stock.setSoldOut(1);
        int updated = stock.getStock(2);
        assertEquals(original, updated);

    }

    @Test
    public void GivenUserselectscandySoldOutReturnitsStocktobeZero() {
        Product stock = new Product();
        stock.setSoldOut(3);
        assertEquals(0, stock.getStock(3));

    }

    @Test
    public void GivenUserselectscandySoldOutandunselectsSoldoutReturnitsStocktobedefault() {
        Product stock = new Product();
        int original = stock.getStock(3);
        stock.setSoldOut(1);
        stock.setSoldOut(1);
        int updated = stock.getStock(3);
        assertEquals(original, updated);

    }

    @Test
    public void GivenUserselectschipsandithas1ThenCheckifitsSoldout() {
        Product stock = new Product();
        stock.setStock(1, 1);
        stock.dispense(1);
        boolean soldout = stock.getSoldOut(1);
        assertEquals(true, soldout);

    }

    @Test
    public void GivenUserselectscandy5timesprinteachstatusproperlyandcheckvalueateachdispense() {
        Product stock = new Product();
        stock.dispense(2);
        int amount=stock.getStock(2);
        boolean soldout = stock.getSoldOut(2);
        assertEquals(false, soldout);
        assertEquals(4,amount);
        stock.dispense(2);
        amount=stock.getStock(2);
        soldout = stock.getSoldOut(2);
        assertEquals(false, soldout);
        assertEquals(3, amount);
        stock.dispense(2);
        amount=stock.getStock(2);
        soldout = stock.getSoldOut(2);
        assertEquals(false, soldout);
        assertEquals(2, amount);
        stock.dispense(2);
        amount=stock.getStock(2);
        soldout = stock.getSoldOut(2);
        assertEquals(false, soldout);
        assertEquals(1, amount);
        stock.dispense(2);
        amount=stock.getStock(2);
        soldout = stock.getSoldOut(2);
        assertEquals(true, soldout);
        assertEquals(0, amount);
        stock.dispense(2);
        amount=stock.getStock(2);
        soldout = stock.getSoldOut(2);
        assertEquals(true, soldout);
        assertEquals(0, amount);
    }
}