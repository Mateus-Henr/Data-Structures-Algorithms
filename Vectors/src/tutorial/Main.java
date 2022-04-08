package tutorial;

import java.util.List;
import java.util.Vector;

/*  Vectors

    The Vector class is basically a thread safe ArrayList. So you, as a developer, don't have to synchronize the code.
    It came before the ArrayList class. The reason why ArrayList was created it was because synchronization has an
    overhead involved that slow things down.
    Vectors are also backed by an array and offer the same stuff as ArrayLists, but its methods are synchronized.
    Summing up, use ArrayList if you don't need synchronization, and Vector otherwise.
 */
public class Main
{
    public static void main(String[] args)
    {
        List<Employee> employeeList = new Vector<>();

        employeeList.add(new Employee(13435434, "Jane", "Jones"));
        employeeList.add(new Employee(54546587, "John", "Doe"));
        employeeList.add(new Employee(76897876, "Mary", "Smith"));
        employeeList.add(new Employee(67535461, "Mike", "Wilson"));
    }

}
