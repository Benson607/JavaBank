package account;

public interface Account {
    void deposit(int money);
    void withdraw(int money);
    String name();
    int balance();
    void compute_interest();
}
