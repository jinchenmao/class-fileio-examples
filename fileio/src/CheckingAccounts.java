import java.util.ArrayList;
import java.util.List;

public class CheckingAccounts extends Accounts {
    public static final double accountRisk = 15;
    public static List<CheckingAccounts> checkingAccountsList = new ArrayList<>();
    
    // Constructor with parameters
    public CheckingAccounts(String accountNumber, String accountHolderName, String accountType,
                           double balance, boolean isActive) {
        super(accountNumber, accountHolderName, accountType, balance, isActive);
    }
    
    // Default empty constructor
    public CheckingAccounts() {}
    
    @Override
    public double calculateRisk() {
        return accountRisk;
    }
}