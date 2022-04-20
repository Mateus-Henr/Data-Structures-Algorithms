package tutorial;

/*  Hashtables (Linear Probing)

    One well known strategy to handle collisions is called open addressing.


    Open addressing
    • It consists of looking for another position in the array if the mapped key already exists in the array.
    • There are several ways that we can look for a new index, but the one that we will be using is called
      linear probing.

    Linear probing
    • With this concept, if we map a key to an integer value and that position is already occupied, we increment the
      index by one. We do that until we find a free slot for the value to be inserted.
    • It has this name because each time we increment the index we are doing that in a linear fashion. In addition to
      that, every increment to the index is called a prob. So if we have to increment the index two times we have to use
      two probes.
    • Due to that, the lower the number of probes the better.


    Final conclusion
    • Besides complicating things, when handling collisions, the time complexity can also degrade since we need to look
      for the item. So we have a O(n) algorithm for operations when using linear probing.
    • The load factor also interferes here, if it's too high, a lot of probes are going to be necessary to find an empty
      spot.
 */

public class Main
{
    public static void main(String[] args)
    {
        Employee janeJones = new Employee(13435434, "Jane", "Jones");
        Employee johnDoe = new Employee(54546587, "John", "Doe");
        Employee marySmith = new Employee(76897876, "Mary", "Smith");
        Employee mikeWilson = new Employee(67535461, "Mike", "Wilson");
        Employee billEnd = new Employee(54353453, "Bill", "End");

        SimpleHashtable ht = new SimpleHashtable();

        ht.put(janeJones.getLastName(), janeJones);
        ht.put(johnDoe.getLastName(), johnDoe);
        ht.put(mikeWilson.getLastName(), mikeWilson);

        ht.put(marySmith.getLastName(), marySmith); // Collision

        ht.printHashtable();

        System.out.println("Retrieve key Wilson: " + ht.get("Wilson"));
        System.out.println("Retrieve key Smith: " + ht.get("Smith"));
    }

}

