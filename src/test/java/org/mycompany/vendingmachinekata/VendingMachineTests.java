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
        assertEquals("No VendingMachine", vendingMachine.printStatus());
    }

    @Test
    public void GivenUserEntersCoinReturnTrue(){
        VendingMachine vendingMachine =new VendingMachine();
        vendingMachine.insertCoin();
        assertEquals(true, vendingMachine.getCoinStatus());
    }

    @Test
    public void GivenUserEntersCoinChangeCoinEnteredStatus(){
        VendingMachine vendingMachine =new VendingMachine();
        vendingMachine.insertCoin();

        assertEquals("VendingMachine inserted", vendingMachine.printStatus());
    }

}
