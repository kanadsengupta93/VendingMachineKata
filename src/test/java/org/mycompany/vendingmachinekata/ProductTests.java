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

}
