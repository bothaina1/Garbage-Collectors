package com.company;

import java.util.Queue;

public class copyGarbageColllector {
    Queue<Integer> roots;
    Heap heap;

    public copyGarbageColllector(Heap heap,Queue roots){
        this.roots=roots;
        this.heap=heap;
    }
}
