package tutorial;

public class TreeNode
{

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

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

        if (value < data)
        {
            if (leftChild == null)
            {
                leftChild = new TreeNode(value);
            }
            else
            {
                leftChild.insert(value);
            }
        }
        else
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

    public TreeNode get(int value)
    {
        if (value == data)
        {
            return this;
        }

        if (value < data)
        {
            if (leftChild != null)
            {
                return leftChild.get(value);
            }
        }
        else
        {
            if (rightChild != null)
            {
                return rightChild.get(value);
            }
        }

        return null;
    }

    public int min()
    {
        if (leftChild == null)
        {
            return data;
        }
        else
        {
            return leftChild.min();
        }
    }

    public int max()
    {
        if (rightChild == null)
        {
            return data;
        }
        else
        {
            return rightChild.max();
        }
    }

    public void traverseInOrder() // Visits the left nodes first. NOTICE THAT WE CAN SEE THIS IN THE CODE.
    {
        if (leftChild != null) // LEFT NODE
        {
            leftChild.traverseInOrder();
        }

        System.out.print(data + ", "); // ROOT NODE

        if (rightChild != null) // RIGHT NODE
        {
            rightChild.traverseInOrder();
        }
    }

    public void traversePreOrder() // It visits the root node, then the left subtree, and lastly the right subtree.
    {
        System.out.print(data + ", "); // ROOT NODE

        if (leftChild != null) // LEFT NODE
        {
            leftChild.traversePreOrder();
        }

        if (rightChild != null) // RIGHT NODE
        {
            rightChild.traversePreOrder();
        }
    }

    public void traversePostOrder() // It starts from the leaf right node and goes up, the roots are the last.
    {
        if (leftChild != null) // LEFT NODE
        {
            leftChild.traversePostOrder();
        }

        if (rightChild != null) // RIGHT NODE
        {
            rightChild.traversePostOrder();
        }

        System.out.print(data + ", "); // ROOT NODE
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

    public String toString()
    {
        return "Data = " + data;
    }

}
