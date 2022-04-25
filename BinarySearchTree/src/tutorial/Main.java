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

    Notice that the insertion order matters, for that reason to build the tree above we have:
    Insertion order = 25, 20, 15, 27, 30, 29, 26, 22, 32.


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


    Traversing a tree
    When it comes to trees, we "visit" their nodes.
    To traverse a tree, we have at our disposal four ways:
        • Level - Visit nodes on each level from left to right. So we start on level 0 (the root), then level 1, and so
                  on. Not used very often.
        • Pre-order - Visit the root of every subtree first. We start from the root. It starts from the root, visits its
                      entire left subtree and then visits its right subtree.
        • Post-order - Visit the root of every subtree last. We start from the leaf. It starts from the left most leaf
                       and goes to the right most leaf.
        • In-order - Visit left child, then root, then right child for every node. It gives us the values in ascending
                     order (that's why it's called an in-order), so it's really easy to sort the data after inserting it
                     to a binary search tree. If you had an array, inserting its values into a binary search tree and
                     getting the data sorted, it's faster than some sorting algorithms.


    Tree for traversal representations
                        [25]
                [20]               [27]
            [15]     [22]    [26]         [30]
                                      [29]    [32]

    Level traversal
    Order = 25, 20, 27, 15, 22, 26, 30, 29, 32.

    Pre-order traversal
    Order = 25, 20, 15, 22, 27, 26, 30, 29, 32.

    In-order traversal
    Order = 15, 20, 22, 25, 26, 27, 29, 30, 32.

    Post-order traversal
    Order = 15, 22, 20, 26, 29, 32, 30, 27, 25.


    Deletion
    There are three possibilities of node that we can find in a binary search tree, being them:
        1. Node is a leaf. Just null out the node and cut off the connection.
        2. Node has one child. We just move the value up to the parent. Whether the value is greater or less than the
           parent, it's safe to move it up since this child will always be greater or less than the parent. So we
           preserve the concept of a binary search tree.
        3. Node has two children.

    Tree for deletion representations
                        [25]
                [20]               [27]
            [15]     [22]    [26]         [30]
              [17]                    [29]    [32]

    Leaf deletion (node "17")
                        [25]
                [20]               [27]
            [15]     [22]    [26]         [30]
                                      [29]    [32]

    One-child node deletion (node "15")
                        [25]
                [20]               [27]
            [17]     [22]    [26]         [30]
                                      [29]    [32]
    OBS: This is safe to do because we now that everything in 20's left subtree is less than 20.

    Two-children node deletion
    • Notice that the parent might already have two children, so we have to decide where the value would go.
    • Need to figure out what the replacement node will be.
    • Want minimal disruption to the existing tree structure.
    • Can take the replacement node from the deleted node's left subtree or right subtree.
    • If taking it from the left subtree, we have to take the largest value in the left subtree. This happens because
      we need to make sure that the value that will go into the parent is greater than its left child, and less than
      its right child. By searching for the greatest value on the left subtree we keep the binary search tree
      characteristics.
    • If taking it from the right subtree, we have to take the smallest value in the right subtree.
    • Choose one and stick to it.

    Two-children node deletion (node "20")
                        [25]
                [17]               [27]
            [15]     [22]    [26]         [30]
                                      [29]    [32]
    We decided to take the left subtree, so we will be looking for the greatest value which is "17", this value will
    become "15"'s parent, and "15"'s child will be nulled out. If "17" had a left child we would need to bring its left
    child to "17"'s place. NOTICE THAT IF "17" HAD A RIGHT CHILD, "17" COULD NOT BE THE MAXIMUM VALUE.

    Two-children node deletion (node "27")
                        [25]
                [17]               [29]
            [15]     [22]    [26]         [30]
                                              [32]
    Now looking at the right subtree, we would look for the smallest value, which would be "29". And we would do the
    same thing as described when working with the left subtree.

    Two-children node deletion (node "25" root deletion)
                        [26]
                [20]               [27]
            [15]     [22]    [25]         [30]
              [17]                    [29]    [32]
    Looking at the right subtree we would get the smallest value, which would be "26", we would set "26" as the root,
    and we would null out where "26" was.
 */

public class Main
{
    public static void main(String[] args)
    {
        Tree intTree = new Tree();

        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);
        intTree.insert(17);

        System.out.println("In-order traversal");
        intTree.traverseInOrder();

        System.out.println("\nLooking for 27 -> " + intTree.get(27));
        System.out.println("Looking for 17 -> " + intTree.get(17));
        System.out.println("Looking for 43 -> " + intTree.get(43));

        System.out.println("Min value = " + intTree.min());
        System.out.println("Max value = " + intTree.max());

        System.out.println("\nDeleting values");

//        intTree.delete(15);
//        System.out.println("After deleting 15");
//        intTree.traverseInOrder();
//        System.out.println();
//
//        intTree.delete(27);
//        System.out.println("After deleting 27");
//        intTree.traverseInOrder();
//        System.out.println();

        intTree.delete(25);
        System.out.println("After deleting 25");
        intTree.traverseInOrder();
        System.out.println();

        intTree.delete(54);
        System.out.println("After deleting 54 (doesn't exist)");
        intTree.traverseInOrder();
        System.out.println();
    }

}
