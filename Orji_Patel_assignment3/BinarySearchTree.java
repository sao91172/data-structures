package Orji_Patel_assignment3;

public class BinarySearchTree<T extends Comparable<T>> {

    private NodeType<T> root;

    boolean found;
    /* 
     * Constructor 
    */
    BinarySearchTree() {
        root = null;
    }

    /**
     * Deletes selected node in tree
     * Case 1: delete node with one child
     * Case 2: with two children
     * Case 3: with no child
     * Case 4: key not present in tree
     * 
     * @param tree
     * @param key
     */
    public NodeType<T> delete(NodeType<T> tree, T key) {
        if (root == null) { // if tree is empty
            return root;
        }
        if (tree == null) {
            System.out.println("The number is not present in the tree.");
        }
        if (key.compareTo(tree.info) < 0) { // recur
            tree.left = delete(tree.left, key);
        } else if (key.compareTo(tree.info) > 0) {
            tree.right = delete(tree.right, key);
        } else {
            if(tree.left == null & tree.right == null) {
                return null;
            } else if (tree.left == null) {
                tree = tree.right;
            }  else if (tree.right == null) {
                tree = tree.left;
            } else {
                tree.info = GetPredecessor(tree.left);
                tree.left = delete(tree.left,tree.info); 

            }

        } // else
        return tree;
    }// deleteItem



    /**
     * if the subtree doesn't exist then the predecessor can be
     * one of its ancestor
     * @param tree
     * @return
     */
    public T GetPredecessor(NodeType<T> tree) {
        T data = tree.info;
        while(tree.right != null) {
            tree = tree.right;
        }
        data = tree.info;
        return data;
    }

    public void delete(T key) {
        root = delete(root, key);
    }

    /**
     * Insert a node with the value of key into the tree.
     * No duplicates allowed
     * @param tree
     * @param key
     * @return
     */
    public NodeType<T> insert(NodeType<T> tree, T key) {

        if (tree == null) {
            tree = new NodeType<>(key);
            tree.right = null;
            tree.left = null;
            tree.info = key;
        } else if (key.compareTo(tree.info) < 0) {
            tree.left = insert(tree.left, key);
        } else if (key.compareTo(tree.info) > 0) {
            tree.right = insert(tree.right, key);
        } else {
            System.out.println("The item already exists in the tree.");
        }
        return tree;
    }// insert

    public void insert(T key) {
        root = insert(root, key);
    }


    /**
     * Helper function that allows us to call the 
     * root object in the main
     * @return
     */
    public NodeType<T> getRoot() {
        return root;
    }// getLength

    /**
     * Prints out the tree in-order
     * @param tree
     */
    public void inOrder(NodeType<T> tree) {// check this
        if (tree == null) {
            return;
        }
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(tree.info + " ");
            inOrder(tree.right);
        } // if

    }// inOrder

    /**
     * Searches and retrieves item in tree
     * @param tree
     * @param item
     * @param found
     * @return
     */
    public boolean retrieve(NodeType<T> tree, T item, boolean found) {// check this
        if (tree == null) {
            found = false; // item not found
            System.out.println("Item is not present in the tree.");
        } else if (item.compareTo(tree.info) < 0) {
            retrieve(tree.left, item, found);
        } else if (item.compareTo(tree.info) > 0) {
            retrieve(tree.right, item, found);
        } else {
            item = tree.info;
            found = true;
            System.out.println("Item is present in the tree.");
        }
        return found;
    }// retrieve

    public boolean retrieve(T item) {

        return retrieve(root, item, found);
    }

    /**
     * prints the nodes that have one child
     * 
     * @param root
     */
    void getSingleParent(NodeType<T> root) { // O(N) - not working
        if (root == null) {
            return;
        }
        // internal node-check both left and right branches
        if (root.left != null && root.right != null) {
            getSingleParent(root.left);
            getSingleParent(root.right);
            //// If left child is NULL and right is not, print right child and recur for
            //// right child
        } else if (root.right != null && root.left == null) {
            System.out.print(root.info + " ");
            getSingleParent(root.right);

            // If right child is NULL and left is not, print left child and recur for left
            // child
        } else if (root.left != null && root.right == null) {
            System.out.print(root.info + " ");
            getSingleParent(root.left);
        }

    }

    void getSingleParent() {
        getSingleParent(root);
    }

    /* Function to get the count of leaf nodes in a binary tree (helper) */
    int getNumLeafNodes() {
        System.out.print(getNumLeafNodes(root));
        return getNumLeafNodes(root);
    }

    /**
     * count the number of leaf nodes in the BST (Nodes
     * with no children) and then output the count
     * 
     * @param tree
     * @return
     */
    int getNumLeafNodes(NodeType<T> tree) // O(N)
    {
        if (tree == null)
            return 0;
        if (tree.left == null && tree.right == null)
            return 1;
        else
            return getNumLeafNodes(tree.left) + getNumLeafNodes(tree.right);

    }

}
