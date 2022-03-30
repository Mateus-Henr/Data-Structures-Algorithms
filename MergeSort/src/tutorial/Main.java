package tutorial;

/*  Merge Sort

    A divide and conquer algorithm.
    Recursive algorithm.
    It has two major phases, the splitting phase, and the merging phase.
    By applying the splitting phase (it's a preparations phase), it leads to a faster sorting during the merging phase
    (the merging phase is responsible for the sorting).
    The splitting is logical, we don't create new arrays. In other words, we use indexes to keep track of where the
    array has been split.


    Splitting phase
    The splitting phase consists in splitting the arrays into two arrays until we get to the point when all arrays
    have one element each. Therefore, by default, when an array has only one element, this array is sorted.
    If the array has an odd number of element, which array is bigger will depend on the implementation.

    Steps
    1 - Start with an unsorted array.
    2 - Divide the array into two arrays, the left part is the left array, and the right part is the right array.
    3 - Keep splitting the array in half until all the arrays have one element each.

    OBS: You can look at this face as a binary tree.


    Merging phase
    Once the splitting phase is completed, this phase is performed.
    This phase merges every left/right pair of sibling arrays into a sorted array. Hence, after the first merge, we will
    have a bunch of 2-elements sorted arrays. And this same process is repeated until we have a single sorted array.
    It's CRUCIAL to remember that this phase is not in-place. It uses temporary arrays.

    Steps
    1 - Merge every left/right pair of sibling arrays into a sorted array.
    2 - Repeats the first process until we have a single sorted array. Thus, during the merging phase, we will have
    arrays of size 2ⁿ, according to the current phase.


    Example

    Array = [20] [35] [-15] [7] [55] [1] [-22]


    Splitting phase
    Step 1                                      Full array = [20] [35] [-15] [7] [55] [1] [-22]
        [20] [35] [-15] | [7] [55] [1] [-22]

    Step 2 (left array of step 1)               Full array = [20] [35] [-15] | [7] [55] [1] [-22]
        [20] | [35] [-15]

    Step 3 (right array of step 2)              Full array = [20] | [35] [-15] | [7] [55] [1] [-22]
        [35] | [-15]

    Step 4 (right array of step 1)              Full array = [20] | [35] | [-15] | [7] [55] [1] [-22]
        [7] [55] | [1] [-22]

    Step 5 (left array of step 4)               Full array = [20] | [35] | [-15] | [7] [55] | [1] [-22]
        [7] | [55]

    Step 6 (right array of step 4)              Full array = [20] | [35] | [-15] | [7] | [55] | [1] [-22]
        [1] | [-22]

    Tree structure representation (for the splitting)
                                       {20, 35, -15, 7, 55, 1, -22}
                                     {20, 35, -15}    {7, 55, 1, -22}
                                 {20}    {35, -15}    {7, 55}    {1, -22}
                            {20}    {35}    {-15}    {7}    {55}    {1}    {-22}

    OBS: The left side of the array comes first due to the recursion that's performed.


    Merging phase
    It's important to know that given the array above, all elements but 20 are organized in pairs, or siblings, and
    that those siblings will be merged first. In other words, we always merge sibling left/right. Also, each merge array
    will be sorted.

    How it works
    We create a temporary array large enough to hold all the elements in the arrays being merged.
    We set "i" to the first index of the left array, and "j" to the first index of the second array.
    We compare left[i] to right[j]. If left is smaller, we copy it to the temp array and increment "i" by one.
    Otherwise, we copy it to the temp array and increment "j" by one.
    And this will be repeated until all the elements are processed.
    After all of this, we copy the sorted values back to the original array.
    If the left array is at positions x to y, and the right array is at positions y + 1 to z, then after the copy,
    positions x to z will be sorted in the original array.

    Step 1 (i = 1 & j = 2)
    Pair = {35} {-15}
    Temporary array = {-15, 35} // This is copied to the original array.
    Original array = {20, -15, 35, 7, 55, 1, -22}   We copied the values back to position 1 and 2.

    Step 2 (i = 0 & j = 1)
    Pair = {20} {-15, 35}               Notice that we are processing the left partition here.
    Temporary array = {-15, 20, 35}     -15 is smaller than 20,so it's copied to the temp array, and j is incremented.
    Original array = {-15, 20, 35, 7, 55, 1, -22}   We copied the values back to position 0, 1, and 2.

    Step 3 (i = 3 & j = 4)
    Pair = {7} {55}
    Temporary array = {7, 55}
    Original array = {20, -15, 35, 7, 55, 1, -22}   We copied the values back to position 3 and 4.

    Step 3 (i = 5 & j = 6)
    Pair = {1} {-22}
    Temporary array = {-22, 1}
    Original array = {20, -15, 35, 7, 55, -22, 1}   We copied the values back to position 5 and 6.

    Step 4 (i = 3 & j = 5)
    Pair = {7, 55} {-22, 1}
    Temporary array = {-22, 1, 7, 55}
    Original array = {20, -15, 35, -22, 1, 7, 55}   We copied the values back to position 3, 4, 5, and 6.

    Step 5 (i = 0 & j = 3)
    Pair = {-15, 20, 35} {-22, 1, 7, 55}
    Temporary array = {-22, -15, 1, 7, 20, 35, 55}
    Original array = {-22, -15, 1, 7, 20, 35, 55}   We copied the values back to position all the positions.

    OBS: It's important to know that for sorting, we compare "i" and "j". We first compare "i" to "j", if "i" is
         smaller, then "i" is saved in the temp array and incremented by one, if "j" is smaller t, then "j" is saved
         in the temp array and incremented by one. Remember that this is only possible because the temp arrays are
         already organized.

    Tree structure representation (for the merging, so it's inverted)
                            {20}    {35}    {-15}    {7}    {55}    {1}    {-22}
                                  {20}    {-15, 35}    {7, 55}    {-22, 1}
                                     {-15, 20, 35}    {-22, 1, 7, 55}
                                       {-22, -15, 1, 7, 20, 35, 55}


    Final conclusion
    NOT an in-place algorithm.
    It has a complexity of O(nlogn) - base 2. Due to the fact that we are repeatedly diving the array in half.
    Stable algorithm. This is because when we do the merging, we check whether the element in the left is smaller than
    the element in the right, consequently, if the element in the left is smaller, this one is going to be added first
    in the temporary array, so the relative ordering of duplicate elements is kept.
    Nowadays, memory is cheap, but it still needs to take into question.
 */

public class Main
{
    public static void main(String[] args)
    {

    }

}
