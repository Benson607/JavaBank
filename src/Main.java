import utils.*;

public class Main {
    public static void main(String[] args) {
        CheckingAccount checking_account = new CheckingAccount("checking_account");
        SavingAccount saving_account = new SavingAccount("saving_account");
        CDAccount cd_account = new CDAccount("saving_account");
        LoanAccount loan_account = new LoanAccount("loan_account");
        
        System.out.println(checking_account.name());
        System.out.println(saving_account.name());
        System.out.println(cd_account.name());
        System.out.println(loan_account.name());
    }
}