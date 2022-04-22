package tutorial;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashtable
{
    private LinkedList<StoredEmployee>[] hashtable;

    public ChainedHashtable()
    {
        // We could also start with an array of objects, and if there's just one object at that position then we store
        // the employee object, and only when there's a collision we add a linked list.
        this.hashtable = new LinkedList[10];

        for (int i = 0; i < hashtable.length; i++)
        {
            hashtable[i] = new LinkedList<>();
        }
    }

    public void put(String key, Employee employee)
    {
        int hashedKey = hashKey(key);

        hashtable[hashedKey].add(new StoredEmployee(key, employee));
    }

    public Employee get(String key)
    {
        int hashedKey = hashKey(key);

        for (StoredEmployee storedEmployee : hashtable[hashedKey])
        {
            if (storedEmployee.key.equals(key))
            {
                return storedEmployee.employee;
            }
        }

        return null;
    }

    public Employee remove(String key)
    {
        int hashedKey = hashKey(key);
        int index = 0;

        for (StoredEmployee removedStoredEmployee : hashtable[hashedKey])
        {
            if (removedStoredEmployee.key.equals(key))
            {
                // The "remove()" method iterates through the list again, because it compares the employee to be deleted
                // against each employee in the list. For that reason, the method that allows us to remove by index is
                // better since we avoid unnecessary comparison.
                hashtable[hashedKey].remove(index);
                return removedStoredEmployee.employee;
            }

            index++;
        }

        return null;
    }

    private int hashKey(String key)
    {
//        return key.length() % hashtable.length;
        // Often how you would use. This "hashCode()" method for Strings can produce negative numbers, for that reason,
        // we have to use the number's absolute value.
        // YOU ALWAYS HAVE TO MOD BY THE SIZE OF THE ARRAY. You have to make sure that the returned value is an index in
        // the array.
        return Math.abs(key.hashCode() % hashtable.length);
    }

    public Employee printHashtable()
    {
        for (int i = 0; i < hashtable.length; i++)
        {
            if (hashtable[i].isEmpty())
            {
                System.out.println("Position " + i + ": empty");
            }
            else
            {
                System.out.print("Position " + i + ": ");
                for (StoredEmployee storedEmployee : hashtable[i])
                {
                    System.out.print(storedEmployee.employee);
                    System.out.print(" <-> ");
                }
                System.out.println("NULL");
            }
        }

        return null;
    }

}
