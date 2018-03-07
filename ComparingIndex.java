import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jeanlee on 2017/10/31.
 */
public class ComparingIndex {
    private  ArrayList<Node> nodeArrayList = new ArrayList<>();
    public void add(Set<Node> nodes){
        for (Node node : nodes){
            nodeArrayList.add(node);
            if (!node.getNodes().isEmpty()){
                add(node.getNodes());
            }
        }
    }
    public  int compare(){
        int mini = 0;
        for (Node node : nodeArrayList) {
            if (node.getIndex() <= mini && node.getIndex() != -1) {
                mini = node.getIndex();
            }
        }
        return mini;
    }

    public static void main(String[] args) {
        Set<Node> nodes = new HashSet<>();
        nodes.add(new Node("a",1));
        nodes.add(new Node("b",2));
        nodes.add(new Node("c",0));
        Node a = new Node("d",5);
        Set<Node> nodes1 = new HashSet<>();
        nodes1.add(new Node("2",-1));
        a.setNodes(nodes1);
        nodes.add(a);
        ComparingIndex index =  new ComparingIndex();
        index.add(nodes);
        System.out.println(index.compare());
    }
}
