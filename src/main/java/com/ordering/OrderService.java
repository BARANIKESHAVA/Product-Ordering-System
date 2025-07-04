package com.ordering;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

private final List<Product> cart = new ArrayList<>();
private static final int MAX_CART_ITEMS = 4;

public void addToCart(Product product) {
    if (cart.size() >= MAX_CART_ITEMS) {
        System.out.println(" Cart limit reached. You can only add " + MAX_CART_ITEMS + " products.\n");
        return;
    }
    cart.add(product);
    System.out.println(" Product added successfully to cart.\n");
}

public List<Product> getCartItems() {
    return cart;
}

public double checkout() {
    if (cart.isEmpty()) {
        System.out.println(" Cart is empty.\n");
        return 0;
    }

    System.out.println("\n Checkout Summary:");
    for (Product p : cart) {
        System.out.println(p);
    }

    double total = cart.stream().mapToDouble(Product::getPrice).sum();

    System.out.println(" Total Amount: Rs. " + total);
    cart.clear(); 
    System.out.println(" Checkout complete. Cart is now empty.\n");

    return total;
}
}