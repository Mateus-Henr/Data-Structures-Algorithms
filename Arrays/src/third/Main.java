package third;

/*  Big O for Arrays

    Retrieving an element in an array from its index
    In order to retrieve any element in an array, all that is going to take is three steps as described below:
    1 - Multiply the size of the element by its index.
    2 - Get the start address of the array.
    3 - Add the start address to the result of the multiplication.
    As we don't have any "n"s, only a constant, we have a constant time complexity, O(1).


    Searching for an element in an array
    If using a linear search for looking for an element in an array, the time complexity would be O(n).


    Other operations
    Add an element to a full array - O(n). (Creating a new array and adding the elements)
    Add an element to the end of the array (has space) - O(1).
    Insert or update element at a specific index - O(1).
    Delete an element by setting it to null - O(1).
    Delete an element by shifting elements - O(n). (Moving the elements to fill in the position of the removed one)
    To sum up, having to loop through an array for an operation implies on having a linear time complexity.
 */

public class Main
{
    public static void main(String[] args)
    {
        int[] intArray = new int[7];

        intArray[0] = 20;
        intArray[1] = 35;
        intArray[2] = -15;
        intArray[3] = 7;
        intArray[4] = 55;
        intArray[5] = 1;
        intArray[6] = -22;

        int index = -1;

        // Linear search in an array. O(n).
        for (int i = 0; i < intArray.length; i++)
        {
            if (intArray[i] == 7)
            {
                index = i;
                break;
            }
        }

        if (index == -1)
        {
            System.out.println("Not found!");
        }
        else
        {
            System.out.println("Element at position " + index);
        }
    }

}
