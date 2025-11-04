import account.*;
import exception.InsufficientFundsException;

public class Application {
    public static void main(String[] args) {
        Checking.NormalTest();
        Saving.NormalTest();
        CD.NormalTest();
        Loan.NormalTest();

        InsufficientFundsException.CheckingAccountExceptionTest();
        InsufficientFundsException.SavingAccountExceptionTest();
        InsufficientFundsException.CDAccountExceptionTest();
        InsufficientFundsException.LoanAccountExceptionTest();
    }
}