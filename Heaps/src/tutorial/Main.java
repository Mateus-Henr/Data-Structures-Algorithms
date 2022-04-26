package tutorial;

/*  Heaps

    • It's a special type of binary tree.
    • It has nothing to do with memory.


    What is it?
    • A heap is a complete binary tree. A complete binary tree is when every level of the tree is complete (nodes with
      two children), except for the last level. And the leaves have to be as far to the left as possible.
    • Must satisfy the heap property. It depends on whether heap we are talking about, the max heap or the min heap.
    • Max heap: Every parent is greater than or equal to its children.
    • Min heap: Every parent is less than or equal to its children.


    Building a heap
    • Children are added at each level from left to right.
    • Usually implemented as arrays. When we have a complete binary tree we can back it using arrays.
    • The maximum or minimum value will always be at the root of the tree — the advantage of using a heap. You can
      get the maximum or minimum value in O(1) since we will be accessing the root.
    • Heapify: Process of converting a binary tree into a heap — this often has to be done after an insertion or
               deletion. This is important since when inserting a value, for example, the value will assume the first
               available position from left to right at the last level. So we need to fix the heap.
    • No required ordering between siblings, in other words, node at the same level don't have to be in ascending order
      or descending order. The only thing that matters is the relative values between parent and children.


    Tree (not a heap)
                       [15]
                [22]          [4]
           [19]          [18]     [3]
                             [14]
    The tree above is not a heap because it's not a complete tree. In order for it to be a complete tree, "22" would
    have to have a right child since "22" is not in the last level, also we would have to have more children at the
    last level because children have to be added from the left to the right. In addition to that, it doesn't meet the
    parent/child values relationship for the min or max heap.


    Tree (another tree that's not a heap)
                       [22]
                [19]         [18]
           [3]           [18]    [14]
                             [4]
    Even though the tree above meet the parent/children requirement for a max heap, it doesn't meet the requirement of
    all the levels be full, except for the last level, and the last level has to have nodes starting from the left to
    the right.


    Heap
                       [22]
                [19]          [18]
           [15]     [3]   [14]    [4]
       [12]
    The structure above is a heap because it meets the requirements for a max heap. At the same time all the levels, but
    the last level is complete, and at the last level, we have values starting as far to the left as possible.
    A fun fact about a max heap is that if you travel to the root down to whatever leaf, the values will be in
    descending order. The opposite, travelling to a leaf to the root, would give you values in ascending order.


    Checking if a tree is a heap
    • To check whether a tree is a heap you just have to check all the paths to the leaves to see if all of them are in
      descending order in the case of a max heap. When it comes to a min heap, the opposite would be true, in other
      words, all the paths down would be in ascending order.


    Heap as arrays
    • We can store binary heaps as arrays.
    • We put the root at array[0].
    • We then traverse each level from left to right, and so the left child of the root would go into array[1],
      its right child would to into array[2], etc.
    • If you think about it, it makes sense why we can store a complete binary tree in an array. Looking at an array
      implementation, we have all the values in sequence, so if we have a full tree, and the last level starts from the
      left we can see that we can calculate where the children of a level would be at, and at the last level, as the
      values start from the left, the position in the array would fit perfectly.

    Heap (tree representation)
                       [22]
                [19]          [18]
           [15]     [3]   [14]    [4]
       [12]

    Heap (array representation)
        [22] [19] [18] [15] [3] [14] [4] [12]
    OBS: Notice that in the array implementation, to build it, we just grab the values at each level of the tree from
         the left to the right.

    How to figure out any parent or children in an array
    • Left child = 2i + 1.
    • Right child = 2i + 2.
    • Parent = floor((i - 1) / 2).
    OBS: Notice that this equation wouldn't work if we didn't have a complete binary tree once we don't want to have
         empty positions in the array.

    Given the array before, if we wanted to figure out 15's children we would do:
    • 15's position = 3
    • Left child = 2 * 3 + 1 = 7 -> [12]
    • Right child = 2 * 3 + 2 = 8 -> (Doesn't exist since the array only have 8 slots)
    • Getting the parent using its child = ((7 - 1) / 2) = 3

    Given the array before, if we wanted to figure out 18's children we would do:
    • 18's position = 2
    • Left child = 2 * 2 + 1 = 5 -> [14]
    • Right child = 2 * 2 + 2 = 6 -> [4]
    • Getting the parent using left child = ((5 - 1) / 2) = 2
    • Getting the parent using right child = ((6 - 1) / 2) = 2 // It rounds down since we are working with its.
    OBS: Notice that the rounding down the value is very important to get the same value for the left and right child.


    Inserting into the heap
    • Always add new items to the end of the array.
    • Then we have to fix the heap (heapify). In other words, we have to fix the array to meet the max or min heaps
      criteria.

    How heapify works
    • We compare the new item against its parent. We can do it using the expression.
    • If the item is greater than its parent, we swap it with its parent.
    • We then rinse and repeat. It repeats until everything is properly in their right places.


    Initial tree for insertion operation
                       [22]
                [19]          [18]
           [15]     [3]   [14]    [4]
       [12]

    Inserting "20"
                       [22]
                [19]          [18]
           [15]     [3]   [14]    [4]
       [12]   [20]

    Array = [22] [19] [18] [15] [3] [14] [4] [12] [20]
    OBS: Notice that in the array and in the tree the item always enter at the first available position.
         Also, after inserting "20", we don't have a heap anymore, so we have to fix it.


    Heapifying
    1. Comparing "20" against its parent ("15"), since "20" is greater than its parent, we swap them..
                       [22]
                [19]          [18]
           [20]     [3]   [14]    [4]
       [12]   [15]

    Array = [22] [19] [18] [20] [3] [14] [4] [12] [15]
    The exact same thing occurs in the array, but to figure out the parents position we use the expression that has been
    shown before.

    2. Comparing "20" against its parent ("19"), since "20" is greater than its parent, we swap them.
                       [22]
                [20]          [18]
           [19]     [3]   [14]    [4]
       [12]   [15]

    Array = [22] [20] [18] [19] [3] [14] [4] [12] [15]

    3. Comparing "20" against its parent ("22"), since "20" is smaller than its parent, we are done.
                       [22]
                [20]          [18]
           [19]     [3]   [14]    [4]
       [12]   [15]

    Array = [22] [20] [18] [19] [3] [14] [4] [12] [15]

    OBS: We know that the properties of a max heap is maintained because everytime that we swap, we are swapping a
         greater value with its parent, and so we know that after the swap the parent will have a greater value than
         its child.


    Deleting from the heap
    • Must choose a replacement value (size - 1, when it comes to the array).
    • Will take the rightmost value in the heap (or the right most value in the tree), so that the tree remains
      complete. Remember that one requirement for the heap structure is a complete tree, because of that, if we are
      removing from the heap in an array representation we would only shift values to the right.
    • Then we must heapify the heap.
    • When replacement value is greater than parent, fix heap above. Otherwise, fix heap below. It's more usual to look
      down the heap, when you put a parent in a place that's less than its children. However, it's possible that we
      put it somewhere that's greater than its parent, and for this scenario, we would look up the heap.

    Choosing how to look at the heap
    • We only have to fix the upwards or downwards, never both directions.
    • Fix heap above — Same as insert. Swap replacement value with parent. If the value is greater than its parent.
    • Fix heap below — Swap the replacement value with the larger of its two children. If the value is smaller than its
      children.
    • Rinse and repeat in both cases until the replacement value is in its correct position.
    • Will only need to fix up or down, not both.

    Base heap for deletion representation
                       [80]
                [75]           [60]
           [68]     [55]   [40]    [52]
       [67]

    Delete "75"
                       [80]
                [67]           [60]
           [68]     [55]   [40]    [52]

    Replacement value will be 67 which is the rightmost leaf (in the array representation it's easier to identify,
    being the last value in the array). This way we keep a complete tree.

    Heapifying
    1. Compare "67" against its parent ("80"), as "67" is smaller, then we don't have to fix the heap upwards.
    2. Compare "67" against its children ("68") and ("55"), so we get the largest child ("68"), and swap "67" with
       "68". Notice that we couldn't swap with "55" because we wouldn't have a heap after that.
    OBS: If there were children from the "68" node, we would have to compare "67" against them before swapping, this
         would be the repeat that has been mentioned before.

                       [80]
                [68]           [60]
           [67]     [55]   [40]    [52]


    Delete "40"
                       [80]
                [75]           [60]
           [68]     [55]   [67]    [52]

    Replacement value is 67, the rightmost value in the heap (rightmost leaf at the last level).

    Heapifying
    1. Compare "67" against its parent ("60"), as "67" is greater, then we fix the heap upwards, so we swap it with
       "60".
    2. Compare "67" against its other parent ("80"), as "67" is smaller, we finish the heapifying.
    OBS: Notice that we never get to check the value against its children due to that fact that previously, the parent
         was greater than its children (due to the heap concept). So if we check that the value that's going to take
         the parent's place is greater than the parent, it'll be greater than the previous parent's children.


    Peeking on the heap
    • Get the value at the root.


    Time complexity
    • Insert an item - It takes O(n) time since we have to potentially fix the heap (heapify), and the worst case is
                       if we have to swap the value all the way up to the root.
    • Delete an item - If using a delete method that has to find the value, then we would have linear search, plus the
                       fixing the heap (O(n)). Therefore, we would have a O(nlog(n)) time.
                       But when working with heaps, usually you're going to want to delete the root. And for deleting
                       only the root we would have a O(log(n)) since we don't have to do the linear search.
    • Peek on an item - O(1). The root will always be at index 0.


    Final conclusion
    • We typically use heaps when we are interested in hierarchical relationships, and we want to acquire either the
      minimum or maximum values in constant time. This is different from a binary search tree because when using it
      you have to travel either the right edges or left edges depending on what extreme you want.
 */

public class Main
{
    public static void main(String[] args)
    {
        Heap heap = new Heap(10);

        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        System.out.println("Printing the heap");
        heap.printHeap();

//        System.out.println("\nAfter deleting 75");
//        heap.delete(1); // "75" as in the example.
//        heap.printHeap();

//        System.out.println("\nAfter deleting 40");
//        heap.delete(5); // "40" as in the example.
//        heap.printHeap();

        System.out.println("\nPeeking on the heap = " + heap.peek());

        System.out.println("\nAfter deleting the root");
        heap.delete(0);
        heap.printHeap();

        System.out.println("\nPeeking on the heap = " + heap.peek());
    }

}
