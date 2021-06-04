package GarbageCollector;

import java.util.*;

public class compactGarbageCollector {
    LinkedList<Integer> roots;
    Heap heap;

    public compactGarbageCollector(Heap heap,LinkedList roots){
        this.roots=roots;
        this.heap=heap;
        checkHeap();
    }
    public void checkHeap() {
        for (int key : roots) {
            Node n = heap.getNode(key);
            n.incrementEdges();
        }
        Map<Node, ArrayList<Node>> nodes = heap.getAdjNodes();
        checkGarbage(nodes);

    }

    public void checkGarbage( Map<Node, ArrayList<Node>> nodes){
        for (Map.Entry<Node, ArrayList<Node>> entry : nodes.entrySet()) {
                Node currentNode=entry.getKey();
                ArrayList<Node> currentList=entry.getValue();
                if(currentNode.getNumberOfEdges()==0&&!(currentNode.isTested())){
                    currentNode.setTested(true);
                    deleteEdge(entry,nodes);

                }
        }
    }
    public void deleteEdge(Map.Entry<Node, ArrayList<Node>> entry,Map<Node, ArrayList<Node>> nodes){
        for(Node l:entry.getValue()){
            l.decrementEdges();
            if(l.getNumberOfEdges()==0&&!(l.isTested())){
                l.setTested(true);
                Map.Entry<Node, ArrayList<Node>> currentEntry =heap.getEntry(l);
                deleteEdge(currentEntry,nodes);
            }
        }
    }




    }






