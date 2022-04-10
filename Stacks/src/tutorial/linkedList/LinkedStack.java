package tutorial.linkedList;

import java.util.LinkedList;
import java.util.ListIterator;

// THIS CLASS HAS BEEN CREATED TO ALLOW THE USERS TO ONLY CALL METHODS RELATED TO A STACK.
// EXPOSING ONLY SPECIFIC STACK METHODS.
public class LinkedStack
{
    // Using the JDK LinkedList for backing our stack.
    // Even though usually a stack is based on a singly-linked list, here we will be using a doubly-linked list since
    // memory is not an issue.
    private LinkedList<Employee> stack;

    public LinkedStack()
    {
        stack = new LinkedList<>();
    }

    // O(1)
    public void push(Employee employeeToPush)
    {
        stack.push(employeeToPush);
    }

    // O(1)
    public Employee pop()
    {
        return stack.pop();
    }

    // O(1)
    public Employee peek()
    {
        return stack.peek();
    }

    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    public void printStack()
    {
        ListIterator<Employee> iterator = stack.listIterator();

        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

}
