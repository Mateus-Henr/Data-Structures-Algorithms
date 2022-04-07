package tutorial;

/*  Sorting Arrays Using the JDK

    The JDK contains an "Array" class that has methods for sorting arrays.
    If you're sorting objects we have to tell the runtime how to sort them. In order to do that, we use the "Comparable"
    interface.
 */

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        final int[] finalIntArray = {20, 35, -15, 7, 55, 1, -22};
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        System.out.println("Sort");
        // This "sort" method uses a "DualPivotQuicksort" as the sorting algorithm. It's a O(n log(n)) algorithm in
        // most scenarios, but it can be a O(n).
        Arrays.sort(intArray);
        printArray(intArray);

        System.out.println("\nParallel Sort");
        intArray = finalIntArray.clone();
        // This is a parallel sort-merge algorithm. It uses merge sort, but when it gets to smaller partitions it
        // uses quick sort through the "sort" method. It also uses threads. This is usually faster to larger data sets.
        Arrays.parallelSort(intArray);
        printArray(intArray);
    }

    private static void printArray(int[] input)
    {
        Arrays.stream(input).forEach(value -> System.out.print("[" + value + "] "));
        System.out.println();
    }

}
