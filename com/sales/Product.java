package com.sales;

public class Product {

    private final String productId;
    private final String productName;
    private final String category;
    private final int quantitySold;
    private final double unitPrice;

    public Product(String productId, String productName, String category, int quantitySold, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.quantitySold = quantitySold;
        this.unitPrice = unitPrice;
    }
    
}
