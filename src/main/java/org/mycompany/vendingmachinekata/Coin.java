package org.mycompany.vendingmachinekata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Coin {

    private int pennySize = 2;
    private int nickelSize = 5;
    private int dimeSize = 3;
    private int quarterSize = 6;
    private HashMap<String, Integer> change = new HashMap<String, Integer>();


    public int getSize(int choice) {
        int size = 0;
        if (choice == 1) {
            size = this.pennySize;
        } else if (choice == 2) {
            size = this.nickelSize;
        } else if (choice == 3) {
            size = this.dimeSize;
        } else {
            size = this.quarterSize;
        }
        return size;
    }

    public HashMap<String, Integer> getChange(ArrayList<Integer> coins) {
        this.change.put("Pennies", Collections.frequency(coins, 2));
        this.change.put("Nickels", Collections.frequency(coins, 5));
        this.change.put("Dimes", Collections.frequency(coins, 3));
        this.change.put("Quarters", Collections.frequency(coins, 6));
        return this.change;
    }

    public void printChange() {
        System.out.println("The machine returned " + this.change.get("Pennies") + " Pennies");
        System.out.println("The machine returned " + this.change.get("Nickels") + " Nickels");
        System.out.println("The machine returned " + this.change.get("Dimes") + " Dimes");
        System.out.println("The machine returned " + this.change.get("Quarters") + " Quarters");


    }

}
