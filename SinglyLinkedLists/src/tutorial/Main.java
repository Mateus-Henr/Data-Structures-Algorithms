package tutorial;

/*  Singly Liked List

    What is it?
    This is a data structure that's a sequential list of objects that are not backed by an array.
    Each item in the list is called a note, and each node contains the data as well as a link (reference) to the next
    item in the list.
    The first item in the list is the head of the list, similarly to a snake.
    It's worth mentioning that in an array, each item of it is unaware of any other items, whereas in a linked list
    each item is aware of another item(s).
    If you have a reference to the head you can traverse the entire list since all nodes are connected. For that
    reason, the only reference that needs to be stored is a reference to the head.


    Advantages
    Linked lists can also continue to grow without being resized.
    Insertion and deletion at the beginning O(n).


    Disadvantages
    We have to store an extra field (node) in each item. Therefore, if memory is really tight this is not ideal.
    Random accesses.


    Inserting items O(1)
    An element is always added at the beginning of the list. This is due to the fact that we only store the reference to
    the head, therefore we can only add an item on the head. Otherwise, we would have to traverse the list.
    The process of inserting an item into the list would be as following:
        1. Create a new node.
        2. Assign the current first node to the next field.
        3. Assign the head to the newly created node.
    OBS: This will be O(1) complexity since the number of steps don't increase as the number of items increase.


    Deletion
    For deletion, we would also want to delete from the front of the list, otherwise we have to traverse the list.
    The process of deleting an item into the list would be as following:
        1. Assign the current node to a temporary variable "removedNode" (because we want to return the deleted node).
           To do some cleanup, we can also assign the current node to null.
        2. Assign head to the second node.
        3. Return "removedNode".
    OBS: This will be O(1) complexity since the number of steps don't increase as the number of items increase.


    Example

    Array representation
        [Jane] [John] [Mary] [Mike]

    Singly liked list representation
               Head                EmployeeNode              EmployeeNode             EmployeeNode
         [Jane | EmployeeNode@454a] [John | EmployeeNode@455a] [Mary | EmployeeNode@456a] [Mike | NULL]
              EmployeeNode@453a          EmployeeNode@454a         EmployeeNode@455a        EmployeeNode@456a


    Insertion example

    Initial linked list
               Head                EmployeeNode              EmployeeNode             EmployeeNode
         [Jane | EmployeeNode@454a] [John | EmployeeNode@455a] [Mary | EmployeeNode@456a] [Mike | NULL]
              EmployeeNode@453a          EmployeeNode@454a         EmployeeNode@455a        EmployeeNode@456a

    Inserting "Bill"
               Head                EmployeeNode              EmployeeNode             EmployeeNode
         [Bill | EmployeeNode@453a] [Jane | EmployeeNode@454a] [John | EmployeeNode@455a] [Mary | EmployeeNode@456a] [Mike | NULL]
             EmployeeNode@452a           EmployeeNode@453a          EmployeeNode@454a         EmployeeNode@455a        EmployeeNode@456a


    Deletion example

    Initial linked list
               Head                EmployeeNode              EmployeeNode             EmployeeNode
         [Jane | EmployeeNode@454a] [John | EmployeeNode@455a] [Mary | EmployeeNode@456a] [Mike | NULL]
              EmployeeNode@453a          EmployeeNode@454a         EmployeeNode@455a        EmployeeNode@456a

    Inserting "Bill"
               Head                EmployeeNode              EmployeeNode             EmployeeNode
         [Jane | EmployeeNode@454a] [John | EmployeeNode@455a] [Mary | EmployeeNode@456a] [Mike | NULL]
              EmployeeNode@453a          EmployeeNode@454a         EmployeeNode@455a        EmployeeNode@456a

    Final conclusion
    - It differs from arrays since insertion and deletion (from the start of the list) are made in constant time (O(1)).
    - It's called a single liked list due to the fact that there's just one link in each node.
    - When working with this type of list we only want to delete and insert items from the front of the list because
      we only have the reference to the head. Otherwise, you would have to traverse the list which is a disadvantage.
 */

public class Main
{
    public static void main(String[] args)
    {
        Employee janeJones = new Employee(13435434, "Jane", "Jones");
        Employee johnDoe = new Employee(54546587, "John", "Doe");
        Employee marySmith = new Employee(76897876, "Mary", "Smith");
        Employee mikeWilson = new Employee(67535461, "Mike", "Wilson");

        EmployeeSinglyLinkedList list = new EmployeeSinglyLinkedList();

        System.out.println("Is empty = " + list.isEmpty());

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        list.printList();

        System.out.println("Size = " + list.getSize());
        System.out.println("Is empty = " + list.isEmpty());

        list.removeFromFront();
        list.removeFromFront();
        System.out.println("\nAfter calling the remove method twice");
        list.printList();
    }

}
