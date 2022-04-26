package tutorial;

/*  Sets

    • Sets are abstract data types.
    • It's just a data set that doesn't contain duplicate elements, it cannot contain duplicates.


    Set interface
    • This is a collection that contains no duplicate elements.
    • It uses the "equals()" method to check whether two object instances are equal or not. If it returns true it
      doesn't add the element.
    • It can contain one null element.


    HashSet class
    • This is an implementation of a set that's backed by a hashtable (a HashMap instance).


    LinkedHashSet class
    • This is an implementation of a hash table and linked list of the Set interface.


    TreeSet class
    • This is a NavigableSet implementation based on a TreeMap.


    The "add()" method
    • When it comes to the "add()" method from the Set interface, it only adds if the elements is not already present
      in the set.


    Other methods
    • It also has: "contains()", "iterator()", "remove()", and "toArray()" methods.
 */

import java.util.HashSet;
import java.util.Set;

public class Main
{
    public static void main(String[] args)
    {
        Set<Integer> hashSet = new HashSet<>();

        hashSet.add(2);
        hashSet.add(3);

        System.out.println("Printing set out");
        for (Integer value : hashSet)
        {
            System.out.print(value + ", ");
        }
        System.out.println();

        System.out.println("\nAdding duplicate element = " + hashSet.add(3));
        System.out.println("Printing set out after trying to add duplicate element");
        for (Integer value : hashSet)
        {
            System.out.print(value + ", ");
        }
        System.out.println();
    }

}
