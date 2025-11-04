package account;

import java.time.LocalDate;
import java.time.Period;

public class Loan implements Account {
    private String user_name = "";
    private int user_balance = 0;
    
    private double year_interest_rate;

    private LocalDate last_interest_date;
    
    public Loan(String name, double year_interest_rate, int loan) {
        if (name == null) {
            throw new IllegalArgumentException("name can not be null");
        }
        if (loan < 0) {
            throw new IllegalArgumentException("loan can not less than 0");
        }
        if (year_interest_rate < 0.0) {
            throw new IllegalArgumentException("interest rate can not less than 0");
        }
        user_name = name;
        this.year_interest_rate = year_interest_rate;
        user_balance = -loan;

        last_interest_date = BankCalendar.get_date_object();
    }

    public void deposit(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("can not deposit money that less than 0");
        }
        user_balance += money;
    }

    public void withdraw(int money) {
        throw new UnsupportedOperationException("you can not withdraw in loan account");
    }
    
    public String name() {
        return user_name;
    }
    
    public int balance() {
        return user_balance;
    }
    
    public void compute_interest() {
        LocalDate now_date = BankCalendar.get_date_object();
        
        Period delta_time = Period.between(last_interest_date, now_date);

        int delta_month = delta_time.getYears() * 12 + delta_time.getMonths();
        
        user_balance += (int)(user_balance * delta_month * year_interest_rate / 12 / 100);

        last_interest_date = now_date;
    }

    public static void NormalTest() {
        System.out.println("LoanAccount test start");
        System.out.println("create loan account that interest rate of year is 10% and have 5000 loan");
        Loan loan_account = new Loan("loan_account", 10, 5000);
        System.out.println("account name: " + loan_account.name());
        System.out.println("balance now: " + loan_account.balance());
        System.out.println("deposit 2000 dollar");
        loan_account.deposit(2000);
        System.out.println("balance now: " + loan_account.balance());
        System.out.println("jump to 10 months later");
        BankCalendar.fast_forward_by_month(10);
        System.out.println("compute interest");
        loan_account.compute_interest();
        System.out.println("balance now: " + loan_account.balance());
        System.out.println("LoanAccount test finish");
        System.out.println();
    }
}
