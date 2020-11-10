package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();

        // Read file to collect new account holder info
        String file = "C:\\Users\\aabsi\\Documents\\myProject\\Java\\NewBankAccounts.csv";
        List<String[]> newAccHolders = utilities.CSV.read(file);
        for (String[] accountHolder : newAccHolders) {
            String name = accountHolder[0];
            String sin = accountHolder[1];
            String accType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            if (accType.equals("Savings")) {
                accounts.add(new Savings(name,sin,accType,initDeposit));
            }
            else if (accType.equals("Checking")) {
                accounts.add(new Checking(name,sin,accType,initDeposit));
            }
            else {
                System.out.println("Account Type Not Recognized!");
            }
        }
        for (Account acc : accounts) {
            System.out.println("\n**********");
            acc.showInfo();
        }

        accounts.get((int)Math.random()*accounts.size()).deposit(2050);
        accounts.get((int)Math.random()*accounts.size()).transfer("Wichita",800);
        accounts.get((int)Math.random()*accounts.size()).withdraw(500);
    }

}
