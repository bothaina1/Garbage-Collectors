package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class controller {
    Queue<Integer> roots;
    Heap heap;
    compactGarbageCollector compact;
    copyGarbageColllector copy;

    public controller(File rootFile, File heapFile, File pointerFile) throws FileNotFoundException {
        roots=new PriorityQueue<>();
        heap =new Heap();
        this.setRoots(rootFile);
        this.setHeap(heapFile,pointerFile);

    }

    public void setHeap(File heapFile,File pointerFile) throws FileNotFoundException {
        Scanner sc = new Scanner(heapFile);
        //sets the delimiter pattern
        sc.useDelimiter(",|\\n");
        while (sc.hasNext())  //returns a boolean value
        {
            int value= Integer.parseInt(sc.next().replaceAll("[\\D]", ""));
            int memoryStart=Integer.parseInt(sc.next().replaceAll("[\\D]", ""));
            int memoryEnd=Integer.parseInt(sc.next().replaceAll("[\\D]", ""));
            heap.addVertex(value,memoryStart,memoryEnd);

        }
        sc.close();
        sc = new Scanner(pointerFile);
        sc.useDelimiter(",|\\n");
        while (sc.hasNext())  //returns a boolean value
        {
            int parent=Integer.parseInt(sc.next().replaceAll("[\\D]", ""));
            int child=Integer.parseInt(sc.next().replaceAll("[\\D]", ""));
            heap.addEdge(parent,child);
        }
        sc.close();

    }
    public void setRoots(File rootFile) throws FileNotFoundException {
        Scanner sc = new Scanner(rootFile);
        while (sc.hasNext()) {
            roots.add(Integer.parseInt(sc.nextLine()));  //find and returns the next complete token from this scanner
        }
        sc.close();  //closes the scanner

    }
    public void getCopyHeap(){
        copy=new copyGarbageColllector(heap,roots);
    }
    public void getCompactHeap(){
        compact=new compactGarbageCollector(heap,roots);
    }

}
