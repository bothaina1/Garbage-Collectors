package GarbageCollector;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String rootsFile=null ;
        String heapFile=null ;
        String pointersFile=null;
        String destinationFile =null;
        try {
              rootsFile = args[0];
              heapFile = args[1];
              pointersFile = args[2];
              destinationFile = args[3];
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException caught");
        }
        finally {

        }
/*
        String rootsFile = "roots.txt";
        String heapFile = "heap.csv";
        String pointersFile = "pointers.csv";
        String destinationFile = "newheap.csv";
*/
        controller controller =new controller(new File(rootsFile),new File(heapFile),new File(pointersFile));
        controller.getNewCompactHeap(destinationFile);




    }
}
