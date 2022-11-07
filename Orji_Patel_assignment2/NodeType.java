package Orji_Patel_assignment2;

public class NodeType<T extends Comparable<T>> {
    public T info;
    public NodeType<T> next;
    public NodeType<T> back;

    NodeType (T info) {
        this.next = null;
        this.info = info;
    }
    }//NodeType




    