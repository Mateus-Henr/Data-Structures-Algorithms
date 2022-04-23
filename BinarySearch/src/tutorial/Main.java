package tutorial;

/*  Binary Search

    • Data must be sorted! THE BIG BUT OF THIS ALGORITHM.
    • It's the most used algorithm for searching for a value.
    • If your app is going to do a lot of binary searching, then you should consider inserting data already sorted, so
      then you don't have to sort the data whenever you want to use binary search.
    • The concept of dividing the data structure in half is very similar to merge sort.
    • Can be written recursively.


    How it works
    • Chooses the element in the middle of the array and compares it against the search value.
    • If element is equal to the value, we're done.
    • If element is greater than the value, search the left half of the array.
    • If the element is less than the value, search the right half of the array.
    • We are allowed to do this of breaking the array in half because the data is sorted. Also, the steps below repeat
      until the value is found or when there's no more elements to compare against.


    Example

    Array = [-22] [-15] [1] [7] [20] [35] [55]

    Search value = 1

    Step 1 (entire array)                       Start = 0
        [-22] [-15] [1] [7] [20] [35] [55]      End = 7
                                                Midpoint = (start + end) / 2 = 3 -> [7]

    Step 2 (left half of the array)             Start = 0
        [-22] [-15] [1] [7]                     End = 3 (Gets the midpoint value, because it's the left half)
                                                Midpoint = (start + end) / 2 = 1 -> [-15]

    Step 3 (right half of the array)            Start = 2 (Receives the midpoint, because it's the right half)
        [-22] [-15] [1]                         End = 0
                                                Midpoint = (start + end) / 2 = 1 -> [1] FOUND THE ELEMENT
    OBS: NOTICE THAT THE END IS ALWAYS ONE GREATER.

    Tree representation

        [-22] [-15] [1] [7] [20] [35] [55]
                [-22] [-15] [1]
                       [1]


    Final conclusion
    • At some point, there will be only one element in the partition that you're checking, but it doesn't have to get
      to that point.
    • Can be implemented recursively.
    • O(nlog(n)) - It keeps dividing the array in half.
 */

public class Main
{
    public static void main(String[] args)
    {
        
    }

}
