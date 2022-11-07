package Orji_Patel_assignment2;

import java.util.Scanner;
import java.io.*;

public class DoublyLinkedListDriver {
    // private DoublyLinkedList <Integer> list;

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        DoublyLinkedList<Double> dlist = new DoublyLinkedList<>();
        DoublyLinkedList<String> slist = new DoublyLinkedList<>();

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
                    // System.out.println(num);
                    // System.out.println(item.getValue());
                    list.insertItem(num);
                } // while

            } // if-i
            if (listType == 'd') {
                double num = 0d;
                while (scanner.hasNextDouble()) {// add each # to list individually then convert to int
                    num = scanner.nextDouble();
                    // System.out.println(num);
                    // System.out.println(item.getValue());
                    dlist.insertItem(num);// check on this

                } // while

            } // elseif-d
            if (listType == 's') {
                String num;
                while (scanner.hasNext()) {// add each # to list individually then convert to int
                    num = scanner.next();
                    // System.out.println(num);
                    // System.out.println(item.getValue());
                    slist.insertItem(num);// check on this

                } // while

            } // elseif-d
        } // try
        catch (FileNotFoundException e) {
            System.out.println("Unable to open file");// file doesn't exist
            return;
        } // catch

        // Menu
        System.out.println("Commands:");
        System.out.println("(i) - Insert value");
        System.out.println("(d) - Delete value");
        System.out.println("(p) - Print list");
        System.out.println("(l) - Print length");
        System.out.println("(t) - Print reverse");
        System.out.println("(r) - Reverse list");
        System.out.println("(b) - Delete Subsection");
        System.out.println("(s) - Swap alternate");
        System.out.println("(q) - Quit program");

        // System.out.println("head: " + list.getHead().getInfo().getValue());
        // System.out.println("");

        while (true) {

            System.out.println("\nEnter a command: ");
            String user = keyboard.next();// Where user will input command

            if (user.equals("q")) {
                System.out.println("Exiting the program...");
                System.exit(0);
            } // if-q
            else if (user.equals("p")) {
                System.out.print("The list is: ");
                if (listType == 'i') {
                    list.print();
                }
                if (listType == 'd') {
                    dlist.print();
                }
                if (listType == 's') {
                    slist.print();
                }
            } // else if-p
            else if (user.equals("i")) {
                if (listType == 'i') {
                    System.out.println("Enter a number to insert: ");
                    int insertNum = keyboard.nextInt();
                    System.out.print("\nOrginal list: ");
                    list.print();
                    list.insertItem(insertNum); // create a new insert object
                    System.out.print("\nNew list: ");
                    list.print();// print the updated list
                    System.out.print("\nThe reverse list: ");
                    list.printReverse();
                }

                if (listType == 'd') {// not sorted
                    System.out.println("Enter a number to insert: ");
                    double insertNum = keyboard.nextDouble();
                    System.out.print("\nOrginal list: ");
                    dlist.print();
                    dlist.insertItem(insertNum); // create a new insert object
                    System.out.print("\nNew list: ");
                    dlist.print();// print the updated list
                    System.out.print("\nThe reverse list: ");
                    dlist.printReverse();
                }

                if (listType == 's') {
                    System.out.println("Enter a string to insert: ");
                    String insertStr = keyboard.next();
                    System.out.print("\nOrginal list: ");
                    slist.print();
                    slist.insertItem(insertStr); // create a new insert object
                    System.out.print("\nNew list: ");
                    slist.print();// print the updated list
                    System.out.print("\nThe reverse list: ");
                    slist.printReverse();
                }
            } // else if-i
            else if (user.equals("d")) {
                if (listType == 'i') {

                    System.out.println("Enter a number to delete: ");
                    int deleteNum = keyboard.nextInt();
                    System.out.print("Orginal list: ");
                    list.print();
                    list.deleteItem(deleteNum);
                    System.out.print("\nNew list: ");
                    list.print();
                    System.out.print("\nThe reverse list: ");
                    list.printReverse();
                }

                if (listType == 'd') {

                    System.out.println("Enter a number to delete: ");
                    double deleteNum = keyboard.nextDouble();
                    System.out.print("Orginal list: ");
                    dlist.print();
                    dlist.deleteItem(deleteNum);
                    System.out.print("\nNew list: ");
                    dlist.print();
                    System.out.print("\nThe reverse list: ");
                    dlist.printReverse();
                }

                if (listType == 's') {
                    System.out.println("Enter a string to delete: ");
                    String deleteNum = keyboard.next();
                    System.out.print("Orginal list: ");
                    slist.print();
                    slist.deleteItem(deleteNum);
                    System.out.print("\nNew list: ");
                    slist.print();
                    System.out.print("\nThe reverse list: ");
                    slist.printReverse();
                }
            } // if

            else if (user.equals("l")) {
                if (listType == 'i') {
                    System.out.println("The length of the list is: " + list.getLength());
                }
                if (listType == 'd') {
                    System.out.println("The length of the list is: " + dlist.getLength());
                }
                if (listType == 's') {
                    System.out.println("The length of the list is: " + slist.getLength());
                }
            } // else if-l
            else if (user.equals("t")) {
                System.out.print("\nThe reverse list: ");
                if (listType == 'i') {
                    list.printReverse();
                }
                if (listType == 'd') {
                    dlist.printReverse();
                }
                if (listType == 's') {
                    slist.printReverse();
                }

            } // else if-l
            else if (user.equals("r")) {// come back to this
                System.out.print("\nThe original list:");
                if (listType == 'i') {
                    list.print();
                }
                if (listType == 'd') {
                    dlist.print();
                }
                if (listType == 's') {
                    slist.print();
                }
                System.out.print("\nThe reverse list: ");
                if (listType == 'i') {
                    list.reverseList();
                }
                if (listType == 'd') {
                    dlist.reverseList();
                }
                if (listType == 's') {
                    slist.reverseList();
                }
            } // else if-l

            else if (user.equals("b")) {
                if (listType == 'i') {
                    System.out.print("Enter the lower bound: ");
                    int lowerBound = keyboard.nextInt();
                    System.out.print("Enter the upper bound: ");
                    int upperBound = keyboard.nextInt();
                    System.out.print("\nThe original list:");
                    list.print();
                    System.out.print("\nThe modified list:");
                    list.deleteSubsection(lowerBound, upperBound);
                    list.print();
                    System.out.print("\nThe reverse list: ");
                    list.printReverse();
                }

                if (listType == 'd') {
                    System.out.print("Enter the lower bound: ");
                    double lowerBound = keyboard.nextDouble();
                    System.out.print("Enter the upper bound: ");
                    double upperBound = keyboard.nextDouble();
                    System.out.print("\nThe original list:");
                    dlist.print();
                    System.out.print("\nThe modified list:");
                    dlist.deleteSubsection(lowerBound, upperBound);
                    dlist.print();
                    System.out.print("\nThe reverse list: ");
                    dlist.printReverse();
                }

            } // else if-p

            else {
                if (!user.equals("i") || !user.equals("d") || !user.equals("s") || !user.equals("n")
                        || !user.equals("r")
                        || !user.equals("a") || !user.equals("m") || !user.equals("t") || !user.equals("p")
                        || !user.equals("l") || !user.equals("q")) {
                    System.out.println("Invalid command try again: ");
                } // else
            } // else

        } // while

    }// main
}
