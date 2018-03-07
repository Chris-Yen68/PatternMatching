import file.FileReader;
import file.FileWriter;

import java.io.File;

/**
 * Created by jeanlee on 2017/10/31.
 */
public class ForceTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String text = FileReader.read(new File("test case 2/string.txt"));
        BruteForce force = new BruteForce();
        FileReader fileReader = new FileReader(new File("test case 2/patterns.txt"));
        String line1 = fileReader.nextLine();
        int numberOfPatterns = Integer.parseInt(line1);
        FileWriter fileWriter = FileWriter.on("files/Output12.txt");
        String[] groups = new String[numberOfPatterns];
        for (int i = 0; i < groups.length; i++){
            groups[i] = fileReader.nextLine();
        }
        for (int i = 0; i < groups.length; i++) {
            fileWriter.println(String.valueOf(force.serach(text,groups[i])));

        }
        fileWriter.close();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

    }
}
