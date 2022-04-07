package challenges.third;

/*  Sort Algorithms — Challenge #3

    • Sort the following values using radix sort: "bcdef", "dbaqc", "abcde", "omadd", "bbbbb".
    • All values are in lowercase, so don't worry about uppercasing/lowercasing the values.
 */

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        String[] stringArray = {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};

        radixSort(stringArray, 26, stringArray[0].length());

        Arrays.stream(stringArray).forEach(value -> System.out.print("[" + value + "] "));
        System.out.println();
    }

    private static void radixSort(String[] input, int radix, int width)
    {
        for (int i = width - 1; i >= 0; i--)
        {
            radixSingleSort(input, i, radix);
        }
    }

    private static void radixSingleSort(String[] input, int position, int radix)
    {
        int numItems = input.length;

        int[] countArray = new int[radix];

        for (String value : input)
        {
            countArray[getLetterIndex(position, value)]++;
        }

        for (int j = 1; j < countArray.length; j++)
        {
            countArray[j] += countArray[j - 1];
        }

        String[] temp = new String[numItems];

        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--)
        {
            temp[--countArray[getLetterIndex(position, input[tempIndex])]] = input[tempIndex];
        }

        System.arraycopy(temp, 0, input, 0, numItems);
    }

    private static int getLetterIndex(int position, String value)
    {
        return value.charAt(position) - 'a';
    }

}
