import java.util.ArrayList;
import java.util.List;

public abstract class Accounts {
    private String accountNumber;
    private String accountHolderName;
    private String accountType;
    private double balance;
    private boolean isActive;
    
    // Class-level ArrayList
    public static List<Accounts> accountsList = new ArrayList<>();
    
    // Constructor with parameters
    public Accounts(String accountNumber, String accountHolderName, String accountType, 
                    double balance, boolean isActive) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = balance;
        this.isActive = isActive;
    }
    
    // Default empty constructor
    public Accounts() {}
    
    // Getters
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }
    public String getAccountType() { return accountType; }
    public double getBalance() { return balance; }
    public boolean isActive() { return isActive; }
    
    // Setters
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public void setAccountHolderName(String accountHolderName) { this.accountHolderName = accountHolderName; }
    public void setAccountType(String accountType) { this.accountType = accountType; }
    public void setBalance(double balance) { this.balance = balance; }
    public void setActive(boolean active) { isActive = active; }
    
    // Abstract method
    public abstract double calculateRisk();
    
    @Override
    public String toString() {
        return "Accounts{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                ", isActive=" + isActive +
                '}';
    }
}