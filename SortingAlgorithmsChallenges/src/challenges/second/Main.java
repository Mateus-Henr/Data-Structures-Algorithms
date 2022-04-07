package challenges.second;

/*  Sort Algorithms Challenge #2

    • Change insertion sort so that it uses recursion.
    • Sort the usual example array.
 */

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        insertionSort(intArray, 0, intArray.length);
        Arrays.stream(intArray).forEach(value -> System.out.print("[" + value + "] "));
        System.out.println();
    }

    private static void insertionSort(int[] input, int start, int end)
    {
        if (start >= end)
        {
            return;
        }

        sortValue(input, input[start], start);
        insertionSort(input, start + 1, end);
    }

    private static void sortValue(int[] input, int newElement, int start)
    {
        if (start <= 0 || input[start - 1] < newElement)
        {
            input[start] = newElement;
            return;
        }

        input[start] = input[start - 1];
        sortValue(input, newElement, start - 1);
    }

}
