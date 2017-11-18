package org.mycompany.vendingmachinekata;

/**
 * Hello world!
 *
 */
public class Coin
{

    private boolean insertCoin= false;

    public static int getSize(int size) {
        return size;
    }

    public boolean getCoinStatus(){

        return this.insertCoin;
}

    public void insertCoin(){
        this.insertCoin=true;
    }

    public String printStatus(){
        if (this.insertCoin==false){
            return ("No Coin");
        }
        else {
            return ("Coin inserted");
        }
    }

}

