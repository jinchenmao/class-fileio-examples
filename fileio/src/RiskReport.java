import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class RiskReport {
    private LinkedList<AuditResults> auditResultsList;
    
    public void generateRiskReport(LinkedList<AuditResults> auditResults, String filepath) {
        this.auditResultsList = auditResults;
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            // Write header
            writer.write(String.format("%-15s %-20s %-12s %-25s %-30s\n", 
                "Account Number", "Composite Rating", "Risk Level", "Risk Title", "Action to Take"));
            writer.write("=".repeat(102) + "\n");
            
            // Write each audit result
            for (AuditResults result : auditResultsList) {
                writer.write(String.format("%-15s %-20d %-12s %-25s %-30s\n",
                    result.getAccountNumber(),
                    result.getCompositeRating(),
                    result.getRiskLevel(),
                    result.getRiskTitle(),
                    result.getActionToTake()));
            }
            
            System.out.println("Risk report generated successfully: " + filepath);
        } catch (IOException e) {
            System.err.println("Error writing risk report: " + e.getMessage());
        }
    }
}