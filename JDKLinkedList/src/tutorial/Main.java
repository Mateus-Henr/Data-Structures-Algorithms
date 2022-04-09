package tutorial;

/*  The JDK Linked List Class

    This class is a doubly-linked list implementation. It also implements the List interface, and the Deque interface.
    Since it implements the List interface, all the methods related to List can also be used on LinkedList.
    However, notice that if you use the "List" as the object, you will only get methods available in the List interface,
    whereas if you use the LinkedList object you will get methods from LinkedList class, and List interface.
    It uses generics, and it also has its own implementation of the Node class.
    This is not synchronized, in other words, by default it's not thread safe. It's up to you to synchronize it.
    Another way of synchronizing it is by using "Collection.synchronizeList()" method.
    This class have an iterator that's handy concerning going through elements in the list.
    In addition to all of that, remember that the LinkedList itself is the data structure, there's nothing backing it.
    For methods that remove/add at a specific index or object, O(n).
    If memory is tight, another data structure might be more advantageous, or even a singly-linked list.

    Circular linked list
    This is a type of linked list that the last node points to the head node.
    The advantage of this is that you can traverse the list starting at any node.
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Employee janeJones = new Employee(13435434, "Jane", "Jones");
        Employee johnDoe = new Employee(54546587, "John", "Doe");
        Employee marySmith = new Employee(76897876, "Mary", "Smith");
        Employee mikeWilson = new Employee(67535461, "Mike", "Wilson");
        Employee billEnd = new Employee(43536546, "Bill", "End");

        LinkedList<Employee> list = new LinkedList<>();

        // Adding an item to the front of the list.
        list.addFirst(janeJones);
        list.addFirst(johnDoe);
        list.addFirst(marySmith);
        list.addFirst(mikeWilson);

        // Printing out the list.
        System.out.println("Printing out the list");
        printList(list);

        // Adding an item to the end of the list. We can either use "add()" from List, or "addLast()" from LinkedList.
        // They are equivalent. "addLast()" can be used when you want to be really clear.
        System.out.println("\nAdding an item to the end of the list");
        list.add(billEnd);
        printList(list);

        // Removing an employee from the front of the list.
        System.out.println("\nRemoving an employee from the front of the list");
        list.removeFirst();
        printList(list);

        // Removing an employee from the end of the list.
        System.out.println("\nRemoving an employee from the end of the list");
        list.removeLast();
        printList(list);

        // For the "remove()" method from the List interface, it'll remove the item from the front of the list.
        System.out.println("\nUsing remove() from the List interface");
        list.remove();
        printList(list);
    }

    private static void printList(List<Employee> list)
    {
        Iterator<Employee> iter = list.iterator();
        System.out.print("HEAD -> ");
        while (iter.hasNext())
        {
            System.out.print(iter.next());
            System.out.print(" <=> ");
        }
        System.out.println("TAIL");

//        // Another way of printing out the list.
//        for (Employee employee : list)
//        {
//            System.out.println(employee);
//        }
    }

}
