package account;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Checking implements Account {
    private String user_name = "";
    private int user_balance = 0;
    
    private double year_interest_rate;

    private LocalDate last_interest_date;
    
    public Checking(String name, double year_interest_rate) {
        if (name == null) {
            throw new IllegalArgumentException("name can not be null");
        }
        if (year_interest_rate < 0.0) {
            throw new IllegalArgumentException("interest rate can not less than 0");
        }
        user_name = name;
        this.year_interest_rate = year_interest_rate;
        user_balance = 0;

        last_interest_date = BankCalendar.get_date_object();
    }

    public void deposit(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("can not deposit money that less than 0");
        }
        user_balance += money;
    }

    public void withdraw(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("can not withdraw money that less than 0");
        }

        if (money > user_balance) {
            throw new UnsupportedOperationException("you don't have enough money");
        }

        if (user_balance - money < 1000) {
            throw new UnsupportedOperationException("you must leave 1000 dollar in checking account");
        }
        
        user_balance -= money;
    }
    
    public String name() {
        return user_name;
    }
    
    public int balance() {
        return user_balance;
    }
    
    public void compute_interest() {
        LocalDate now_date = BankCalendar.get_date_object();
        
        long delta_day = ChronoUnit.DAYS.between(last_interest_date, now_date);

        user_balance += (int)(user_balance * delta_day * year_interest_rate / 365 / 100);

        last_interest_date = now_date;
    }

    public static void NormalTest() {
        System.out.println("CheckingAccount test start");
        System.out.println("create checking account that interest rate of year is 10%");
        Checking checking_account = new Checking("checking_account", 10);
        System.out.println("account name: " + checking_account.name());
        System.out.println("balance now: " + checking_account.balance());
        System.out.println("deposit 2000 dollar");
        checking_account.deposit(2000);
        System.out.println("balance now: " + checking_account.balance());
        System.out.println("withdraw 500 dollar");
        checking_account.withdraw(500);
        System.out.println("balance now: " + checking_account.balance());
        System.out.println("jump to 10 days later");
        BankCalendar.fast_forward_by_day(10);
        System.out.println("compute interest");
        checking_account.compute_interest();
        System.out.println("balance now: " + checking_account.balance());
        System.out.println("CheckingAccount test finish");
        System.out.println();
    }
}
