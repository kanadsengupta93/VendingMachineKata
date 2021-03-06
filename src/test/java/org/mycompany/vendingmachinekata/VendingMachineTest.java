package org.mycompany.vendingmachinekata;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {
    @Test
    public void GivenUserHasNotEnteredCoinReturnFalse() {
        VendingMachine vendingMachine = new VendingMachine();
        assertEquals(false, vendingMachine.getCoinStatus());
    }

    @Test
    public void GivenUserHasNotEnteredCoinPrintNoCoinEntered() {
        VendingMachine vendingMachine = new VendingMachine();
        assertEquals("No Coin", vendingMachine.printStatus());
    }

    @Test
    public void GivenUserEntersCoinReturnTrue() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(5);
        assertEquals(true, vendingMachine.getCoinStatus());
    }

    @Test
    public void GivenUserEntersCoinChangeCoinEnteredStatus() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(3);

        assertEquals("Value Inserted: $0.10", vendingMachine.printStatus());
    }

    @Test
    public void GivenUserEntersPennyThenRejectPenny() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(2);
        assertEquals(false, vendingMachine.getCoinStatus());


    }

    @Test
    public void GivenUserEntersPennyThenPrintNoCoinInserted() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(2);
        assertEquals("No Coin", vendingMachine.printStatus());

    }

    @Test
    public void GivenUserEntersNickelThenAcceptNickel() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(5);
        assertEquals("Value Inserted: $0.05", vendingMachine.printStatus());

    }

    @Test
    public void GivenUserEntersDimeThenAcceptDime() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(3);
        assertEquals("Value Inserted: $0.10", vendingMachine.printStatus());

    }

    @Test
    public void GivenUserEntersQuarterThenAcceptQuarter() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(6);
        assertEquals("Value Inserted: $0.25", vendingMachine.printStatus());

    }

    @Test
    public void GivenUserEnters3Quarters2Dimes1NickelThenPrintDollar() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(6);
        vendingMachine.insertCoin(6);
        vendingMachine.insertCoin(6);
        vendingMachine.insertCoin(3);
        vendingMachine.insertCoin(3);
        vendingMachine.insertCoin(5);

        assertEquals("Value Inserted: $0.25", vendingMachine.printStatus());

    }

    @Test
    public void GivenUserEnters3PenniesRejectThemAndReturnThem() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(2);
        vendingMachine.insertCoin(2);
        vendingMachine.insertCoin(2);
        ArrayList<Integer> coins = new ArrayList<Integer>();
        coins.add(2);
        coins.add(2);
        coins.add(2);
        assertEquals(coins, vendingMachine.getCoinReturn());

    }

    @Test
    public void GivenUserHasChosenProductReturnTrueAfterEnoughMoneyIsEntered() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setProductPrice(50);
        vendingMachine.insertCoin(6);
        vendingMachine.insertCoin(6);
        assertEquals(true, vendingMachine.checkEnoughMoney());


    }

    @Test
    public void GivenUserHasChosenProductReturnFalseIfEnoughMoneyIsNotEntered() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setProductPrice(50);
        vendingMachine.insertCoin(6);
        vendingMachine.insertCoin(3);
        assertEquals(false, vendingMachine.checkEnoughMoney());


    }

    @Test
    public void GivenUserEnters92CentsFor50CentsReturn1Quarter1Dime1Nickeland2Penny() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setProductPrice(50);
        vendingMachine.insertCoin(6);
        vendingMachine.insertCoin(6);
        vendingMachine.insertCoin(6);
        vendingMachine.insertCoin(3);
        vendingMachine.insertCoin(5);
        vendingMachine.insertCoin(2);
        vendingMachine.insertCoin(2);
        ArrayList<Integer> coins = vendingMachine.calculateCoins();
        ArrayList<Integer> expectedCoins = new ArrayList<Integer>();
        expectedCoins.add(0, 2);
        expectedCoins.add(1, 2);
        expectedCoins.add(2, 3);
        expectedCoins.add(3, 5);
        expectedCoins.add(4, 6);
        assertEquals(expectedCoins, coins);
    }

    @Test
    public void GivenMachineExactChangeIsOffReturnExactChangeToBeFalse() {
        VendingMachine vendingMachine = new VendingMachine();
        assertEquals(false, vendingMachine.getExactChangeStatus());
    }

    @Test
    public void GivenMachineExactChangeISOnReturnExactChangeToBeTrue() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setExactChangeStatus();
        assertEquals(true, vendingMachine.getExactChangeStatus());
    }

    @Test
    public void GivenMachineExactChangeISOnReturnExactChangeToBeFalse() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setExactChangeStatus();
        vendingMachine.setExactChangeStatus();
        assertEquals(false, vendingMachine.getExactChangeStatus());
    }

    @Test
    public void GivenExactChangeIsOnDontDispenseProductUnlessExactChangeisGiven() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setExactChangeStatus();
        vendingMachine.setProductPrice(65);
        vendingMachine.insertCoin(6);
        vendingMachine.insertCoin(6);
        vendingMachine.insertCoin(6);
        assertEquals("Your product has not been dispensed", vendingMachine.dispenseProduct());

    }

    @Test
    public void GivenExactChangeIsOnReturnExtraCoins() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setExactChangeStatus();
        vendingMachine.setProductPrice(65);
        vendingMachine.insertCoin(6);
        vendingMachine.insertCoin(6);
        vendingMachine.insertCoin(6);
        ArrayList<Integer> coins = vendingMachine.getCoinReturn();
        ArrayList<Integer> expectedCoins = new ArrayList<Integer>();
        expectedCoins.add(0, 6);
        assertEquals(expectedCoins, coins);

    }


}
