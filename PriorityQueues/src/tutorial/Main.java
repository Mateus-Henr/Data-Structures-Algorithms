package tutorial;

import java.util.Arrays;
import java.util.PriorityQueue;

/*  Priority Queues

    • This a very common use of heaps.
    • This is an unbounded priority queue based on a priority heap.
    • Even though the priority queue is unbounded, the internal array has a capacity, so it resizes the array if you try
      to add something to an array that's already full.
    • Also, this implements a min heap, so the item between 1 and 2, would be 1.
    • Queues are FIFO, but combining it with heaps, we can get the first item with the highest priority (in the case
      of this implementation the lower the number the higher priority it has).
    • We can always get the highest priority item in constant time because it'll be at the root.
    • The synchronized version of this is the "PriorityBlockingQueue" class.
    • If you want a max heap, you could provide a Comparator to the class to get this behaviour.


    Common operations
    • Insert with priority, remove the highest priority item, and peek.


    Using it with object
    • To use it with objects, the class has to implement the Comparable interface, so the queue can decide how to
      organize the items. It's also possible to provide a Comparator when you construct the queue.


    Example
    • It would be like an emergency room at a hospital, a queue that's based on severity of the patient. So, once we
      remove the highest priority item (at index 0), we fix the heap, and we go the next priority item.
 */
public class Main
{
    public static void main(String[] args)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);

        // Peek at the highest priority item
        System.out.println("Peeking at the priority queue = " + pq.peek());

        // Remove the highest priority item
        System.out.println("\nRemoving the highest priority item = " + pq.remove());
        System.out.println("\nPeeking after removing the highest priority item = " + pq.peek());

        // Poll (the same thing as remove)
        System.out.println("\nPolling the highest priority item = " + pq.poll());
        System.out.println("\nPeeking after polling the highest priority item = " + pq.peek());

        // Removing a random number
        System.out.println("\nRemoving 54 = " + pq.remove(54));
        System.out.println("\nPeeking after removing 54 = " + pq.peek());

        // Adding an item that's going to become the root
        pq.add(-1);
        System.out.println("\nPeeking after adding item = " + pq.peek());

        // Getting the array from the queue.
        System.out.println("\nPrinting the queue's array out");
        Object[] intArray = pq.toArray();
        Arrays.stream(intArray).forEach((item) -> System.out.print("[" + item + "] "));
        System.out.println();
    }

}
