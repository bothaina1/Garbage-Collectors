package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class compact {
    Stack<Integer> roots;
    Heap heap;

    public compact(File rootFile,File heapFile,File pointerFile) throws FileNotFoundException {
       roots=new Stack<>();
       heap =new Heap();
        this.setRoots(rootFile);
        this.setHeap(heapFile,pointerFile);
    }

    public void setHeap(File heapFile,File pointerFile) throws FileNotFoundException {
        Scanner sc = new Scanner(heapFile);
        sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            int value=Integer.parseInt(sc.next());
            int memoryStart=Integer.parseInt(sc.next());
            int memoryEnd=Integer.parseInt(sc.next());
          heap.addVertex(value,memoryStart,memoryEnd);
        }
        sc.close();
        sc = new Scanner(pointerFile);
        while (sc.hasNext())  //returns a boolean value
        {
            int parent=Integer.parseInt(sc.next());
            int child=Integer.parseInt(sc.next());
            heap.addEdge(parent,child);
        }
        sc.close();

    }
    public void setRoots(File rootFile) throws FileNotFoundException {
        Scanner sc = new Scanner(rootFile);
        while (sc.hasNext()) {
            roots.push(Integer.parseInt(sc.nextLine()));  //find and returns the next complete token from this scanner
        }
        sc.close();  //closes the scanner

    }
}

