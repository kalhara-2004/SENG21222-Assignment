package com.sales;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesCalculatorService {

    public SalesSummary calculateSummary(List<Product> products) {
        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException("Product list cannot be empty.");
        }

        Map<String, Double> categoryRevenues = new HashMap<>();
        Product bestSelling = products.get(0);
        Product highestRevenue = products.get(0);
        double grandTotal = 0.0;

        for (Product product : products) {
            double revenue = product.getTotalRevenue();
            grandTotal += revenue;

            
            categoryRevenues.put(product.getCategory(), 
                categoryRevenues.getOrDefault(product.getCategory(), 0.0) + revenue);

            
            if (product.getQuantitySold() > bestSelling.getQuantitySold()) {
                bestSelling = product;
            }

            
            if (revenue > highestRevenue.getTotalRevenue()) {
                highestRevenue = product;
            }
        }
        return new SalesSummary(products, categoryRevenues, bestSelling, highestRevenue, grandTotal);
    }
    
}
