package tutorial.array;

import java.util.EmptyStackException;

public class ArrayStack
{
    private Employee[] stack;
    private int top; // Tracks where the top of the stack is. Points to the next available position on the stack.

    public ArrayStack(int capacity)
    {
        stack = new Employee[capacity];
    }

    // O(n) due to the resizing of the array.
    public void push(Employee employeeToPush)
    {
        if (top == stack.length)
        {
            // A common way to resize an array is to double the length.
            Employee[] newArray = new Employee[stack.length * 2];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }

        stack[top++] = employeeToPush; // O(1)
    }

    // O(1). But if we worry about resizing the array according to the number of empty elements, it would be O(n).
    // There are implementations that worry about resizing and other that don't since this operation is depends on the
    // application.
    public Employee pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }

        // Remember that we are incrementing the top variable at the push method. So, the top would be 1 greater.
        Employee employeeToPop = stack[--top];
        stack[top] = null;

        return employeeToPop;
    }

    public Employee peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public int size()
    {
        return top;
    }

    public boolean isEmpty()
    {
        return top == 0;
    }

    // Printing stack from top to bottom
    public void printStack()
    {
        int biggestSize = 0;

        for (int i = top - 1; i >= 0; i--)
        {
            if (stack[i].toString().length() > biggestSize)
            {
                biggestSize = stack[i].toString().length();
            }
        }

        for (int i = top - 1; i >= 0; i--)
        {
            System.out.println("|   " + stack[i] + " ".repeat(biggestSize - stack[i].toString().length()) + "   |");
        }

        System.out.println("|" + "_".repeat(biggestSize + 6) + "|");
    }

}
