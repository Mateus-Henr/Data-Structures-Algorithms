package tutorial;

public class EmployeeDoublyLinkedList
{
    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public EmployeeDoublyLinkedList()
    {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public void insertToFront(Employee employeeToAdd)
    {
        EmployeeNode newNode = new EmployeeNode(employeeToAdd);

        if (head == null)
        {
            tail = newNode;
        }
        else
        {
            newNode.setNextNode(head);
            newNode.setPreviousNode(head.getPreviousNode());

            head.setPreviousNode(newNode);
        }

        head = newNode;

        size++;
    }

    public void insertToEnd(Employee employeeToAdd)
    {
        EmployeeNode newNode = new EmployeeNode(employeeToAdd);

        if (tail == null)
        {
            head = newNode;
        }
        else
        {
            newNode.setPreviousNode(tail);
            newNode.setNextNode(tail.getNextNode());

            tail.setNextNode(newNode);
        }

        tail = newNode;

        size++;
    }

    public void insertAtIndex(int position, Employee employeeToAdd)
    {
        if (position > size)
        {
            return;
        }

        EmployeeNode newNode = new EmployeeNode(employeeToAdd);

        if (head == null)
        {
            head = tail = newNode;
            return;
        }

        if (position == (size - 1))
        {
            insertToEnd(employeeToAdd);
        }
        else if (position == 0)
        {
            insertToFront(employeeToAdd);
        }
        else
        {
            EmployeeNode item = searchItem(position - 1);

            newNode.setPreviousNode(item);
            newNode.setNextNode(item.getNextNode());

            item.setNextNode(newNode);
            item.getNextNode().setPreviousNode(newNode);
        }
    }

    public EmployeeNode removeAtIndex(int position)
    {
        if (position > size || isEmpty())
        {
            return null;
        }

        EmployeeNode employeeToRemove;

        if (position == (size - 1))
        {
            employeeToRemove = removeFromEnd();
        }
        else if (position == 0)
        {
            employeeToRemove = removeFromFront();
        }
        else
        {
            employeeToRemove = searchItem(position);

            employeeToRemove.getPreviousNode().setNextNode(employeeToRemove.getNextNode());
            employeeToRemove.getNextNode().setPreviousNode(employeeToRemove.getPreviousNode());
        }

        return employeeToRemove;
    }

    public EmployeeNode removeFromFront()
    {
        if (isEmpty())
        {
            return null;
        }

        EmployeeNode nodeToRemove = head;

        head = head.getNextNode();
        head.setPreviousNode(nodeToRemove.getPreviousNode());

        nodeToRemove.setPreviousNode(null);
        nodeToRemove.setNextNode(null);
        size--;

        return nodeToRemove;
    }

    public EmployeeNode removeFromEnd()
    {
        if (isEmpty())
        {
            return null;
        }

        EmployeeNode nodeToRemove = tail;

        tail = tail.getPreviousNode();
        tail.setNextNode(nodeToRemove.getNextNode());

        nodeToRemove.setPreviousNode(null);
        nodeToRemove.setNextNode(null);
        size--;

        return nodeToRemove;
    }

    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    private EmployeeNode searchItem(int position)
    {
        if (position > size)
        {
            return null;
        }

        EmployeeNode currNode;
        int control = 0;

        if (position <= ((size / 2) - 1))
        {
            currNode = head;

            while (control != position)
            {
                System.out.println(currNode);
                currNode = currNode.getNextNode();
                control++;
            }
        }
        else
        {
            currNode = tail;

            while (control != position)
            {
                System.out.println(currNode);
                currNode = currNode.getPreviousNode();
                control++;
            }
        }

        return currNode;
    }

    public void printListFromHead()
    {
        EmployeeNode currNode = head;

        while (currNode != null)
        {
            System.out.println(currNode);
            currNode = currNode.getNextNode();
        }
    }

    public void printListFromTail()
    {
        EmployeeNode currNode = tail;

        while (currNode != null)
        {
            System.out.println(currNode);
            currNode = currNode.getPreviousNode();
        }
    }

}
