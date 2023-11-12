import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends AccountTransaction{
    public static void main(String[] args) {
        boolean exitProgram = false;
        while (!exitProgram) {
            BankManager bank = new BankManager();
            Scanner scanner = new Scanner(System.in);

            ArrayList<AccountManager> allAccounts = bank.getAccounts();
            displayMenu();
            int choiceBank = scanner.nextInt();

            try {
                switch (choiceBank) {
                    case 1:
                        handleTransaction(scanner, allAccounts);
                        break;

                    case 2:
                        System.out.print("Enter First Name: ");
                        String firstName = scanner.next();
                        System.out.print("Enter Last Name: ");
                        String lastName = scanner.next();
                        System.out.print("Enter account number: ");
                        String accNumber = scanner.next();
                        double balance = 0.0;

                        AccountManager newAccount = new AccountManager(firstName, lastName, accNumber, balance);
                        bank.addAccount(newAccount);
                        break;

                    case 3:
                        System.out.print("Enter account number to remove: ");
                        String accToRemove = scanner.next();
                        AccountManager accountToRemove = bank.findAccount(accToRemove);
                        if (accountToRemove != null) {
                            bank.removeAccount(accountToRemove);
                        } else {
                            System.out.println("Account not found.");
                        }
                        break;

                    case 4:
                        if (allAccounts.isEmpty()) {
                            System.out.println("No accounts found.");
                        } else {
                            for (AccountManager account : allAccounts) {
                                System.out.println("Account Number: " + account.getAccountNumber() + ", Balance: $" + account.getBalance());
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Exiting... Thank you!");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input to avoid an infinite loop
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
            scanner.close();
        }

    }
}