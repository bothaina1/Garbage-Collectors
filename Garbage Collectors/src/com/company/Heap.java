package com.company;

import java.util.*;

public class Heap {
    private Map<Integer, ArrayList<Integer>> adjNodes;


    public Heap(){
      adjNodes= new LinkedHashMap<>();
    }

    void addVertex(int value,int memoryStart,int memoryEnd) {

        ArrayList<Integer> children=new ArrayList<>();
        adjNodes.putIfAbsent(value,children);
    }


    void addEdge(int value1, int value2) {

          adjNodes.get(value1).add(value2);
    }



}
