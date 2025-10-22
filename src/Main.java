import utils.*;

public class Main {
    public static void main(String[] args) {
        CheckingAccount checking_account = new CheckingAccount("checking_account");
        System.out.println(checking_account.name());

        SavingAccount saving_account = new SavingAccount("saving_account");
        System.out.println(saving_account.name());
        
        CDAccount cd_account = new CDAccount("saving_account");
        System.out.println(cd_account.name());

        LoanAccount loan_account = new LoanAccount("loan_account", 1000);
        System.out.println(loan_account.name());

        CDAccount c = new CDAccount(null);
        System.out.println(c.name());
    }
}