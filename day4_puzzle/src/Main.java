import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        FileReader reader = new FileReader(new File("./input.txt"));

        ArrayList<String> inputLines = reader.readFile();

        int overlapCount = 0;
        int containsCount = 0;
        for(String line : inputLines){
            String[] sections = line.split(",");
            String[] section1 = sections[0].split("-");
            String[] section2 = sections[1].split("-");

            if(sectionIsContained(section1,section2)) overlapCount +=1;
            if(sectionIsOverlap(section1,section2)) containsCount +=1;
        }

        System.out.println(containsCount);
        System.out.println(overlapCount);
    }

    static boolean sectionIsContained(String[] range1, String[] range2){
        ArrayList<Integer> intRange1 = new ArrayList<>();
        intRange1.add(Integer.parseInt(range1[0]));
        intRange1.add(Integer.parseInt(range1[1]));
        ArrayList<Integer> intRange2 = new ArrayList<>();
        intRange2.add(Integer.parseInt(range2[0]));
        intRange2.add(Integer.parseInt(range2[1]));

        return (intRange1.get(0) <= intRange2.get(0)
                && intRange1.get(1) >= intRange2.get(1))
                || (intRange1.get(0)  >= intRange2.get(0)
                && intRange1.get(1)  <= intRange2.get(1));
    }


    static boolean sectionIsOverlap(String[] range1, String[] range2){
        ArrayList<Integer> intRange1 = new ArrayList<>();
        intRange1.add(Integer.parseInt(range1[0]));
        intRange1.add(Integer.parseInt(range1[1]));
        ArrayList<Integer> intRange2 = new ArrayList<>();
        intRange2.add(Integer.parseInt(range2[0]));
        intRange2.add(Integer.parseInt(range2[1]));

        return (intRange1.get(0) <= intRange2.get(0)
                && intRange1.get(1) >= intRange2.get(0)) ||
                (intRange2.get(0) <= intRange1.get(0)
                        && intRange2.get(1) >= intRange1.get(0))
                || (intRange2.get(1)  >= intRange1.get(1)
                && intRange2.get(0)  <= intRange1.get(1))
                || (intRange1.get(1)  >= intRange2.get(1)
                && intRange1.get(0)  <= intRange2.get(1));
    }
}