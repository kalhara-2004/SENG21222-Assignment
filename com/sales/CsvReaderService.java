package com.sales;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderService {

    public List<Product> readProductsFromCsv(String filePath) throws
            IOException {
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                if (isHeader) {
                    isHeader = false; // Skip the header row
                    continue;
                }

                String[] tokens = line.split(",");
                if (tokens.length < 5) {
                    throw new IllegalArgumentException("Invalid CSV row format: " + line);
                }

                String id = tokens[0].trim();
                String name = tokens[1].trim();
                String category = tokens[2].trim();
                int quantity = Integer.parseInt(tokens[3].trim());
                double unitPrice = Double.parseDouble(tokens[4].trim());

                products.add(new Product(id, name, category, quantity, unitPrice));

            }

        }

        if (products.isEmpty()) {
            throw new IllegalArgumentException("CSV file contains no valid sales records.");


    }
}
