package tutorial;

/*  Counting Sort

    This type of sorting algorithm makes assumptions about the data. And by doing these assumptions they can sort
    the data more efficiently.
    It doesn't use comparisons. Instead, it counts the number of occurrences of each value.
    It only works with non-negative discrete values (can't work with floats, strings).
    Values must be within a specific range, and this range cannot be huge, otherwise it doesn't make sense to use this
    algorithm. For example, with one million elements, this algorithm is not viable.


    Example

    Array = [2] [5] [9] [8] [2] [8] [7] [10] [4] [3]

    Info about the algorithm
    - Assumption: Values between 1 and 10 inclusive.
    - We have 10 possible values, so we create a counting array of length 10.
    - The array will be traversed from the left to the right.
    - The counting array is used to track how many of each value are in the input array.
    - Using the counts in the counting array, write the values in sorted order to the original array.

    Relation between the original array and the counting array
    [1] [2] [3] [4] [5] [6] [7] [8] [9] [10]
    [0] [0] [0] [0] [0] [0] [0] [0] [0] [0]

    Step 1 (Building the counting array)                    | Full array = [2] [5] [9] [8] [2] [8] [7] [10] [4] [3]
    [0] [1] [0] [0] [0] [0] [0] [0] [0] [0] | Elem = 2
    [0] [1] [0] [0] [1] [0] [0] [0] [0] [0] | Elem = 5
    [0] [1] [0] [0] [1] [0] [0] [0] [1] [0] | Elem = 9
    [0] [1] [0] [0] [1] [0] [0] [1] [1] [0] | Elem = 8
    [0] [2] [0] [0] [1] [0] [0] [1] [1] [0] | Elem = 2
    [0] [2] [0] [0] [1] [0] [0] [2] [1] [0] | Elem = 8
    [0] [2] [0] [0] [1] [0] [1] [2] [1] [0] | Elem = 7
    [0] [2] [0] [0] [1] [0] [1] [2] [1] [1] | Elem = 10
    [0] [2] [0] [1] [1] [0] [1] [2] [1] [1] | Elem = 4
    [0] [2] [1] [1] [1] [0] [1] [2] [1] [1] | Elem = 3

    Step 2
    Using the counting array to sort the original array by traversing the counting array.
    Counting array = [0] [2] [1] [1] [1] [0] [1] [2] [1] [1]

    Original array
    [2] [5] [9] [8] [2] [8] [7] [10] [4] [3] | Elem = 2
    [2] [2] [9] [8] [2] [8] [7] [10] [4] [3] | Elem = 2
    [2] [2] [3] [8] [2] [8] [7] [10] [4] [3] | Elem = 3
    [2] [2] [3] [4] [2] [8] [7] [10] [4] [3] | Elem = 4
    [2] [2] [3] [4] [5] [8] [7] [10] [4] [3] | Elem = 5
    [2] [2] [3] [4] [5] [7] [7] [10] [4] [3] | Elem = 7
    [2] [2] [3] [4] [5] [7] [8] [10] [4] [3] | Elem = 8
    [2] [2] [3] [4] [5] [7] [8] [8] [4] [3]  | Elem = 8
    [2] [2] [3] [4] [5] [7] [8] [8] [9] [3]  | Elem = 9
    [2] [2] [3] [4] [5] [7] [8] [8] [9] [10] | Elem = 10


    Final conclusion
    - Not an in-place algorithm because of the "counting" array that needs to be created.
    - Time complexity O(n) - This is achievable because we make assumptions about the data being sorted.
    - It can either stable or unstable. According to the implementation below, it's unstable.
    - It's important to notice that the length of the "counting" array depends on the range of values that we have.
      Therefore, this algorithm is best used when we have a range of values similar to the number of elements in the
      array to be sorted.
 */

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        int[] intArray = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};

        countingSort(intArray, 1, 10);

        System.out.println("\nFinal array");
        Arrays.stream(intArray).forEach(value -> System.out.print("[" + value + "] "));
        System.out.println();
    }

    private static void countingSort(int[] input, int minRange, int maxRange)
    {
        int[] countingArray = new int[(maxRange - minRange) + 1];

        // Counting phase
        System.out.println("Step 1 (Building the counting array)");
        for (int i : input)
        {
            countingArray[i - minRange]++;
            Arrays.stream(countingArray).forEach(value -> System.out.print("[" + value + "] "));
            System.out.println();
        }

        // Setting the values back to the input array.
        System.out.println("\nStep 2");
        int j = 0; // Keep track of the index on the input array.
        for (int i = minRange; i <= maxRange; i++)
        {
            // We are using as base the element's value to identify how many times the number needs to be repeated.
            // By using this style we don't have to create a new variable.
            while (countingArray[i - minRange] > 0)
            {
                input[j++] = i;
                countingArray[i - minRange]--; // Decrementing the count.

                Arrays.stream(input).forEach(value -> System.out.print("[" + value + "] "));
                System.out.println();
            }
        }
    }

}
