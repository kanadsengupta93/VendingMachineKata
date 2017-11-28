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
    public void GivenUserSetsStockReturnCorrectStock(){
        Product stock =new Product();
        stock.setStock(1,10);
        stock.setStock(2,15);
        stock.setStock(3,20);
        int chips=stock.getStock(1);
        int cola=stock.getStock(2);
        int candy=stock.getStock(3);
        assertEquals(10,chips);
        assertEquals(15,cola);
        assertEquals(20,candy);


    }
    @Test
    public void GivenUserSelectsChipsReduceStockBy1(){
    Product stock =new Product();
    stock.dispense(1);
    int chips= stock.getStock(1);
    assertEquals(4,chips);
    }

    @Test
    public void GivenUserSelectsColaThreeTimesreduceStockBy3(){
        Product stock =new Product();
        stock.setStock(2,15);
        stock.dispense(2);
        stock.dispense(2);
        stock.dispense(2);
        int cola=stock.getStock(2);
        assertEquals(12,cola);
    }
    @Test
    public void GivenUserSelectsCandyTenTimesreduceStockBy10(){
        Product stock =new Product();
        stock.setStock(3,20);
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

        int candy=stock.getStock(3);
        assertEquals(10,candy);
    }
}
