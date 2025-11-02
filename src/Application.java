import account.*;

public class Application {
    public static void main(String[] args) {
        Tester tester = new Tester();

        tester.CheckingAccountNormalTest();

        tester.SavingAccountNormalTest();
        
        tester.CDAccountNormalTest();
        
        tester.LoanAccountNormalTest();
        
        tester.CheckingAccountExceptionTest();
        
        tester.SavingAccountExceptionTest();
        
        tester.CDAccountExceptionTest();
        
        tester.LoanAccountExceptionTest();
    }
}