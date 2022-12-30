package Orji_Patel_assignment3;

import java.util.Scanner;
import java.io.*;

public class BinarySearchTreeDriver {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String args[]) throws IOException {
        Scanner keyboard = new Scanner(System.in);

        BinarySearchTree<Integer> list = new BinarySearchTree<>();
        BinarySearchTree<Double> dlist = new BinarySearchTree<>();
        BinarySearchTree<String> slist = new BinarySearchTree<>();

        if (args.length != 1) { // if args don't equal one then that means no file
            System.out.println("No input file");
            return;
        } // if

        System.out.println("Enter list type (i - int, d - double, s - string):");
        char listType = keyboard.next().charAt(0);

        try {
            Scanner scanner = new Scanner(new File(args[0])); // open file
            if (listType == 'i') {
                int num = 0;
                while (scanner.hasNextInt()) {// add each # to list individually then convert to int
                    num = scanner.nextInt();
                    list.insert(num);
                } // while

            } // if-i
            if (listType == 'd') {
                double num = 0d;
                while (scanner.hasNextDouble()) {// add each # to list individually then convert to int
                    num = scanner.nextDouble();
                    dlist.insert(num);

                } // while

            } // elseif-d
            if (listType == 's') {
                String num;
                while (scanner.hasNext()) {// add each # to list individually then convert to int
                    num = scanner.next();
                    slist.insert(num);
                } // while

            } // elseif-d
        } // try
        catch (FileNotFoundException e) {
            System.out.println("Unable to open file");// file doesn't exist
            return;
        } // catch

        // Menu
        System.out.println("Commands:");
        System.out.println("(i) - Insert Item");
        System.out.println("(d) - Delete Item");// need
        System.out.println("(p) - Print Tree");
        System.out.println("(r) - Retrieve Item");
        System.out.println("(l) - Count Leaf Nodes");
        System.out.println("(s) - Find Single Parents");
        System.out.println("(c) - Find cousins");// need
        System.out.println("(q) - Quit program");

        while (true) {

            System.out.print("\nEnter a command: ");
            String user = keyboard.next();// Where user will input command

            if (user.equals("q")) {
                System.out.println("Exiting the program...");
                System.exit(0);
            } // if-q
            else if (user.equals("p")) {
                System.out.print("In-order: ");
                if (listType == 'i') {
                    list.inOrder(list.getRoot());
                }
                if (listType == 'd') {
                    dlist.inOrder(dlist.getRoot());
                }
                if (listType == 's') {
                    slist.inOrder(slist.getRoot());
                }
            } // else if-p
            else if (user.equals("i")) {
                if (listType == 'i') {
                    System.out.print("In-order: ");
                    list.inOrder(list.getRoot());// print the original list
                    System.out.println("\nEnter a number to insert: ");
                    int insertNum = keyboard.nextInt();
                    list.insert(list.getRoot(), insertNum); // create a new insert object
                    System.out.print("\nIn-order: ");
                    list.inOrder(list.getRoot());// print the updated list
                }
                if (listType == 'd') {// not sorted
                    System.out.print("In-order: ");
                    dlist.inOrder(dlist.getRoot());
                    System.out.println("\nEnter a number to insert: ");
                    double insertNum = keyboard.nextDouble();
                    dlist.insert(dlist.getRoot(), insertNum); // create a new insert object
                    System.out.print("\nIn-order: ");
                    dlist.inOrder(dlist.getRoot());// print the updated list

                }
                if (listType == 's') {
                    System.out.print("In-order: ");
                    slist.inOrder(slist.getRoot());
                    System.out.println("\nEnter a string to insert: ");
                    String insertStr = keyboard.next();
                    slist.insert(slist.getRoot(), insertStr); // create a new insert object
                    System.out.print("\nIn-order: ");
                    slist.inOrder(slist.getRoot());// print the updated list
                }

            } // else if-i
            else if (user.equals("d")) {
                if(listType == 'i') {
                    System.out.print("In-order: ");
                    list.inOrder(list.getRoot());// print the original list
                    System.out.println("\nEnter a number to delete: ");
                    int deletetNum = keyboard.nextInt();
                    list.delete(list.getRoot(), deletetNum); // create a new insert object
                    System.out.print("\nIn-order: ");
                    list.inOrder(list.getRoot());// print the updated list

                }
                if(listType == 'd') {
                    System.out.print("In-order: ");
                    dlist.inOrder(dlist.getRoot());// print the original list
                    System.out.println("\nEnter a number to delete: ");
                    double deletetNum = keyboard.nextDouble();
                    dlist.delete(dlist.getRoot(), deletetNum); // create a new insert object
                    System.out.print("\nIn-order: ");
                    dlist.inOrder(dlist.getRoot());// print the updated list

                }
                if(listType == 's') {
                    System.out.print("In-order: ");
                    slist.inOrder(slist.getRoot());// print the original list
                    System.out.println("\nEnter a string to delete: ");
                    String deletetNum = keyboard.next();
                    slist.delete(slist.getRoot(), deletetNum); // create a new insert object
                    System.out.print("\nIn-order: ");
                    slist.inOrder(slist.getRoot());// print the updated list

                }
            }//if-q
            else if (user.equals("r")) {// come back to this
                if (listType == 'i') {
                    System.out.print("In-order: ");
                    list.inOrder(list.getRoot());// print the original list
                    System.out.print("\nEnter a number to search: ");
                    int searchNum = keyboard.nextInt();
                    list.retrieve(searchNum);
                }

                if (listType == 'd') {
                    System.out.print("In-order: ");
                    dlist.inOrder(dlist.getRoot());// print the original list
                    System.out.print("\nEnter a number to search: ");
                    double searchNum = keyboard.nextDouble();
                    dlist.retrieve(searchNum);

                }
                if (listType == 's') {
                    System.out.print("In-order: ");
                    slist.inOrder(slist.getRoot());// print the original list
                    System.out.print("\nEnter a string to search: ");
                    String searchNum = keyboard.next();
                    slist.retrieve(searchNum);
                }

            } // else if-r
            if (user.equals("l")) {
                if (listType == 'i') {
                    System.out.println("The number of leaf nodes are ");
                    list.getNumLeafNodes();
                }
                if (listType == 'd') {
                    System.out.println("The number of leaf nodes are ");
                    dlist.getNumLeafNodes();
                }
                if (listType == 's') {
                    System.out.println("The number of leaf nodes are ");
                    slist.getNumLeafNodes();
                }

            } // if-l
            if (user.equals("s")) {
                if (listType == 'i') {
                    System.out.println(" Single Parents: ");
                    list.getSingleParent();
                }
                if (listType == 'd') {
                    System.out.println(" Single Parents: ");
                    dlist.getSingleParent();
                }
                if (listType == 's') {
                    System.out.println(" Single Parents: ");
                    slist.getSingleParent();
                }
            } // if-l

        } // while

    }// main

}
