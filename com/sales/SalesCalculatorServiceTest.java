package com.sales;

import java.util.ArrayList;
import java.util.List;

public class SalesCalculatorServiceTest {

    public static void main(String[] args) {
        System.out.println("Running Unit Tests...");

        SalesCalculatorService calculator = new SalesCalculatorService();
        List<Product> sampleProducts = new ArrayList<>();

        sampleProducts.add(new Product("P001", "Wireless Mouse",
                "Electronics", 12, 25.50)); // Rev: 306.00
        sampleProducts.add(new Product("P002", "Notebook", "Stationery", 35,
                3.75));        // Rev: 131.25
        sampleProducts.add(new Product("P003", "USB Hub", "Electronics", 8,
                18.00));         // Rev: 144.00
        sampleProducts.add(new Product("P004", "Ballpoint Pen", "Stationery",
                100, 0.50));   // Rev: 50.00
        sampleProducts.add(new Product("P005", "HDMI Cable", "Electronics",
                20, 12.00));      // Rev: 240.00

        SalesSummary summary = calculator.calculateSummary(sampleProducts);

        // Test Revenue Calculation
        check(sampleProducts.get(0).getTotalRevenue() == 306.00, "Wireless
                Mouse revenue calculation failed");
                check(summary.getGrandTotalRevenue() == 871.25, "Grand total revenue
                        calculation failed");

                        // Test Best Seller Logic
                        check("P004".equals(summary.getBestSellingProduct().getProductId()),
                                "Best selling product detection failed");
// Test Highest Revenue Logic
        check("P001".equals(summary.getHighestRevenueProduct().getProductId()),
                "Highest revenue product detection failed");
        System.out.println("ALL TESTS PASSED SUCCESSFULLY!");
    }
    private static void check(boolean condition, String errorMessage) {
        if (!condition) {
            System.err.println("TEST FAILED: " + errorMessage);
            System.exit(1);
        }
    }
}


