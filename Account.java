// Base Account Class
class Account {
    private int accountNumber;
    private double balance;
    private double annualInterestRate;

    public Account(int accountNumber, double balance, double annualInterestRate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterest() {
        return balance * (annualInterestRate / 12) / 100;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                return true;
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Balance: $" + balance + ", Annual Interest Rate: " + annualInterestRate + "%";
    }
}

// CheckingAccount Class
class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(int accountNumber, double balance, double annualInterestRate, double overdraftLimit) {
        super(accountNumber, balance, annualInterestRate);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0) {
            if (getBalance() + overdraftLimit >= amount) {
                deposit(-amount); // This will reduce the balance
                return true;
            } else {
                System.out.println("Amount exceeds overdraft limit.");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + ", Overdraft Limit: $" + overdraftLimit;
    }
}

// SavingsAccount Class
class SavingsAccount extends Account {

    public SavingsAccount(int accountNumber, double balance, double annualInterestRate) {
        super(accountNumber, balance, annualInterestRate);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0) {
            if (getBalance() >= amount) {
                deposit(-amount); // This will reduce the balance
                return true;
            } else {
                System.out.println("Insufficient funds. Savings account cannot be overdrawn.");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " (Savings Account)";
    }
}

// Main Class to Test the Program
public class Main {
    public static void main(String[] args) {
        Account account = new Account(1001, 500.00, 1.5);
        CheckingAccount checkingAccount = new CheckingAccount(1002, 500.00, 1.5, 200.00);
        SavingsAccount savingsAccount = new SavingsAccount(1003, 500.00, 1.5);

        // Test Deposit
        account.deposit(200);
        checkingAccount.deposit(200);
        savingsAccount.deposit(200);

        // Test Withdrawal
        account.withdraw(100);
        checkingAccount.withdraw(700); // Should be allowed due to overdraft limit
        savingsAccount.withdraw(700); // Should not be allowed

        // Print Account Details
        System.out.println(account);
        System.out.println(checkingAccount);
        System.out.println(savingsAccount);
    }
}
