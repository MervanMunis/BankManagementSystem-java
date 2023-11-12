class AccountManager {
    private final String firstName;
    private final String lastName;
    private final String accountNumber;
    private double balance;

    // Write a constructor
    public AccountManager(String firstName, String lastName, String accountNumber, double balance){
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    // Write getters:
    public String getAccountNumber() {
        return accountNumber;
    }
    // Write getters:
    public double getBalance() {
        return balance;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void deposit(double amount) {
        try {
            if (amount<=0) {
                throw new IllegalArgumentException("Amount must be greater than 0.");
            }
            this.balance = this.getBalance() + amount; // adding to balance
            System.out.println("Deposit of $" + amount + " successful. New balance: $" + this.getBalance());
        }catch (IllegalArgumentException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    public void withdraw(double amount) {
        try {
            if (amount>=0) {
                throw new IllegalArgumentException("Amount must be greater than 0.");
            }
            this.balance = this.getBalance() + amount;
            System.out.println("withdrawal of $" + amount + " successful. New abalance $" + this.getBalance());
        }catch (IllegalArgumentException exception) {
            System.out.println("Error: " + exception);
        }
    }

}

