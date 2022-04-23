package challenges.first;

/*  Hashtables Challenge #1

    • Write the hashing function for this challenge.
 */

public class Main
{
    public static void main(String[] args)
    {
        int[] nums = new int[10];
        int[] numsToAdd = {59382, 43, 6894, 500, 99, -58};

        for (int value : numsToAdd)
        {
            nums[hash(value)] = value;
        }

        for (int num : nums)
        {
            System.out.println(num);
        }
    }

    public static int hash(int value)
    {
        // You always want to MOD the value with the array's length to be sure that's going to return a valid index.
        return Math.abs(value % 10); // By using the MOD operator we would get the digit in the number's unity slot.
    }

}
