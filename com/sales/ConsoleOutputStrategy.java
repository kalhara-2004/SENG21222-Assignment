package com.sales;

import java.util.Map;

public class ConsoleOutputStrategy implements OutputStrategy {

    @Override
    public void writeOutput(SalesSummary summary) {
        System.out.println("============================================");
        System.out.println("        PRODUCT SALES SUMMARY REPORT        ");
        System.out.println("============================================\n");

        System.out.println("--- Revenue Per Product ---");

        for (Product p : summary.getProducts()) {
            System.out.printf("%s\t%-18s\t%-12s\t$%.2f\n",
                    p.getProductId(),
                    p.getProductName(),
                    p.getCategory(),
                    p.getTotalRevenue());
        }

        System.out.println("\n--- Revenue Per Category ---");

        for (Map.Entry<String, Double> entry : summary.getCategoryRevenues().entrySet()) {
            System.out.printf("%-15s : $%.2f\n",
                    entry.getKey(),
                    entry.getValue());
        }

        System.out.println("\n--- Highlights ---");

        System.out.printf("Best-Selling Product : %s (%d units)\n",
                summary.getBestSellingProduct().getProductName(),
                summary.getBestSellingProduct().getQuantitySold());

        System.out.printf("Highest Revenue      : %s ($%.2f)\n",
                summary.getHighestRevenueProduct().getProductName(),
                summary.getHighestRevenueProduct().getTotalRevenue());

        System.out.printf("Grand Total Revenue  : $%.2f\n",
                summary.getGrandTotalRevenue());

        System.out.println("============================================");
    }
}