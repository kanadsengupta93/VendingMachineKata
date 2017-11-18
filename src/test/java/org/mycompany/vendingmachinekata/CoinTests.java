package org.mycompany.vendingmachinekata;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CoinTests {

    @Test
    public void GivenUserEntersPennyReturnPennyWeight(){
        Coin coin=new Coin();
        int choice=1;
        assertEquals(2,coin.getSize(choice));
    }
    @Test
    public void GivenUserEntersNickelReturnNickelWeight(){
        Coin coin =new Coin();
        int choice=2;
        assertEquals(5,coin.getSize(choice));
    }
    @Test
    public void GivenUserEntersDimeReturnDimeWeight(){
        Coin coin =new Coin();
        int choice=3;
        assertEquals(3,coin.getSize(choice));
    }
    @Test
    public void GivenUserEntersQuarterReturnQuarterWeight(){
        Coin coin =new Coin();
        int choice=4;
        assertEquals(6,coin.getSize(choice));
    }

}
