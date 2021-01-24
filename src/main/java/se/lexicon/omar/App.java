package se.lexicon.omar;


import se.lexicon.omar.model.Conditional;
import se.lexicon.omar.model.Product;
import se.lexicon.omar.model.Action;

import java.util.Arrays;
import java.util.List;

public class App {

    public static List<Product> products = Arrays.asList(
            new Product("BOB", 15, 0),
            new Product("Beer", 25, 0),
            new Product("Pepsi", 6, 2),
            new Product("Coca-Cola Packet", 125, 35),
            new Product("Chocolate", 18, 9)
    );

    public static void productsTest(List<Product> products, Conditional conditional, Action action) {
        for (Product p : products) {
            if (conditional.test(p)) {
                action.execute(p);
            }
        }
    }

    public static void main(String[] args) {

        //Print out all Products that have stock value of 0.
        System.out.println("All Products that have stock value of 0");
        Conditional productStockValueZeroIsTrue = p -> p.getStock() == 0;
        Action productStockValueZero = p -> System.out.println(p.toString());
        productsTest(products, productStockValueZeroIsTrue, productStockValueZero);

        // Print out the productName of all the Products that starts with B.
        System.out.println("=========\nAll the Products that starts with B");
        Conditional productNameStartWithBIsTrue = p -> p.getProductName().startsWith("B");
        Action productNameStartWithB = p -> System.out.println(p.getProductName());
        productsTest(products, productNameStartWithBIsTrue, productNameStartWithB);

        //Print out all Products that have price above 100 AND lower than 150.
        System.out.println("=========\nAll Products that have price above 100 AND lower than 150.");
        Conditional productThatHaveSpecialPrisIsTrue = p -> p.getPrice() > 100 && p.getPrice() < 150;
        Action productThatHaveSpecialPris = p -> System.out.println(p.toString());
        productsTest(products, productThatHaveSpecialPrisIsTrue, productThatHaveSpecialPris);

        // Increase the price of all Products that have a stock value of less than 10 AND above 0 by 50%.
        System.out.println("=========\n" +
                "Increase the price of all Products that have a stock value < 10 AND > 0 by 50%.");
        System.out.println("Print the products before increasing the price");
        for (Product p : products) {
            System.out.println(p.toString());
        }
        Conditional productThatHaveSpecialStockIsTrue = p -> p.getStock() < 10 && p.getStock() > 0;
        Action productThatHaveSpecialStock = p -> p.setPrice(p.getPrice() + p.getPrice() * 0.5);
        productsTest(products, productThatHaveSpecialStockIsTrue, productThatHaveSpecialStock);

        System.out.println("Print the products after increasing the price");
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }
}
