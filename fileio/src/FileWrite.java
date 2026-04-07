import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.Buffer;
import java.util.Scanner;

public class FileWrite {

    public void writeToAFile(){
        try{
            FileWriter fileWriter = new FileWriter("Output.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("Hello World");
            bufferedWriter.newLine();
            bufferedWriter.write("Hello World, again!");
            bufferedWriter.newLine();
            bufferedWriter.write("It ends here");
            bufferedWriter.newLine();

            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void askAndWrite(){
        try{
            FileWriter fileWriter = new FileWriter("Output2.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            
        
            
            Scanner scanner = new Scanner(System.in);

            System.out.println("Write your thoughts here: ");

            while (true) {
                String line = scanner.nextLine();

                if (line.equalsIgnoreCase("END")) {
                    break;
                }

                bufferedWriter.write(line);
                bufferedWriter.newLine();

            }

            bufferedWriter.flush();
            bufferedWriter.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        
    }

        /* public void askAndWrite() {
    try (
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Output2.txt"));
         Scanner scanner = new Scanner(System.in)) {

        System.out.println("Write your thoughts (type 'END' to finish):");

        while (true) {
            String line = scanner.nextLine();

            if (line.equalsIgnoreCase("END")) {
                break;
            }

            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        scanner.close();
        bufferedWriter.flush();
        bufferedWriter.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
} */
    
}
