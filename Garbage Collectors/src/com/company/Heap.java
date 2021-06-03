package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Heap {
    private Map<Node, List<Node>> adjNodes;


    public Heap(){}

    void addVertex(int value,int memoryStart,int memoryEnd) {
        Node node=new Node(value);
        node.setMemoryStart(memoryStart);
        node.setMemoryEnd(memoryEnd);
        adjNodes.putIfAbsent(node, new ArrayList<>());
    }

    void removeVertex(int label) {
        Node v = new Node(label);
        adjNodes.values().stream().forEach(e -> e.remove(v));
        adjNodes.remove(new Node(label));
    }

    void addEdge(int label1, int label2) {
        Node v1 = new Node(label1);
        Node v2 = new Node(label2);
        adjNodes.get(v1).add(v2);
        adjNodes.get(v2).add(v1);
    }

}
