package com.ordering;

import java.util.*;

public class App {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    OrderService service = new OrderService();


    List<Product> productList = new ArrayList<>();
    productList.add(new Product(1, "Teddy Bear", 350));
    productList.add(new Product(2, "Toy Car", 150));
    productList.add(new Product(3, "Doll", 220));
    productList.add(new Product(4, "Building Blocks", 500));
    productList.add(new Product(5, "Action Figure", 275));
    productList.add(new Product(6, "Lego Set", 850));
    productList.add(new Product(7, "Puzzle Cube", 120));
    productList.add(new Product(8, "Remote Helicopter", 1250));
    productList.add(new Product(9, "Racing Track", 600));
    productList.add(new Product(10, "Doctor Set", 330));

    while (true) {
        System.out.println("===== TOY STORE MENU =====");
        System.out.println("1. View Product List");
        System.out.println("2. Add Product to Cart");
        System.out.println("3. View Cart");
        System.out.println("4. Checkout");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                System.out.println("\n Available Products:");
                for (Product p : productList) {
                    System.out.println(p);
                }
                break;
            }

            case 2: {
                System.out.print("Enter Product ID to add to cart: ");
                int id = scanner.nextInt();
                Product selected = null;

                for (Product p : productList) {
                    if (p.getId() == id) {
                        selected = p;
                        break;
                    }
                }

                if (selected != null) {
                    service.addToCart(selected);
                } else {
                    System.out.println(" Product with ID " + id + " not found.\n");
                }
                break;
            }

            case 3: {
                List<Product> cart = service.getCartItems();
                System.out.println("\n-- CART ITEMS --");
                if (cart.isEmpty()) {
                    System.out.println("(Cart is empty)\n");
                } else {
                    for (Product p : cart) {
                        System.out.println(p);
                    }
                }
                break;
            }

            case 4: {
                double total = service.checkout();
                if (total > 0) {
                    System.out.println(" Please pay Rs. " + total + "\n");
                }
                break;
            }

            case 5: {
                System.out.println(" Thank you for shopping with us!");
                scanner.close();
                return;
            }

            default:
                System.out.println(" Invalid choice. Try again.\n");
        }
    }
}
}