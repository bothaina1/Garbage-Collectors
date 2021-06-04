package GarbageCollector;

import java.io.File;
import java.io.FileNotFoundException;

public class Main1 {

    public static void main(String[] args) throws FileNotFoundException {

      /*  String rootsFile = args[0];
        String heapFile = args[1];
        String pointersFile = args[2];
        String destinationFile = args[3];
*/

        String rootsFile = "roots.txt";
        String heapFile = "heap.csv";
        String pointersFile = "pointers.csv";
        String destinationFile = "newheap2.csv";
        controller controller =new controller(new File(rootsFile),new File(heapFile),new File(pointersFile));
        controller.getCopyHeap(destinationFile);




    }
}
