package org.mycompany.vendingmachinekata;

/**
 * Hello world!
 *
 */
public class Coin
{

    public static boolean insertCoin= false;

    public int getSize(int size) {
        return size;
    }

    public static String getStatus(){
        if (insertCoin==false){
            return ("No Coin");
        }
        else {
            return ("Coin inserted");
        }
    }

}

