# Bank Management System

## Overview

The Bank Management System is a Java application designed to simulate basic banking operations such as creating and managing customer accounts, depositing and withdrawing funds, and transferring money between accounts. It utilizes JDBC (Java Database Connectivity) to interact with a MySQL database for storing and retrieving banking data.

## Features

- **Account Management**: Allows the creation, deletion, and updating of customer accounts.
- **Deposit and Withdrawal**: Enables users to deposit funds into and withdraw funds from their accounts.
- **Transfer Funds**: Facilitates the transfer of funds between different accounts.
- **View Transactions**: Provides a transaction history for each account.
- **Security**: Implements basic authentication and authorization mechanisms to ensure data integrity and user privacy.

## Technologies Used

- Java
- JDBC (Java Database Connectivity)
- MySQL

## Setup Instructions

1. **Clone the Repository**: Clone the Bank Management System repository from GitHub to your local machine.
   ```bash
   git clone https://github.com/yourusername/bank-management-system.git
   ```

2. **Database Setup**: Install MySQL and create a database named `bank_management_system`. Import the SQL schema file provided in the repository (`bank_management_system.sql`) to set up the necessary tables.

3. **Configure Database Connection**: Open the `src/main/java/com/bank/util/DBUtil.java` file and update the database connection details such as URL, username, and password to match your MySQL setup.

4. **Compile and Run**: Compile the Java files and run the application.
   ```bash
   javac -cp ".:lib/*" src/main/java/com/bank/*.java
   java -cp ".:lib/*" src/main/java/com/bank/BankManagementSystem
   ```

## Usage

1. **Login**: Upon running the application, you will be prompted to log in with your username and password. Use the provided credentials or create a new account if logging in for the first time.

2. **Main Menu**: After successful login, you will be presented with the main menu options:
   - Create Account
   - Deposit
   - Withdraw
   - Transfer
   - View Transactions
   - Logout

3. **Create Account**: Allows you to create a new customer account by providing necessary details such as name, address, initial deposit amount, etc.

4. **Deposit**: Enables you to deposit funds into an existing account by specifying the account number and deposit amount.

5. **Withdraw**: Allows you to withdraw funds from an existing account by specifying the account number and withdrawal amount.

6. **Transfer**: Facilitates the transfer of funds between two existing accounts by specifying the sender's and receiver's account numbers along with the transfer amount.

7. **View Transactions**: Provides a transaction history for a specific account by entering the account number.

8. **Logout**: Logs out the current user and returns to the login screen.

## Contributors

- [Your Name](https://github.com/yourusername)
- [Contributor 1](https://github.com/contributor1)
- [Contributor 2](https://github.com/contributor2)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Support

For any inquiries or issues, please [open an issue](https://github.com/yourusername/bank-management-system/issues) on GitHub.
