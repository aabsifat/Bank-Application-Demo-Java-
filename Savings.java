package bankaccountapp;

public class Savings extends Account {
    // List the properties specific to a savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxCode;

    // Constructor to initialize savings account properties
    public Savings(String name,String sin,String accType , double initDeposit) {
        super(name,sin,accType,initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    // Methods to set interest rate specific to savings account
    @Override
    public void setRate() {
        rate = getBaseRate() - 0.25;
    }

    // Method to set safety deposit box ID & code
    private void setSafetyDepositBox() {
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10,3));
        safetyDepositBoxCode = (int) (Math.random() * Math.pow(10,4));
    }

    // Method to show info specific to savings account
    public void showInfo() {
        super.showInfo();
        System.out.println("Safety deposit Box Number: " + safetyDepositBoxID +
                "\nSafety Deposit Box Pin: " + safetyDepositBoxCode);
    }


}