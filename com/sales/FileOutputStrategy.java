package com.sales;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileOutputStrategy implements OutputStrategy {
    private final String destinationPath;

    public FileOutputStrategy(String destinationPath) {
        this.destinationPath = destinationPath;
    }

    @Override
    public void writeOutput(SalesSummary summary) throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new
                FileWriter(destinationPath))) {
            writer.write("============================================\n");
            writer.write("        PRODUCT SALES SUMMARY REPORT        \n");
            writer.write("============================================\n\n");

            writer.write("--- Revenue Per Product ---\n");
            for (Product p : summary.getProducts()) {
                writer.write(String.format("%s\t%-18s\t%-12s\t$%.2f\n",
                        p.getProductId(), p.getProductName(), p.getCategory(),
                        p.getTotalRevenue()));
            }

            writer.write("\n--- Revenue Per Category ---\n");
            for (var entry : summary.getCategoryRevenues().entrySet()) {
                writer.write(String.format("%-15s : $%.2f\n", entry.getKey(),
                        entry.getValue()));
            }

            writer.write("\n--- Highlights ---\n");
            writer.write(String.format("Best-Selling Product : %s (%d units)\n",
                    summary.getBestSellingProduct().getProductName(),
                    summary.getBestSellingProduct().getQuantitySold()));

            writer.write(String.format("Highest Revenue      : %s ($%.2f)\n",
                    summary.getHighestRevenueProduct().getProductName(),
                    summary.getHighestRevenueProduct().getTotalRevenue()));

            writer.write(String.format("Grand Total Revenue  : $%.2f\n",
                    summary.getGrandTotalRevenue()));
            writer.write("============================================\n");
        }
        System.out.println("Report successfully written to file: " + destinationPath);
    }
}