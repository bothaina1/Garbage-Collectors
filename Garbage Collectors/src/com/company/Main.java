package com.company;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File rootsFile=new File("roots.txt");
        File heapFile=new File("heap.csv");
        File pointersFile=new File("pointers.csv");
        controller compact=new controller(rootsFile,heapFile,pointersFile);



    }
}
