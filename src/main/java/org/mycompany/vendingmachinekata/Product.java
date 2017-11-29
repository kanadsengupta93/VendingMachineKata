package org.mycompany.vendingmachinekata;

import java.util.HashMap;
import java.util.ArrayList;

public class Product {
    private ArrayList<String> products = new ArrayList<String>();
    private HashMap<String, Integer> stock = new HashMap<String, Integer>();
    private HashMap<String, Double> prices = new HashMap<String, Double>();
    private HashMap<String, Boolean> soldOut = new HashMap<String, Boolean>();


    public Product() {
        products.add(0, "Chips");
        products.add(1, "Cola");
        products.add(2, "Candy");
        prices.put("Chips", 50.0);
        prices.put("Cola", 150.0);
        prices.put("Candy", 65.0);
        stock.put("Chips", 5);
        stock.put("Cola", 5);
        stock.put("Candy", 5);
        soldOut.put("Chips", false);
        soldOut.put("Cola", false);
        soldOut.put("Candy", false);
    }

    public double getProductPrice(int i) {
        String product = this.products.get(i - 1);
        return this.prices.get(product);
    }

    public void setStock(int i, int stock) {
        String product = this.products.get(i - 1);
        this.stock.put(product, stock);
    }

    public int getStock(int i) {
        String product = this.products.get(i - 1);
        return this.stock.get(product);
    }

    public void dispense(int i) {
        String product = this.products.get(i - 1);
        int oldStock = this.stock.get(product);
        int newStock = oldStock - 1;
        boolean isSoldout = this.soldOut.get(product);
        if (!isSoldout) {
            if (newStock > 0) {
                this.stock.put(product, newStock);

            } else if (newStock == 0) {
                this.stock.put(product, newStock);
                this.soldOut.put(product, true);
            }
        }
    }

    public void setSoldOut(int i) {
        String product = this.products.get(i - 1);
        this.soldOut.put(product, !this.soldOut.get(product));
        if (this.soldOut.get(product)) {
            this.stock.put(product, 0);
        } else {
            this.stock.put(product, 5);
        }
    }

    public boolean getSoldOut(int i) {
        String product = this.products.get(i - 1);
        return this.soldOut.get(product);

    }

}
