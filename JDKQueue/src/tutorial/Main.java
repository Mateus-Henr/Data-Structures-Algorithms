package tutorial;

/*  Queues and the JDK

    • A queue backed by an array will have as time complexity O(1) or O(n) which depends on whether there is array
      resizing.
    • A doubly-linked list is the most ideal choice when it comes to queues since we can add at back of the list, and
      remove at the front of the list in constant time.
    • To implement it, we would create a class that would expose only the desired methods.


    The "Queue" interface
    The JDK has this interface that implements methods related to queues. In addition to that, there are several classes
    that implement this interface.
    • It has two methods that are similar "poll" and "remove". The difference is that the "remove" throws an exception
      if it can remove whereas the "poll" returns null.
    • It also has a "offer()" method, that returns a boolean that tells us if it's possible to add an element without
      violating capacity restrictions.
    • There is "element()" as well, similar to "peek()", but it throws an exception if there are no elements.


    ArrayBlockingQueue
    This is a class that implements the Queue interface, its differential is that it doesn't resize the array.
    The capacity cannot be resized. It blocks when attempted a "remove" operation with no elements or an "add" operation
    when the queue is full.
    This is used in a producer/consumer scenario, one add and the other removes. So if the producer attempts to add
    a message to a full queue, it'll block until the consumer removes a message from the queue (the same for the
    opposite).
    This queue is ideal for a chat scenario. The messages get processed in the order that they were sent.


    ConcurrentLinkedQueue
    This is an unbounded thread-safe queue based on a linked list.
    It uses a non-block algorithm.
    Since this is accessed by multiple threads, the "size()" method requires a traversal of the elements, O(n).


    The "Deque" interface
    This interface allows element insertion adn removal at both ends.
    Its name is short for "double ended queue".
    Queue are used more often than deques.
 */

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Main
{
    public static void main(String[] args)
    {
        Queue<String> queue = new ArrayBlockingQueue<>(10);

        // Chat example

        // Sending the messages (producer).
        queue.add("First message");
        queue.add("Second message");
        queue.add("Third message");

        // Receiving the messages (consumer).
        for (String message : queue)
        {
            System.out.println(message);
        }
    }

}
