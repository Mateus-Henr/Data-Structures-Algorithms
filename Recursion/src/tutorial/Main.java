package tutorial;

/*  Recursion

    A method is a recursive method when it calls itself.


    Factorial algorithm
    1. If num is equal to 0, The factorial is 1. Stop. We have the result. Otherwise...
    2. Set multiplier to 1.
    3. Set factorial to 1.
    4. While multiplier is not equal to num, do steps 5 and 6.
    5. Multiply factorial by multiplier and assign the result to factorial.
    6. Add 1 to multiplier.
    7. Stop. The result is factorial.

    Formula
    1! = 0! * 1 = 1
    2! = 2 * 1 = 2 * 1!
    3! = 3 * 2 * 1 = 3 * 2!
    4! = 4 * 3 * 2 * 1 = 4 * 3!

    n! = n (n - 1)!


    Call stack
    When dealing with recursion the return value is placed in the call stack.
    Each call waits for a return value.


    Base condition
    REMEMBER NONE OF THE RECURSION CALLS RETURN UNTIL IT MEETS A CONDITION.
    That's why the condition is essential, this condition can be called "the base case" or the "breaking condition".
    Without this condition you will get a "StackOverflow" exception since the call stack has only a specific size
    of memory allocated to it.


    Iterative vs recursive
    The iterative version usually runs faster, and it doesn't take as much memory as the recursive one.
    Most of the time, recursion is used because the code gets more elegant (readable).
 */

public class Main
{
    public static void main(String[] args)
    {
        int num = 5;

        System.out.println("Factorial of " + num + " (iterative version) = " + iterativeFactorial(num));
        System.out.println("Factorial of " + num + " (recursive version) = " + recursiveFactorial(num));
    }

    // Factorial Algorithm Iteratively
    private static int iterativeFactorial(int num)
    {
        if (num == 0)
        {
            return 1;
        }

        int factorial = 1;

        for (int i = 1; i <= num; i++)
        {
            factorial *= i;
        }

        return factorial;
    }

    // Factorial Algorithm Recursively
    private static int recursiveFactorial(int num)
    {
        // In this case, when num is 0, "1" is going to be returned to the previous calls that are in the call stack.
        if (num == 0) // Base case.
        {
            return 1;
        }

        return num * recursiveFactorial(num - 1);
    }

    /*  Call stack representation when using the recursive version of the factorial algorithm.

        Call 1 (num = 5)
        {
            num * Call2();                  // 5 * 24 = 120

            Call 2 (num = 4)
            {
                num * Call3();              // 4 * 6 = 24

                Call 3 (num = 3)
                {
                    num * Call4();          // 3 * 2 = 6

                    Call 4 (num = 2)
                    {
                        num * Call5();      // 2 * 1 = 2

                        Call 5 (num = 1)
                        {
                            num * Call6();  // 1 * 1 = 1

                            Call 6 (num = 0)
                            {
                                return 1; // Since "num" is equal to 0, then the method returns 1.
                            }
                        }
                    }
                }
            }
        }

        Stack
        | Call 6(); |
        | Call 5(); |
        | Call 4(); |
        | Call 3(); |
        | Call 2(); |
        | Call 1(); |  // First added (Gets the result after this call)
    */
}
