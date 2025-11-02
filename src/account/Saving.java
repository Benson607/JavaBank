package account;

import java.time.LocalDate;
import java.time.Period;

public class Saving implements Account {
    private String user_name = "";
    private int user_balance = 0;

    private LocalDate last_withdraw_date;
    private int withdraw_times = 0;

    private double year_interest_rate;

    private LocalDate last_interest_date;
    
    public Saving(String name, double year_interest_rate) {
        if (name == null) {
            throw new IllegalArgumentException("name can not be null");
        }
        if (year_interest_rate < 0.0) {
            throw new IllegalArgumentException("interest rate can not less than 0");
        }
        user_name = name;
        this.year_interest_rate = year_interest_rate;
        user_balance = 0;

        last_withdraw_date = BankCalendar.get_date_object();
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
            throw new IllegalArgumentException("can not deposit money that less than 0");
        }

        if (money > user_balance) {
            throw new UnsupportedOperationException("you don't have enough money");
        }
        
        LocalDate now_date = BankCalendar.get_date_object();

        Period delta_month = Period.between(last_withdraw_date, now_date);

        if (delta_month.getMonths() > 0) {
            withdraw_times = 0;
            last_withdraw_date = now_date;
        }

        if (withdraw_times >= 3) {
            money += 1;

            if (money > user_balance) {
                throw new UnsupportedOperationException("you don't have enough money to spend handling fees");
            }
        }

        withdraw_times++;

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

        int delta_month = delta_time.getYears() * 12 + delta_time.getMonths();
        
        user_balance += (int)(user_balance * delta_month * year_interest_rate / 12 / 100);

        last_interest_date = now_date;
    }
}
