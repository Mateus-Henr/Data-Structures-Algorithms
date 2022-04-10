package tutorial.circular;

/*  Circular Queue

    • This is a solution to avoid unnecessary resizing regarding the array queue implementation.
    • Due to the current implementation in the "array" package, the array could be resized pointlessly, this issue is
      raised due to the fact that we are only checking the "pointer" of the back field of the queue.
      Since we are only checking this value, and because an array is being used to back the queue, there might be
      empty spaces in the front of the array (the user might have removed some elements), because of that, by ignoring
      these empty spaces we would be resizing the array unnecessarily.
    • By wrapping "back" to the front of the queue we can fix this problem. And the problem of have the queue
      unorganized can be fixed by unwrapping the queue when resizing the array.



     Example when resizing is needed
     When we get to the point displayed below, in order to have an empty space to make possible the wrap back to the
     beginning the queue needs to be resized.
        [Jane]   [John]   [Mary]   [Mike]   [NULL]
        (FRONT)                             (BACK)

     Adding "Bill" (after resizing)
        [Jane]   [John]   [Mary]   [Mike]   [Bill]   [NULL]   [NULL]   [NULL]   [NULL]   [NULL]
        (FRONT)                                      (BACK)


    Example when there's an empty space
    Adding elements
        [Jane]   [John]   [NULL]   [NULL]   [NULL]
        (FRONT)           (BACK)

    Removing "Jane"
        [NULL]   [John]   [NULL]   [NULL]   [NULL]
                 (FRONT)  (BACK)

    Adding "Mary"
        [NULL]   [John]   [Mary]   [NULL]   [NULL]
                 (FRONT)           (BACK)

    Removing "John"
        [NULL]   [NULL]   [Mary]   [NULL]   [NULL]
                          (FRONT)  (BACK)

    Adding "Mike"
        [NULL]   [NULL]   [Mary]   [Mike]   [NULL]
                          (FRONT)           (BACK)

    Removing "Mary"
        [NULL]   [NULL]   [Mary]   [Mike]   [NULL]
                                   (FRONT)  (BACK)

    Adding "Bill" (the "else" condition gets executed, and back is set to 0) (Still O(1))
        [NULL]   [NULL]   [Mary]   [Mike]   [Bill]
        (BACK)                     (FRONT)

    Adding "Jane" and "John"
        [Jane]   [John]   [Mary]   [Mike]   [Bill]
                          (BACK)   (FRONT)

    Resizing the array (by doing it we adjust back and front to their "natural" positions)
        [Mike]   [Bill]   [Jane]   [John]   [Mary]   [NULL]   [NULL]   [NULL]   [NULL]   [NULL]
        (FRONT)                                      (BACK)
 */

public class Main
{
    public static void main(String[] args)
    {
        Employee janeJones = new Employee(13435434, "Jane", "Jones");
        Employee johnDoe = new Employee(54546587, "John", "Doe");
        Employee marySmith = new Employee(76897876, "Mary", "Smith");
        Employee mikeWilson = new Employee(67535461, "Mike", "Wilson");
        Employee billEnd = new Employee(45645657, "Bill", "End");

        ArrayQueue queue = new ArrayQueue(5);

        // Represent the problem. There's never more than 2 employees in the queue. So the array MUST NOT BE RESIZED.
        queue.enqueue(janeJones);
        queue.enqueue(johnDoe);
        queue.dequeue();
        queue.enqueue(marySmith);
        queue.dequeue();
        queue.enqueue(mikeWilson);
        queue.dequeue();
        queue.enqueue(billEnd);
        queue.dequeue();
        queue.enqueue(janeJones); // This is the 6th add.

        queue.printQueue();

//        queue.enqueue(janeJones);
//        queue.enqueue(johnDoe);
//        queue.enqueue(marySmith);
//        queue.enqueue(mikeWilson);
//        queue.enqueue(billEnd);
//        //queue.printQueue();
//
//        queue.dequeue();
//        queue.dequeue();
//        //queue.printQueue();
//
//        //System.out.println(queue.peek());
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
//        //queue.dequeue();
//
//        queue.enqueue(mikeWilson);
//
//
//        queue.printQueue();
    }

}
