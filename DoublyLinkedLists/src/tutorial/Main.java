package tutorial;

/*  Doubly Linked Lists

    The main difference between the "doubly" and the "singly" linked lists is that the "doubly" holds a reference to
    the next item, as well as to the previous item in every item.
    It also has a head, and a tail. Therefore, we can traverse the list from right to left, or left to right.
    Also, insertion or deletion at the end, or at the beginning, of the list can be done in constant time because
    of the two references.
    For an item in the middle of the list the worst case still is O(n).


    Inserting at head
        1. Create a new node.
        2. Assign the current head to the next field.
        3. Assign whatever the previous head (now in the second field) to the newly created node (often is null).
        4. Assign the reference to the new node to the previous head previous node.
        5. Assign head to the new node.
    OBS: The number of steps don't increase upon the number of elements, therefore, time complexity is O(1).


    Inserting at tail
        1. Create a new node.
        2. Assign the current tail to the previous field.
        3. Assign whatever the previous tail (now in the before last field) to the newly created node (often is null).
        4. Assign the reference to the new node to the next tail next node.
        5. Assign tail to the new node.
    OBS: The number of steps don't increase upon the number of elements, therefore, time complexity is O(1).


    Removing at head
        1. Assign the head to the "removedNode".
        2. Assign the next node of the head to head.
        3. Assign whatever the previous head (now in the second field) to the new head.
        4. Do some cleanup on the "removedNode" by assigning "null" to its nodes.
        5. Return the "removedNode".
    OBS: The number of steps don't increase upon the number of elements, therefore, time complexity is O(1).


    Removing at tail
        1. Assign the tail to the "removedNode".
        2. Assign the tail's previous node to tail.
        3. Assign whatever the previous tail (now in the before last field) to the new tail.
        4. Do some cleanup on the "removedNode" by assigning "null" to its nodes.
        5. Return the "removedNode".
    OBS: The number of steps don't increase upon the number of elements, therefore, time complexity is O(1).


    Inserting node at a specific position
    To insert a node A between nodes B and C
        • Assign A's next field to B's next field.
        • Assign A's previous field to C's previous field.
        • Assign B's next field to A.
        • Assign C's previous field to A.
     OBS: 0(1) time complexity BUT we have to find the insertion position first, so this is actually 0(n).


    Removing node at a specific position
    To remove node A from between B and C
        • Assign A to "removed Node".
        • Assign C's previous field to A's previous field.
        • Assign B's next field to A's next field.
        • Return A from the method.
    OBS: 0(1) time complexity BUT we have to find A first, so this is actually 0(n).


    Insertion at head example

    Initial linked list
                   Head                  EmployeeNode
         [NULL | Jane | Node@454a] [Node@453a | John | NULL]
                 Node@453a                 Node@454a

    Inserting "Bill"
                  Head                     EmployeeNode                EmployeeNode
        [NULL | Bill | Node@453a] [Node@452a | Jane | Node@454a] [Node@453a | John | NULL]
                Node@452a                   Node@453a                    Node@454a

    ------------------------------------------------------------------------------------------------------------------

    Insertion at tail example

    Initial linked list
                   Head                  EmployeeNode
         [NULL | Jane | Node@454a] [Node@453a | John | NULL]
                 Node@453a                 Node@454a

    Inserting "Bill"
                   Head                     EmployeeNode                EmployeeNode
         [NULL | Jane | Node@454a] [Node@453a | John | Node@455a] [Node@454a | Bill | NULL]
                 Node@453a                   Node@454a                    Node@455a

    ------------------------------------------------------------------------------------------------------------------

    Removing at head example

    Initial linked list
                  Head                     EmployeeNode                EmployeeNode
        [NULL | Bill | Node@453a] [Node@452a | Jane | Node@454a] [Node@453a | John | NULL]
                Node@452a                   Node@453a                    Node@454a

    Removing "Bill"
                   Head                  EmployeeNode
         [NULL | Jane | Node@454a] [Node@453a | John | NULL]
                 Node@453a                 Node@454a

    ------------------------------------------------------------------------------------------------------------------

    Insertion at tail example

    Initial linked list
                   Head                     EmployeeNode                EmployeeNode
         [NULL | Jane | Node@454a] [Node@453a | John | Node@455a] [Node@454a | Bill | NULL]
                 Node@453a                   Node@454a                    Node@455a

    Removing "Bill"
                   Head                  EmployeeNode
         [NULL | Jane | Node@454a] [Node@453a | John | NULL]
                 Node@453a                 Node@454a

    ------------------------------------------------------------------------------------------------------------------

    Inserting node at a specific position (position 1)

    Initial linked list
                   Head                  EmployeeNode
         [NULL | Jane | Node@454a] [Node@453a | John | NULL]
                 Node@453a                 Node@454a

    Inserting "Bill"
                   Head                     EmployeeNode                EmployeeNode
         [NULL | Jane | Node@454a] [Node@453a | Bill | Node@455a] [Node@454a | John | NULL]
                 Node@453a                   Node@454a                    Node@455a

    ------------------------------------------------------------------------------------------------------------------

    Removing node at a specific position

    Initial linked list
                   Head                     EmployeeNode                EmployeeNode
         [NULL | Jane | Node@454a] [Node@453a | Bill | Node@455a] [Node@454a | John | NULL]
                 Node@453a                   Node@454a                    Node@455a

    Removing "Bill" (position 1)
                   Head                  EmployeeNode
         [NULL | Jane | Node@454a] [Node@453a | John | NULL]
                 Node@453a                 Node@454a
 */

