package tutorial;

/*  Array Lists

    List
    It's an abstract data type which can be implemented using an interface (java.util.list).

    Abstract data types
    - Abstract data types don't dictate how the data is organized, being lists an example.
      Lists are more of conceptual idea, differently form arrays, for example, that dictate how the data is organized.
    - However, it still dictates the operations that can be performed.
    - In Java, concrete data structure is usually a concrete class.
    - Abstract data type is usually an interface. This is due to the fact that we set how they are going to behaviour
      (how data is going to be stored, etc. However, the operations are dictated, such as removing an item from a list),
      that's why an interface is used.


    ArrayList
    This is a resizable-array implementation of the List interface. Therefore, an array is used for storing data.
    Operations that would be performed on arrays can also be performed on ArrayLists.
    Through a constructor it's possible to specify an initial capacity, so it could avoid having to resize the array
    size many times uselessly.
    Also, for operations that an index is specified, they usually happen in constant time.

    Adding items ("add()")
    It uses a backing array, so if this array you're adding multiple items and this array is not big enough, adding
    items take longer since the backing array needs to be resized.
    This method adds items to the end of the list by default, however if you specify an index, you can choose at which
    position the item is going to be added, however this operation is an O(n) because it needs to shift items to the
    right of the list.

    Removing items ("remove()")
    This operation also takes longer since the array needs to be resized to fill up the position of the item that has
    been removed.

    Size vs capacity
    It's important to know that the size of an array list consists of the number of items that it has, whereas capacity
    consists of the size of the array that's backing up the list. If the capacity is not specified in the constructor
    we will get an initial capacity of ten.

    ArrayList vs array
    The advantage of using ArrayList is that you can perform list operations on the array, and also, array operations.
    Basically, the code for manipulating arrays as a list is already written for you in a way that would be suitable
    for performance. Also, if future changes require, since ArrayList implements the List interface it's easier to
    change the type of list.


    Final conclusion
    - Good for random access (using the index). Otherwise, it's not good.
    - Not so good for adding items other than at the end of the list because other values need to be swift.
    - Not good for removals because other values need to be swift.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        // Using "List" to make easier in the future if the data structure changes.
        List<Employee> employeeList = new ArrayList<>();

        // Adding employees
        employeeList.add(new Employee(13435434, "Jane", "Jones"));
        employeeList.add(new Employee(54546587, "John", "Doe"));
        employeeList.add(new Employee(76897876, "Mary", "Smith"));
        employeeList.add(new Employee(67535461, "Mike", "Wilson"));

        // Printing employees.
        employeeList.forEach(System.out::println);

        // Printing the second employee.
        // It's important to notice that this operation is made in constant time since an array is backing up the list.
        System.out.println(employeeList.get(1));

        // Checking if a list is empty.
        System.out.println(employeeList.isEmpty());

        // Changing an employee. Also O(1).
        System.out.println("\nChanging an employee");
        employeeList.set(1, new Employee(45546768, "John", "Adams"));
        employeeList.forEach(System.out::println);

        // Getting number of items of the list.
        System.out.println(employeeList.size());

        // Adding employee at specific index. It shifts the other items to the right of the array.
        // Because of that, the worst case of it is O(n).
        System.out.println("\nAdding employee at specific position");
        employeeList.add(3, new Employee(54546587, "John", "Doe"));
        employeeList.forEach(System.out::println);

        // Transforming the ArrayList into an array.
        // Notice that here, it returns an Object array.
        Object[] objectArray = employeeList.toArray();

        // If we want to specify the size we can use the following:
        System.out.println("\nEmployee array");
        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
        Arrays.stream(employeeArray).forEach(System.out::println);

        // Checking if a list contains an employee.
        // Notice that the "equals" method by default compares object instances. Only when we implement it that it
        // compares data. It searches the list.
        System.out.println(employeeList.contains(new Employee(76897876, "Mary", "Smith")));

        // Getting the index of an employee. It searches the list.
        System.out.println(employeeList.indexOf(new Employee(54546587, "John", "Doe")));

        // Removing an item from the list.
        // Providing the index (O(1)) is faster than looking for an instance O(n). HOWEVER, once you remove the item
        // it can take O(n) to swift the other values to fill in that position.
        System.out.println("\nRemoving an employee");
        employeeList.remove(2);
        employeeList.forEach(System.out::println);
    }

}
