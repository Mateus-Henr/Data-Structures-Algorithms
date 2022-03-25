package tutorial;

/*  Bubble Sort

    Similarly to the majority of sorting algorithms, this algorithm divides the array in one partition that is sorted,
    and another that's going to be sorted. In other words, we don't create auxiliary arrays.
    It received the name because the largest values will bubble up to the end or top of the array (in our case).


    How it works
    Given an unsorted array, this algorithm starts from the beginning of the array and compares an element with the
    next. If the next element is smaller than the current, then they get swapped. And it repeats this step until all
    elements are in their right position. After each step we can assume that the last element related to that step
    is sorted, in other words we look for the biggest element and put it in the end.


    Example

    Array = [20] [35] [-15] [7] [55] [1] [-22]

    Step 1                                      | Full Array = [20] [35] [-15] [7] [55] [1] [-22]
        [20] [-15] [35] [7] [55] [1] [-22]
        [20] [-15] [7] [35] [55] [1] [-22]
        [20] [-15] [7] [35] [1] [55] [-22]
        [20] [-15] [7] [35] [1] [-22] [55]

    Step 2                                      | Full Array = [-15] [20] [7] [35] [1] [-22] [55]
        [-15] [20] [7] [35] [1] [-22]
        [-15] [7] [20] [35] [1] [-22]
        [-15] [7] [20] [1] [35] [-22]
        [-15] [7] [20] [1] [-22] [35]

    Step 3                                      | Full Array = [-15] [7] [20] [1] [-22] [35] [55]
        [-15] [7] [1] [20] [-22]
        [-15] [7] [1] [-22] [20]

    Step 4                                      | Full Array = [-15] [7] [1] [-22] [20] [35] [55]
        [-15] [1] [7] [-22]
        [-15] [1] [-22] [7]

    Step 5                                      | Full Array = [-15] [1] [-22] [7] [20] [35] [55]
        [-15] [-22] [1]

    Step 6                                      | Full Array = [-15] [-22] [1] [7] [20] [35] [55]
        [-22] [-15]

    So in order to organize the array it took six loops, however the code has to go through another loop in order to
    check if there are all sorted. Furthermore, concerning the number of moves, in total were fourteen.


    Final Conclusion
    This algorithm does sort an array without an allocating any other structures in memory which is called an "in-place
    algorithm", however the worst case scenario of this algorithm is a O(n²) which is the WORST algorithm possible.
    For example, it'll take 100 steps for sorting 100 items, 10000 steps for 100 items, so it degrades quickly.
 */

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        // Changes the index according to the current step. So we don't loop uselessly.
        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--)
        {
            System.out.println("Step " + (intArray.length - lastUnsortedIndex));

            // Traversing the array and bubbling the largest value to the end of the array.
            for (int i = 0; i < lastUnsortedIndex; i++)
            {
                if (intArray[i] > intArray[i + 1])
                {
                    swap(intArray, i, i + 1);
                    Arrays.stream(intArray).forEach(value -> System.out.print("[" + value + "] "));
                    System.out.println();
                }
            }

            System.out.println();
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
// Additionally, to identify time complexity, we consider the number of loops there are.