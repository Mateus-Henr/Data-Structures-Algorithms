package tutorial.array;

/*  Stacks (Array)

    • They dictate what operations we can do on the items. They are also known as an abstract data type.
    • LIFO (Last In, First Out). Therefore, NO RANDOM ACCESS.
    • The ideal backing data structure is usually a linked list, but you can back it with whatever data structure.
      This data structure is ideal because when working with a linked list we always want to deal with the head (or
      the tail), so it would align interests perfectly with the stack.
    • The item on the top is the only one that can be manipulated.
    • It's like a mountain of papers, we can add a paper, but everytime that we need a paper other than the top one,
      we need to go through the entire pile starting from the top.


    Operations
    • Push - Adds an item as the top item on the stack.
    • Pop - Removes the top item on the stack.
    • Peek - Gets the top item on the stack without popping it.


    Call Stack
    This is an example of use of stack. Regarding it, when a method gets called, and it calls another method, the first
    waits until the one that it has called finish its "job".


    Empty stack example

    |          | top = null
    |          |
    |          |
    |          |
    |__________|

    Pushing "Jane"

    |          |
    |          |
    |          |
    |   Jane   |  <- top
    |__________|

    Pushing "John"

    |          |
    |          |
    |   John   |  <- top
    |   Jane   |
    |__________|

    Pushing "Mary"

    |          |
    |   Mary   |  <- top
    |   John   |
    |   Jane   |
    |__________|

    Popping

    |          |
    |          |
    |   John   |  <- top
    |   Jane   |
    |__________|

    Peeking

    |          |
    |          |
    |   John   |  <- top
    |   Jane   |
    |__________|


    Time complexity
    It depends on the data structure backing up the stack.
        • O(1) for operations such as pop, push, and peek, when using a liked list for backing it.
        • If you use an array,then push is O(n), because the array may have to be resized.
        • If it's known in advance the maximum number of elements that a stack will have, or memory is tight (doesn't
          use "next field" overhead that a linked list uses), an array can be a good choice.
        • Linked list tends to be ideal.


    Using an array
    • Even though arrays are good for random access, stacks don't use it.
    • They have an initial size.
    • As classes such as ArrayList, and Vector are also backed by an array they would have the same problems.


    Final conclusion
    • Knowing the maximum capacity array is more advantageous. Consumes less memory. However, if it needs resizing we
      have a huge drawback.
    • Linked list is usually the best data structure, but it consumes more memory due to the "next field".
 */

public class Main
{
    public static void main(String[] args)
    {
        ArrayStack stack = new ArrayStack(10);

        // Using "push()"
        stack.push(new Employee(13435434, "Jane", "Jones"));
        stack.push(new Employee(54546587, "John", "Doe"));
        stack.push(new Employee(76897876, "Mary", "Smith"));
        stack.push(new Employee(67535461, "Mike", "Wilson"));
        stack.push(new Employee(53564645, "Bill", "End"));

        // Printing the stack
        System.out.println("Printing the stack");
        stack.printStack();

        // Using "peek()"
        System.out.println("\nPeeking the stack");
        System.out.println("Peek = " + stack.peek());
        stack.printStack();

        // Using "pop()"
        System.out.println("\nPopping item");
        System.out.println("Popped = " + stack.pop());
        System.out.println("Peek = " + stack.peek());
    }

}
