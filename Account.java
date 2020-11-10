package bankaccountapp;

public abstract class Account implements IBaseRate {
    // List common properties for saving and checking accounts
    private String name;
    private String sin;
    double balance;
    private static int index = 10000;
    protected String accountNumber;
    private String accType;
    protected double rate;

    // Constructor to set base properties and initialize the account
    public Account (String name,String sin,String accType,double initDeposit) {
        this.name = name;
        this.sin = sin;
        this.accType = accType;
        balance = initDeposit;
        // Set Account Number
        index++;
        this.accountNumber = setAccountNumber();
        setRate(); // Call method to set interest rate

    }

    // All account types should implement setRate
    public abstract void setRate();

    // Method to set last 10 digits of account number
    private String setAccountNumber() {
        String lastTwoOfSin = sin.substring(sin.length()-2);
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10,3));
        return lastTwoOfSin + uniqueID + randomNumber;
    }

    // Calculate compound interest rate
    public void compound() {
        double accuredInterest = balance * (rate/100);
        balance = balance + accuredInterest;
        accName();
        System.out.println("Accrued Interest: $" + accuredInterest);
        printBalance();
    }

    // Show Account Info
    public void showInfo() {
        System.out.println("\nName: " + name + "\nSocial Insurance Number: " + sin + "\nAccount Type: " + accType +
                "\nAccount Number: " + accountNumber + "\nBalance: $" + balance + "\nRate: " + rate + "%");
    }

    // Method to deposit money into account
    public void deposit(double amount) {
        balance = balance + amount;
        accName();
        System.out.println("Depositing $" + amount);
        printBalance();
    }

    // Method to withdraw money from account
    public void withdraw(double amount) {
        balance = balance - amount;
        accName();
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }

    // Method to transfer money from account
    public void transfer (String toWhere, double amount) {
        balance = balance - amount;
        accName();
        System.out.println("Transferring $" + amount + " to " + toWhere);
        printBalance();
    }

    // Method to print account balance
    public void printBalance() {
        System.out.println("Your new balance is: $" + balance);
    }

    // Method to print account type for transaction purpose
    public void accName () {
        System.out.println("\n" + accType + " Account:");
    }


}
