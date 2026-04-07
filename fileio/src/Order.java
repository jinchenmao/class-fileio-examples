import java.io.*;

public class Order {

    public void generateOrderInvoice(){
        String input = "order.txt";
        String output = "Invoice.txt";

        String[] array = new String[3];
        String s = "";
        String delimeter = ",";

        String itemName;
        double price;
        int quantity;
        double total = 0;
        String line;
        String heading;

        try{

            FileReader fileReader = new FileReader(input);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(output);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            //heading = "Item Name" + "\t\t\t" + "Price" + "\t\t\t" + "Quantity";
            heading = String.format("%-20s %-10s %-10s", "Item Name", "Price", "Quantity");

            bufferedWriter.write("*".repeat(50));
            bufferedWriter.newLine();
            bufferedWriter.write(heading);
            bufferedWriter.newLine();
            s = bufferedReader.readLine();
            while(s != null){
                array = s.split(delimeter);
                itemName = array[0];
                price = Double.parseDouble(array[1]);
                quantity = Integer.parseInt(array[2]);
                total += (price * quantity);
                
                line = String.format("%-20s %-10.2f %-10d", itemName, price, quantity);
                //line = itemName + "\t\t\t" + price + "\t\t\t" + quantity;
                //System.out.println(line);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                s = bufferedReader.readLine();
            }
            bufferedWriter.write("Grand Total: " + total);
            bufferedReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
    
}
