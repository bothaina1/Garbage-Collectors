package GarbageCollector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class controller {
    LinkedList<Integer> roots;
    Heap heap;
    compactGarbageCollector compact;
    copyGarbageCollector copy;

    public controller(File rootFile, File heapFile, File pointerFile) throws FileNotFoundException {
        roots=new LinkedList();
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


    public void getNewCompactHeap(String destinationFile) throws FileNotFoundException {
        compact=new compactGarbageCollector(heap,roots);
        int currentMamoryStart = 0;
        List<String[]> dataLines = new ArrayList<>();
        File csvOutputFile = new File(destinationFile);


        for (Map.Entry<Node, ArrayList<Node>> entry : heap.getAdjNodes().entrySet()) {
            Node node = entry.getKey();
            if (!(node.getNumberOfEdges() == 0)) {
                int memorySize = node.getMemoryEnd() - node.getMemoryStart();
                dataLines.add(new String[]
                        {String.valueOf(node.getValue()), String.valueOf(currentMamoryStart), String.valueOf(currentMamoryStart + memorySize)});

                currentMamoryStart += memorySize +1;
            }
        }
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        }
    }




    public void getCopyHeap(String destinationFile) throws FileNotFoundException {
        copy = new copyGarbageCollector(heap,roots);
        Heap newHeap = copy.createHeap();
        List<String[]> dataLines = new ArrayList<>();
        File csvOutputFile = new File(destinationFile);

        for (Map.Entry<Node, ArrayList<Node>> nodeArrayListEntry : newHeap.getAdjNodes().entrySet()) {
            Node node = (Node) ((Map.Entry) nodeArrayListEntry).getKey();
            dataLines.add(new String[]
                    {String.valueOf(node.getValue()), String.valueOf(node.getMemoryStart()), String.valueOf(node.getMemoryEnd())});
        }
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        }
    }

    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

}
