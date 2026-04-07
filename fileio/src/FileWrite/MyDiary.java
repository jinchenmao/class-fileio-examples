package FileWrite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class MyDiary {

    public void writeToMyDiary(){
        String output = "MyDiary.txt";

        try{
            FileWriter fileWriter = new FileWriter(output);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("Dear Diary,");
            bufferedWriter.newLine();
            bufferedWriter.write("Today was a good day.");
            bufferedWriter.newLine();
            bufferedWriter.write("I learned how to write to a file in Java.");
            
            
            bufferedWriter.flush();
            bufferedWriter.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }    

    public void askAndWrite(){
        String output = "MyDiary.txt";
        String line = "";

        try{
            FileWriter fileWriter = new FileWriter(output);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Start writing in your diary. Type 'exit' to stop writing.");

            while(true){
                line = scanner.nextLine();
                if(line.equalsIgnoreCase("exit")){
                    break;
                }
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            
            bufferedWriter.flush();
            bufferedWriter.close();
            scanner.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
