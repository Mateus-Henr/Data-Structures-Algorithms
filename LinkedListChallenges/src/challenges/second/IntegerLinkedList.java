package challenges.second;

import challenges.first.Employee;

public class IntegerLinkedList
{
    private IntegerNode head;
    private int size;

    public void addToFront(Integer value)
    {
        IntegerNode node = new IntegerNode(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public IntegerNode removeFromFront()
    {
        if (isEmpty())
        {
            return null;
        }

        IntegerNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void insertSorted(Integer value)
    {
        // add your code here
        IntegerNode newNode = new IntegerNode(value);

        // If position is at the start of the list.
        if (head == null || value < head.getValue())
        {
            newNode.setNext(head);
            head = newNode;
            return;
        }

        // Finding the insertion point.
        IntegerNode currNode = head;

        // Checking if we hit the end of the list or found the insertion point.
        while (currNode.getNext() != null && currNode.getValue() < value)
        {
            currNode = currNode.getNext();
        }

        newNode.setNext(currNode.getNext());
        currNode.setNext(newNode);
        size++;
    }

    public IntegerNode searchInsertionPosition(Integer value)
    {
        if (isEmpty())
        {
            return head;
        }

        IntegerNode currNode = head;

        while (currNode != null && currNode.getValue() < value)
        {
            currNode = currNode.getNext();
        }

        return currNode;
    }

    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public void printList()
    {
        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null)
        {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("NULL");
    }

}
