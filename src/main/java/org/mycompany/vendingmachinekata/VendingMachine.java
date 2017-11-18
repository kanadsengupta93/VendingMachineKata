package org.mycompany.vendingmachinekata;

/**
 * Hello world!
 *
 */
public class VendingMachine
{

    private boolean insertCoin= false;


    public boolean getCoinStatus(){

        return this.insertCoin;
}

    public void insertCoin(){
        this.insertCoin=true;
    }

    public String printStatus(){
        if (this.insertCoin==false){
            return ("No VendingMachine");
        }
        else {
            return ("VendingMachine inserted");
        }
    }

}

