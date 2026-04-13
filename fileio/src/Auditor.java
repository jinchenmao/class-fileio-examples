import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Auditor {
    private LinkedList<AuditResults> auditResultsList = new LinkedList<>();
    private Importer importer = new Importer();
    private List<Accounts> accountsList;
    private List<Transactions> transactionsList;
    private AuditResultsReview auditResultsReview;
    
    public Auditor() {
        this.auditResultsReview = new AuditResultsReview();
        // Import data when Auditor is created
        this.accountsList = importer.importAccounts("Accounts.txt");
        this.transactionsList = importer.importTransactions("Transactions.txt");
    }
    
    public void startAudit() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Bank of Orion Risk Audit System. Following accounts are available for audit:");
        
        // Display accounts
        for (Accounts account : accountsList) {
            System.out.println("Account Holder: " + account.getAccountHolderName() + 
                             ", Account Number: " + account.getAccountNumber());
        }
        
        while (true) {
            System.out.println("\nIf you want to audit a single account, type 1.");
            System.out.println("If you want to manage audit all accounts, type 2.");
            System.out.println("To EXIT the Bank of Orion Risk Audit System, type 3.");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            if (choice == 1) {
                System.out.print("Enter account number: ");
                String accountNumber = scanner.nextLine();
                
                // Check if account exists
                Accounts foundAccount = null;
                for (Accounts account : accountsList) {
                    if (account.getAccountNumber().equals(accountNumber)) {
                        foundAccount = account;
                        break;
                    }
                }
                
                if (foundAccount != null) {
                    Audit audit = new Audit();
                    AuditResults result = audit.auditTransactions(accountNumber, transactionsList);
                    auditResultsList.add(result);
                    System.out.println("Audit completed for account: " + accountNumber);
                } else {
                    System.out.println("Account not found!");
                }
            } else if (choice == 2) {
                auditResultsList = auditResultsReview.reviewAuditResults(transactionsList);
                System.out.println("Audit completed for all accounts.");
            } else if (choice == 3) {
                System.out.println("Thank you for using the Bank of Orion Risk Audit System");
                break;
            }
        }
        
        // Ask about saving report
        System.out.print("\nWould you like to save the audit results in a report format? (yes/no): ");
        String saveChoice = scanner.nextLine();
        
        if (saveChoice.equalsIgnoreCase("yes")) {
            RiskReport riskReport = new RiskReport();
            riskReport.generateRiskReport(auditResultsList, "RiskReport.txt");
        }
        
        scanner.close();
    }
    
    public AuditResults auditTransactions(String accountNumber, List<Transactions> transactions) {
        // Implementation here - calculate composite rating
        int compositeRating = 0;
        // ... calculate based on transactions
        
        return evaluateRiskLevel(compositeRating, accountNumber);
    }
    
    private AuditResults evaluateRiskLevel(int compositeRating, String accountNumber) {
        double accountRisk = 0;
        
        // Find account type and add risk
        for (Accounts account : accountsList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                accountRisk = account.calculateRisk(); // Polymorphism in action!
                break;
            }
        }
        
        compositeRating += accountRisk;
        
        // Map composite rating to risk level (same logic as before)
        String riskLevel, riskTitle, actionToTake;
        if (compositeRating <= 50) {
            riskLevel = "No Risk";
            riskTitle = "No Risk";
            actionToTake = "There's no risk detected. No action required";
        } else if (compositeRating <= 100) {
            riskLevel = "Low Risk";
            riskTitle = "Minor Suspicious Activity";
            actionToTake = "Monitor account activity";
        } else if (compositeRating <= 150) {
            riskLevel = "Medium Risk";
            riskTitle = "Suspicious Activity";
            actionToTake = "Review and verify transactions";
        } else {
            riskLevel = "High Risk";
            riskTitle = "Extremely Suspicious activity";
            actionToTake = "Contact, verify, and inform of 'account freezing' possibility";
        }
        
        return new AuditResults();
    }
}