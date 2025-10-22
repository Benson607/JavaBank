package utils;

public class CDAccount implements Account {
    private String user_name = "";
    private int user_balance = 0;
    
    public CDAccount(String name) {
        user_name = name;
        user_balance = 0;
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
        
        user_balance -= money;
    }
    
    public String name() {
        return user_name;
    }
    
    public int balance() {
        return user_balance;
    }
    
    public void compute_interest() {

    }
}
