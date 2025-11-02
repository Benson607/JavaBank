package account;

public class Tester {
    public void CheckingAccountNormalTest() {
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
    
    public void SavingAccountNormalTest() {
        System.out.println("SavingAccount test start");
        System.out.println("create saving account that interest rate of year is 10%");
        Saving saving_account = new Saving("saving_account", 10);
        System.out.println("account name: " + saving_account.name());
        System.out.println("balance now: " + saving_account.balance());
        System.out.println("deposit 2000 dollar");
        saving_account.deposit(5000);
        System.out.println("balance now: " + saving_account.balance());
        System.out.println("withdraw 500 dollar 3 times");
        saving_account.withdraw(500);
        saving_account.withdraw(500);
        saving_account.withdraw(500);
        System.out.println("balance now: " + saving_account.balance());
        System.out.println("withdraw 500 dollar");
        saving_account.withdraw(500);
        System.out.println("balance now: " + saving_account.balance());
        System.out.println("you can see that only 2999 dollar because the handling fee");
        System.out.println("jump to 1 month later");
        BankCalendar.fast_forward_by_month(1);
        System.out.println("compute interest");
        saving_account.compute_interest();
        System.out.println("balance now: " + saving_account.balance());
        System.out.println("SavingAccount test finish");
        System.out.println();
    }
    
    public void CDAccountNormalTest() {
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
    
    public void LoanAccountNormalTest() {
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
    
    public void CheckingAccountExceptionTest() {

    }
    
    public void SavingAccountExceptionTest() {

    }
    
    public void CDAccountExceptionTest() {

    }
    
    public void LoanAccountExceptionTest() {

    }
}
