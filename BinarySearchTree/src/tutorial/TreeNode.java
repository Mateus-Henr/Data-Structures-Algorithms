package tutorial;

public class TreeNode
{
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    // When we construct a node it will be a leaf node at first. Only after that we connect it to other nodes.
    public TreeNode(int data)
    {
        this.data = data;
    }

    public void insert(int value)
    {
        if (value == data)
        {
            return;
        }

        // Explore the current value's left subtree.
        if (value < data)
        {
            // Checking if there's a left child since we want to insert a value at the leaf.
            if (leftChild == null)
            {
                leftChild = new TreeNode(value); // Found our insertion point.
            }
            else
            {
                // If we don't find our insertion spot, we call the method on the left child until it gets to a leaf.
                leftChild.insert(value);
            }
        }
        else // Explore the current value's right subtree.
        {
            if (rightChild == null)
            {
                rightChild = new TreeNode(value);
            }
            else
            {
                rightChild.insert(value);
            }
        }
    }

    public int getData()
    {
        return data;
    }

    public void setData(int data)
    {
        this.data = data;
    }

    public TreeNode getLeftChild()
    {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild)
    {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild()
    {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild)
    {
        this.rightChild = rightChild;
    }

}
