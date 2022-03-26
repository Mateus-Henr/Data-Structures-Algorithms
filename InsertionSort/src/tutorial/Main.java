package tutorial;

/*  Insertion Sort

    Just like previous algorithm seen, it partitions the array into a sorted and unsorted partitions.
    However, the implementation shown here the sorted partition will start from the left.


    How it works
    We basically get the elements from the unsorted partition and insert it into the sorted partition already in its
    correct position. Looking at the array as a sorted and an unsorted partition, in the first iteration, we consider
    the sorted partition as just the first element (and since the sorted partition only has one element, it means that
    it's sorted), and then we start going thorough the unsorted partition and adding those elements to the sorted one.
    Consequently, at the end of each iteration, the sorted partition will have grown by one.
    For inserting the value, we traverse the sorted partition from left to right (biggest to smallest), while looking
    for a value that is less or equal to the one to be added. Once we find it we insert our value at that position and
    fix the positions of the other elements (shift them to the right).


    Remember
    Looking for value to add - Unsorted partition
    Inserting a value - Sorted partition


    Example (The "|" shows the division between the sorted and unsorted partition)

    Array = [20] [35] [-15] [7] [55] [1] [-22]

    Step 1                                      | Full Array = [20] | [35] [-15] [7] [55] [1] [-22]
        [20] [35] | [-15] [7] [55] [1] [-22]

    Step 2                                      | Full Array = [20] [35] | [-15] [7] [55] [1] [-22]
        [20] [35] | [35] [7] [55] [1] [-22]  (-15 is saved in a variable)
        [20] [20] | [35] [7] [55] [1] [-22]
        [-15] [20] [35] | [7] [55] [1] [-22]

    Step 3                                      | Full Array = [-15] [20] [35] | [7] [55] [1] [-22]
        [-15] [20] [35] | [35] [55] [1] [-22] (7 is saved in a variable)
        [-15] [20] [20] | [35] [55] [1] [-22]
        [-15] [7] [20] [35] | [55] [1] [-22]

    Step 4                                      | Full Array = [-15] [7] [20] [35] | [55] [1] [-22]
        [-15] [7] [20] [35] [55] | [1] [-22]

    Step 4                                      | Full Array = [-15] [7] [20] [35] [55] | [1] [-22]
        [-15] [7] [20] [35] [55] | [55] [-22] (1 is saved in a variable)
        [-15] [7] [20] [35] [35] | [55] [-22]
        [-15] [7] [20] [20] [35] | [55] [-22]
        [-15] [7] [7] [20] [35] | [55] [-22]
        [-15] [1] [7] [20] [35] [55] | [-22]

    Step 5                                      | Full Array = [-15] [1] [7] [20] [35] [55] | [-22]
        [-15] [1] [7] [20] [35] [55] | [55] (-22 is saved in a variable)
        [-15] [1] [7] [20] [35] [35] | [55]
        [-15] [1] [7] [20] [20] [35] | [55]
        [-15] [1] [7] [7] [20] [35] | [55]
        [-15] [1] [1] [7] [20] [35] | [55]
        [-15] [-15] [1] [7] [20] [35] | [55]
        [-22] [-15] [1] [7] [20] [35] [55]

    As shown above, for the array in question, five iterations were necessary to sort the array.


    Final Conclusion
    - In place algorithm.
    - It's a O(n²).
    - It's a stable algorithm since it goes through the sorted partition from the left to the right, and we stop
      when an element is less or equal to the being inserted. In other words, the element being inserted will be
      inserted to the right of the found position.


    Curiosity
    We can implement a binary search in order to reduce the number of comparisons. But the number of moves won't
    change.
 */

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++)
        {
            System.out.println("Step " + firstUnsortedIndex);

            int newElement = intArray[firstUnsortedIndex];
            int lastSortedIndex = firstUnsortedIndex;

            // Shifting elements and looking for position for inserting the element.
            while (lastSortedIndex > 0 && intArray[lastSortedIndex - 1] > newElement)
            {
                intArray[lastSortedIndex] = intArray[lastSortedIndex - 1];
                lastSortedIndex--;

                Arrays.stream(intArray).forEach(value -> System.out.print("[" + value + "] "));
                System.out.println();
            }

            intArray[lastSortedIndex] = newElement;
            Arrays.stream(intArray).forEach(value -> System.out.print("[" + value + "] "));
            System.out.println("\n");
        }
    }

}
