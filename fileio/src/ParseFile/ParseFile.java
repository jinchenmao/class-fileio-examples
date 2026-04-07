package ParseFile;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.Buffer;

public class ParseFile {

    public void parseFile(){
        String input = "fileio/order.txt";
        String output = "Invoice3.txt";

        String itemName = "";
        double price = 0.0;
        int quantity = 0;
        double total = 0.0;

        String delimiter = ",";
        String[] items = new String[3];
        String decoration = "*".repeat(50);
        String header = String.format("%-20s %10s %10s", "Item Name", "Price", "Quantity");

        try{
            FileReader fileReader = new FileReader(input);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            FileWriter fileWriter = new FileWriter(output);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(decoration);
            bufferedWriter.newLine();
            bufferedWriter.write(header);
            bufferedWriter.newLine();
            String line = "";
            

            while((line = bufferedReader.readLine()) != null){
                items = line.split(delimiter);
                System.out.println(items[0] + " " + items[1] + " " + items[2]);
                itemName = items[0];
                price = Double.parseDouble(items[1]);
                quantity = Integer.parseInt(items[2]);
                total += price * quantity;

                String formattedLine = String.format("%-20s %10.2f %10d", itemName, price, quantity);
                bufferedWriter.write(formattedLine);
                bufferedWriter.newLine();

            }
            bufferedWriter.write(decoration);
            bufferedWriter.newLine();

            String totalLine = String.format("%-20s %10.2f", "Total:", total);
            bufferedWriter.write(totalLine);
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();

        }catch(Exception e){
            e.printStackTrace();

    }
    
}}
