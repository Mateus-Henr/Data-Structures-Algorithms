package challenge;

/*  Queues Challenge

    • Using a stack and a queue, determine whether a string is a palindrome.
    • Strings may contain punctuation and spaces. They should be ignored. Case should be ignored.
    • Examples:
        1. "I did, did I?" is a palindrome.
        2. "Racecar" is a palindrome.
        3. "hello" is not a palindrome
 */

import java.util.LinkedList;
import java.util.Stack;

public class Main
{
    public static void main(String[] args)
    {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    // This is the most elegant solution to check for palindrome.
    public static boolean checkForPalindrome(String string)
    {
        LinkedList<Character> queue = new LinkedList<>(); // DISPLAYS DATA NORMALLY.
        Stack<Character> stack = new Stack<>(); // DISPLAYS DATA IN REVERSE.

        string = string.toLowerCase();

        for (int i = 0; i < string.length(); i++)
        {
            char letter = string.charAt(i);

            if ((letter >= 'a') && (letter <= 'z'))
            {
                queue.addLast(letter); // FIFO (Original string)
                stack.push(letter); // LIFO (Reversed string)
            }
        }

        for (int i = 0; i < queue.size(); i++)
        {
            // Remember that the type of data in the data structures are objects.
            if (!queue.removeFirst().equals(stack.pop()))
            {
                return false;
            }
        }

        return true;
    }

}
