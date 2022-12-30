package Orji_Patel_assignment3;

public class NodeType<T extends Comparable<T>> {
    public T info;
    public NodeType<T> left;
    public NodeType<T> right;

    NodeType (T info) {
        this.left = null;
        this.right = null;
        this.info = info;
    }
    }//NodeType




    