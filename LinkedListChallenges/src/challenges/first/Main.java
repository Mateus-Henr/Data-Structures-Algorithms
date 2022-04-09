package challenges.first;

/*  Linked Lists Challenge #1

    • Implement the addBefore() method for the EmployeeDoublylinkedList class.
    • Use the starter project in the resources section.
    • Project contains all the code you need and an empty add Before() method.
    • Main method contains code that should work when you're finished.
 */

public class Main
{
    public static void main(String[] args)
    {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);
        list.printList();

        list.addBefore(billEnd, johnDoe);
        list.addBefore(new Employee("Someone", "Else", 1111), mikeWilson);
        list.printList();
    }

}
