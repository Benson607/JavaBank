import utils.*;

public class Main {
    public static void main(String[] args) {
        System.err.println(BankCalendar.now());

        CheckingAccount checking_account = new CheckingAccount("checking_account", 12.0);
        System.out.println(checking_account.name());

        SavingAccount saving_account = new SavingAccount("saving_account", 12.0);
        System.out.println(saving_account.name());
        
        CDAccount cd_account = new CDAccount("saving_account", 12.0, 5000, 12);
        System.out.println(cd_account.name());

        LoanAccount loan_account = new LoanAccount("loan_account", 12.0, 1000);
        System.out.println(loan_account.name());
    }
}