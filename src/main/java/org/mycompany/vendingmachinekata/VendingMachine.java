package org.mycompany.vendingmachinekata;

import java.util.ArrayList;
import java.util.Collections;

public class VendingMachine {

    private boolean insertCoin = false;
    private boolean enoughMoney = false;
    private boolean exactChange = false;
    private int coinValues[] = {5, 10, 25};
    private int value = 0;
    private int oldvalue = 0;
    private double productPrice = 0;
    private ArrayList<Integer> coinList = new ArrayList<Integer>();
    private ArrayList<Integer> returnCoins = new ArrayList<Integer>();

    public boolean getCoinStatus() {
        return this.insertCoin;
    }

    public boolean checkEnoughMoney() {
        if (this.exactChange == false) {
            if (this.value >= this.productPrice) {
                this.enoughMoney = true;
            }
        } else {

            if (this.value == this.productPrice) {
                this.enoughMoney = true;
            } else if (this.value > this.productPrice) {

                this.enoughMoney = false;
                int length = this.coinList.size();
                int coin = this.coinList.remove(length - 1);
                printStatus();
                this.value = this.oldvalue;
                this.returnCoins.add(coin);

            }
        }
        return this.enoughMoney;
    }


    public void insertCoin(int size) {

        if (this.enoughMoney == false) {
            if (size != 2) {
                this.insertCoin = true;
                this.oldvalue = this.value;

                if (size == 5) {
                    this.value += coinValues[0];
                } else if (size == 3) {
                    this.value += coinValues[1];
                } else {
                    this.value += coinValues[2];
                }
                coinList.add(size);
            } else {
                returnCoins.add(size);
            }
        } else {
            returnCoins.add(size);
        }
        checkEnoughMoney();
        System.out.println(printStatus());

    }


    public String printStatus() {
        if (this.insertCoin == false) {
            return ("No Coin");
        } else {
            double dollarValue = (double) this.value / 100;
            String result = String.format("%.2f", dollarValue);
            return ("Value Inserted: $" + result);

        }
    }

    public ArrayList<Integer> getCoinReturn() {
        return this.returnCoins;
    }

    public void setProductPrice(double v) {
        this.productPrice = v;
    }


    public ArrayList<Integer> calculateCoins() {
        int difference = (int) (this.value - this.productPrice);

        int numberofQuarters = difference / 25;
        difference %= 25;
        int numberofDimes = difference / 10;
        difference %= 10;

        int numberofNickels = difference / 5;


        int i = 0;
        while (i < numberofQuarters) {
            this.returnCoins.add(6);
            i++;
        }
        i = 0;
        while (i < numberofDimes) {
            this.returnCoins.add(3);
            i++;
        }
        i = 0;
        while (i < numberofNickels) {
            this.returnCoins.add(5);
            i++;
        }


        Collections.sort(returnCoins);
        return this.returnCoins;

    }

    public double getProductPrice() {
        return this.productPrice;
    }

    public String dispenseProduct() {
        String dispensed = "Your product has not been dispensed";
        if (this.enoughMoney) {
            dispensed = "Your product has been dispensed";
            this.productPrice = 0;
            this.insertCoin = false;
            calculateCoins();
        }
        return dispensed;
    }

    public boolean getExactChangeStatus() {
        return this.exactChange;
    }

    public void setExactChangeStatus() {

        this.exactChange = !this.exactChange;


    }

}