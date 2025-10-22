package utils;

public class LoanAccount implements Account {
    private String user_name = "";
    private int user_balance = 0;
    
    public LoanAccount(String name, int loan) {
        if (name == null) {
            throw new IllegalArgumentException("name can not be null");
        }
        if (loan < 0) {
            throw new IllegalArgumentException("loan can not less than 0");
        }
        user_name = name;
        user_balance = loan;
    }

    public void deposit(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("can not deposit money that less than 0");
        }
        user_balance += money;
    }

    public void withdraw(int money) {
        throw new UnsupportedOperationException("you can not withdra in loan account");
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
