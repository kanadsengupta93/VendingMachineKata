package org.mycompany.vendingmachinekata;

import junit.framework.TestCase;
import org.junit.Test;
import org.mycompany.vendingmachinekata.Coin;
import org.junit.Test;
import  org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

public class CoinTests {
    @Test
    public void GivenUserHasNotEnteredCoinReturnFalse(){
        Coin coins=new Coin();
        assertEquals(false, coins.getCoinStatus());
    }
    @Test
    public void GivenUserEntersCoinSizeReturnCoinSize(){
        Coin coin=new Coin();
        assertEquals(5,coin.getSize(5));

    }
    @Test
    public void GivenUserHasNotEnteredCoinPrintNoCoinEntered(){
        Coin coin=new Coin();
        assertEquals("No Coin",coin.printStatus());
    }

    @Test
    public void GivenUserEntersCoinReturnTrue(){
        Coin coin=new Coin();
        coin.insertCoin();
        assertEquals(true,coin.getCoinStatus());
    }

    @Test
    public void GivenUserEntersCoinChangeCoinEnteredStatus(){
        Coin coin=new Coin();
        coin.insertCoin();

        assertEquals("Coin inserted",coin.printStatus());
    }

}
