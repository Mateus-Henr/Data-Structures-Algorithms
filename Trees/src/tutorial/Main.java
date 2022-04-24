package tutorial;

/*  Trees

    They can be called a data structure or an abstract data type. This is due to the fact that they dictate how to
    organize the data, but it's also possible to back certain types of trees with arrays.


    Characteristics (terminologies)

    Tree
    • A tree is a hierarchical data structure.
    • Every tree has one or more subtrees (you can start at any given node).
    • Every tree has only one root that is the top most node. It doesn't have a parent.
    • A singleton tree has only one node, the root.

    Node
    • Every item in a tree is called a "node". And nodes can have children.
    • Each node can have only one parent (except for the root that doesn't have any).

    Leaf node
    • A leaf node is when the node has no children.

    Edges
    • The arrows that connects the nodes are called "edges". They always point from the parent to the child.

    Path
    • A path is a sequence of nodes that require to go from one node to another.
    • A route path is how the inverse path, how to get from a node to the root.
    • You cannot have cycles in your path (a path that crosses one node more than once) when it comes to trees.

    Usages
    • They are ideal when things can descend other things, a hierarchical relationship. A child is the descendant of the
      parent node, for example.

    Node's depth
    • This is the numbers of edges from the node to the root. Going up the tree.
    • The root always has a depth of zero once it doesn't have any edges.

    Tree's level
    • The level of a tree contains the nodes that have the same depth.
    • The root has a level of zero.

    Node's height
    • This is the number of edges on the longest path from the node to a leaf. Going down the tree.
    • Leaf nodes always have a height of zero once they don't have any edges.
    • Notice that nodes that are on the same level don't necessarily have the same height.

    Node's ancestors
    • The ancestors of a node are the nodes that are on the node's path.
    • The root doesn't have ancestors since it doesn't have a path.

    Tree's height
    • The height of a tree is the height of its root node.

    Examples of trees
      • Java class hierarchy is an example of a tree. Meaning that, each class can have only one parent. But you can
        have multiple classes extending the same class, so a class can have many children. And the root is the Object
        class.
      • The file system follows a tree structure as well. A folder or a file can have only one parent, but it can have
        multiple children. Each drive is a tree, so the root would be the "C://", for instance.


    Visual representation
                  [15]  (Root)
    [22]          [4]             [17]
    [19]      [9] [18] [3]      [11] [0]    (Leaves)


 */

public class Main
{
    public static void main(String[] args)
    {

    }

}
