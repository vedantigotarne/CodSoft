import java.util.Scanner;

// Class representing a bank account
class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
            return true;
        } else {
            System.out.println("Insufficient balance or invalid amount.");
            return false;
        }
    }

    // Check balance method
    public double getBalance() {
        return balance;
    }
}

// ATM class to handle user operations
class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    // Constructor
    public ATM(BankAccount account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    // Display ATM menu
    public void displayMenu() {
        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    withdrawProcess();
                    break;
                case 2:
                    depositProcess();
                    break;
                case 3:
                    System.out.println("Current balance: $" + userAccount.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Withdrawal process
    private void withdrawProcess() {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        userAccount.withdraw(amount);
    }

    // Deposit process
    private void depositProcess() {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
    }
}

// Main class to run the ATM system
public class ATMSimulator {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(10000); // Initial balance of $01000
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
    }
}
