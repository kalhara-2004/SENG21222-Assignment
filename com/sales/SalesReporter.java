package com.sales;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class SalesReporter {

    public static void main(String[] args) {

        String csvFilePath;
        String outputMethod;
        String outputFilePath = "report.txt";

        Scanner scanner = new Scanner(System.in);

        // Get CSV file path
        if (args.length >= 1) {
            csvFilePath = args[0];
        } else {
            csvFilePath = findValidCsvPath("products.csv");
        }

        // Get output method from command-line if provided
        if (args.length >= 2) {

            outputMethod = args[1].toLowerCase();

            if ("file".equals(outputMethod) && args.length >= 3) {
                outputFilePath = args[2];
            }

        } else {

            // Interactive output selection
            System.out.println("============================================");
            System.out.println(" Select Output Method:");
            System.out.println(" 1. Console Output");
            System.out.println(" 2. File Output");
            System.out.println("============================================");
            System.out.print("Enter choice (1 or 2): ");

            String choice = scanner.nextLine().trim();

            if ("2".equals(choice)) {

                outputMethod = "file";

                System.out.print(
                        "Enter output file name (press Enter for default 'report.txt'): "
                );

                String customFile = scanner.nextLine().trim();

                if (!customFile.isEmpty()) {
                    outputFilePath = customFile;
                }

            } else {

                outputMethod = "console";
            }
        }

        OutputStrategy outputStrategy;

        if ("console".equals(outputMethod)) {

            outputStrategy = new ConsoleOutputStrategy();

        } else if ("file".equals(outputMethod)) {

            outputStrategy = new FileOutputStrategy(outputFilePath);

        } else {

            System.err.println("Error: Invalid output method specified.");
            return;
        }

        try {

            CsvReaderService readerService = new CsvReaderService();
            SalesCalculatorService calculatorService =
                    new SalesCalculatorService();

            List<Product> products =
                    readerService.readProductsFromCsv(csvFilePath);

            SalesSummary summary =
                    calculatorService.calculateSummary(products);

            outputStrategy.writeOutput(summary);

        } catch (Exception e) {

            System.err.println("Error: " + e.getMessage());
        }
    }

    private static String findValidCsvPath(String filename) {

        String[] candidatePaths = {
                filename,
                "com/sales/" + filename,
                "SENG21222-Assignment/com/sales/" + filename,
                "src/com/sales/" + filename,
                "src/" + filename
        };

        for (String path : candidatePaths) {

            if (new File(path).exists()) {
                return path;
            }
        }

        return filename;
    }
}