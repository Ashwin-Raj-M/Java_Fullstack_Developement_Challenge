/* "7. Write a Java program to create a class called "Bank" with a collection of accounts 
and methods to add and remove accounts, and to deposit and withdraw money. Also define a class called 
"Account" to maintain account details of a particular customer." */

package Java_refference.oops_exercises.Question_7;

import java.util.ArrayList;
public class Main{
    public static void main(String[] args) {
        Bank bank1 = new Bank();
        Account acc1 = new Account(100, "Ashwin", 10);
        Account acc2 = new Account(101, "Raj", 100);
        Account acc3 = new Account(102, "Marimuthu", 1000);

        bank1.addAccount(acc1);
        bank1.addAccount(acc2);
        bank1.addAccount(acc3);

        ArrayList<Account> accounts = bank1.getAccounts();

        for(Account account : accounts){
            System.out.println(bank1.accountDetails(account));
        }

        bank1.depositeMoney(acc1, 1000);
        bank1.withdrawMoney(acc2, 150);
        bank1.depositeMoney(acc3, 3000);
        
        for(Account account : accounts){
            System.out.println(bank1.accountDetails(account));
        }
        for(Account account : accounts){
            System.out.println(bank1.accountDetails(account));
        }
    }   
}
