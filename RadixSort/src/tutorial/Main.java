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


    Final conclusion
    - Counting sort (stable version) is often used as the sort algorithm for radix sort.
    - It's possible to achieve O(n) due to the assumptions, but it often runs slower than O(nlogn) algorithms because
      of the overhead involved.
    - It might be in-place depending on which sort algorithm you use.
    - It's a stable algorithm which is also a requirement for this algorithm to work.
 */

public class Main
{
    public static void main(String[] args)
    {
        int[] intArray = {4725, 4586, 1330, 8792, 1594, 5729};

        radixSort();
    }

    private static void radixSort()
    {

    }

}
