package org.mycompany.vendingmachinekata;

import java.text.NumberFormat;
import java.util.*;

public class Application {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        VendingMachine vm = new VendingMachine();
        Product product = new Product();
        String quit = getQuitStatus(input);

        while (quit != "q") {
            Coin coin = new Coin();
            userChangeStatusPrompt(vm, input);
            userProductPrompt(vm, input, product);
            userCoinPrompt(vm, input, coin);
        }
    }

    public static String getQuitStatus(Scanner input) {
        System.out.println("Press q to quit anything else to continue");
        String s = input.nextLine();
        s.toLowerCase();
        s.replaceAll("\\s+", "");
        return s;
    }

    public static void userChangeStatusPrompt(VendingMachine vm, Scanner input) {


        System.out.println("Exact Change Mode is " + vm.printExactChangeStatus() + " Hit 1 if you want to change Exact Change mode Hit 2 to not change it");
        if (input.nextInt() == 1) {

            vm.setExactChangeStatus();
        }
        System.out.println("Exact Change Mode is " + vm.printExactChangeStatus());

    }

    public static int getIntforProductPrompt(Scanner input) {
        System.out.println("Hit 1 to select Chips, 2 to select cola, 3 to select Candy");

        int in = input.nextInt();

        while (in > 3 || in < 0) {
            System.out.println("Hit 1 to select Chips, 2 to select cola, 3 to select Candy");
            in = input.nextInt();
        }
        return in;
    }

    public static void userProductPrompt(VendingMachine vm, Scanner input, Product product) {
        System.out.println(vm.printStatus());
        int in = getIntforProductPrompt(input);

        while (product.getSoldOut(in)) {
            System.out.println("SOLD OUT");
            {

            }
            System.out.println("Hit 1 to select Chips, 2 to select cola, 3 to select Candy");
            in = getIntforProductPrompt(input);
        }
        double price = product.getProductPrice(in);
        double printprice = price / 100;

        vm.setProductPrice(price);

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("The price of the product is " + formatter.format(printprice));
        System.out.println("The amount left is " + product.getStock(in));
        product.dispense(in);
        System.out.println(vm.printStatus());

    }

    public static void userCoinPrompt(VendingMachine vm, Scanner input, Coin coin) {
        System.out.println("Press 1 to Select Penny, 2 to select Nickel, 3 to select Dime, 4 to select Quarter");
        int in = input.nextInt();
        boolean enoughMoney = false;
        int size = coin.getSize(in);
        vm.insertCoin(size);
        while (!enoughMoney) {
            System.out.println("Press 1 to Select Penny, 2 to select Nickel, 3 to select Dime, 4 to select Quarter");
            in = input.nextInt();

            size = coin.getSize(in);
            vm.insertCoin(size);
            vm.calculateCoins();
            enoughMoney = vm.getenoughMoney();

        }

        coin.getChange(vm.getCoinReturn());
        coin.printChange();

        System.out.println(vm.dispenseProduct());
    }


}
