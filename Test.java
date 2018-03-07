import file.FileReader;
import file.FileWriter;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jeanlee on 2017/10/30.
 */
public class Test {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String text = FileReader.read(new File("test case 1/string.txt"));
        SuffixTree tree = new SuffixTree();
        tree.build(text);
        FileReader fileReader = new FileReader(new File("test case 1/patterns.txt"));
        String line1 = fileReader.nextLine();
        int numberOfPatterns = Integer.parseInt(line1);
        FileWriter fileWriter = FileWriter.on("files/Output1.txt");
        String[] groups = new String[numberOfPatterns];
        for (int i = 0; i < groups.length; i++){
            groups[i] = fileReader.nextLine();
        }
        for (int i = 0; i < groups.length; i++) {
            fileWriter.println(String.valueOf(tree.search(groups[i])));
        }
        fileWriter.close();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
