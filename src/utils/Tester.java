package utils;

public class Tester {
    public void CheckingAccountNormalTest() {
        System.out.println("CheckingAccount test start");
        System.out.println("create checking account that interest rate of year is 10%");
        CheckingAccount checking_account = new CheckingAccount("checking_account", 10);
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
        System.out.println();
    }
    
    public void SavingAccountNormalTest() {

    }
    
    public void CDAccountNormalTest() {

    }
    
    public void LoanAccountNormalTest() {

    }
    
    public void CheckingAccountExceptionTest() {

    }
    
    public void SavingAccountExceptionTest() {

    }
    
    public void CDAccountExceptionTest() {

    }
    
    public void LoanAccountExceptionTest() {

    }
}
