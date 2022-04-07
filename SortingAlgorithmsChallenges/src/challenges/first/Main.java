package challenges.first;

/*  Sort Algorithms Challenge #1

    • Modify the merge sort algorithm so that it sorts integers in DESCENDING order.
    • Use the usual example array.
 */

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        mergeSort(intArray, 0, intArray.length);

        Arrays.stream(intArray).forEach(value -> System.out.print("[" + value + "] "));
        System.out.println();
    }

    private static void mergeSort(int[] input, int start, int end)
    {
        if ((end - start) < 2)
        {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    private static void merge(int[] input, int start, int mid, int end)
    {
        // Optimization condition.
        if (input[mid - 1] >= input[mid])
        {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end)
        {
            // Since merge sort is a stable sort, keeping the equals sign here is extremely important.
            // In order to preserve the relative ordering of duplicate elements, the element in the left array has to
            // be written first. In our case, "i" represents the traversal on the left array.
            temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }

}
