package challenges.second;

/*  Hashtables — Challenge #2

    • Remove duplicate items from a linked list.
    • Your solution must use the JDK's Linked List class.
    • Your solution must use a HashMap.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
        LinkedList<Employee> employees = new LinkedList<>();

        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));

        System.out.println("\nOriginal linked list");
        employees.forEach(System.out::println);

        Map<Integer, Employee> uniqueEmployees = new HashMap<>();

        // My first solution
//        for (Employee employee : employees)
//        {
//            uniqueEmployees.putIfAbsent(employee.getId(), employee);
//        }
//
//        for (Employee employee : uniqueEmployees.values())
//        {
//            int firstIndex = employees.indexOf(employee);
//
//            if (firstIndex != employees.lastIndexOf(employee))
//            {
//                employees.remove(firstIndex);
//            }
//        }

        // My second solution
//        for (int i = 0; i < employees.size(); i++)
//        {
//            if (uniqueEmployees.putIfAbsent(employees.get(i).getId(), employees.get(i)) != null)
//            {
//                employees.remove(i);
//            }
//        }

        // My third solution
        employees.removeIf(employee -> uniqueEmployees.putIfAbsent(employee.getId(), employee) != null);


        // As seen, if you try to modify the list while looping through it, you will get an exception.

        System.out.println("\nUnique key linked list");
        employees.forEach(System.out::println);
    }

}
