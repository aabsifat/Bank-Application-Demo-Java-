package bankaccountapp;

public class Checking extends Account {
    // List the properties specific to a checking account
    private long debitCardNumber;
    private int debitCardPin;

    // Constructor to initialize checking account properties
    public Checking(String name, String sin, String accType , double initDeposit) {
        super(name,sin,accType,initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    // Method to set interest rate specific to checking account
    @Override
    public void setRate() {
        rate = getBaseRate() * 0.15;
    }

    // Method to set debit card number & pin
    private void setDebitCard() {
        debitCardNumber = (long) (Math.random() * Math.pow(10,12));
        debitCardPin = (int) (Math.random() * Math.pow(10,4));
    }

    // Method to show info specific to checking account
    public void showInfo() {
        super.showInfo();
        System.out.println("Debit Card Number: " + debitCardNumber +
                "\nDebit Card Pin: " + debitCardPin);
    }


}
