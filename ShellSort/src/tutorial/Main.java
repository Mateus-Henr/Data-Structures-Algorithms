package tutorial;

/*  Shell Sort
    This algorithm is a variation of the insertion sort.
    Whereas insertion sort chooses which element to insert using gaps of 1, this uses larger values for the gaps.
    As the algorithm runs, the gaps is reduced.
    The main goal is to reduce the number of shifting necessary.
    Its time complexity depends on the gap.


    Remember
    If the data is almost sorted, the number of shifting necessary to sort everything is very few, compared to when the
    data is not sorted at all. And this is a characteristic of the insertion sort that the shell sort inherits.


    How does it work
    As mentioned before this is a variation of the insertion sort, therefore it follows almost the same patterns as the
    insertion sort, with the exception concerning the gap for comparison. Shell sort chooses a larger gap for
    comparison, in other words, it doesn't compare values with its neighbours but with other "blocks". And the same
    gap gets reduced throughout time. Furthermore, the last iteration, when the gap is equal to 1, we will be performing
    an insertion sort, being the objective to reduce the number of shifting, as explained in the "Remember".
    Depending on the value of the gap, the time complexity changes
    (https://en.wikipedia.org/wiki/Shellsort#Gap_sequences).


    Knuth Sequence
    This calculates the gap through an equation which is "(3 * k - 1) / 2".
    "k" is set based on the length of the array, the gap must be as close as the length as possible, without being
    greater than it.

    Values for k and the related interval
    k               Gap (interval)
    1                   1
    2                   4
    3                   13
    4                   40
    5                   121


    Example (implementation using Hibbard's increment)

    Array = [20] [35] [-15] [7] [55] [1] [-22]

    Gap
       It'll be based on the array's length.
       Initially, the gap will be three, we are using the gap as "array.length / 2".
       On each iteration we'll divide the gap by 2, in our scenario, it'll be "1 - insertion sort".

    Gap Steps (Gap = 3)                                            | Full array = [20] [35] [-15] [7] [55] [1] [-22]
        [20] [35] [-15] [20] [55] [1] [-22] Gap element = [7]
        [7] [35] [-15] [20] [55] [1] [-22]  Gap element = [7]

        [7] [35] [-15] [20] [55] [1] [-22]  Gap element = [35] (No move)

        [7] [35] [-15] [20] [55] [1] [-22]  Gap element = [-15] (No move)

        [7] [35] [-15] [20] [55] [1] [20]   Gap element = [-22]
        [7] [35] [-15] [-22] [55] [1] [20]  Gap element = [-22]
        [-22] [35] [-15] [7] [55] [1] [20]  Gap element = [7]

    OBS: By moving "-22" to the front of the array with only one assignment, the number of moves decreases substantially
         when applying the insertion sort.

    Step 1 (Gap = 1 So we apply the insertion sort)             | Full array = [-22] | [35] [-15] [7] [55] [1] [20]
        [-22] [35] | [-15] [7] [55] [1] [20]  Elem = 35

    Step 2                                                      | Full array = [-22] [35] | [-15] [7] [55] [1] [20]
        [-22] [35] [35] | [7] [55] [1] [20]  Elem = -15
        [-22] [-15] [35] | [7] [55] [1] [20]

    Step 3                                                      | Full array = [-22] [-15] [35] | [7] [55] [1] [20]
        [-22] [-15] [35] | [35] [55] [1] [20]  Elem = 7
        [-22] [-15] [7] [35] | [55] [1] [20]

    Step 4                                                      | Full array = [-22] [-15] [7] [35] | [55] [1] [20]
        [-22] [-15] [7] [35] [55] | [1] [20]  Elem = 55

    Step 5                                                      | Full array = [-22] [-15] [7] [35] [55] | [1] [20]
        [-22] [-15] [7] [35] [55] | [55] [20]  Elem = 1
        [-22] [-15] [7] [35] [35] | [55] [20]
        [-22] [-15] [7] [7] [35] | [55] [20]
        [-22] [-15] [1] [7] [35] [55] | [20]

    Step 6                                                      | Full array = [-22] [-15] [1] [7] [35] | [55] [20]
        [-22] [-15] [1] [7] [35] [55] | [55]  Elem = 20
        [-22] [-15] [1] [7] [35] [35] | [55]
        [-22] [-15] [1] [7] [20] [35] [55]

    As describe above the code for sorting the array in question, using shell sort would take six loops with regard to
    the number of times that the insertion sort would execute. Therefore, the number of moves decreases, because of the
    "preprocessing" done.


    Final Conclusion
    - In-place algorithm.
    - Difficult to calculate the time complexity since it depends on the gap. Worst case: O(n²), but it can be a lot
      better than it, mainly when using Hibbard's increment or Knuth sequence.
    - Reduces the number of shifting when running the insertion sort.
    - Unstable algorithm since it can alter the ordering of duplicate elements when performing the "preprocessing"
      before executing the insertion sort.

   Curiosity
   Bubble sort can also be improved using the concept of shell sort.
 */

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        // Loop for the gap. Notice that we aren't using the Knuth Sequence.
        for (int gap = intArray.length / 2; gap > 0; gap /= 2)
        {
            for (int firstUnsortedIndex = gap; firstUnsortedIndex < intArray.length; firstUnsortedIndex++)
            {
                if (gap == 1)
                {
                    System.out.println("Step " + firstUnsortedIndex);
                }
                else
                {
                    System.out.println("Gap Step | Elem = " + intArray[firstUnsortedIndex]);
                }

                int newElement = intArray[firstUnsortedIndex];
                int lastSortedIndex = firstUnsortedIndex;

                // The first comparison is to know whether we hit the front of the array.
                while ((lastSortedIndex >= gap) && (intArray[lastSortedIndex - gap] > newElement))
                {
                    intArray[lastSortedIndex] = intArray[lastSortedIndex - gap];
                    lastSortedIndex -= gap;
                    Arrays.stream(intArray).forEach(value -> System.out.print("[" + value + "] "));
                    System.out.println();
                }

                intArray[lastSortedIndex] = newElement;
                Arrays.stream(intArray).forEach(value -> System.out.print("[" + value + "] "));
                System.out.println("\n");
            }
        }

//        shellSortWithKnuth(intArray);
    }

    // Implementation using Knuth sequence
    private static void shellSortWithKnuth(int[] intArray)
    {
        int gap = 1;

        do
        {
            gap = gap * 3 + 1; // Sequence version of the equation.

        } while (gap < intArray.length);

        while (gap > 0)
        {
            for (int firstUnsortedIndex = gap; firstUnsortedIndex < intArray.length; firstUnsortedIndex++)
            {
                if (gap == 1)
                {
                    System.out.println("Step " + firstUnsortedIndex);
                }
                else
                {
                    System.out.println("Gap (" + gap + ") Step | Elem = " + intArray[firstUnsortedIndex]);
                }

                int newElement = intArray[firstUnsortedIndex];
                int lastSortedIndex = firstUnsortedIndex;

                while ((lastSortedIndex >= gap) && (intArray[lastSortedIndex - gap] > newElement))
                {
                    intArray[lastSortedIndex] = intArray[lastSortedIndex - gap];
                    lastSortedIndex -= gap;
                    Arrays.stream(intArray).forEach(value -> System.out.print("[" + value + "] "));
                    System.out.println();
                }

                intArray[lastSortedIndex] = newElement;
                Arrays.stream(intArray).forEach(value -> System.out.print("[" + value + "] "));
                System.out.println("\n");
            }

            gap /= 3; // Changing the gap.
        }
    }

}
