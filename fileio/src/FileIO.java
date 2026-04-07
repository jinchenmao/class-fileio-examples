import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileIO {

    public void fileIO(){

        String inputFile = "/Users/pram/Downloads/Groceries.txt";
        String outputFile = "Output.txt";

        String[] array = new String[4];
        String s = "";
        String delimiter = ",";


        String id;
        String itemName;
        String quantity;
        double price;
        double total;
        String line;
        String heading;

        try{
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(outputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            heading = "ID" + "\t" + "Item Name" + "\t" + "Quantity" + "\t" + "Price" + "\t" + "Total";

            bufferedWriter.append("*************************************************************");
            bufferedWriter.newLine();

            bufferedWriter.append(heading);
            bufferedWriter.newLine();

            s = bufferedReader.readLine();
            while(s != null){
                array = s.split(delimiter);
                id = array[0];
                itemName = array[1];
                quantity = array[2];
                price = Double.parseDouble(array[3]);
                
                total = Double.parseDouble(array[2]) * price;
                line = id + "\t" + itemName + "\t" + quantity + "\t" + price + "\t" + total;
                System.out.println(line);
            }
            bufferedReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
    }
    
}
}