public class Main
{
    public static void main(String[] args)
    {
        Employee janeJones = new Employee(13435434, "Jane", "Jones");
        Employee johnDoe = new Employee(54546587, "John", "Doe");
        Employee marySmith = new Employee(76897876, "Mary", "Smith");
        Employee mikeWilson = new Employee(67535461, "Mike", "Wilson");
        Employee michaelLoy = new Employee(54654657, "Michael", "Loy");
        Employee hermanLouis = new Employee(76575455, "Herman", "Louis");
        Employee ryanOwen = new Employee(43253463, "Ryan", "Owen");

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();


        // Insertions
        System.out.println("Inserting 2 employees at the front of the list");
        list.insertToFront(janeJones);
        list.insertToFront(johnDoe);
        list.printListFromHead();
        System.out.println("Size = " + list.getSize());

        System.out.println("\nInserting employee at the end of the list");
        list.insertToEnd(michaelLoy);
        list.printListFromHead();
        System.out.println("Size = " + list.getSize());

        System.out.println("\nInserting employee at index 1");
        list.insertAtIndex(1, mikeWilson);
        list.printListFromHead();
        System.out.println("Size = " + list.getSize());

        System.out.println("\nInserting employee at index 0 (head)");
        list.insertAtIndex(0, marySmith);
        list.printListFromHead();
        System.out.println("Size = " + list.getSize());

        System.out.println("\nInserting employee at index 4 (before the tail)");
        list.insertAtIndex(4, ryanOwen);
        list.printListFromHead();
        System.out.println("Size = " + list.getSize());

        System.out.println("\nInserting employee at index 6 (tail)");
        list.insertAtIndex(6, hermanLouis);
        list.printListFromHead();
        System.out.println("Size = " + list.getSize());


        // Removals
        System.out.println("\nRemoving employee at the front of the list");
        list.removeFromFront();
        list.printListFromTail();
        System.out.println("Size = " + list.getSize());

        System.out.println("\nRemoving employee at the end of the list");
        list.removeFromEnd();
        list.printListFromTail();
        System.out.println("Size = " + list.getSize());

        System.out.println("\nRemoving employee at index 1");
        list.removeAtIndex(1);
        list.printListFromTail();
        System.out.println("Size = " + list.getSize());

        System.out.println("\nRemoving employee at index 0 (head)");
        list.removeAtIndex(0);
        list.printListFromTail();
        System.out.println("Size = " + list.getSize());

        System.out.println("\nRemoving employee at index 1 (before the tail)");
        list.removeAtIndex(1);
        list.printListFromTail();
        System.out.println("Size = " + list.getSize());

        System.out.println("\nRemoving employee at index 1 (tail)");
        list.removeAtIndex(1);
        list.printListFromTail();
        System.out.println("Size = " + list.getSize());


        // Others
        System.out.println("\nIs empty = " + list.isEmpty());
        System.out.println("Size = " + list.getSize());
    }

}
