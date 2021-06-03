package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class compactGarbageCollector {
    Queue<Integer> roots;
    Heap heap;
    LinkedList<Node> blocks;

    public compactGarbageCollector(Heap heap,Queue roots,LinkedList blocks){
        this.roots=roots;
        this.heap=heap;
        this.blocks=blocks;
    }
}

