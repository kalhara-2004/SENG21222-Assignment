package com.sales;

import java.util.List;
import java.util.Map;

public class SalesSummary {
    
    private final List<Product> products;
    private final Map<String, Double> categoryRevenues;
    private final Product bestSellingProduct;
    private final Product highestRevenueProduct;
    private final double grandTotalRevenue;

    public SalesSummary(List<Product> products, Map<String, Double> categoryRevenues,
                        Product bestSellingProduct, Product highestRevenueProduct, double grandTotalRevenue) {
        this.products = products;
        this.categoryRevenues = categoryRevenues;
        this.bestSellingProduct = bestSellingProduct;
        this.highestRevenueProduct = highestRevenueProduct;
        this.grandTotalRevenue = grandTotalRevenue;
    }

    

}
