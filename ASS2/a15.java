package com.ASS2;

import java.io.*; // Import for IOException and FileWriter
import java.util.*; // Import for List and ArrayList

class Product {
    private int productId;
    private String productName;
    private double productPrice;

    public Product(int productId, String productName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getProductPrice() { return productPrice; }

    @Override
    public String toString() {
        return "Product [ID=" + productId + ", Name=" + productName + ", Price=" + productPrice + "]";
    }
}

class Customer {
    private int customerId;
    private String customerName;

    public Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public int getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }

    @Override
    public String toString() {
        return "Customer [ID=" + customerId + ", Name=" + customerName + "]";
    }
}

class Order {
    private int orderId;
    private Customer customer;
    private List<Product> productList = new ArrayList<>();

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public double calculateTotalCost() {
        return productList.stream().mapToDouble(Product::getProductPrice).sum();
    }

    public void saveOrderHistory() throws IOException {
        FileWriter writer = new FileWriter("order_history.txt", true);
        writer.write("Order ID: " + orderId + ", Customer: " + customer.getCustomerName() + "\n");
        for (Product product : productList) {
            writer.write(product + "\n");
        }
        writer.write("Total Cost: " + calculateTotalCost() + "\n\n");
        writer.close();
    }
}

public class a15 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Product product1 = new Product(1, "Laptop", 50000);
            Product product2 = new Product(2, "Smartphone", 20000);
            Customer customer = new Customer(1, "John Doe");
            Order order = new Order(101, customer);

            order.addProduct(product1);
            order.addProduct(product2);

            System.out.println("Total Cost: " + order.calculateTotalCost());
            order.saveOrderHistory();
        } catch (IOException e) {
            System.out.println("Error saving order history: " + e.getMessage());
        }
    }
}
