package com.company;

public class Node {
    int value;
    int memoryStart;
    int memoryEnd;
    boolean garbٍage;

    public Node(int value){
        this.value=value;
        garbٍage=true;
    }

    public boolean isgarbٍage() {
        return garbٍage;
    }

    public void setgarbٍage(boolean isgarbٍage) {
        garbٍage = isgarbٍage;
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
        return garbٍage;
    }

    public void setGarbٍage(boolean garbٍage) {
        this.garbٍage = garbٍage;
    }

}
