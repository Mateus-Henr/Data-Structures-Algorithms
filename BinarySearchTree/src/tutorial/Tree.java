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

    public void traverseInOrder()
    {
        if (root != null)
        {
            root.traverseInOrder();
        }
    }
}
