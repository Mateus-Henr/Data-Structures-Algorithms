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
        EmployeeNode newNode = new EmployeeNode(employeeToAdd);

        if (position == size)
        {
            insertToEnd(employeeToAdd);
        }

        EmployeeNode employeeAtPosition = searchEmployee(position);

        if (employeeAtPosition == null)
        {
            return;
        }

        if (employeeAtPosition.getPreviousNode() == null)
        {
            insertToFront(employeeToAdd);
        }
        else
        {
            EmployeeNode beforeEmployee = employeeAtPosition.getPreviousNode();

            newNode.setPreviousNode(beforeEmployee);
            newNode.setNextNode(employeeAtPosition);

            beforeEmployee.setNextNode(newNode);
            employeeAtPosition.setPreviousNode(newNode);
            size++;
        }
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
        size--;

        return nodeToRemove;
    }

    public EmployeeNode removeAtIndex(int position)
    {
        EmployeeNode employeeAtPosition = searchEmployee(position);

        if (employeeAtPosition == null)
        {
            return null;
        }

        if (employeeAtPosition.getNextNode() == null)
        {
            removeFromEnd();
        }
        else if (employeeAtPosition.getPreviousNode() == null)
        {
            removeFromFront();
        }
        else
        {
            employeeAtPosition.getPreviousNode().setNextNode(employeeAtPosition.getNextNode());
            employeeAtPosition.getNextNode().setPreviousNode(employeeAtPosition.getPreviousNode());
            size--;
        }

        employeeAtPosition.setPreviousNode(null);
        employeeAtPosition.setNextNode(null);

        return employeeAtPosition;
    }

    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    private EmployeeNode searchEmployee(int position)
    {
        if (position >= size || isEmpty())
        {
            return null;
        }

        EmployeeNode currNode;
        int control;

        if (position <= ((size / 2) - 1))
        {
            control = 0;
            currNode = head;

            while (control != position)
            {
                currNode = currNode.getNextNode();
                control++;
            }
        }
        else
        {
            control = size - 1;
            currNode = tail;

            while (control != position)
            {
                currNode = currNode.getPreviousNode();
                control--;
            }
        }

        return currNode;
    }

    public void printListFromHead()
    {
        EmployeeNode currNode = head;
        System.out.print("HEAD -> ");
        while (currNode != null)
        {
            System.out.print(currNode);
            System.out.print(" -> ");
            currNode = currNode.getNextNode();
        }
        System.out.println("TAIL");
    }

    public void printListFromTail()
    {
        EmployeeNode currNode = tail;
        System.out.print("TAIL -> ");
        while (currNode != null)
        {
            System.out.print(currNode);
            System.out.print(" -> ");
            currNode = currNode.getPreviousNode();
        }
        System.out.println("HEAD");
    }

}
