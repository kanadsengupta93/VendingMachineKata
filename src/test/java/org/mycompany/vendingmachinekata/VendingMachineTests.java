package org.mycompany.vendingmachinekata;

import org.junit.Test;

import java.util.ArrayList;

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
    @Test
    public void GivenUserEntersDimeThenAcceptDime(){
        VendingMachine vendingMachine =new VendingMachine();
        vendingMachine.insertCoin(3);
        assertEquals("Value Inserted: $0.10",vendingMachine.printStatus());

    }
    @Test
    public void GivenUserEntersQuarterThenAcceptQuarter(){
        VendingMachine vendingMachine =new VendingMachine();
        vendingMachine.insertCoin(6);
        assertEquals("Value Inserted: $0.25",vendingMachine.printStatus());

    }
    @Test
    public void GivenUserEnters3Quarters2Dimes1NickelThenPrintDollar(){
        VendingMachine vendingMachine =new VendingMachine();
        vendingMachine.insertCoin(6);
        vendingMachine.insertCoin(6);
        vendingMachine.insertCoin(6);
        vendingMachine.insertCoin(3);
        vendingMachine.insertCoin(3);
        vendingMachine.insertCoin(5);

        assertEquals("Value Inserted: $1.00",vendingMachine.printStatus());

    }
    @Test
    public void GivenUserEnters3PenniesRejectThemAndReturnThem(){
        VendingMachine vendingMachine =new VendingMachine();
        vendingMachine.insertCoin(2);
        vendingMachine.insertCoin(2);
        vendingMachine.insertCoin(2);
        ArrayList<Integer> coins=new ArrayList<Integer>();
        coins.add(2);
        coins.add(2);
        coins.add(2);
        assertEquals(coins,vendingMachine.getCoinReturn());

    }



}
