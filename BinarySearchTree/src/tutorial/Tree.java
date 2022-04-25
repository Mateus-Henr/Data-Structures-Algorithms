package tutorial;

public class Tree
{
    // We only need the root.
    private TreeNode root;

    // When inserting we insert at the very first empty spot we find.
    public void insert(int value)
    {
        if (root == null)
        {
            root = new TreeNode(value);
        }
        else
        {
            // Always start from the root, and it looks for the position.
            root.insert(value);
        }
    }

    public void delete(int value)
    {
        // If the root is the value that we want to delete, then it'll change.
        root = delete(root, value); // Starting from the root to start traversing the tree.
    }

    // If the value to be deleted is not the root, then the same root's value is returned. Otherwise, a new root will be
    // returned.
    private TreeNode delete(TreeNode subtreeRoot, int value)
    {
        if (subtreeRoot == null)
        {
            return null;
        }

        // Go down to the left subtree.
        if (value < subtreeRoot.getData())
        {
            // Replace the left child with the result of the delete method.
            // If the left child is the value that we want to delete, the left child of this node will be replaced.
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
        }
        else if (value > subtreeRoot.getData()) // Go down to the right subtree.
        {
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
        }
        else // In case that we found the node to be deleted.
        {
            // Cases 1 and 2: node to delete has 0 or 1 child(ren).
            if (subtreeRoot.getLeftChild() == null)
            {
                // If it has a right child then we want it to replace the root. Notice that this is one return
                // possibility to when calling the delete method.
                return subtreeRoot.getRightChild();
            }
            else if (subtreeRoot.getRightChild() == null)
            {
                return subtreeRoot.getLeftChild();
            }
            else // Case 3: node to delete has 2 children.
            {
                // We want to find the minimum value in the right subtreeRoot.
                // AT THIS POINT "subtreeRoot" IS THE ROOT THAT WE WANT TO DELETE.
                // Replace the value in the subtreeRoot node with the smallest value from the right subtree.
                subtreeRoot.setData(subtreeRoot.getRightChild().min());

                // Delete the node that has the smallest value in the right subtree.
                subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
            }
        }

        return subtreeRoot;
    }

    public TreeNode get(int value)
    {
        if (root == null)
        {
            return null;
        }

        return root.get(value);
    }

    public int min()
    {
        if (root == null)
        {
            return Integer.MIN_VALUE;
        }

        return root.min();
    }

    public int max()
    {
        if (root == null)
        {
            return Integer.MAX_VALUE;
        }

        return root.max();
    }

    public void traverseInOrder()
    {
        if (root != null)
        {
            root.traverseInOrder();
        }
    }

}
