package tutorial;

public class EmployeeSinglyLinkedList
{
    private EmployeeNode HEAD;
    private int size;

    public EmployeeSinglyLinkedList()
    {
        this.HEAD = null;
        this.size = 0;
    }

    // O(1)
    public void addToFront(Employee employeeToAdd)
    {
        EmployeeNode newNode = new EmployeeNode(employeeToAdd);
        newNode.setNextNode(HEAD);
        HEAD = newNode;
        size++;
    }

    // O(1)
    public EmployeeNode removeFromFront()
    {
        if (isEmpty())
        {
            return null;
        }

        EmployeeNode nodeToRemove = HEAD;
        HEAD = HEAD.getNextNode();

        size--;
        nodeToRemove.setNextNode(null); // Cleaning the past reference.

        return nodeToRemove;
    }

    // O(1)
    public int getSize()
    {
        return this.size;
    }

    // O(1)
    public boolean isEmpty()
    {
        return HEAD == null;
    }

    // O(n)
    public void printList()
    {
        EmployeeNode currNode = HEAD;
        System.out.print("HEAD -> ");
        while (currNode != null)
        {
            System.out.print(currNode);
            System.out.print(" -> ");
            currNode = currNode.getNextNode();
        }
        System.out.println("NULL");
    }

}
