package FileRead;

import java.io.*;


public class NurseryRhyme {

    public void readNurseryRhyme(){
        String input = "nurseryRhymes.txt";

        String s = "";

        try{
            FileReader fileReader = new FileReader(input);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            s = bufferedReader.readLine();
            while((s = bufferedReader.readLine()) != null){
                System.out.println(s);
                //s = bufferedReader.readLine();
            
            }
            bufferedReader.close();

        }catch(Exception e){
            e.printStackTrace();    
        }
    
    }
}
