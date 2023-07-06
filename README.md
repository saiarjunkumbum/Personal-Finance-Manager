# PersonalFinanceManager

The Personal Finance Manager is a Java-based application that allows users to track and manage their personal finances. It provides functionalities to add transactions, view transaction details, and categorize transactions. The application incorporates various principles and concepts of Java programming and software development.

# Functionality of each class :
FinanceManagerController:

This class acts as the controller in the application and handles the business logic and data management.
It manages a list of Transaction objects and provides methods for adding transactions and retrieving all transactions.
The controller is responsible for data persistence, loading transactions from a file, and saving transactions to a file.
It also performs data validation to ensure that transaction amounts are non-negative.
The controller class interacts with the Transaction class to handle transaction objects.


Transaction:

The Transaction class represents a single transaction in the personal finance manager application.
It contains attributes such as amount, category, date, and description to store transaction details.
The class provides getter and setter methods for accessing and modifying the transaction attributes.
Instances of the Transaction class are created and managed by the FinanceManagerController class.



FinanceManagerUI:

The FinanceManagerUI class is responsible for the user interface of the application.
It presents a menu to the user and captures user input to perform various actions.
The class interacts with the FinanceManagerController class to add transactions, view transactions, and exit the application.
It prompts the user for transaction details, such as amount and category, and creates a Transaction object to add to the controller.
The UI class also displays the list of transactions to the user, retrieved from the controller.
