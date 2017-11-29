package org.mycompany.vendingmachinekata;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class CoinTest {

    @Test
    public void GivenUserEntersPennyReturnPennyWeight() {
        Coin coin = new Coin();
        int choice = 1;
        assertEquals(2, coin.getSize(choice));
    }

    @Test
    public void GivenUserEntersNickelReturnNickelWeight() {
        Coin coin = new Coin();
        int choice = 2;
        assertEquals(5, coin.getSize(choice));
    }

    @Test
    public void GivenUserEntersDimeReturnDimeWeight() {
        Coin coin = new Coin();
        int choice = 3;
        assertEquals(3, coin.getSize(choice));
    }

    @Test
    public void GivenUserEntersQuarterReturnQuarterWeight() {
        Coin coin = new Coin();
        int choice = 4;
        assertEquals(6, coin.getSize(choice));
    }
    @Test
    public void GivenUserEntersListOfCoinsReturnCoinSizewithAssociatedName(){
        Coin coin=new Coin();
        ArrayList<Integer> coins=new ArrayList<Integer>();
        coins.add(2);
        coins.add(2);
        coins.add(2);
        coins.add(3);
        coins.add(3);
        coins.add(3);
        coins.add(5);
        coins.add(5);
        coins.add(5);
        coins.add(5);
        coins.add(6);
        coins.add(6);
        coins.add(6);
        coins.add(6);
        coins.add(6);
        coins.add(6);
        coins.add(6);
        coins.add(6);
        HashMap<String,Integer> values=new HashMap<String,Integer>();
        values.put("Pennies",3);
        values.put("Nickels",4);
        values.put("Dimes",3);
        values.put("Quarters",8);
        assertEquals(values,coin.getChange(coins));


    }
}
