

import java.util.Scanner;

public class ATMInterface {

    private BankAccount account;

    private static final int WITHDRAW_OPTION = 1;
    private static final int DEPOSIT_OPTION = 2;
    private static final int BALANCE_OPTION = 3;
    private static final int EXIT_OPTION = 4;

    public ATMInterface(BankAccount bankAccount) {
        this.account = bankAccount;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();

            int choice = getUserChoice(scanner);

            switch (choice) {
                case WITHDRAW_OPTION:
                    performWithdrawal(scanner);
                    break;

                case DEPOSIT_OPTION:
                    performDeposit(scanner);
                    break;

                case BALANCE_OPTION:
                    checkAccountBalance();
                    break;

                case EXIT_OPTION:
                    System.out.println("Exiting ATM...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private int getUserChoice(Scanner scanner) {
        System.out.print("Enter your choice: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }

        return scanner.nextInt();
    }

    private void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println(WITHDRAW_OPTION + ". Cash Withdraw");
        System.out.println(DEPOSIT_OPTION + ". Cash Deposit");
        System.out.println(BALANCE_OPTION + ". Check Account balance");
        System.out.println(EXIT_OPTION + ". Exit the ATM");
    }

    private void performWithdrawal(Scanner scanner) {
        System.out.print("Enter withdrawal amount: ");

        double withdrawalAmount;

        while (true) {
            try {
                withdrawalAmount = Double.parseDouble(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.print("Enter withdrawal amount: ");
            }
        }

        if (account.withdraw(withdrawalAmount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void performDeposit(Scanner scanner) {
        System.out.print("Enter deposit amount: ");

        double depositAmount;

        while (true) {
            try {
                depositAmount = Double.parseDouble(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.print("Enter deposit amount: ");
            }
        }

        account.deposit(depositAmount);
        System.out.println("Deposit successful.");
    }

    private void checkAccountBalance() {
        System.out.println("Your account balance is: " + account.getBalance());
    }

    private static class BankAccount {

        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public boolean withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
                return true;
            } else {
                return false;
            }
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000.0);
        ATMInterface newATM = new ATMInterface(bankAccount);
        newATM.start();
    }
}
