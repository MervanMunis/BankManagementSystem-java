import java.util.ArrayList;

class BankManager {
    private final ArrayList<AccountManager> accounts;

    public BankManager(){ // Constructor
        this.accounts = new ArrayList<>();
    }

    public void addAccount(AccountManager account) {
        this.accounts.add(account);
    }

    public void removeAccount(AccountManager account) {
        this.accounts.remove(account);
    }

    // getter
    public ArrayList<AccountManager> getAccounts(){
        return this.accounts;
    }

    public AccountManager findAccount(String accountNumber) {
        for (AccountManager account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
