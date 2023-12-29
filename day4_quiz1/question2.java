package day4_quiz1;
interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    double Balance();
}
abstract class Acc implements Account {
     double balance;
    public Acc(double initialBalance) {
        this.balance = initialBalance;
    }
    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }
    public double Balance() {
        return balance;
    }
}
class SavingsAccount extends Acc {
    SavingsAccount(double initialBalance) {
        super(initialBalance);
    }
    void applyInterest(double rate) {
        balance += balance * rate;
    }
}
class CheckingAccount extends Acc {
    private double overdraftLimit;
    CheckingAccount(double initialBalance, double overdraftLimit) {
        super(initialBalance);
        this.overdraftLimit = overdraftLimit;
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance + overdraftLimit) balance -= amount;
    }
}
class LoanAccount extends Acc {
    LoanAccount(double initialBalance) {
        super(initialBalance);
    }
    void applyInterest(double rate) {
        balance += balance * rate;
    }
}
public class question2 {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount(5000);
        CheckingAccount checking = new CheckingAccount(5000, 2000);
        LoanAccount loan = new LoanAccount(3000);
        savings.deposit(200);
        savings.applyInterest(0.05);
        checking.withdraw(1500);
        loan.deposit(1000);
        loan.applyInterest(0.1);
        System.out.println("Savings: Rs." + savings.Balance());
        System.out.println("Checking: Rs." + checking.Balance());
        System.out.println("Loan: Rs." + loan.Balance());
    }
}
