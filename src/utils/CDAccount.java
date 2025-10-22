package utils;

import java.time.LocalDate;
import java.time.Period;

public class CDAccount implements Account {
    private String user_name = "";
    private int user_balance = 0;

    private int duration;
    
    private double year_interest_rate;

    private LocalDate last_interest_date;
    
    public CDAccount(String name, double year_interest_rate, int init_amount, int duration) {
        if (name == null) {
            throw new IllegalArgumentException("name can not be null");
        }
        if (year_interest_rate < 0.0) {
            throw new IllegalArgumentException("interest rate can not less than 0");
        }
        if (init_amount < 0.0) {
            throw new IllegalArgumentException("initial amoun can not less than 0");
        }
        if (duration < 0.0) {
            throw new IllegalArgumentException("interest rate can not less than 0");
        }
        user_name = name;
        this.year_interest_rate = year_interest_rate;
        user_balance = init_amount;
        this.duration = duration;

        last_interest_date = BankCalendar.get_date_object();
    }

    public void deposit(int money) {
        throw new UnsupportedOperationException("you can not deposit in CD account");
    }

    public void withdraw(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("can not deposit money that less than 0");
        }

        if (money > user_balance) {
            throw new UnsupportedOperationException("you don't have enough money");
        }

        if (duration > 0) {
            money += 250;
        }

        if (money > user_balance) {
            throw new UnsupportedOperationException("you don't have enough money to spend handling fees");
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
        
        Period delta_time = Period.between(last_interest_date, now_date);

        int delta_month = delta_time.getMonths();

        if (delta_month > duration) {
            delta_month = duration;
        }
        
        user_balance += (int)(user_balance * delta_month * year_interest_rate / 12 / 100);

        duration -= delta_month;
        last_interest_date = now_date;
    }
}
