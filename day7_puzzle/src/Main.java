import java.io.File;
import java.util.ArrayList;

public class Main {
    static SingleDirectory root = new SingleDirectory("root",null);

    static SingleDirectory currentDirectory = root;

    public static void main(String[] args) {
        FileReader reader = new FileReader(new File("./input.txt"));
        ArrayList<String> inputLines = reader.readFile();

        for(int i = 1; i< inputLines.size(); i++){

            String line = inputLines.get(i);
            String[] lineParts = line.split(" ");
            if(line.startsWith("$") && line.contains("ls")){
                i = readFolder(inputLines,i);
            }
            if(lineParts[1].equals("cd") && lineParts[2].equals("..")){
                currentDirectory = currentDirectory.getParentFolder();
            } else if(lineParts[1].equals("cd")){
                currentDirectory = currentDirectory.getSubFolder(lineParts[2]);
            }
        }
        int currentTotalSize = root.getSize();

        int sumOfFolders = 0;
        ArrayList<SingleDirectory> limitedFolders = root.findMaxSizedFolder(100000);

        for (SingleDirectory limitedFolder : limitedFolders) {
            sumOfFolders += limitedFolder.getSize();
        }

        //task 1 answer
        System.out.println("Task 1 answer: "+sumOfFolders);

        ArrayList<SingleDirectory> maxedFolders = root.findMinSizedFolder((30000000+currentTotalSize)-70000000);

        System.out.println("Missing space: " +((30000000+currentTotalSize)-70000000));

        int lowestMax = 99999999;
        for(SingleDirectory maxedFolder: maxedFolders){
            if (maxedFolder.getSize() < lowestMax){
                lowestMax= maxedFolder.getSize();
            }
        }

        //task 2 answer
        System.out.println("Task 2 answer: "+lowestMax);
    }

    public static int readFolder(ArrayList<String> currentPartition,int i){
        int index;
        for(index = i+1; index < currentPartition.size(); index++){

            String line = currentPartition.get(index);
            String[] lineParts = line.split(" ");
            if(lineParts[0].equals("$")) break;
            if(lineParts[0].equals("dir")){
                currentDirectory.addDirectory(new SingleDirectory(lineParts[1],currentDirectory));
            }else{
                currentDirectory.addFile(new SingleFile(lineParts[1],Integer.parseInt(lineParts[0]),currentDirectory));
            }


        }
        return index-1;
    }
}