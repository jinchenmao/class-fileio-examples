import java.io.*;
import java.util.Scanner;

public class MyDiary {

    public void writeToMyDiary(){

        String output = "Diary.txt";

        try{

            FileWriter fileWriter = new FileWriter(output);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your diary entry:");

            String line = scanner.nextLine();
            
            bufferedWriter.write(line);
            //bufferedWriter.newLine();

            

                /* bufferedWriter.write("Dear Diary,");
                bufferedWriter.newLine();
                bufferedWriter.write("Today was a good day.");
                bufferedWriter.newLine();
                bufferedWriter.write("I am learning how to read and write files in Java.");
                bufferedWriter.newLine();
                bufferedWriter.write("I am excited to learn more about file handling in Java.");
                bufferedWriter.newLine();
                bufferedWriter.write("Goodnight, Diary."); */
    
                bufferedWriter.flush();

                bufferedWriter.close();

        }catch(Exception e){
            e.printStackTrace();

    }
}
    
}
