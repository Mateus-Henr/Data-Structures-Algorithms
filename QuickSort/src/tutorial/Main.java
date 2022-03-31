package tutorial;

/*  Quick Sort

    A divide and conquer algorithm.
    By default, it's recursive.
    It uses a pivot element to partition the array into two parts.
    On the left stay the elements that are smaller than the pivot, and on the right, elements that are greater than it.
    And this is called the partitioning step. After that, the pivot will be in its correct sorted position.
    Important to notice that both sides of the array aren't necessarily sorted. They are only separated regarding its
    value in comparison to the pivot.
    The process described above is repeated until we have 1-element arrays. So, eventually, all elements will have been
    chosen as a pivot, consequently they will be in their right position.
    This is an in-place algorithm.


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

    Array = [20] [35] [-15] [7] [55] [1] [-22]

    Step 1 (Pivot = 20)                             Full array = [20] [35] [-15] [7] [55] [1] [-22]
        [-22] [35] [-15] [7] [55] [1] [-22]  (i = 1 | j = 6)
        [-22] [35] [-15] [7] [55] [1] [35]   (i = 2 | j = 6)
        [-22] [1] [-15] [7] [55] [35] [35]   (i = 1 | j = 5)
        [-22] [1] [-15] [7] [35] [55] [35]   (i = 4 | j = 5) (after this, "i" and "j" will have crossed each other)
        [-22] [1] [-15] [7] [20] [55] [35]   (the value of "i" will be the sorted position of the pivot value)

    Step 2 (Pivot = -22)                            Full array = [-22] [1] [-15] [7] [20] [55] [35]
        [-22] [35] [-15] [7]  (there's no value smaller than the pivot, so "i" and "j" will cross each other)

    Step 3 (Pivot = -22)                            Full array = [-22] [35] [-15] [7] [20] [55] [35]
        [-22] [35]

    Step 4 (Pivot = -15)                            Full array = [-22] [35] [-15] [7] [20] [55] [35]
        [-15] [7]

    Step 5 (Pivot = 55)                             Full array = [-22] [35] [-15] [7] [20] [55] [35]
        [-22] [1] [-22]  (i = 0 | j = 6)
        [-22] [1] [55]   (i = 6 | j = 6)

    Step 6 (Pivot = 55)                             Full array = [-22] [35] [-15] [7] [20] [55] [35]
        [-22] [1]

    Step 6 (Pivot = 55)                             Full array = [-22] [35] [-15] [7] [20] [55] [35]
        [-22] [1]

    Final conclusion
    In-place algorithm.
    O(nlogn) - base 2. We're repeatedly partitioning the array into two halves. In the worst case, it's a O(n²). But
    most of the time it performs as O(nlogn), and it performs better than merge sort.
    Unstable algorithm. This is due to the fact that when we are alternating between the "i" and "j", we are taking
    values out of the relative ordering, in the case of duplicate elements.
    The choice of pivot can have an effect in the time complexity.

 */

public class Main
{
    public static void main(String[] args)
    {

    }

}
