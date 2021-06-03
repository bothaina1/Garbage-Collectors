package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class copyGarbageColllector {
    Queue<Integer> roots;
    Heap heap;
    LinkedList<Node> blocks;

    public copyGarbageColllector(Heap heap,Queue roots,LinkedList blocks){
        this.roots=roots;
        this.heap=heap;
        this.blocks=blocks;
    }
}
