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
            }

        }

    }
}
