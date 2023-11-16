import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.InputMismatchException;

public class AccountTransaction {
    static void handleTransaction(Scanner scanner, ArrayList<AccountManager> allAccounts) {


        boolean returnToMainMenu = false;
        while (!returnToMainMenu) {
            displayAccountMenu();
            int choiceAccount = scanner.nextInt();
            try {
                switch (choiceAccount) {
                    case 1:
                        // Handle deposit
                        System.out.println("To Deposit Enter Account Number: ");
                        String accNumberAdd = scanner.next();

                        for (AccountManager account : allAccounts) {
                            if (Objects.equals(account.getAccountNumber(), accNumberAdd)) {
                                System.out.println("Enter amount of deposit.");
                                int amount = Integer.parseInt(scanner.next());
                                account.deposit(amount);
                                break;
                            }
                        }
                        break;

                    case 2:
                        // Handle withdraw
                        System.out.println("To Withdraw Enter Account Number: ");
                        String accNumberRemove = scanner.next();

                        for (AccountManager account : allAccounts) {
                            if (Objects.equals(account.getAccountNumber(), accNumberRemove)) {
                                System.out.println("Enter amount of withdraw.");
                                int amount = Integer.parseInt(scanner.next()) * (-1);
                                account.withdraw(amount);
                                break;
                            }
                        }
                        break;

                    case 3:
                        // Handle account balance
                        System.out.println("To See You Balance Enter Account Number: ");
                        String accNumberBalance = scanner.next();

                        for (AccountManager account : allAccounts) {
                            if (Objects.equals(account.getAccountNumber(), accNumberBalance)) {
                                System.out.println(
                                        "Name: " + account.getFirstName() + "\n" +
                                                "Last Name: " + account.getLastName() + "\n" +
                                                "Account Number: " + account.getAccountNumber() + "\n" +
                                                "Account Balance: " + account.getBalance() + "\n");
                                break;
                            }
                        }
                        break;

                    case 4:
                        // Return to main menu
                        return;

                    case 5:
                        System.out.println("Exiting... Thank you!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }catch (InputMismatchException exception) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input to avoid an infinite loop
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }

        }
    }
    public static void displayMenu() {
        System.out.println(
                """
                                                
                        1. Deposit / Withdraw / Balance
                        2. Add Account
                        3. Remove Account
                        4. View All Accounts
                        5. Exit\s
                        """);
        System.out.println("Enter your choice: ");
    }

    public static void displayAccountMenu() {
        System.out.println("""
                                    
                1. Deposit\s
                2. Withdraw
                3. Account Balance
                4. Return to Main Menu
                5. Exit\s
                """);

        System.out.println("Enter your choice: ");
    }

}
