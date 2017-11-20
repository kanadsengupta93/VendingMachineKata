package org.mycompany.vendingmachinekata;

import java.util.ArrayList;
import java.util.Collections;

public class VendingMachine
{

    private boolean insertCoin= false;
    private boolean enoughMoney=false;
    private int coinValues[]={5,10,25};
    private int value=0;
    private double productPrice=0;
    private ArrayList<Integer> returnCoins= new ArrayList<Integer>();

    public boolean getCoinStatus(){
        return this.insertCoin;
    }
    public boolean checkEnoughMoney(){
        if(this.value>=this.productPrice){
            this.enoughMoney=true;
        }
        return this.enoughMoney;
}
    public void insertCoin(int size){
        if(size!=2){
        this.insertCoin=true;
       if(size==5){

           this.value+=coinValues[0];
       }
        else if(size==3){
            this.value+=coinValues[1];
       }
        else {
            this.value+=coinValues[2];
       }

        }
        else{
            returnCoins.add(size);
        }

    }


    public String printStatus(){
        if (this.insertCoin==false){
            return ("No Coin");
        }
        else {
           double dollarValue= (double) this.value/100;
            String result = String.format("%.2f", dollarValue);
            return ("Value Inserted: $"+result);

        }
    }

    public ArrayList<Integer> getCoinReturn() {
        return this.returnCoins;
    }

    public void setProductPrice(double v) {
    this.productPrice=v;
    }

    public ArrayList<Integer> calculateCoins() {
        int difference=(int)(this.value-this.productPrice);

        int numberofQuarters= difference/25;
        difference%=25;
        int numberofDimes= difference/10;
        difference%=10;

        int numberofNickels= difference/5;
        difference%=5;


        int i=0;
        while(i<numberofQuarters){
            this.returnCoins.add(6);
            i++;
        }
        i=0;
        while(i<numberofDimes){
           this.returnCoins.add(3);
            i++;
        }
        i=0;
        while(i<numberofNickels){
            this.returnCoins.add(5);
            i++;
        }


        Collections.sort(returnCoins);
    return this.returnCoins;

    }

    public double getProductPrice(){
        return this.productPrice;
    }
    public void dispenseProduct(){
        if(this.enoughMoney){
            System.out.println("Your product has been dispensed");
            this.productPrice=0;
            this.insertCoin=false;
            calculateCoins();
        }
    }
}

