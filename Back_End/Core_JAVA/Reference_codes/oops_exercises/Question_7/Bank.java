package Java_refference.oops_exercises.Question_7;

import java.util.ArrayList;
// import java.util.List;

public class Bank{
    ArrayList<Account> accounts = new ArrayList<Account>();

    public void addAccount(Account account){
        accounts.add(account);
    }
    public void removeAccount(Account account){
        accounts.remove(account);
    }
    public void depositeMoney(Account account, float amount){
        account.deposite(amount);
    }
    public void withdrawMoney(Account account, float amount){
        account.withdraw(amount);
    }
    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    public String accountDetails(Account account){
        return account.details();
    }
}
