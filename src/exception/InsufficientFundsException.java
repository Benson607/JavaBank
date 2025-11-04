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
        System.out.println("SavingAccount exception test start");
        
        Saving saving_account = null;

        System.out.println("create saving account with null name to try IllegalArgumentException");
        try {
            saving_account = new Saving(null, 10);
        }
        catch (IllegalArgumentException e) {
            System.out.println("catch exception: " + e.getMessage());
        }

        System.out.println("create saving account with negative interest rate to try IllegalArgumentException");
        try {
            saving_account = new Saving("saving_account", -10);
        }
        catch (IllegalArgumentException e) {
            System.out.println("catch exception: " + e.getMessage());
        }

        System.out.println("create legal saving account that interest rate of year is 10%");
        saving_account = new Saving("saving_account", 10);
        System.out.println("account name: " + saving_account.name());
        System.out.println("balance now: " + saving_account.balance());

        System.out.println("deposit -2000 dollar to try IllegalArgumentException");
        try {
            saving_account.deposit(-2000);
        }
        catch (IllegalArgumentException e) {
            System.out.println("catch exception: " + e.getMessage());
        }
        System.out.println("balance now: " + saving_account.balance());

        System.out.println("withdraw -500 dollar to try a IllegalArgumentException");
        try {
            saving_account.withdraw(-500);
        }
        catch (IllegalArgumentException e) {
            System.out.println("catch exception: " + e.getMessage());
        }
        System.out.println("balance now: " + saving_account.balance());
        
        System.out.println("withdraw 500 dollar to try a UnsupportedOperationException");
        try {
            saving_account.withdraw(500);
        }
        catch (UnsupportedOperationException e) {
            System.out.println("catch exception: " + e.getMessage());
        }
        System.out.println("balance now: " + saving_account.balance());
        
        System.out.println("deposit 2000 dollar");
        saving_account.deposit(2000);
        System.out.println("balance now: " + saving_account.balance());

        System.out.println("withdraw 500 dollar 3 times for test handling fees exception");
        saving_account.withdraw(500);
        saving_account.withdraw(500);
        saving_account.withdraw(500);
        System.out.println("balance now: " + saving_account.balance());

        System.out.println("withdraw 500 dollar to try a UnsupportedOperationException for handling fees");
        try {
            saving_account.withdraw(500);
        }
        catch (UnsupportedOperationException e) {
            System.out.println("catch exception: " + e.getMessage());
        }

        System.out.println();
    }
    
    public static void CDAccountExceptionTest() {
        System.out.println("CDAccount exception test start");

        CD cd_account = null;

        System.out.println("create CD account with null name to try IllegalArgumentException");
        try {
            cd_account = new CD(null, 10, 5000, 12);
        }
        catch (IllegalArgumentException e) {
            System.out.println("catch exception: " + e.getMessage());
        }

        System.out.println("create CD account with negative interest rate to try IllegalArgumentException");
        try {
            cd_account = new CD("cd_account", -10, 5000, 12);
        }
        catch (IllegalArgumentException e) {
            System.out.println("catch exception: " + e.getMessage());
        }

        System.out.println("create CD account with negative initial amount to try IllegalArgumentException");
        try {
            cd_account = new CD("cd_account", 10, -5000, 12);
        }
        catch (IllegalArgumentException e) {
            System.out.println("catch exception: " + e.getMessage());
        }

        System.out.println("create CD account with negative duration to try IllegalArgumentException");
        try {
            cd_account = new CD("cd_account", 10, 5000, -12);
        }
        catch (IllegalArgumentException e) {
            System.out.println("catch exception: " + e.getMessage());
        }

        System.out.println("create legal CD account that interest rate of year is 10%, initial amount is 5000 dollar and duration is 12 month");
        cd_account = new CD("cd_account", 10, 5000, 12);
        System.out.println("account name: " + cd_account.name());
        System.out.println("balance now: " + cd_account.balance());
        
        System.out.println("deposit 2000 dollar to try UnsupportedOperationException");
        try {
            cd_account.deposit(2000);
        }
        catch (UnsupportedOperationException e) {
            System.out.println("catch exception: " + e.getMessage());
        }
        System.out.println("balance now: " + cd_account.balance());

        System.out.println("withdraw -500 dollar to try IllegalArgumentException");
        try {
            cd_account.withdraw(-500);
        }
        catch (IllegalArgumentException e) {
            System.out.println("catch exception: " + e.getMessage());
        }
        System.out.println("balance now: " + cd_account.balance());

        System.out.println("withdraw 6000 dollar to try UnsupportedOperationException for insufficient funds");
        try {
            cd_account.withdraw(5500);
        }
        catch (UnsupportedOperationException e) {
            System.out.println("catch exception: " + e.getMessage());
        }
        System.out.println("balance now: " + cd_account.balance());

        System.out.println("withdraw 5000 dollar before duration to try UnsupportedOperationException for handling fees");
        try {
            cd_account.withdraw(5000);
        }
        catch (UnsupportedOperationException e) {
            System.out.println("catch exception: " + e.getMessage());
        }
        System.out.println("balance now: " + cd_account.balance());

        System.out.println();
    }
    
    public static void LoanAccountExceptionTest() {
        System.out.println("LoanAccount exception test start");

        Loan loan_account = null;

        System.out.println("create loan account with null name to try IllegalArgumentException");
        try {
            loan_account = new Loan(null, 10, 5000);
        }
        catch (IllegalArgumentException e) {
            System.out.println("catch exception: " + e.getMessage());
        }

        System.out.println("create loan account with negative interest rate to try IllegalArgumentException");
        try {
            loan_account = new Loan("loan_account", -10, 5000);
        }
        catch (IllegalArgumentException e) {
            System.out.println("catch exception: " + e.getMessage());
        }

        System.out.println("create loan account with negative loan amount to try IllegalArgumentException");
        try {
            loan_account = new Loan("loan_account", 10, -5000);
        }
        catch (IllegalArgumentException e) {
            System.out.println("catch exception: " + e.getMessage());
        }

        System.out.println("create legal loan account that interest rate of year is 10% and have 5000 loan");
        loan_account = new Loan("loan_account", 10, 5000);
        System.out.println("account name: " + loan_account.name());
        System.out.println("balance now: " + loan_account.balance());

        System.out.println("deposit -500 dollar to try IllegalArgumentException");
        try {
            loan_account.deposit(-500);
        }
        catch (IllegalArgumentException e) {
            System.out.println("catch exception: " + e.getMessage());
        }
        System.out.println("balance now: " + loan_account.balance());
        
        System.out.println("withdraw 500 dollar to try UnsupportedOperationException");
        try {
            loan_account.withdraw(500);
        }
        catch (UnsupportedOperationException e) {
            System.out.println("catch exception: " + e.getMessage());
        }
        System.out.println("balance now: " + loan_account.balance());
        
        System.out.println("deposit 5000 dollar to repay all loan");
        loan_account.deposit(5000);
        System.out.println("balance now: " + loan_account.balance());

        System.out.println("deposit 1000 dollar to try UnsupportedOperationException for no loan to repay");
        try {
            loan_account.deposit(1000);
        }
        catch (UnsupportedOperationException e) {
            System.out.println("catch exception: " + e.getMessage());
        }

        System.out.println();
    }
}
