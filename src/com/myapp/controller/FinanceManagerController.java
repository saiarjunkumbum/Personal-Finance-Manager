package com.myapp.controller;

import com.myapp.model.Transaction;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FinanceManagerController {
    private List<Transaction> transactions;
    private static final String FILE_PATH = "transactions.txt";

    public FinanceManagerController()
    {
        transactions = new ArrayList<>();
        loadTransactionsFromFile();
    }


    private void saveTransactionsToFile() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (Transaction transaction : transactions) {
                writer.write(transaction.getAmount() + ",");
                writer.write(transaction.getCategory() + ",");
                writer.write(transaction.getDate() + ",");
                writer.write(transaction.getDescription() + "\n");
            }
            System.out.println("Transactions saved to file.");
        } catch (IOException e) {
            System.out.println("Failed to save transactions to file.");
            e.printStackTrace();
        }
    }

    private void loadTransactionsFromFile() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] transactionData = line.split(",");
                    if (transactionData.length == 4) {
                        double amount = Double.parseDouble(transactionData[0]);
                        String category = transactionData[1];

                        Transaction transaction = new Transaction();
                        transaction.setAmount(amount);
                        transaction.setCategory(category);

                        transactions.add(transaction);
                    }
                }
                System.out.println("Transactions loaded from file.");
            } catch (IOException e) {
                System.out.println("Failed to load transactions from file.");
                e.printStackTrace();
            }
        }
    }


    public void addTransaction(Transaction transaction)
    {
        if (transaction.getAmount() < 0) {
            System.out.println("Invalid transaction amount. Amount must be non-negative.");
            return;
        }

        transactions.add(transaction);
        saveTransactionsToFile();
    }

    public List<Transaction> getAllTransactions()
    {
        return transactions;
    }


    public static void main(String[] args)
    {
        FinanceManagerController controller = new FinanceManagerController();
    }
}
