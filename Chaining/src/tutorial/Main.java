package tutorial;

/*  Chaining

    What is it?
    • This is another way to deal with collisions on the hashtable.
    • When we use it, instead of storing the value directly into the array, each array position contains a linked list.
    • Therefore, instead of storing employee instances we will store a linked list. So we will have a linked list at
      that position in the array, because of that we can deal with collisions more easily compared to linear probing.


    Drawback
    • The main drawback is that at each array's position we have a linked list, so if we want to retrieve an item we
      have to go through the linked list.
      However, if you have a good hashing function and a decent load factor, these linked lists sizes will be very
      small.


    Final conclusion
    • This is much simpler since we don't have to manage stuff once we have a linked list at each position.
    • It requires more memory due to the linked list fields.
    • In the worst case all the instances would have the same hash value, therefore we would have only one linked list
      to go through, if that happens we have a O(n) time complexity. But notice that this is directly affected by your
      hashing function, and the load factor. So, if that doesn't happen then the usual case is a lot better than O(n).
      If we say that k is the average length of the linked list then retrieval will be 1 + k.
 */

public class Main
{
    public static void main(String[] args)
    {
        Employee janeJones = new Employee(13435434, "Jane", "Jones");
        Employee johnDoe = new Employee(54546587, "John", "Doe");
        Employee marySmith = new Employee(76897876, "Mary", "Smith");
        Employee mikeWilson = new Employee(67535461, "Mike", "Wilson");

        ChainedHashtable cht = new ChainedHashtable();

        cht.put(janeJones.getLastName(), janeJones);
        cht.put(johnDoe.getLastName(), johnDoe);
        cht.put(mikeWilson.getLastName(), mikeWilson);

        cht.put(marySmith.getLastName(), marySmith); // Collision

        cht.printHashtable();

        System.out.println("Retrieve key Wilson: " + cht.get("Wilson"));
        System.out.println("Retrieve key Smith: " + cht.get("Smith"));

        cht.remove("Doe");
        cht.remove("Jones");

        System.out.println("\nAfter removal");
        cht.printHashtable();

        System.out.println("Retrieve key Smith: " + cht.get("Smith"));
    }

}
