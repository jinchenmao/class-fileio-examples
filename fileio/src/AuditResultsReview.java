import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AuditResultsReview {
    private List<Transactions> transactionsList = new ArrayList<>();
    private LinkedList<AuditResults> auditResultsForReviewLinkedList = new LinkedList<>();
    
    public LinkedList<AuditResults> reviewAuditResults(List<Transactions> transactions) {
        this.transactionsList = transactions;
        return generateAuditResults();
    }
    
    private LinkedList<AuditResults> generateAuditResults() {
        List<String> accountNumbersList = new ArrayList<>();
        
        // Get unique account numbers
        for (Transactions transaction : transactionsList) {
            String accountNum = transaction.getAccountNumber();
            if (!accountNumbersList.contains(accountNum)) {
                accountNumbersList.add(accountNum);
            }
        }
        
        // Audit each account
        for (String accountNumber : accountNumbersList) {
            Audit audit = new Audit();
            AuditResults result = audit.auditTransactions(accountNumber, transactionsList);
            auditResultsForReviewLinkedList.add(result);
        }
        
        return auditResultsForReviewLinkedList;
    }
}