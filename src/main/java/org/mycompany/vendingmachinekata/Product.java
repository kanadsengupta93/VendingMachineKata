package org.mycompany.vendingmachinekata;

import java.util.HashMap;
import java.util.ArrayList;
public class Product {
    private ArrayList<String> products=new ArrayList<String>();

    private HashMap<String,Double> prices=new HashMap<String, Double>();
public Product(){
    products.add(0,"Chips");
    products.add(1,"Cola");
    products.add(2,"Candy");
    prices.put("Chips",50.0);
    prices.put("Cola",150.0);
    prices.put("Candy",65.0);
}
    public double getProductPrice(int i) {
        String product=this.products.get(i-1);
        return this.prices.get(product);
    }
}
