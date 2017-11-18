package org.mycompany.vendingmachinekata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTests {
    @Test
    public void GivenUserHasNotEnteredCoinReturnFalse(){
        VendingMachine vendingMachine=new VendingMachine();
        assertEquals(false, vendingMachine.getCoinStatus());
    }

    @Test
    public void GivenUserHasNotEnteredCoinPrintNoCoinEntered(){
        VendingMachine vendingMachine =new VendingMachine();
        assertEquals("No Coin", vendingMachine.printStatus());
    }

    @Test
    public void GivenUserEntersCoinReturnTrue(){
        VendingMachine vendingMachine =new VendingMachine();
        vendingMachine.insertCoin(5);
        assertEquals(true, vendingMachine.getCoinStatus());
    }

    @Test
    public void GivenUserEntersCoinChangeCoinEnteredStatus(){
        VendingMachine vendingMachine =new VendingMachine();
        vendingMachine.insertCoin(3);

        assertEquals("Value Inserted: $0.10", vendingMachine.printStatus());
    }
    @Test
    public void GivenUserEntersPennyThenRejectPenny(){
        VendingMachine vendingMachine =new VendingMachine();
        vendingMachine.insertCoin(2);
        assertEquals(false,vendingMachine.getCoinStatus());


    }
    @Test
    public void GivenUserEntersPennyThenPrintNoCoinInserted(){
        VendingMachine vendingMachine =new VendingMachine();
        vendingMachine.insertCoin(2);
        assertEquals("No Coin",vendingMachine.printStatus());

    }
    @Test
    public void GivenUserEntersNickelThenAcceptNickel(){
        VendingMachine vendingMachine =new VendingMachine();
        vendingMachine.insertCoin(5);
        assertEquals("Value Inserted: $0.05",vendingMachine.printStatus());

    }

}
