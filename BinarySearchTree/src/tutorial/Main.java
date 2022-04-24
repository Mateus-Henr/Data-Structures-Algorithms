package tutorial;

/*  Binary Search Tree

    Binary Tree
    • Every node has 0, 1, or 2 children, being it the maximum number of children that a node can have.
    • Children are referred as left child and right child.
    • In practise, we use binary search trees.
    • A binary tree is complete if every level, except the last level have two children, and in the last level all the
      children must be to left as much as possible.
    • A full binary tree is given when every node has two children, except for the leaves.

    Binary tree representation (incomplete)
                  [15]
           [22]         [4]
         [19]      [18]     [3]
                     [14]

    Binary tree representation (complete)
                  [15]
           [22]         [4]
        [19] [18]     [3]

    Binary tree representation (full, also complete)
                  [15]
           [22]         [4]
        [19] [18]     [3] [2]


    Binary Search Tree (BST)
    • It's called a binary search tree because it's naturally organized to perform binary search.
    • Can perform insertions, deletions, and retrievals in O(logn) time.
    • The left child always has a smaller value than its parent.
    • The right child always has a larger value than its parent.
    • This means everything to the left of the root is less than the value of the root, and everything to the right of
      the root is greater than the value of the root.
    • Because of that, we can do a binary search. Remember that starting from the root we only have two options, so
      we can choose which side to go to based on the value comparison. In other words, they are ideal for binary search.

    Binary tree representation
                 [15]
           [3]         [22]
         [2]      [18]     [25]
                     [19]

    Finding "18" in the above binary tree
    1. Go to the root and compare "18" against the root. Since "18" is greater than the root, the value HAS to be to the
       right of the root.
    2. Compare "18" against the node to the right of the root. Since "18" is smaller than "22", it means that the value
       HAS to be to the left of the parent.
    3. Compare "18" against "18", and we found the value.

    Duplicate values
    • Some binary trees say that they are allowed, and others says that they are not.
    • If they are allowed, a common way to handle them is to store duplicates either to the left subtree or the right
      subtree. Another way is to add a counter for each node.

    Building a binary search tree
                        [25]
                [20]               [27]
            [15]     [22]    [26]         [30]
                                      [29]    [32]

    To build the above tree we do the following (the node insertion matters):
    Insert 25, 20, 15, 27, 30, 29, 26, 22, 32

    Insertion

    Step 1 (inserting 25)
                        [25]

    Step 2 (inserting 20)
                        [25]
                [20]

    Step 3 (inserting 15)
                        [25]
                [20]
            [15]

    Step 4 (inserting 27)
                        [25]
                [20]               [27]
            [15]

    Step 5 (inserting 30)
                            [25]
                [20]               [27]
            [15]     [22]                 [30]

    Step 6 (inserting 29)
                        [25]
                [20]               [27]
            [15]                          [30]
                                      [29]

    Step 7 (inserting 26)
                        [25]
                [20]               [27]
            [15]             [26]         [30]
                                      [29]

    Step 8 (inserting 22)
                        [25]
                [20]               [27]
            [15]     [22]    [26]         [30]
                                      [29]

    Step 9 (inserting 32)
                        [25]
                [20]               [27]
            [15]     [22]    [26]         [30]
                                      [29]    [32]

    OBS: Notice that we put the item at the first empty spot, but using comparison to determine where the item goes.

    More on binary search tree
    • If we change the order that the values are inserted, then we end up with a different tree.
    • If you follow the all the left edges all the way down to the leaf you will find the smallest value in the tree.
      For the maximum value you do the same but with the right edges. So to get these types of values is very quickly.

    Inserting sorted data
    • If you insert sorted data into a binary search tree you will end up in a situation that you have only one "branch"
      that starts from the root.
    • This is not a good situation because it becomes a linked list. So if you search it you will get a linear time
      complexity.
    • Ideally when building a binary search tree you try to keep the heights as balanced as possible. There are some
      trees that detects whether the first built tree is too unbalanced, so if it is, it tries to change nodes positions
      to get a better node arrangement.

    Binary search tree with sorted data representation
                    [25]
                [20]
            [15]
        [10]
 */
public class Main
{
    public static void main(String[] args)
    {

    }
}
