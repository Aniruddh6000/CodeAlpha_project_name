// Project no.2 of CodeAlpha
import java.util.Scanner;

public 1class BankingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0.0;
        boolean running = true;

        while (running) {
            System.out.println("\n--- Banking System ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Deposit
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        System.out.println("Deposited successfully! Current balance: " + balance);
                    } else {
                        System.out.println("Invalid deposit amount. Please try again.");
                    }
                    break;

                case 2: // Withdraw
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > 0 && withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        System.out.println("Withdrawn successfully! Current balance: " + balance);
                    } else if (withdrawAmount > balance) {
                        System.out.println("Insufficient balance. Withdrawal failed.");
                    } else {
                        System.out.println("Invalid withdrawal amount. Please try again.");
                    }
                    break;

                case 3: // Check Balance
                    System.out.println("Your current balance is: " + balance);
                    break;

                case 4: // Exit
                    System.out.println("Thank you for using the banking system. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
        }

        scanner.close();
    }
}