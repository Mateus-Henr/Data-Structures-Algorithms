package tutorial;

/*  Bucket Sort

    • Uses hashing.
    • Makes assumptions about the data, like radix and counting sort.
    • Because it makes assumptions, can sort in 0(n) time.
    • Performs best when hashed values of items being sorted are evenly distributed, so there aren't many collisions.


    How does it work?
        1. Distribute the items into buckets based on their hashed values (scattering phase).
        2. Sort the items in each bucket.
        3. Marge the buckets. So, can just concatenate them, basically copy the items back to the original array
           (gathering phase).
    It's a generalization of counting sort.
    OBS: The values in bucket X must be greater than the values in bucket X - 1 and less than the values in bucket
         X + 1. So the hash function to be used must meet this requirement.
         That means that the buckets will be written back to the original array in ascending order, so all the values
         in the first bucket have to be less than the values in the second bucket.


    Example

    Array = [54] [46] [83] [66] [95] [92] [43]

    Scattering phase (hashing phase)
    [] [] [] [] [] [54] [] [] [] []                         | 54 -> 5
    [] [] [] [] [46] [54] [] [] [] []                       | 46 -> 4
    [] [] [] [] [46] [54] [] [] [83] []                     | 83 -> 8
    [] [] [] [] [46] [54] [66] [] [83] []                   | 66 -> 6
    [] [] [] [] [46] [54] [66] [] [83] [95]                 | 95 -> 9
    [] [] [] [] [46] [54] [66] [] [83] [95 -> 92]           | 92 -> 9
    [] [] [] [] [46 -> 43] [54] [66] [] [83] [95 -> 92]     | 43 -> 4

    Sorting phase (organizing array phase)
    [] [] [] [] [46 -> 43] [54] [66] [] [83] [95 -> 92]
    [] [] [] [] [46 -> 43] [54] [66] [] [83] [95 -> 92]
    [] [] [] [] [46 -> 43] [54] [66] [] [83] [95 -> 92]
    [] [] [] [] [46 -> 43] [54] [66] [] [83] [95 -> 92]
    [] [] [] [] [43 -> 46] [54] [66] [] [83] [95 -> 92] (Sorted some values)
    [] [] [] [] [43 -> 46] [54] [66] [] [83] [95 -> 92]
    [] [] [] [] [43 -> 46] [54] [66] [] [83] [95 -> 92]
    [] [] [] [] [43 -> 46] [54] [66] [] [83] [95 -> 92]
    [] [] [] [] [43 -> 46] [54] [66] [] [83] [95 -> 92]
    [] [] [] [] [43 -> 46] [54] [66] [] [83] [92 -> 95] (Sorted some values)

    Gathering phase (copying the values back to the original array)
    [43] [46] [83] [66] [95] [92] [43]
    [43] [46] [83] [66] [95] [92] [43]
    [43] [46] [54] [66] [95] [92] [43]
    [43] [46] [54] [66] [95] [92] [43]
    [43] [46] [54] [66] [83] [92] [43]
    [43] [46] [54] [66] [83] [92] [43]
    [43] [46] [54] [66] [83] [92] [95]

    Final array
    [43] [46] [54] [66] [83] [92] [95]

    Note that the requirement of having the previous buckets always with values less than the next bucket is essential
    for this algorithm to work.


    Final conclusion
    • Not in-place.
    • Stability will depend on sort algorithm used to sort the buckets (ideally, you want a stable sort).
    • To achieve O(n), there must have only one item per bucket.
    • Insertion sort is often used to sort the buckets because it is fast when the number of items is small.
 */

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        int[] intArray = {54, 46, 83, 66, 95, 92, 43};

        bucketSort(intArray);

        System.out.println("\nFinal array");
        Arrays.stream(intArray).forEach((value) -> System.out.print("[" + value + "] "));
        System.out.println();
    }

    private static void bucketSort(int[] input)
    {
        List<Integer>[] buckets = new List[10];

        // Initializing bucket array.
        for (int i = 0; i < buckets.length; i++)
        {
            // Our buckets will be array lists.
            buckets[i] = new ArrayList<>();

//            buckets[i] = new LinkedList<>(); // Can also be a linked list.
        }

        // Scattering phase (hashing phase)
        System.out.println("Scattering phase");
        for (int value : input)
        {
            // Discovering the index by hashing the value, and adding the value to that position.
            buckets[hash(value)].add(value);
            printArray(buckets);
            System.out.println();
        }

        // Sorting phase (organizing array phase)
        System.out.println("\nSorting phase");
        for (List<Integer> bucket : buckets)
        {
            // This method uses an adaptive merge sort.
            Collections.sort(bucket);
            printArray(buckets);
            System.out.println();
        }

        int i = 0;

        // Gathering phase (copying the values back to the original array)
        System.out.println("\nGathering phase");
        for (List<Integer> bucket : buckets)
        {
            for (Integer value : bucket)
            {
                input[i++] = value;
                Arrays.stream(input).forEach((elem) -> System.out.print("[" + elem + "] "));
                System.out.println();
            }
        }
    }

    private static int hash(int value)
    {
        return value / 10;
    }

    private static void printArray(List<Integer>[] array)
    {
        for (List<Integer> bucket : array)
        {
            System.out.print("[");
            for (int i = 0; i < bucket.size(); i++)
            {
                System.out.print(bucket.get(i));

                if (i != bucket.size() - 1)
                {
                    System.out.print(" -> ");
                }
            }
            System.out.print("] ");
        }
    }

}
