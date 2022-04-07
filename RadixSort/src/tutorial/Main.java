package tutorial;

/*  Radix Sort

    - This algorithm also makes assumptions about the data.
    - The data must have the same radix and width.

    Radix
    The radix is the number of unique digits or values (in the case of the values of letters).
    For the decimal system, for example, it has a 10 radix (0 - 9). And when it comes to the radix of the alphabet,
    it's 26 due to the numbers of letters in the alphabet.

    Width
    The number of characters of each element of the data must be the same, the same goes for numbers.
    For example, if the first number is 10, all the following numbers must contain two digits.

    - The data can be integers or strings.
    - The sort is based on each individual digit or letter position.
    - It starts at the rightmost position, and it must use a stable algorithm at each stage.
    - It doesn't work for floats since the decimal point isn't a digit.


    How does it work?
    Given the array, we would start sorting this array based on the 1's (decimal) position on each element.
    In other words, we would start sorting based on the digit that has the least weight, starting from the rightmost
    digit. And we would jump to the next digit to the right and do the same thing.
    At each stage, gradually, the data gets more and more sorted.


    Example

    Array = [4725] [4586] [1330] [8792] [1594] [5729]

    Step 1 - 1's position                               | Full array = [4725] [4586] [1330] [8792] [1594] [5729]
        [4725] [4586] [1330] [8792] [1594] [5729]
        [4725] [5729] [1330] [4586] [8792] [1594]

    Step 2 - 10's position                              | Full array = [4725] [5729] [1330] [4586] [8792]  [1594]
        [4725] [5729] [1330] [4586] [8792] [1594]

    Step 3 - 100's position                             | Full array = [4725] [5729] [1330] [4586] [8792]  [1594]
        [1330] [4586] [1594] [4725] [5729] [8792]

    Step 3 - 1000's position                            | Full array = [4725] [5729] [1330] [4586] [8792]  [1594]
        [1330] [1594] [4586] [4725] [5729] [8792]

    OBS: Through the steps above it is possible to see why's crucial the use of a stable algorithm.
         The necessity of this algorithm being stable is due to the fact that we need to take into account that there
         were previous sorting steps, and we cannot just "take them away". By using a stable algorithm, we take them
         into account when doing the next sorting. In other words, on each step, the relative positions get preserved,
         so, the next step only do some modifications to the previous sort in order to sort it completely.


    Counting Sort (Stable)
    - For a stable version of the counting sort algorithm, extra steps are necessary.
    - For a better explanation of the counting sort algorithm itself, take a look at the unstable version.
    - It calculates where values should be written back to the original array.
    - Writing hte values into the array in backwards order ensures stability.

    How to set the values back to the original array based on the counting sort array (10's position)
    - We create a temporary array that matches the length of the array being sorted.
    - We can use the counts to figure out which range of indices in the temporary array will be occupied by each value.
      For example:
      "2" - There are two, so they occupy indices 0, and 1.
      "3" - It occupies the index 2.
      "8" - It occupies position 3.
      "9" - They occupy positions 4, and 5.

    How the positions are defined
    - After the first pass, we adjust the counts. Instead of the number of values that have a specific 10's value,
      we want ot store how many values have a specific 10's value or less.
      For example, we want to store 3 at index 3, because 3 values have a 10's value of 3 or less.
    - We can calculate each adjusted count by adding up the counts up and including the 10's value.
      After adjusting our counts in this example we would get [0] [0] [2] [3] [3] [3] [3] [3] [4] [6].
      This because:
      [0] - 0 0s.                           0 values with 0
      [0] - 0 1s.                           0 values with 1 or less
      [2] - 2 2s.                           2 values with 2 or less
      [3] - 2 2s + 1 3s.                    3 values with 3 or less
      [3] - 2 2s + 1 3s.                    3 values with 4 or less
      [3] - 2 2s + 1 3s.                    3 values with 5 or less
      [3] - 2 2s + 1 3s.                    3 values with 6 or less
      [3] - 2 2s + 1 3s.                    3 values with 7 or less
      [4] - 2 2s + 1 3s + 1 8s.             4 values with 8 or less
      [6] - 2 2s + 1 3s + 1 8s + 2 9s.      6 values with 9 or less
      By adjusting the counts, we can write out the values in the correct order and preserve the relative positioning
      of duplicate values.
    - Notice that the last position will be equal to the number of values that we have.

    Conclusion on stable counting sort
    - This works because we traverse the input array from right to left, and we write duplicate values into the temp
      array from right to left.
    - If we know that duplicate values will go into positions 3 and 4, we write the rightmost value in the input array
      into position 4, and the leftmost value into position 3.
    - This preserves the relative positioning of duplicate values.
    - By adjusting the counting array after the initial pass, we can map values to indices in the temp array.
    - It's also possible to use linked lists to make counting sort stable.



    Example

    Array = [4725] [4586] [1330] [8792] [1594] [5729]

    Relation between the counting array and the original array
    [0] [1] [2] [3] [4] [5] [6] [7] [8] [9]
    [0] [0] [0] [0] [0] [0] [0] [0] [0] [0]

    Step 1 (1's position)                                                  | Full array = [5] [6] [0] [2] [4] [9]
    [0] [0] [0] [0] [0] [1] [0] [0] [0] [0] | Elem = 5
    [0] [0] [0] [0] [0] [1] [1] [0] [0] [0] | Elem = 6
    [1] [0] [0] [0] [0] [1] [1] [0] [0] [0] | Elem = 0
    [1] [0] [1] [0] [0] [1] [1] [0] [0] [0] | Elem = 2
    [1] [0] [1] [0] [1] [1] [1] [0] [0] [0] | Elem = 4
    [1] [0] [1] [0] [1] [1] [1] [0] [0] [1] | Elem = 9

    Step 2 (Adjusting count array)
    [1] [1] [1] [0] [1] [1] [1] [0] [0] [1]
    [1] [1] [2] [0] [1] [1] [1] [0] [0] [1]
    [1] [1] [2] [2] [1] [1] [1] [0] [0] [1]
    [1] [1] [2] [2] [3] [1] [1] [0] [0] [1]
    [1] [1] [2] [2] [3] [4] [1] [0] [0] [1]
    [1] [1] [2] [2] [3] [4] [5] [0] [0] [1]
    [1] [1] [2] [2] [3] [4] [5] [5] [0] [1]
    [1] [1] [2] [2] [3] [4] [5] [5] [5] [1]
    [1] [1] [2] [2] [3] [4] [5] [5] [5] [6]

    Step 3 (Temp array)                                 | Full array = [4725] [4586] [1330] [8792] [1594] [5729]
    [0] [0] [0] [0] [0] [5729]                          k = 5 | input[k] = 5729 | countArray[9] = (6 - 1) = 5
    [0] [0] [1594] [0] [0] [5729]                       k = 4 | input[k] = 1594 | countArray[4] = (3 - 1) = 2
    [0] [8792] [1594] [0] [0] [5729]                    k = 3 | input[k] = 8792 | countArray[2] = (2 - 1) = 1
    [1330] [8792] [1594] [0] [0] [5729]                 k = 2 | input[k] = 1330 | countArray[0] = (1 - 1) = 0
    [1330] [8792] [1594] [0] [4586] [5729]              k = 1 | input[k] = 4586 | countArray[6] = (5 - 1) = 4
    [1330] [8792] [1594] [4725] [4586] [5729]           k = 0 | input[k] = 4725 | countArray[5] = (4 - 1) = 3


    Step 1 (10's position)                                                  | Full array = [3] [9] [9] [2] [8] [2]
    [0] [0] [0] [1] [0] [0] [0] [0] [0] [0] | Elem = 3
    [0] [0] [0] [1] [0] [0] [0] [0] [0] [1] | Elem = 9
    [0] [0] [0] [1] [0] [0] [0] [0] [0] [2] | Elem = 9
    [0] [0] [1] [1] [0] [0] [0] [0] [0] [2] | Elem = 2
    [0] [0] [1] [1] [0] [0] [0] [0] [1] [2] | Elem = 8
    [0] [0] [2] [1] [0] [0] [0] [0] [1] [2] | Elem = 8

    Step 2 (Adjusting count array)
    [0] [0] [2] [1] [0] [0] [0] [0] [1] [2]
    [0] [0] [2] [1] [0] [0] [0] [0] [1] [2]
    [0] [0] [2] [3] [0] [0] [0] [0] [1] [2]
    [0] [0] [2] [3] [3] [0] [0] [0] [1] [2]
    [0] [0] [2] [3] [3] [3] [0] [0] [1] [2]
    [0] [0] [2] [3] [3] [3] [3] [0] [1] [2]
    [0] [0] [2] [3] [3] [3] [3] [3] [1] [2]
    [0] [0] [2] [3] [3] [3] [3] [3] [4] [2]
    [0] [0] [2] [3] [3] [3] [3] [3] [4] [6]

    Step 3 (Temp array)                                 | Full array = [1330] [8792] [1594] [4725] [4586] [5729]
    [0] [5729] [0] [0] [0] [0]                          k = 5 | input[k] = 5729 | countArray[2] = (2 - 1) = 1
    [0] [5729] [0] [4586] [0] [0]                       k = 4 | input[k] = 4586 | countArray[8] = (4 - 1) = 3
    [4725] [5729] [0] [4586] [0] [0]                    k = 3 | input[k] = 4725 | countArray[2] = (1 - 1) = 1
    [4725] [5729] [0] [4586] [0] [1594]                 k = 2 | input[k] = 1594 | countArray[9] = (6 - 1) = 5
    [4725] [5729] [0] [4586] [8792] [1594]              k = 1 | input[k] = 8792 | countArray[9] = (5 - 1) = 4
    [4725] [5729] [1330] [4586] [8792] [1594]           k = 0 | input[k] = 1330 | countArray[3] = (3 - 1) = 2

    OBS: It's important to know that once the value is written, we decrement the countArray by one.
         This is for keeping the algorithm stable when dealing with duplicate values. So the duplicate values will keep
         their relative positioning.


    Step 1 (100's position)                                                 | Full array = [7] [7] [3] [5] [7] [5]
    [0] [0] [0] [0] [0] [0] [0] [1] [0] [0] | Elem = 7
    [0] [0] [0] [0] [0] [0] [0] [2] [0] [0] | Elem = 7
    [0] [0] [0] [1] [0] [0] [0] [2] [0] [0] | Elem = 3
    [0] [0] [0] [1] [0] [1] [0] [2] [0] [0] | Elem = 5
    [0] [0] [0] [1] [0] [1] [0] [3] [0] [0] | Elem = 7
    [0] [0] [0] [1] [0] [2] [0] [3] [0] [0] | Elem = 5

    Step 2 (Adjusting count array)
    [0] [0] [0] [1] [0] [2] [0] [3] [0] [0]
    [0] [0] [0] [1] [0] [2] [0] [3] [0] [0]
    [0] [0] [0] [1] [0] [2] [0] [3] [0] [0]
    [0] [0] [0] [1] [1] [2] [0] [3] [0] [0]
    [0] [0] [0] [1] [1] [3] [0] [3] [0] [0]
    [0] [0] [0] [1] [1] [3] [3] [3] [0] [0]
    [0] [0] [0] [1] [1] [3] [3] [6] [0] [0]
    [0] [0] [0] [1] [1] [3] [3] [6] [6] [0]
    [0] [0] [0] [1] [1] [3] [3] [6] [6] [6]

    Step 3 (Temp array)                                 | Full array = [4725] [5729] [1330] [4586] [8792] [1594]
    [0] [0] [1594] [0] [0] [0]                          k = 5 | input[k] = 1594 | countArray[5] = (3 - 1) = 2
    [0] [0] [1594] [0] [0] [8792]                       k = 4 | input[k] = 8792 | countArray[7] = (6 - 1) = 5
    [0] [4586] [1594] [0] [0] [8792]                    k = 3 | input[k] = 4586 | countArray[5] = (2 - 1) = 1
    [1330] [4586] [1594] [0] [0] [8792]                 k = 2 | input[k] = 1330 | countArray[3] = (1 - 1) = 0
    [1330] [4586] [1594] [0] [5729] [8792]              k = 1 | input[k] = 5729 | countArray[7] = (5 - 1) = 4
    [1330] [4586] [1594] [5729] [4725] [8792]           k = 0 | input[k] = 4725 | countArray[7] = (4 - 1) = 3


    Step 1 (1000's position)                                                 | Full array = [1] [4] [1] [5] [4] [8]
    [0] [1] [0] [0] [0] [0] [0] [0] [0] [0] | Elem = 1
    [0] [1] [0] [0] [1] [0] [0] [0] [0] [0] | Elem = 4
    [0] [2] [0] [0] [1] [0] [0] [0] [0] [0] | Elem = 1
    [0] [2] [0] [0] [1] [1] [0] [0] [0] [0] | Elem = 5
    [0] [2] [0] [0] [2] [1] [0] [0] [0] [0] | Elem = 4
    [0] [2] [0] [0] [2] [1] [0] [0] [1] [0] | Elem = 8

    Step 2 (Adjusting count array)
    [0] [2] [0] [0] [2] [1] [0] [0] [1] [0]
    [0] [2] [2] [0] [2] [1] [0] [0] [1] [0]
    [0] [2] [2] [2] [2] [1] [0] [0] [1] [0]
    [0] [2] [2] [2] [4] [1] [0] [0] [1] [0]
    [0] [2] [2] [2] [4] [5] [0] [0] [1] [0]
    [0] [2] [2] [2] [4] [5] [5] [0] [1] [0]
    [0] [2] [2] [2] [4] [5] [5] [5] [1] [0]
    [0] [2] [2] [2] [4] [5] [5] [5] [6] [0]
    [0] [2] [2] [2] [4] [5] [5] [5] [6] [6]

    Step 3 (Temp array)                                 | Full array = [1330] [4586] [1594] [5729] [4725] [8792]
    [0] [0] [0] [0] [0] [8792]                          k = 5 | input[k] = 8792 | countArray[8] = (6 - 1) = 5
    [0] [0] [0] [4725] [0] [8792]                       k = 4 | input[k] = 4725 | countArray[4] = (4 - 1) = 3
    [0] [0] [0] [4725] [5729] [8792]                    k = 3 | input[k] = 5729 | countArray[5] = (5 - 1) = 4
    [0] [1594] [0] [4725] [5729] [8792]                 k = 2 | input[k] = 1594 | countArray[1] = (2 - 1) = 1
    [0] [1594] [4586] [4725] [5729] [8792]              k = 1 | input[k] = 4586 | countArray[4] = (3 - 1) = 2
    [1330] [1594] [4586] [4725] [5729] [8792]           k = 0 | input[k] = 1330 | countArray[1] = (1 - 1) = 0

    Final array = [1330] [1594] [4586] [4725] [5729] [8792]



    Final conclusion
    - Counting sort (stable version) is often used as the sort algorithm for radix sort.
    - It's possible to achieve O(n) due to the assumptions, but it often runs slower than O(nlogn) algorithms because
      of the overhead involved.
    - It might be in-place depending on which sort algorithm you use.
    - It's a stable algorithm which is also a requirement for this algorithm to work.
 */

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        int[] intArray = {4725, 4586, 1330, 8792, 1594, 5729};

        radixSort(intArray, 10, 4);

        System.out.println("Final array");
        Arrays.stream(intArray).forEach(value -> System.out.print("[" + value + "] "));
        System.out.println();
    }

    private static void radixSort(int[] input, int radix, int width)
    {
        // Calling the single sort for each position in the elements. Starting from the most significant digit.
        for (int i = 0; i < width; i++)
        {
            radixSingleSort(input, i, radix);
        }
    }

    private static void radixSingleSort(int[] input, int position, int radix)
    {
        int numItems = input.length;

        int[] countArray = new int[radix];

        System.out.println("Step 1 (1's position)");
        for (int value : input)
        {
            countArray[getDigit(position, value, radix)]++;
            Arrays.stream(countArray).forEach(elem -> System.out.print("[" + elem + "] "));
            System.out.println();
        }

        // Creating step that makes the algorithm stable.
        System.out.println("\nStep 2 (Adjusting count array)");
        for (int j = 1; j < countArray.length; j++)
        {
            countArray[j] += countArray[j - 1];
            Arrays.stream(countArray).forEach(value -> System.out.print("[" + value + "] "));
            System.out.println();
        }

        int[] temp = new int[numItems];

        System.out.println("\nStep 3 (Temp array)");
        // Starting at the end
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--)
        {
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
            Arrays.stream(temp).forEach(value -> System.out.print("[" + value + "] "));
            System.out.println("");
        }
        System.out.println("\n");

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++)
        {
            input[tempIndex] = temp[tempIndex];
        }
    }

    private static int getDigit(int position, int value, int radix)
    {
        return (value / (int) Math.pow(radix, position)) % radix; // Ex: 4567 / (10^2) = 45 % 10 = 5
    }

}
