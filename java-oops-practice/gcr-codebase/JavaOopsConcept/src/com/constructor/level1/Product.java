/*
 * Program Name : Product
 * Description  : Demonstrates instance vs class variables and methods.
 */

package com.constructor.level1;

class Product {
    String productName;
    double price;
    static int totalProducts = 0;

    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    void displayProductDetails() {
        System.out.println("Product Name : " + productName);
        System.out.println("Price        : " + price);
    }

    static void displayTotalProducts() {
        System.out.println("Total Products : " + totalProducts);
    }
}
