package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class compactGarbageCollector {
    Queue<Integer> roots;
    Heap heap;

    public compactGarbageCollector(Heap heap,Queue roots){
        this.roots=roots;
        this.heap=heap;
    }

    
}

