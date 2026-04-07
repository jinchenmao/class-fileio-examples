import java.io.*;

public class NurseryRhymeDemo {

    public void readNurseryRhyme(){
        String input = "nurseryRhymes.txt";
        String line = "";

        try{

            FileReader fileReader = new FileReader(input);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();

            while(line !=null){
                System.out.println(line);
                line = bufferedReader.readLine();
            }

            bufferedReader.close();

        }catch(Exception e){
            e.printStackTrace();
        
        }
    
}}
