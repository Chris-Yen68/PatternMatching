import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeanlee on 2017/10/26.
 */
public class SuffixTree {
    private Node root = new Node();

    public void build(String text){
        int lastIndex = text.length() - 1;
        int index = 0;
        Progress.setup(lastIndex);
        for (int i = 0 ; i < Math.min(lastIndex,i + 200); i++){
            Progress.update( i);
            String temp = text.substring(i,Math.min(lastIndex,i + 200));
            root.add(temp, i);
        }
        Progress.finish();

    }
    public int search(String target){
        return root.result(target);
    }

    public Node getRoot() {
        return root;
    }

    public static void main(String[] args) {
        SuffixTree tree = new SuffixTree();
        tree.build("aaaaaaabbddeeeaaa");
        System.out.println(tree.getRoot().result("e"));
    }


}
