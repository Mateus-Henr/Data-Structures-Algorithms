package tutorial.linkedList;

/*  Stacks (LinkedList)

    For more information on stacks, check the "array" implementation since the theory was written there.

    The JDK stack class
    Even though Java has this class, they recommend implementing the "Deque" interface since it's more complete.
    One of the class that implements the "Deque" interface is "ArrayDeque".
    Because the "LinkedList" class implements the "Deque" interface, we also have access to stack methods, but in
    addition to them, we also have methods from "List" and "LinkedList".
    In the Linked list implementation we will be using the JDK "LinkedList", but we will be limiting the use of the
    methods.

    Final conclusion
    • The linked list is ideal for a stack since for the operations push, peek, and pop are O(1).
    • But due to the overhead it consumes more memory.
    • The only thing that a stack does is to limit the operations that you can do on whatever data structure is being
      used.
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

        LinkedStack stack = new LinkedStack();

        // Using "push()"
        stack.push(janeJones);
        stack.push(johnDoe);
        stack.push(marySmith);
        stack.push(mikeWilson);
        stack.push(billEnd);

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
