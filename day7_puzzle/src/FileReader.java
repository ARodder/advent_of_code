import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    File fileToRead;
    public FileReader(File file){
        this.fileToRead = file;
    }

    ArrayList<String> readFile(){
        ArrayList<String> elfs = new ArrayList<>();

        try{
            Scanner reader = new Scanner(this.fileToRead);

            int i = 0;
            while(reader.hasNextLine()){
                String nextLine = reader.nextLine();
                elfs.add(nextLine);


            }

        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        return elfs;
    }
}
