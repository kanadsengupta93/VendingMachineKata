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
        assertEquals(chips,10);
        assertEquals(cola,15);
        assertEquals(candy,20);


    }
    @Test
    public void GivenUserSelectsChipsReduceStockBy1(){
    Product stock =new Product();
    stock.dispense(1);
    int chips= stock.getStock(1);
    assertEquals(chips,4);
    }
}
