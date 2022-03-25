package tutorial;

/*  Selection Sort

    Just like Bubble Sort, this algorithms divide the data structure into sorted and unsorted partitions.
    It's called like this because on each traversal it selects the largest element for swapping.

    How it works?
    This sorting algorithm looks for the largest element in the unsorted partition at each iteration.
    When it finds the largest element, it gets swapped with the last element in the unsorted partition.
    Consequently, that last element will be in its correct position. And, the first value that's going to be used
    for the comparison will be the first element in the unsorted array.


    Example

    Array = [20] [35] [-15] [7] [55] [1] [-22]

    Step 1                                      | Full array = [20] [35] [-15] [7] [55] [1] [-22]
        [20] [35] [-15] [7] [-22] [1] [55]

    Step 2                                      | Full array = [20] [35] [-15] [7] [-22] [1] [55]
        [20] [1] [-15] [7] [-22] [35]

    Step 3                                      | Full array = [20] [1] [-15] [7] [-22] [35] [55]
        [-22] [1] [-15] [7] [20]

    Step 4                                      | Full array = [-22] [1] [-15] [7] [20] [35] [55]
        [-22] [1] [-15] [7]

    Step 5                                      | Full array = [-22] [1] [-15] [7] [20] [35] [55]
        [-22] [-15] [1]

    Step 6                                      | Full array = [-22] [-15] [1] [7] [20] [35] [55]
        [-22] [-15]

    Using the array above, it was necessary 6 loops to organize the entire array.


    Final Conclusion
    Similarly to Bubble Sort, this is an "in-place algorithm" (doesn't require more memory upon the number of elements).
    Its complexity is also quadratic since it has two loops, one for the current element and the other for comparisons.
    So, it's a O(n²).
    It's an unstable algorithm since it looks for the first largest, so if there's a duplicate item, their relative
    ordering will be changed, once the first largest will go to the end of the array.
 */

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--)
        {
            int largestIndex = 0;

            // Starting from 1 since the initial value is the element at index 0.
            for (int i = 1; i <= lastUnsortedIndex; i++) // Here we also have to compare the last element.
            {
                if (intArray[i] > intArray[largestIndex])
                {
                    largestIndex = i;
                }
            }

            System.out.println("Step " + (intArray.length - lastUnsortedIndex));
            swap(intArray, largestIndex, lastUnsortedIndex);
            Arrays.stream(intArray).forEach(element -> System.out.print("[" + element + "] "));
            System.out.println("\n");
        }
    }

    private static void swap(int[] array, int i, int j)
    {
        if (i == j)
        {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
