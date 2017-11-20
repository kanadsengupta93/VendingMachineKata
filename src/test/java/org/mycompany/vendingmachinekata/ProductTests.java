package org.mycompany.vendingmachinekata;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProductTests {
   @Test
    public void GivenUserChoosesChipsReturnChipsPrice(){
       Product chips =new Product();
       double price=chips.getProductPrice(1);
       double toCompare=.5;
       assertEquals(toCompare,price,0);
   }

}
