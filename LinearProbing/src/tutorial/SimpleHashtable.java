package tutorial;

public class SimpleHashtable
{
    private StoredEmployee[] hashtable;

    public SimpleHashtable()
    {
        this.hashtable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee)
    {
        int hashedKey = hashKey(key);

        // This implementation wraps if we get to the end of the array.
        if (occupied(hashedKey))
        {
            // This will identify where we need to stop when we wrap.
            int stopIndex = hashedKey;

            if (hashedKey == hashtable.length - 1)
            {
                hashedKey = 0;
            }
            else
            {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex)
            {
                // This code handles wrapping as well.
                // hashKey = 8 -> (8 + 1) % 10 = 9.
                // hashKey = 9 -> (9 + 1) % 10 = 0.
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        // This condition will only be true, even after wrapping no position was found.
        // This is redundant since the same checking is done above , but it's constant time.
        if (occupied(hashedKey))
        {
            System.out.println("Sorry, there's already an employee at position " + hashedKey);
        }
        else
        {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    public Employee remove(String key) // O(n)
    {
        int foundKey = hashKey(key);

        if (foundKey == -1)
        {
            return null;
        }

        Employee removedEmployee = hashtable[foundKey].employee;

        hashtable[foundKey] = null;

        StoredEmployee[] oldHashtable = hashtable;
        hashtable = new StoredEmployee[oldHashtable.length];

        for (StoredEmployee storedEmployee : oldHashtable)
        {
            if (storedEmployee != null)
            {
                put(storedEmployee.key, storedEmployee.employee);
            }
        }

        return removedEmployee;
    }

    public Employee get(String key)
    {
        int foundKey = findKey(key);

        if (foundKey == -1)
        {
            return null;
        }

        return hashtable[foundKey].employee;
    }

    private int findKey(String key)
    {
        int hashedKey = hashKey(key);

        if ((hashtable[hashedKey] != null) && (hashtable[hashedKey].key.equals(key)))
        {
            return hashedKey;
        }

        int stopIndex = hashedKey;

        hashedKey = (hashedKey == hashtable.length - 1) ? 0 : hashedKey + 1;

        // There was a bug when looping out on the first null spot. Due to the fact that we can remove an employee
        // (and we set the employee's spot as null), if we remove the employee at the hashed index and the employee
        // that we are trying to retrieve was using linear probing from the index of the removed employee
        // we would never find the employee that we were looking for since it would hit a "null".
//        while ((hashedKey != stopIndex) && (hashtable[hashedKey] != null) && (hashtable[hashedKey].key.equals(key)))

        // Implementation O(n) NOT FEASIBLE SINCE THIS METHOD WOULD HAVE A O(n).
//        while (hashedKey != stopIndex)
//        {
//            if ((hashtable[hashedKey] != null) && (hashtable[hashedKey].key.equals(key)))
//            {
//                return hashedKey;
//            }
//
//            hashedKey = (hashedKey + 1) % hashtable.length;
//        }

        // The problem above could be solved either by rehashing all the items after removing an item (therefore we
        // wouldn't have a null position between items that used linear probing), it would make the remove method O(n),
        // or we could set the "Employee" object in the "StoredEmployee" class, so it would help us to identify whether
        // an employee was at that position or if that was always empty. The disadvantage of this second fix is that
        // we would have a polluted hash table and the load factor would be higher. So the add method would have to do
        // more linear probing because we never remove anything from the table.
        // We will be implementing the remove one.

        return -1;
    }

    private int hashKey(String key)
    {
        return key.length() % hashtable.length;
    }

    private boolean occupied(int index)
    {
        return hashtable[index] != null;
    }

    public void printHashtable()
    {
        for (int i = 0; i < hashtable.length; i++)
        {
            if (hashtable[i] == null)
            {
                System.out.println("empty");
            }
            else
            {
                System.out.println("Position " + i + ": " + hashtable[i].employee);
            }
        }
    }

}
