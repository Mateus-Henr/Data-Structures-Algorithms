package tutorial.first;

/*  Trees — Challenge 1

    • Add preorder traversal to our Tree implementation.
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

        System.out.println("Pre order traversal");
        intTree.traversePreOrder();
        System.out.println();

        System.out.println("Post traversal");
        intTree.traversePostOrder();
        System.out.println();

        // Notice that for these traversals, it's only a matter of when we visit the children. The ways that we are
        // visiting these nodes is using the print statement.
    }

}
