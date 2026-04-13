import java.util.ArrayList;
import java.util.List;

public class Transactions {
    private String transactionId;
    private String accountNumber;
    private String transactionType;
    private double amount;
    private String currency;
    private String transactionDate;
    private String description;
    private String status;
    
    public static List<Transactions> transactionsList = new ArrayList<>();
    
    // Constructor with parameters
    public Transactions(String transactionId, String accountNumber, String transactionType,
                       double amount, String currency, String transactionDate, 
                       String description, String status) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.currency = currency;
        this.transactionDate = transactionDate;
        this.description = description;
        this.status = status;
    }
    
    // Default empty constructor
    public Transactions() {}
    
    // Getters
    public String getTransactionId() { return transactionId; }
    public String getAccountNumber() { return accountNumber; }
    public String getTransactionType() { return transactionType; }
    public double getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String getTransactionDate() { return transactionDate; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    
    // Setters
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setTransactionDate(String transactionDate) { this.transactionDate = transactionDate; }
    public void setDescription(String description) { this.description = description; }
    public void setStatus(String status) { this.status = status; }
    
    @Override
    public String toString() {
        return "Transactions{" +
                "transactionId='" + transactionId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}