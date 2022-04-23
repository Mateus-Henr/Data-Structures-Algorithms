package tutorial;

/*  Binary Search

    • Data must be sorted! THE BIG BUT OF THIS ALGORITHM.
    • It's the most used algorithm for searching for a value.
    • If your app is going to do a lot of binary searching, then you should consider inserting data already sorted, so
      then you don't have to sort the data whenever you want to use binary search.
    • The concept of dividing the data structure in half is very similar to merge sort.
    • Can be written recursively.


    How it works
    • Chooses the element in the middle of the array and compares it against the search value.
    • If element is equal to the value, we're done.
    • If element is greater than the value, search the left half of the array.
    • If the element is less than the value, search the right half of the array.
    • We are allowed to do this of breaking the array in half because the data is sorted. Also, the steps below repeat
      until the value is found or when there's no more elements to compare against.


    Example

    Array = [-22] [-15] [1] [7] [20] [35] [55]

    Search value = 1

    Step 1 (entire array)                       Start = 0
        [-22] [-15] [1] [7] [20] [35] [55]      End = 7
                                                Midpoint = (start + end) / 2 = 3 -> [7]

    Step 2 (left half of the array)             Start = 0
        [-22] [-15] [1] [7]                     End = 3 (Gets the midpoint value, because it's the left half)
                                                Midpoint = (start + end) / 2 = 1 -> [-15]

    Step 3 (right half of the array)            Start = 2 (Receives the midpoint, because it's the right half)
        [-22] [-15] [1]                         End = 0
                                                Midpoint = (start + end) / 2 = 1 -> [1] FOUND THE ELEMENT
    OBS: NOTICE THAT THE END IS ALWAYS ONE GREATER.

    Tree representation

        [-22] [-15] [1] [7] [20] [35] [55]
                [-22] [-15] [1]
                      [1]


    Final conclusion
    • At some point, there will be only one element in the partition that you're checking, but it doesn't have to get
      to that point. It does logical partitioning, so we don't have to create a new array at each partitioning.
    • Can be implemented recursively.
    • O(nlog(n)) - It keeps dividing the array in half.
    • Notice that the recursive version is usually more expensive due to the call stack, so the iterative version is
      easier to read and faster.
 */

public class Main
{
    public static void main(String[] args)
    {
        int[] intArray = {-22, -15, 1, 7, 20, 35, 55};

        System.out.println("Iterative Binary Search");
        System.out.println("Searching for the value 1 | Pos = " + iterativeBinarySearch(intArray, 1));
        System.out.println();
        System.out.println("Searching for the value -15 | Pos = " + iterativeBinarySearch(intArray, -15));
        System.out.println();
        System.out.println("Searching for the value 35 | Pos = " + iterativeBinarySearch(intArray, 35));
        System.out.println();
        System.out.println("Searching for the value 99 | Pos = " + iterativeBinarySearch(intArray, 99));

        System.out.println("\n\nRecursive Binary Search");
        System.out.println("Searching for the value 1 | Pos = " + recursiveBinarySearch(intArray, 1));
        System.out.println();
        System.out.println("Searching for the value -15 | Pos = " + recursiveBinarySearch(intArray, -15));
        System.out.println();
        System.out.println("Searching for the value 35 | Pos = " + recursiveBinarySearch(intArray, 35));
        System.out.println();
        System.out.println("Searching for the value 99 | Pos = " + recursiveBinarySearch(intArray, 99));
    }

    public static int iterativeBinarySearch(int[] input, int value)
    {
        int start = 0;
        int end = input.length;

        printArray(input, start, end);

        // When start equals end it means that we have searched the entire array, and we didn't find the value.
        // It means that we got to a partition with 0 elements.
        while (start < end)
        {
            int midpoint = (start + end) / 2;

            if (input[midpoint] == value)
            {
                return midpoint;
            }
            else if (input[midpoint] < value)
            {
                start = midpoint + 1; // Ignore the midpoint value that we checked adding 1 to it.
            }
            else
            {
                // Remember that the end is always one greater, and that we actually don't check the end position.
                // For that reason, and to ignore the previous midpoint that we checked we just assign midpoint to the
                // end value, so if the value checked was at position 3, the end now will be 3, meaning that it goes
                // from 0 to 2.
                end = midpoint;
            }

            printArray(input, start, end);
            System.out.println("Midpoint = " + midpoint + " -> [" + input[midpoint] + "]");
        }

        return -1;
    }

    // This method is necessary for us to create another method with values to be modified recursively.
    private static int recursiveBinarySearch(int[] input, int value)
    {
        return recursiveBinarySearch(input, 0, input.length, value);
    }

    private static int recursiveBinarySearch(int[] input, int start, int end, int value)
    {
        // The condition as the iterative version.
        if (start >= end)
        {
            return -1;
        }

        int midpoint = (start + end) / 2;
        System.out.println("Midpoint = " + midpoint + " -> [" + input[midpoint] + "]");
        printArray(input, start, end);

        if (input[midpoint] == value)
        {
            return midpoint;
        }
        else if (input[midpoint] < value)
        {
            return recursiveBinarySearch(input, midpoint + 1, end, value);
        }
        else
        {
            return recursiveBinarySearch(input, start, midpoint, value);
        }
    }

    private static void printArray(int[] array, int start, int end)
    {
        for (int i = start; i < end; i++)
        {
            System.out.print("[" + array[i] + "] ");
        }

        System.out.println();
    }

}
