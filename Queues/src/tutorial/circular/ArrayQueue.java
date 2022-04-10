package tutorial.circular;

import java.util.NoSuchElementException;

public class ArrayQueue
{
    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity)
    {
        queue = new Employee[capacity];
    }

    public void enqueue(Employee employeeToEnqueue)
    {
        // Adjusting the resizing to just resize when necessary.
        // In order to wrap back to the front, we always need to have an available position, for that reason, we check
        // at "length - 1".
        if (size() == queue.length - 1)
        {
            int numItems = size(); // Needs to save it here since the "back" doesn't represent the size.
            Employee[] newQueue = new Employee[queue.length * 2];

            // Making it also possible if it requires unwrapping.
            System.arraycopy(queue, front, newQueue, 0, queue.length - front);

            // Since wrapping is common, a condition here would be so necessary.
            System.arraycopy(queue, 0, newQueue, queue.length - front, back);

            queue = newQueue;

            front = 0;
            back = numItems;
        }

        queue[back] = employeeToEnqueue;

        if (back < queue.length - 1)
        {
            back++;
        }
        else // This condition will be met if the queue hasn't been resized, meaning that there are empty spaces.
        {
            back = 0;
        }
    }

    public Employee dequeue()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }

        Employee employeeToDequeue = queue[front];
        queue[front++] = null;

        if (isEmpty())
        {
            front = back = 0;
        }
        // "front" now is the one that needs wrapping around to 0.
        else if (front == queue.length) // "front" here is already incremented.
        {
            front = 0;
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
        // Checking if the queue has wrapped.
        if (front <= back)
        {
            return back - front;
        }

        return back - front + queue.length;
    }

    public void printQueue()
    {
        System.out.print("FRONT -> ");
        // Checking if it has wrapped.
        if (front <= back)
        {
            for (int i = front; i < back; i++)
            {
                System.out.print(queue[i] + " -> ");
            }
        }
        else
        {
            for (int i = front; i < queue.length; i++)
            {
                System.out.print(queue[i] + " -> ");
            }
            for (int i = 0; i < back; i++)
            {
                System.out.print(queue[i] + " -> ");
            }
        }
        System.out.println("BACK");
    }

}
