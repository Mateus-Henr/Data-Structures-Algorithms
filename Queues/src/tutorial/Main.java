package tutorial;

/*  Queues

    • An abstract data type, therefore they don't dictate the way that you store the data, but the dictate the way that
      you access the data.
    • FIFO - First In, First Out. Just like a queue (or a lineup) to enter the cinema.
    • The two most used data structures for implementing queues are arrays, and linked lists.


    Operations
    • Enqueue (add) - Adds an item to the end of the queue.
    • Dequeue (remove) - Removes the item at the front of the queue.
    • Peek (Get) - Get the item at the front of the queue, but don't remove it.


    Enqueueing example

    Initial queue
    [10]    [15]    [5]     [22]
    Front                   Back

    After enqueueing "20"
    [10]    [15]    [5]     [22]     [20]
    Front                            Back


    Dequeueing example

    Initial queue
    [10]    [15]    [5]     [22]
    Front                   Back

    After dequeueing "10"
    [10]    [15]    [5]     [22]     [20]
           Front                     Back
    OBS: Depending on the implementation "10" gets removed.


    Peeking example

    Initial queue
    [10]    [15]    [5]     [22]
    Front                   Back

    After dequeueing "10"
    [10]    [15]    [5]     [22]     [20]
           Front                     Back
    Returns "15".


    Time complexity
    It depends on which data structure you're backing the queue with.
        • When it comes to array, whether an operation is O(1) or O(n) depends on whether you have to resize the array.
        • When it comes to a linked list, the operations described above are O(1).
 */

public class Main
{
    public static void main(String[] args)
    {

    }

}
