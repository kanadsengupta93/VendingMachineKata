package org.mycompany.vendingmachinekata;

public class Coin {

private int pennySize=2;
private int nickelSize=5;
private int dimeSize=3;
private int quarterSize=6;

    public int getSize(int choice) {
       int size=0;
        if(choice==1){
           size=this.pennySize;
       }
       if(choice==2){
            size=this.nickelSize;
       }
        return size;
    }

}
