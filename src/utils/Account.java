package utils;

public interface Account {
    void deposit(int money) throws Exception;
    void withdraw(int money) throws Exception;
    String name();
    int balance();
    void compute_interest();
}
