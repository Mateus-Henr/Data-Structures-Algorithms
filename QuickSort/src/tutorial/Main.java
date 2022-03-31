package tutorial;

/*  Quick Sort

    A divide and conquer algorithm.
    By default, it's recursive.
    It uses a pivot element to partition the array into two parts.
    On the left stay the elements that are smaller than the pivot, and on the right, elements that are greater than it.
    And this is called the partitioning step. After that, the pivot will be in its correct sorted position.
    This is an in-place algorithm.


    The process
    It's important to notice that both sides of the array aren't necessarily sorted. They are only divided into two
    sides, where the left side is smaller than the pivot, and the right side greater than the pivot.
    The process described above is repeated until we have 1-element arrays. So, eventually, all elements will have been
    chosen as a pivot, consequently they will be in their right position.


    Example
    In the implementation that's going to be shown here, the pivot chosen will be the first element of the array.
    Also, "j" is used to traverse the array from the right to the left. "j" looks for elements that are less than
    the pivot, and if the element is left than the pivot, the element goes to the "i" position, and "i" is incremented.
    After that, we start traversing the array from left to right, and doing the opposite comparison (greater than the
    pivot), and switching the element to position "j".
    This alternation from left to right, and right to left is important to not lose any data. In other words we won't
    overwrite positions that we have already handled.
    During this process, we check whether "i" and "j" have crossed each other. If not, we continue the alternation.

    Also, the pivot is saved in the pivot variable since it probably will be overwritten.


    Tree representation
    [20]    [35]    [-15]    [7]    [55]    [1]    [-22]
    [-22]    [35]    [-15]    [7]    [55]    [1]    [35]
    [-22]    [1]    [-15]    [7]    [55]    [35]    [35]
    [-22]    [1]    [-15]    [7]    [35]    [55]    [35]
    [-22]    [1]    [-15]    [7]    [20]    [55]    [35]

    [-22]    [1]    [-15]    [7]

    [1]    [-15]    [7]
    [-15]    [-15]    [7]
    [-15]    [1]    [7]

    [55]    [35]
    [35]    [55]

    [-22]    [-15]    [1]    [7]    [20]    [35]    [55]


    More explained version

    Array = [20] [35] [-15] [7] [55] [1] [-22]

    Step 1 (Pivot = 20)                             Full array = [20] [35] [-15] [7] [55] [1] [-22]
        [-22] [35] [-15] [7] [55] [1] [-22]  (i = 1 | j = 6)
        [-22] [35] [-15] [7] [55] [1] [35]   (i = 2 | j = 6)
        [-22] [1] [-15] [7] [55] [35] [35]   (i = 1 | j = 5)
        [-22] [1] [-15] [7] [35] [55] [35]   (i = 4 | j = 5) (after this, "i" and "j" will have crossed each other)
        [-22] [1] [-15] [7] [20] [55] [35]   (the value of "i" will be the sorted position of the pivot value)

    Step 2 (Pivot = -22)                            Full array = [-22] [1] [-15] [7] [20] [55] [35]
        [-22] [1] [-15] [7] [20]

    Step 3 (Pivot = -22)                            Full array = [-22] [1] [-15] [7] [20] [55] [35]
        [-22] [1] [-15] [7]

    Step 4 (Pivot = 1)                              Full array = [-22] [1] [-15] [7] [20] [55] [35]
        [1] [-15] [7]
        [-15] [-15] [7]  (i = 1 | j = 2)
        [-15] [1] [7]    (Putting the pivot in its right place)

    Step 5 (Pivot = 55)                             Full array = [-22] [-15] [1] [7] [20] [55] [35]
        [55] [35]
        [35] [55]  (i = 5 | j = 6)
        [-22] [-15] [1] [7] [20] [35] [55]  Array after the fifth step.

    OBS: All left sub-arrays are always dealt with first in comparison with the right sub-arrays.


    Final conclusion
    - In-place algorithm.
    - O(nlogn) - base 2. We're repeatedly partitioning the array into two halves. In the worst case, it's a O(n²). But
      most of the time it performs as O(nlogn), and it performs better than merge sort.
    - Unstable algorithm. This is due to the fact that when we are alternating between the "i" and "j", we are taking
      values out of the relative ordering, in the case of duplicate elements.
      The choice of pivot can have an effect in the time complexity.

 */

import java.util.Arrays;

public class Main
{
    private enum Directions
    {
        LEFT, RIGHT
    }

    public static void main(String[] args)
    {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        System.out.print("Initial Array = ");
        Arrays.stream(intArray).forEach(value -> System.out.print("[" + value + "] "));
        System.out.println("\n");

        quickSort(intArray, 0, intArray.length);

        System.out.print("\nFinal Array = ");
        Arrays.stream(intArray).forEach(value -> System.out.print("[" + value + "] "));
        System.out.println();
    }

    private static void quickSort(int[] input, int start, int end)
    {
        if ((end - start) < 2)
        {
            return;
        }

        // If we are dealing with more than one element, we want to figure out the index of the pivot when the array is
        // sorted. This method also organizes the other elements based on the pivot.
        int pivotIndex = partition(input, start, end);

        quickSort(input, start, pivotIndex);          // Elements that are smaller than the pivot.
        quickSort(input, pivotIndex + 1, end);   // Elements that are greater than the pivot.
    }

    private static int partition(int[] input, int start, int end)
    {
        int pivot = input[start]; // The pivot is the first element of the sub-array.
        int i = start; // Traverses from left to right.
        int j = end;   // Traverses from right to left.

        // While "i" and "j" haven't crossed each other. By alternating between "i" and "j" prevents accidental
        // overwriting.
        while (i < j)
        {
            // Empty loop body. This is only used for decrementing "j" until we find an element that's less than
            // or equal than the pivot, or "j" crosses "i".
            // Notice that because the end of the array is one element greater than its actual size, we are using the
            // prefix to handle it.
            while (i < j && input[--j] >= pivot) ;

            if (i < j)
            {
                // After we find an element that's less than the pivot, we change its position.
                input[i] = input[j]; // In the first iteration, "i" is 0.
                Arrays.stream(input).forEach(value -> System.out.print("[" + value + "] "));
                System.out.println();
            }

            // Another, an empty loop. Now looking from left to right for an element greater than the pivot.
            while (i < j && input[++i] <= pivot) ;

            if (i < j)
            {
                input[j] = input[i]; // Changing the element that's greater than the pivot to the right of the pivot.
                Arrays.stream(input).forEach(value -> System.out.print("[" + value + "] "));
                System.out.println();
            }
        }

        // Inserting the pivot in its right position.
        input[j] = pivot;
        System.out.println("After partitioning | Pivot = " + pivot);
        Arrays.stream(input).forEach(value -> System.out.print("[" + value + "] "));
        System.out.println("\n");

        return j; // Return the position of the pivot.
    }

    private static void printArray(int[] input, int start, int end, int pivot, Directions directions)
    {
        String message;

        if (directions == Directions.LEFT)
        {
            message = "Left partition | Pivot = " + pivot;
        }
        else
        {
            message = "Right partition | Pivot = " + pivot;
        }

        System.out.println(message);

        for (int i = start; i < end; i++)
        {
            System.out.print("[" + input[i] + "] ");
        }

        System.out.println();
    }

}
