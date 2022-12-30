package Orji_Patel_assignment4;

import java.util.Random;

public class Sort {

    int selectionComp = 0;
    void selectionSort(int arr[]) {

//   printArray(arr);
      // One by one move boundary of unsorted subarray
    int n = arr.length;
//    selectcomparisons++;
    for (int i = 0; i < n-1; i++) {
          // Find the minimum element in unsorted array
          int min_idx = i;
          for (int j = i + 1; j < n; j++) {
              // selectionComp++;
              if (arr[j] < arr[min_idx]) {
                  min_idx  = j;

              }
              selectionComp++;
            }

          // Swap the found minimum element with the first
          // element
          int temp = arr[min_idx];
          arr[min_idx] = arr[i];
          arr[i] = temp;
          // selectcomparisons++;
      }
    //    System.out.println("#Selection-sort comparisons: " + selectcomparisons);

  }

  // Prints the array
  void printArray(int arr[]) {
      int N = arr.length;
      for (int i=0; i<N; ++i)
          System.out.print(arr[i]+" ");
      System.out.println();
  }

    public static void Swap(int arr[], int x, int j){
        int temp = arr[x];
        arr[x] = arr[j];
        arr[j] = temp;
    }
int heapComp = 0;
 public void heapSort(int arr[]) {
     // printArray(arr);
        int N  = arr.length;
        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--) {
            heapify(arr, N, i);
          }

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // heapComp++;
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
        // System.out.println("#Heap-sort comparisons: " + heapComp);

    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int N, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])
            largest = l;
            heapComp++;

        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest])
            largest = r;
             heapComp++;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapComp++;

            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
        }

    }

    int mergeComp = 0;
// Merge two subarrays L and M into arr
  void merge(int arr[], int p, int q, int r) {
    // Create L ← A[p..q] and M ← A[q+1..r]
    int n1 = q - p + 1;
    int n2 = r - q;

    int L[] = new int[n1];
    int M[] = new int[n2];

    for (int i = 0; i < n1; i++)
      L[i] = arr[p + i];
   mergeComp++;
    for (int j = 0; j < n2; j++)
      M[j] = arr[q + 1 + j];
    mergeComp++;
    // Maintain current index of sub-arrays and main array
    int i, j, k;
    i = 0;
    j = 0;
    k = p;

    // Until we reach either end of either L or M, pick larger among
    // elements L and M and place them in the correct position at A[p..r]
    while (i < n1 && j < n2) {
        // mergeComp++;
      if (L[i] <= M[j]) {
        arr[k] = L[i];
        i++;
        //      mergeComp++;
      }
      else {
        arr[k] = M[j];
        j++;
        //  mergeComp++;
      }
      k++;
    }

    // When we run out of elements in either L or M,
    // pick up the remaining elements and put in A[p..r]
    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
      mergeComp++;
    }

    while (j < n2) {
        // mergeComp++;
      arr[k] = M[j];
      j++;
      k++;
      // mergeComp++;
    }
    // mergeComp++;
  }

  // Divide the array into two subarrays, sort them and merge them
  void mergeSort(int arr[], int l, int r) {
     // causes infinite loop when printing
    if (l < r) {
        //  mergeComp++;
      // m is the point where the array is divided into two subarrays
      int m = (l + r) / 2;

      mergeSort(arr, l, m);
      mergeSort(arr, m + 1, r);

      // Merge the sorted subarrays
      merge(arr, l, m, r);

    }
    //   System.out.println("#Merge-sort comparisons: " + mergeComp);
  }
// merge
  //randomized quick sort
    int quickr = 0;
    void random(int arr[],int low,int high) {

        Random rand= new Random();
        int pivot = rand.nextInt(high-low)+low;

        int temp1=arr[pivot];
        arr[pivot]=arr[high];
        arr[high]=temp1;
    }
  int partitionRand(int arr[], int low, int high) {
        // pivot is chosen randomly
        random(arr,low,high);
        int pivot = arr[high];


        int i = (low-1); // index of smaller element
        for (int j = low; j < high; j++) {
            quickr++;
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] < pivot) {
                i++;
                quickr++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
    /* The main function that implements QuickSort()
    arr[] --> Array to be sorted,
    low --> Starting index,
    high --> Ending index */
    void randomSort(int arr[], int low, int high)  {
        if (low < high)  {
            //     quickr++;
            /* pi is partitioning index, arr[pi] is
            now at right place */
            int pi = partitionRand(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            randomSort(arr, low, pi-1);
            randomSort(arr, pi+1, high);
        }
        //  System.out.println("#Quick-sort-rp comparisons: " + quickr);
    }

    // quick sort fp
    int quick = 0;
    //selects last element as pivot, pi using which array is partitioned.
    int partition(int arr[], int low, int high) {
        int pi = arr[high];
        int i = (low-1); // smaller element index
        for (int j=low; j<high; j++) {
            // check if current element is less than or equal to pi
            if (arr[j] <= pi) {
                i++;
                // quick++;
                // swap intArray[i] and intArray[j]
                /** int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                */
                Swap(arr, i, j);
                quick++;
            }
        }

        // swap intArray[i+1] and intArray[high] (or pi)
        Swap(arr, i + 1, high);
 /** int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        */
        return i+1;
    }
    //routine to sort the array partitions recursively
    void quick_sort(int arr[], int low, int high) {
        // printArray(arr);
        if (low < high) {
            //partition the array around pi=>partitioning index and return pi
            int pi = partition(arr, low, high);

            // sort each partition recursively
            quick_sort(arr, low, pi-1);
            quick_sort(arr, pi+1, high);
        }
   }


} // class
