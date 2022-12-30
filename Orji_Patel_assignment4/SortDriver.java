package  Orji_Patel_assignment4;

import java.util.*;
import java.io.*;
import java.lang.Math;

public class SortDriver {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String args[]) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        Sort sort = new Sort();
        //  int [] arr;
          int [] arr = new int[10000];

         if (args.length != 1) { // if args don't equal one then that means no file
            System.out.println("No input file");
            return;
        } // if

        try {
            Scanner scanner = new Scanner(new File(args[0])); // open file
              //File inputFile = new File(args[0]);
            //Scanner inputFileReader = new Scanner(inputFile);
            // int arr [] = new int[9999];
                int i = 0;
               // int n = arr.length - 1;
            while (scanner.hasNext() & i != 10000) {
                    arr[i] = scanner.nextInt();
                    i++;
                }

               } // try

        catch (FileNotFoundException e) {
            System.out.println("Unable to open file");// file doesn't exist
            return;
        } // catch

        System.out.println("selection-sort(s) merge-sort(m) heap-sort(h) quick-sort-fp (q)");
        System.out.println("quick-sort-rp (r)");
        System.out.println("Enter \"rand\" for random array");
        System.out.println("Enter the algorithm: ");
     String user = keyboard.next();
     if (user.equals("s")) {
          sort.selectionSort(arr);
          sort.printArray(arr);
          System.out.println("#Selection-Sort comparisons: " + sort.selectionComp);
            System.exit(0);
        }//if-q
     else if(user.equals("m")) {
         //        sort.mergeSort(arr);
         sort.mergeSort(arr, 0 , arr.length - 1);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n#Merge-Sort comparisons: " + sort.mergeComp);
            System.exit(0);
     }
     else if(user.equals("h")) {
        sort.heapSort(arr);
        sort.printArray(arr);
        System.out.println("#Heap-sort comparisons: " + sort.heapComp);
        System.exit(0);
     }
     else if(user.equals("q")) {
         sort.quick_sort(arr,0, arr.length -1);
         sort.printArray(arr);
          System.out.println("\n#Quick-Sort-fp comparisons: " + sort.quick);
            System.exit(0);
     }
     else if(user.equals("r")) {
        sort.randomSort(arr,0,arr.length - 1);
         for(int i = 0; i < arr.length; i++) {
             System.out.print(arr[i] + " ");
             }
        System.out.println("\n#Quick-Sort-rp comparisons: " + sort.quickr);
            System.exit(0);
     } else if (user.equals("rand")) {
        int[] counts = new int[100];
        for (int i = 0; i < counts.length; i++) {
             counts[i] = (int) (Math.random() * 100);
        }// end for
        sort.mergeSort(counts, 0 , counts.length - 1);
        System.out.println("\n#Merge-Sort comparisons: " + sort.mergeComp);

        System.out.println("");
        sort.heapSort(counts);
        System.out.println("#Heap-sort comparisons: " + sort.heapComp);

        System.out.println("");
       sort.quick_sort(counts,0, counts.length -1);
        System.out.println("\n#Quick-Sort-fp comparisons: " + sort.quick);

        System.out.println("");
        sort.randomSort(counts,0,counts.length - 1);
        System.out.println("\n#Quick-Sort-rp comparisons: " + sort.quickr);







     }






    } //main
    }//SortDriver