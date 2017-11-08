package org.mycompany.vendingmachinekata;

import junit.framework.TestCase;
import org.junit.Test;
import org.mycompany.vendingmachinekata.Coin;
import org.junit.Test;
import  org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

public class CoinTests {

    @Test
    public void GivenUserEntersCoinSizeReturnCoinSize(){
        Coin coin=new Coin();
        assertEquals(5,coin.getSize(5));

    }
}
