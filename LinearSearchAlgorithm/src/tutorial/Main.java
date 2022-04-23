package tutorial;

/*  Linear Search Algorithm

    • This is really simple. It's just looping through the data structure using a loop to find an item. In other words,
      you iterate over the data structure.
    • It's called like that because you increment the index by one in a linear fashion to look for an item.
    • It's time complexity is O(n). The worst case is if we have to traverse the entire data structure.


    Search algorithm
    • A search algorithm will find a value in a data structure.

    Example

    Search value = 1

    Step 1
        [20]                                     End = 1
        [20] [35]                                End = 2
        [20] [35] [-15]                          End = 3
        [20] [35] [-15] [7]                      End = 4
        [20] [35] [-15] [7] [55]                 End = 5
        [20] [35] [-15] [7] [55] [1]             End = 6


    Final conclusion
    • A simple iteration over a data structure.
    • O(n).
 */

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        System.out.println("Looking for -15 -> Pos = " + linearSearch(intArray, -15));
        System.out.println();
        System.out.println("Looking for 1 -> Pos = " + linearSearch(intArray, 1));
        System.out.println();
        System.out.println("Looking for 999 -> Pos = " + linearSearch(intArray, 999));
        System.out.println();
        System.out.println("Looking for -22 -> Pos = " + linearSearch(intArray, -22));
    }

    public static int linearSearch(int[] input, int value)
    {
        for (int i = 0; i < input.length; i++)
        {
            printArray(input, i + 1);

            if (input[i] == value)
            {
                return i;
            }
        }

        return -1;
    }

    private static void printArray(int[] array, int end)
    {
        for (int i = 0; i < end; i++)
        {
            System.out.print("[" + array[i] + "] ");
        }

        System.out.println();
    }

}
