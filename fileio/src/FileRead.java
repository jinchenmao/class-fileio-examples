import java.io.BufferedReader;
import java.io.FileReader;

public class FileRead {

    public void readFIle(){
        String inputFile = "/Users/prabhatram/Downloads/readFile.rtf";
        try{
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            while(line != null){
                System.out.println(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();

        }catch(Exception e){
            e.printStackTrace();    
    }
    
}}
