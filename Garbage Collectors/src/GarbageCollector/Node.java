package GarbageCollector;

public class Node {
    private int value;
    private int memoryStart;
    private int memoryEnd;
    private int numberOfEdges;
    private boolean tested;


    public Node(int value){
        this.value=value;
        this.tested=false;
        numberOfEdges=0;
    }

    public boolean isTested() {
        return this.tested;
    }

    public void setTested(boolean tested) {
        this.tested = tested;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMemoryStart() {
        return memoryStart;
    }

    public void setMemoryStart(int memoryStart) {
        this.memoryStart = memoryStart;
    }

    public int getMemoryEnd() {
        return memoryEnd;
    }

    public void setMemoryEnd(int memoryEnd) {
        this.memoryEnd = memoryEnd;
    }

    public boolean isGarbٍage() {
        return tested;
    }

    public void setGarbٍage(boolean garbٍage) {
        this.tested = garbٍage;
    }

    public void incrementEdges(){
        numberOfEdges++;
    }
    public void decrementEdges(){
        numberOfEdges--;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }


}
