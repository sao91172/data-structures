package Orji_Patel_assignment1;
import java.util.Scanner;


import java.io.*;

public class LinkedListDriver {
    private SortedLinkedList list;

    
    /**
     * @param args
     * @throws IOException
     */
    public static void main (String[] args) throws IOException {


        SortedLinkedList list = new SortedLinkedList();
        if(args.length!= 1) { //if args don't equal one then that means no file
            System.out.println("No input file");
            return;
        }//if

        int num = 0;
        try {
            Scanner scanner = new Scanner(new File(args[0])); //open file
            while(scanner.hasNextInt()) {//add each # to list individually then convert to int 
                num = scanner.nextInt();
                ItemType item = new ItemType(num);
                //System.out.println(num);
                //System.out.println(item.getValue());
                list.insertItem(item);//check on this

            }
        }//try
        catch (FileNotFoundException e) {
            System.out.println("Unable to open file");//file doesn't exist
            return;
        }//catch


        //Menu
        System.out.println("Commands:");
        System.out.println("(i) - Insert value");
        System.out.println("(d) - Delete value");
        System.out.println("(s) - Search value");
        System.out.println("(n) - Print next iterator value");
        System.out.println("(r) - Reset iterator");
        System.out.println("(a) - Delete alternate nodes");
        System.out.println("(m) - Merge lists");
        System.out.println("(t) - Find intersection");
        System.out.println("(p) - Print list");
        System.out.println("(l) - Print length");
        System.out.println("(q) - Quit program");

        //System.out.println("head: " + list.getHead().getInfo().getValue());
       // System.out.println("");

         while(true) {
    Scanner keyboard = new Scanner (System.in);
        
        System.out.println("\nEnter a command: ");
        String user = keyboard.next();// Where user will input command

        if (user.equals("q")) {
            System.out.println("Exiting the program...");
            System.exit(0);
        }//if-q
         else if(user.equals("i")) {
            System.out.println("Enter a number to insert: ");
            int insertNum = keyboard.nextInt();
            System.out.print("\nOrginal list: ");
            list.printList();
            list.insertItem(new ItemType(insertNum)); //create a new insert object
            System.out.print("\nNew list: ");
            list.printList();//print the updated list

        }//else if-i
       else if(user.equals("d")) {
            System.out.println("Enter a number to delete: ");
            int deleteNum = keyboard.nextInt();
            System.out.print("Orginal list: ");
            list.printList();
            list.deleteItem(new ItemType(deleteNum));
            System.out.print("\nNew list: ");
            list.printList();
        }//if  
        else if(user.equals("s")) {
            System.out.println("Enter a number to search: ");
            int searchNum = keyboard.nextInt();
            list.searchItem(new ItemType(searchNum));
        }//else if-s
        else if(user.equals("m")) { 
            System.out.println("Enter the length of the new list: ");
            int length = keyboard.nextInt();
            SortedLinkedList list2 = new SortedLinkedList();
            System.out.println("Enter the numbers: ");
            for(int i = 0; i < length; i++) {
                int enterNum = keyboard.nextInt();
                ItemType tempItem = new ItemType(enterNum);
                list2.insertItem(tempItem);
            }//for
            System.out.print("The list 1: ");
            list.printList();
            System.out.print("\nThe list 2: ");
            list2.printList();
            //create a new list onbject-the one user will input to compare
            SortedLinkedList mergedList = new SortedLinkedList();
            mergedList = list.mergeList(list2);
            System.out.print("\nMerge Lst: ");
            mergedList.printList(); 
        }//else if-m
        else if(user.equals("t")){
            System.out.println("Enter the length of the new list: ");
            int length = keyboard.nextInt();
            System.out.println("Enter the numbers: ");
        SortedLinkedList list2 = new SortedLinkedList();
        for(int i = 0; i < length; i++) {
            int enterNum = keyboard.nextInt();
            ItemType tempItem = new ItemType(enterNum);
            list2.insertItem(tempItem);
        }//for
            System.out.print("The list 1: ");
        list.printList();
            System.out.print("\nThe list 2: ");
        list2.printList();
        SortedLinkedList intersection = list.intersection(list2);
            System.out.print("Intersection of lists: ");
        intersection.printList(); //prints the result of searchItem so need to fix that
        }//else if-t
        else if(user.equals("a")) {
            System.out.print("Original list: ");
            list.printList();
            //list.deleteAlternateNode();
            System.out.print("\nModified list: ");
            list.deleteAlternateNode();
            list.printList();
        }//else if-a
        else if(user.equals("n")) {
            list.getNextItem().getValue();
        }//else if-n
        else if(user.equals("r")) {
            list.resetList();
         }//else if-r
        else if(user.equals("p")) {
            System.out.print("The list is: ");
           list.printList();
        }//else if-p
        else if(user.equals("l")) {
            System.out.println("The length of the list is: " + list.getLength());
         }//else if-l

        else {
            if(!user.equals("i") || !user.equals("d") || !user.equals("s") || !user.equals("n") || !user.equals("r") 
            || !user.equals("a") || !user.equals("m") || !user.equals("t") || !user.equals("p") || !user.equals("l") || !user.equals("q")) {
                System.out.println("Invalid command try again: ");
            }
        
            }//else
            
        }//while
        }//main
//COMPILE: javac *.java -d bin    
//RUN: java -cp bin Orji_Patel_assignment1.LinkedListDriver input.txt 
}//LinkedListDriver
