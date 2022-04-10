package tutorial.array;

import java.util.NoSuchElementException;

public class ArrayQueue
{
    private Employee[] queue;
    private int front;
    private int back; // End of the queue is back - 1.

    public ArrayQueue(int capacity)
    {
        queue = new Employee[capacity];
    }

    public void enqueue(Employee employeeToEnqueue)
    {
        // This is problematic because there's the possibility of having space on the queue.
        if (back == queue.length)
        {
            Employee[] newQueue = new Employee[queue.length * 2];
            System.arraycopy(queue, 0, newQueue, 0, queue.length);
            queue = newQueue;
        }

        queue[back++] = employeeToEnqueue;
    }

    public Employee dequeue()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }

        Employee employeeToDequeue = queue[front];
        queue[front++] = null;

        // Optimization
        if (isEmpty())
        {
            front = back = 0;
        }

        return employeeToDequeue;
    }

    public Employee peek()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public boolean isEmpty()
    {
        return (back - front) == 0;
    }

    public int size()
    {
        return back - front;
    }

    public void printQueue()
    {
        System.out.print("FRONT -> ");
        for (int i = front; i < back; i++)
        {
            System.out.print(queue[i] + " -> ");
        }
        System.out.println("BACK");
    }

}
