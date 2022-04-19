package tutorial;

public class SimpleHashtable
{
    private Employee[] hashtable;

    public SimpleHashtable()
    {
        this.hashtable = new Employee[10]; // Initial capacity.
    }

    public void put(String key, Employee employee) // key and value pair.
    {
        int hashedKey = hashKey(key); // Mapping the key to an integer within the length of the array range.

        // As perceptible below it doesn't handle collisions.
        if (hashtable[hashedKey] != null)
        {
            System.out.println("Sorry, there's already an employee at position " + hashedKey);
        }
        else
        {
            hashtable[hashedKey] = employee;
        }
    }

    // O(1)
    public void remove(String key)
    {
        int hashedKey = hashKey(key);

        if (hashtable[hashedKey] == null)
        {
            System.out.println("Sorry, couldn't find any employees with the specified key");
        }
        else
        {
            hashtable[hashedKey] = null;
        }
    }

    public Employee get(String key)
    {
        int hashedKey = hashKey(key);

        return hashtable[hashedKey];
    }

    // We don't expose the hash function.
    // In the real world, ids are usually used as the key, but they still need hashing since very rarely their id will
    // be their position in the array.
    private int hashKey(String key)
    {
        return key.length() % hashtable.length; // 5 % 10 = 5
    }

    public void printHashtable()
    {
        for (Employee value : hashtable)
        {
            System.out.println(value);
        }
    }
}
