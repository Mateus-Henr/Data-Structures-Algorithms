package tutorial;

/*  Trees and the JDK

    TreeMap class
    • It takes key/value pairs items.
    • It uses a Red-Black tree which is a self-balancing tree. After every insertion and deletion it checks the tree
      to see how balanced it is. It doesn't perfectly balance a tree, but it's the most used. A Red-Black tree is a
      binary search tree.
    • It guarantees O(log(n)) for "containsKey()", "get()", "put()", and "Remove()" operations.
    • This is not synchronized. So, you can wrap it using the "Collections.synchronize()" method.


    TreeSet class
    • This is an implementation that doesn't allow duplicate values based on TreeMap.
 */

import java.util.Map;
import java.util.TreeMap;

public class Main
{
    public static void main(String[] args)
    {
        Map<Integer, String> tree = new TreeMap<>();

        tree.put(0, "John");
        tree.put(1, "Mark");

        System.out.println("Printing the tree out");
        for (String value : tree.values())
        {
            System.out.print(value + ", ");
        }

        tree.remove(0);

        System.out.println("\nAfter removing node");
        for (String value : tree.values())
        {
            System.out.print(value + ", ");
        }

        System.out.println("\nGet value with key 1 = " + tree.get(1));
    }

}
