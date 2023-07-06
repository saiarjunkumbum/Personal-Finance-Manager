package com.myapp.view;

import com.myapp.controller.FinanceManagerController;
import com.myapp.model.Transaction;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FinanceManagerUI {
    private FinanceManagerController controller;
    private Scanner scanner;

    public FinanceManagerUI(FinanceManagerController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("===== Personal Finance Manager =====");
        System.out.println("1. Add Transaction");
        System.out.println("2. View All Transactions");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTransaction();
                    break;
                case 2:
                    viewAllTransactions();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting Personal Finance Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private void viewAllTransactions() {
        // Code for retrieving all transactions from the controller and displaying them
        List<Transaction> transactions = controller.getAllTransactions();

        System.out.println("All Transactions:");
        for (Transaction transaction : transactions) {
            System.out.println("Amount: " + transaction.getAmount());
            System.out.println("Category: " + transaction.getCategory());
            // Display date and description attributes similarly
            System.out.println("--------------------------------------");
        }
    }

    private void addTransaction() {
        try {
            System.out.println("Enter transaction details:");
            System.out.print("Amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character

            System.out.print("Category: ");
            String category = scanner.nextLine();


            Transaction transaction = new Transaction();
            transaction.setAmount(amount);

            transaction.setCategory(category);

            controller.addTransaction(transaction);

            System.out.println("Transaction added successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a numeric value for the amount.");
            scanner.nextLine();
            addTransaction();
        }
    }

    public static void main(String[] args) {
        FinanceManagerController controller = new FinanceManagerController();
        FinanceManagerUI financeManagerUI = new FinanceManagerUI(controller);
        financeManagerUI.run();
    }
}
