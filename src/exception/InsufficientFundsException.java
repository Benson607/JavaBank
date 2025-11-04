package exception;

import account.*;

public class InsufficientFundsException {
    public static void CheckingAccountExceptionTest() {
        System.out.println("CheckingAccount exception test start");
        
        Checking checking_account = null;

        System.out.println("create checking account with null name to try IllegalArgumentException");
        try {
            checking_account = new Checking(null, 10);
        }
        catch (IllegalArgumentException e) {
            System.out.println("catch exception: " + e.getMessage());
        }

        System.out.println("create checking account with negative interest rate to try IllegalArgumentException");
        try {
            checking_account = new Checking("checking_account", -10);
        }
        catch (IllegalArgumentException e) {
            System.out.println("catch exception: " + e.getMessage());
        }

        System.out.println("create legal checking account that interest rate of year is 10%");
        checking_account = new Checking("checking_account", 10);
        System.out.println("account name: " + checking_account.name());
        System.out.println("balance now: " + checking_account.balance());

        System.out.println("deposit -2000 dollar to try IllegalArgumentException");
        try {
            checking_account.deposit(-2000);
        }
        catch (IllegalArgumentException e) {
            System.out.println("catch exception: " + e.getMessage());
        }
        System.out.println("balance now: " + checking_account.balance());

        System.out.println("withdraw -500 dollar to try a IllegalArgumentException");
        try {
            checking_account.withdraw(-500);
        }
        catch (IllegalArgumentException e) {
            System.out.println("catch exception: " + e.getMessage());
        }
        System.out.println("balance now: " + checking_account.balance());
        
        System.out.println("withdraw 500 dollar to try a UnsupportedOperationException");
        try {
            checking_account.withdraw(500);
        }
        catch (UnsupportedOperationException e) {
            System.out.println("catch exception: " + e.getMessage());
        }
        System.out.println("balance now: " + checking_account.balance());
        
        System.out.println("deposit 2000 dollar");
        checking_account.deposit(2000);
        System.out.println("balance now: " + checking_account.balance());

        System.out.println("withdraw 1500 dollar to try a UnsupportedOperationException");
        try {
            checking_account.withdraw(1500);
        }
        catch (UnsupportedOperationException e) {
            System.out.println("catch exception: " + e.getMessage());
        }
        System.out.println("balance now: " + checking_account.balance());

        System.out.println();
    }
    
    public static void SavingAccountExceptionTest() {
        Saving saving_account = new Saving("saving_account", 10);
    }
    
    public static void CDAccountExceptionTest() {
        CD cd_account = new CD("cd_account", 10, 5000, 12);
    }
    
    public static void LoanAccountExceptionTest() {
        Loan loan_account = new Loan("loan_account", 10, 5000);
    }
}
