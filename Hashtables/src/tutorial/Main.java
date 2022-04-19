package tutorial;

/*  Hash Tables

    • Another abstract data type, it doesn't dictate how you store the data.
    • By using keys we can access the data.
    • Consists of key/value pairs, for that reason, data types don't have to match.
    • Optimized for retrieval (when known the key).
    • Associative array is one type of hash table.
    • Also known as maps, dictionaries, lookup tables and associative arrays.


    Hashing
    This is the process of hashing any data type to an integer.
    • The key doesn't have to be an integer (can be whatever you want). But under the covers, these keys are converted
      to integers through hash functions, the keys are mapped to integers. In Java, the hash function is
      "Object.hashCode()".
    • Collisions occurs when more than one value has the same hashed value.


    Example
    One example of hash table would be product numbers that map to products.
    This is interesting because if we have a product name very big, if you had to store it in one array you would have
    to create an array with a very large capacity just to match the array's index with the product number.
    Another example is when you sign up to a website, the hash-code of your username may be used to get your profile.


    Load Factor
    • It tells how full a hash table is.
    • It is calculated by # of items / size / capacity. An array of 10, and 5 elements, the load factor would be 0.5.
    • It's used to decide when to resize the array backing the hash table.
    • Don't want load factor too low (lots of empty space).
    • Don't want load factor too high (will increase the likelihood of collisions). This is due to the fact that you're
      hashing the keys to indexes (there's a range for that), so the collisions are higher when the load factor is too
      high.
    • Can play a role in determining the time complexity for retrieval.


    Add to a Hash Table backed by an array
    1. Provide a key/value pair.
    2. Use a hash function to hash the key to an int value.
    3. Store the value at the hashed key value (this is the index into the array).


    Add "Jane Jones" with key of "Jones"
    1. Use a hash function to map "Jones" to an int (let's assume we get the value 4).
    2. Store "Jane Jones" at array[4].


    Retrieve a value from a Hash Table
    1. Provide the key.
    2. Use the same hash function to hash the key to an int value.
    3. Retrieve the value stored at the hashed key value.


    Retrieve the employee with key "Jones"
    1. Provide the key "Jones".
    2. Use the same hash function to map "Jones" to an int (so, we get the value 4).
    3. Retrieve the value at array[4] -> "Jane Jones".


    Final conclusion
    - The load factor is super important when it comes to the retrieval because if the load factor is too high,
      the hashing function gets too many collisions, so the retrieval won't happen in constant time.
    - Really handy if you want operations to happen in constant time.
    - They key can be whatever you want.
    - The same hash function has to be shared between its methods.
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

        // This will cause a collision since her name has the same number of characters as "janeJones", and we are using
        // the number of characters to determine where she would go in the array that backs the hashtable.
        ht.put(marySmith.getLastName(), marySmith);

        ht.printHashtable();

        System.out.println("Retrieve key Wilson: " + ht.get("Wilson"));
    }

}
