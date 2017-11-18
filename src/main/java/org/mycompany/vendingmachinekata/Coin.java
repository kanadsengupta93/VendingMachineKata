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
       else if(choice==2){
            size=this.nickelSize;
       }
       else if(choice==3){
           size=this.dimeSize;
        }
        return size;
    }

}
