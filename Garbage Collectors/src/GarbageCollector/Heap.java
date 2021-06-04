package GarbageCollector;

import java.util.*;

public class Heap {

    private Map<Node, ArrayList<Node>> adjNodes;


    public Heap(){
      adjNodes= new LinkedHashMap<>();
    }

    void addVertex(int value,int memoryStart,int memoryEnd) {
        Node node=getNode(value);
        if (node==null){
            node=new Node(value);

        }
        node.setMemoryStart(memoryStart);
        node.setMemoryEnd(memoryEnd);
        ArrayList<Node> children=new ArrayList<>();
        adjNodes.putIfAbsent(node,children);
    }

    void removeVertex(int label) {
        Node v = new Node(label);
        adjNodes.values().stream().forEach(e -> e.remove(v));
        adjNodes.remove(new Node(label));
    }

    void addEdge(int value1, int value2) {
          Node node1=getNode(value1);
          Node node2=getNode(value2);
          node2.incrementEdges();
          adjNodes.get(node1).add(node2);
    }

    public Node getNode(int value){
        Set<Node> keys = adjNodes.keySet();
        for (Node node : keys) {
            if(node.getValue()==value){
                return node;
            }
        }
        return null;
    }

    public Map.Entry<Node, ArrayList<Node>> getEntry(Node node){
        for (Map.Entry<Node, ArrayList<Node>> entry : adjNodes.entrySet()) {
            if(entry.getKey()==node){
                return entry;
            }
        }
        return null;
    }

    public Map<Node, ArrayList<Node>> getAdjNodes() {
        return adjNodes;
    }

    public void setAdjNodes(Map<Node, ArrayList<Node>> adjNodes) {
        this.adjNodes = adjNodes;
    }

    public ArrayList<Integer> getChildren(int value) {
        ArrayList<Integer> children = new ArrayList<>();
        for (Node child :adjNodes.getOrDefault(getNode(value),null) ){
            children.add(child.getValue());
        }
        Collections.sort(children);
        return children;
    }

}
