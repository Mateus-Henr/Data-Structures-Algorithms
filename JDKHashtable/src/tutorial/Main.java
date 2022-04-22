package tutorial;

/*  Hashtables and the JDK

    • The primary interface for hashtables is Map. It consists of a key/value pairs that maps a key to a value.
    • It cannot have duplicate keys, so the key must be unique (not the hashcode that it generates under the covers).
    • This is important because if we had duplicate keys we couldn't possibly know which value associated to that key
      the user would want to retrieve.
    • If you add an employee with an existent key in the hash map, the old employee will be replaced for the new one.
      The method "putIfAbsent()" is a way of handling it.


    HashMap class (concrete class)
    • It provides constant-time performance for basic operations (get and put) when it doesn't require resizing.
    • It allows you to set a load factor, so that when that is exceeded the hash map is going to be resized.
    • The difference between "HashMap" and "Hashtables" is that "HashMap" is unsynchronized and permits nulls.
    • For synchronizing this implementation, you can use the "Collections.synchronize()" method.


    LinkedHashMap class
    • This is an implementation backed by an array, but at each entry it has a linked list.
    • Not synchronized.
    • It has a "removeEldestEntry()" method that's used to remove the first entry added to the map. Usually used when
      you're using this implementation as a cache.


    Hashtable class
    • You cannot add null key or value. Everything needs to be not null.
    • It's synchronized.


    ConcurrentHashMap
    • This is a "HashMap" synchronized implementation. This is the most preferable if you want concurrency.
 */

import java.util.HashMap;
import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
        Employee janeJones = new Employee(13435434, "Jane", "Jones");
        Employee johnDoe = new Employee(54546587, "John", "Doe");
        Employee marySmith = new Employee(76897876, "Mary", "Smith");
        Employee mikeWilson = new Employee(67535461, "Mike", "Wilson");
        Employee billEnd = new Employee(54353453, "Bill", "End");

        Map<String, Employee> hashMap = new HashMap<>();

        hashMap.put(janeJones.getLastName(), janeJones);
        hashMap.put(johnDoe.getLastName(), johnDoe);
        hashMap.put(marySmith.getLastName(), marySmith);

        // Notice that the employees won't be displayed in the order that we added them. They will be displayed in
        // accord with their hashed keys.

        // First way of printing the values out.
//        Iterator<Employee> iterator = hashMap.values().iterator();
//        while (iterator.hasNext())
//        {
//            System.out.println(iterator.next());
//        }

        // Second way of printing the values out.
//        for (Employee employee : hashMap.values()) // Give us the values.
//        {
//            System.out.println(employee);
//        }

        // Third way of printing the values out.
        hashMap.forEach((k, v) -> System.out.println("Key = " + k + ", Employee = " + v));

        // Checking if a map contains a key or a value (always better to have the key).
        System.out.println("Contains the key 'Doe' = " + hashMap.containsKey("Doe")); // O(1)ish
        System.out.println("Contains the value 'janeJones' (object) = " + hashMap.containsValue(janeJones)); // O(n)

        // Replacing an employee by adding an employee with an existent key in the hash map.
        Employee employee = hashMap.put("Doe", mikeWilson); // Returns the old employee.

        System.out.println("Old employee = " + employee);

        // Inserting a value only if the key is not already in the map. Also returns the value associated to the key
        // if it already exists.
        Employee employee1 = hashMap.putIfAbsent("Smith", billEnd);
        System.out.println("Found employee = " + employee1);

        // Getting an employee
        System.out.println("Get = " + hashMap.get("Smith"));

        // Getting an employee that doesn't exist.
        System.out.println("Invalid key = " + hashMap.get("Someone"));

        // Setting a default value if the employee doesn't exist.
        System.out.println("Invalid key with default value = " + hashMap.getOrDefault("Someone", mikeWilson));

        // Removing an employee.
        System.out.println("Removed employee = " + hashMap.remove("Jones"));
    }

}
