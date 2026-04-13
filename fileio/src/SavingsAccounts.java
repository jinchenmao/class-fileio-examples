import java.util.ArrayList;
import java.util.List;

public class SavingsAccounts extends Accounts {
    public static final double accountRisk = 5;
    public static List<SavingsAccounts> savingsAccountsList = new ArrayList<>();
    
    // Constructor with parameters
    public SavingsAccounts(String accountNumber, String accountHolderName, String accountType,
                          double balance, boolean isActive) {
        super(accountNumber, accountHolderName, accountType, balance, isActive);
    }
    
    // Default empty constructor
    public SavingsAccounts() {}
    
    @Override
    public double calculateRisk() {
        return accountRisk;
    }
}