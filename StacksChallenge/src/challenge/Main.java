package challenge;

/*  Stack Challenge

    • Using a stack, determine whether a string is a palindrome.
    • Strings may contain punctuation and spaces. They should be ignored. Case should be ignored .
    • Examples: 1. "I did, did I?" is a palindrome.
    2. "Racecar" is a palindrome.
    3. "hello" is not a palindrome.
 */

import java.util.ArrayDeque;
import java.util.Deque;

// A stack is ideal for reversing a string since the last element will be the first and so on.
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

    public static boolean checkForPalindrome(String string)
    {
        Deque<Character> stack = new ArrayDeque<>();
        string = string.toLowerCase().replaceAll("[^a-z]", "");

        // Pushing letters on to the stack.
        for (int i = 0; i < string.length(); i++)
        {
            stack.push(string.charAt(i));
        }

        int i = 0;

        while (!stack.isEmpty())
        {
            if (string.charAt(i++) != stack.pop())
            {
                return false;
            }
        }

        return true;
    }

}
