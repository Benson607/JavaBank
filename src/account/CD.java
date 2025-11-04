package account;

import java.time.LocalDate;
import java.time.Period;

public class CD implements Account {
    private String user_name = "";
    private int user_balance = 0;

    private int duration;
    
    private double year_interest_rate;

    private LocalDate last_interest_date;
    
    public CD(String name, double year_interest_rate, int init_amount, int duration) {
        if (name == null) {
            throw new IllegalArgumentException("name can not be null");
        }
        if (year_interest_rate < 0.0) {
            throw new IllegalArgumentException("interest rate can not less than 0");
        }
        if (init_amount < 0.0) {
            throw new IllegalArgumentException("initial amount can not less than 0");
        }
        if (duration < 0.0) {
            throw new IllegalArgumentException("duration can not less than 0");
        }
        user_name = name;
        this.year_interest_rate = year_interest_rate;
        user_balance = init_amount;
        this.duration = duration;

        last_interest_date = BankCalendar.get_date_object().plusDays(0);
    }

    public void deposit(int money) {
        throw new UnsupportedOperationException("you can not deposit in CD account");
    }

    public void withdraw(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("can not withdraw money that less than 0");
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

        int delta_month = delta_time.getYears() * 12 + delta_time.getMonths();

        if (delta_month > duration) {
            delta_month = duration;
        }
        
        user_balance += (int)(user_balance * delta_month * year_interest_rate / 12 / 100);

        duration -= delta_month;
        last_interest_date = now_date;
    }

    public static void NormalTest() {
        System.out.println("CDAccount test start");
        System.out.println("create CD account that interest rate of year is 10% and have 5000 dollar and the duration is 12 month");
        CD cd_account = new CD("cd_account", 10, 5000, 12);
        System.out.println("account name: " + cd_account.name());
        System.out.println("balance now: " + cd_account.balance());
        System.out.println("withdraw 500 dollar");
        cd_account.withdraw(500);
        System.out.println("balance now: " + cd_account.balance());
        System.out.println("you can see that only 4250 dollar because the handling fee");
        System.out.println("jump to 12 month later");
        BankCalendar.fast_forward_by_month(12);
        System.out.println("compute interest");
        cd_account.compute_interest();
        System.out.println("balance now: " + cd_account.balance());
        System.out.println("jump to 1 month later");
        BankCalendar.fast_forward_by_month(1);
        System.out.println("compute interest");
        cd_account.compute_interest();
        System.out.println("balance now: " + cd_account.balance());
        System.out.println("you can see that the balance has no increase because the duration is pass");
        System.out.println("CDAccount test finish");
        System.out.println();
    }
}
