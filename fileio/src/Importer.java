import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Importer {
    private List<Accounts> accountsList = new ArrayList<>();
    private List<Transactions> transactionsList = new ArrayList<>();
    
    public List<Accounts> importAccounts(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String accountNumber = values[0].trim();
                String accountHolderName = values[1].trim();
                String accountType = values[2].trim();
                double balance = Double.parseDouble(values[3].trim());
                boolean isActive = Boolean.parseBoolean(values[4].trim());
                
                Accounts account;
                if (accountType.equalsIgnoreCase("Savings")) {
                    account = new SavingsAccounts(accountNumber, accountHolderName, 
                                                   accountType, balance, isActive);
                } else if (accountType.equalsIgnoreCase("Checking")) {
                    account = new CheckingAccounts(accountNumber, accountHolderName, 
                                                    accountType, balance, isActive);
                } else {
                    continue; // Skip unknown account types
                }
                accountsList.add(account);
            }
        } catch (IOException e) {
            System.err.println("Error reading accounts file: " + e.getMessage());
        }
        return accountsList;
    }
    
    public List<Transactions> importTransactions(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 8) {
                    String transactionId = values[0].trim();
                    String accountNumber = values[1].trim();
                    String transactionType = values[2].trim();
                    double amount = Double.parseDouble(values[3].trim());
                    String currency = values[4].trim();
                    String transactionDate = values[5].trim();
                    String description = values[6].trim();
                    String status = values[7].trim();
                    
                    Transactions transaction = new Transactions(transactionId, accountNumber,
                        transactionType, amount, currency, transactionDate, description, status);
                    transactionsList.add(transaction);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading transactions file: " + e.getMessage());
        }
        return transactionsList;
    }
}