package challenges.second;

/*  Linked Lists Challenge #2

    • Use the starter project in the resources section.
    • Implement a method in the IntegerLinkedList class that inserts a value in sorted order.
    • Lower values should appear first in the list (be closer to the head).
    • If we insert 4, 2, 1, 5, list should look like HEAD->1->2->4->5->null.
    • IntegerLinkedList is a singly-linked list.
    • Project contains all the code you need and an empty insertSorted() method.
    • Main method contains code that should work when you're finished.
 */

public class Main
{
    public static void main(String[] args)
    {
        Integer minusOne = -1;
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        Integer five = 5;

        IntegerLinkedList list = new IntegerLinkedList();

        list.insertSorted(three);
        list.printList();

        list.insertSorted(two);
        list.printList();

        list.insertSorted(one);
        list.printList();

        list.insertSorted(four);
        list.insertSorted(minusOne);
        list.insertSorted(five);
        list.printList();
    }

}
