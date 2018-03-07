import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jeanlee on 2017/10/26.
 */
public class Node {

    private Set<Node> nodes = new HashSet<>();
    private String content = "";
    private int index = -1;

    public void setContent(String content) {
        this.content = content;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Node() {
    }

    public Node(String content, int index) {
        this.content = content;
        this.index = index;
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public String getContent() {
        return content;
    }

    public int getIndex() {
        return index;
    }
    public void addChild(Node child){
        nodes.add(child);
    }

    public int result(String target){
        int result = -1;
        result = search(target);
        return result;
    }

    private int search(String target) {
        int result = -1;
        if (!nodes.isEmpty()) {
            for (Node child : nodes) {
                if (CompareString.completedMatched(child.getContent(), target)) {
                    String[] group = CompareString.ToSplit(child.getContent(), target);
                    if (group[1] != null && group[0] == null) {
                        result = child.search(group[1]);
                    } else if (group[0] == null && group[1] == null) {
                        if (child.getNodes().isEmpty()) {
                            result = child.getIndex();
                        } else {
                            ComparingIndex comparingIndex = new ComparingIndex();
                            comparingIndex.add(child.getNodes());
                            result = comparingIndex.compare();
                        }

                    } else if (group[0] != null && group[1] == null) {
                        if (!child.getNodes().isEmpty()) {
                            ComparingIndex comparingIndex = new ComparingIndex();
                            comparingIndex.add(child.getNodes());

                            result = comparingIndex.compare();
                        } else {
                            result = child.getIndex();
                        }
                    }

                }
            }
        }
        return result;
    }

    public void add(String text, int index){
        if (this.getNodes().isEmpty() ){
            Node node = new Node(text,index);
            this.getNodes().add(node);
        }else {
            boolean hasFound = false;
            for (Node child : this.getNodes()){
                if (CompareString.isMatched(child.getContent(), text)){
                    hasFound = true;
                }
            }
            if (!hasFound){
//                for (Node child : this.getNodes().keySet()){
//                    if (CompareString.isMatched(child.getContent(), text)){
//                        String[] group = CompareString.ToSplit(child.getContent(), text);
//                        child.add(group[1], index);
//                    }
                Node node = new Node(text,index);
                this.getNodes().add(node);
            }else {
                for (Node child : this.getNodes()){
                    if (CompareString.isMatched(child.getContent(), text)){
                        String[] group = CompareString.ToSplit(child.getContent(), text);
                        if (group[0] != null && child.getNodes().isEmpty()){
                            child.setContent(child.getContent().substring(0,CompareString.locationOfSplit(child.getContent(),text)));
                            Node node = new Node(group[0],child.getIndex());
                            child.setIndex(-1);
                            child.addChild(node);
                        }else if (group[0] != null && !child.getNodes().isEmpty()){
                            Node node = new Node(group[0], child.getIndex());
                            node.setNodes(child.getNodes());
                            Set<Node> nodes = new HashSet<>();
                            nodes.add(node);
                            child.setNodes(nodes);
                            child.setContent(child.getContent().substring(0,CompareString.locationOfSplit(child.getContent(),text)));

                        }
                        if (group[1] != null) {
                            if (!group[1].equals(child.getContent())) {
                                child.add(group[1], index);
                            }
                        }
                    }
                }
            }


        }
//        if (parent != null){
//
//            if (parent.nodes.isEmpty() && CompareString.isMatched(this.getContent(),text)) {
//                String[] group = CompareString.ToSplit(this.getContent(), text);
//                Node node = new Node(group[1], index);
//                if (group[0] != null && parent.getIndex() != -2) {
//                    Node splitedParent = new Node(group[0], parent.getIndex());
//                    parent.setIndex(-1);
//                    parent.setContent(parent.getContent().substring(0, CompareString.locationOfSplit(this.getContent(), text)));
//                } else if (group[0] != null && parent.getIndex() == -2) {
//                    Node splitedParent = new Node(group[0], parent.getIndex());
//                }
//                parent.addChild(node, text);
//            }
//        }else {
//            boolean hasFound = false;
//            if (parent != null) {
//                if (!parent.getNodes().isEmpty()) {
//                    for (Node child : this.getNodes().keySet()) {
//                        if (CompareString.isMatched(child.getContent(), text)) {
//                            hasFound = true;
//                            String[] group = CompareString.ToSplit(child.getContent(), text);
//                            this.add(child, group[1], index);
//                        }
//
//                    }
//                }
//            }
//            if (!hasFound){
//                Node node = new Node(text,index);
//                this.getNodes().put(node,text);
//
//
//            }
//        }
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }
}
