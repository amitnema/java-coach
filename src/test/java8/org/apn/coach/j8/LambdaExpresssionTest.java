package org.apn.coach.j8;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Lambda Expression enables you to encapsulate a single unit of behavior and pass it to other code.
 * You can use a lambda expressions if you want a certain action performed on each element of a collection,
 * when a process is completed, or when a process encounters an error.
 *
 * <blockquote>Reference: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html</blockquote>
 */
@Test
public class LambdaExpresssionTest {

    public void testLambdaExpresssion() {
        LambdaExpresssionTest tester = new LambdaExpresssionTest();

        // with all detail as anonymous class
        MathOperation addition0 = new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        };

        // with type declaration
        MathOperation addition = (int a, int b) -> a + b;

        // with out type declaration
        MathOperation subtraction = (a, b) -> a - b;

        // with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // without return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b;

        assertEquals(addition0.operation(10, 5), 15);
        assertEquals(tester.operate(10, 5, addition), 15);
        assertEquals(tester.operate(10, 5, subtraction), 5);
        assertEquals(tester.operate(10, 5, multiplication), 50);
        assertEquals(tester.operate(10, 5, division), 2);

        // with parenthesis
        GreetingService greetService1 = message -> ("Hello " + message);

        // without parenthesis
        GreetingService greetService2 = (message) -> ("Hello " + message);

        assertEquals(greetService1.sayMessage("India"), "Hello " + "India");
        assertEquals(greetService2.sayMessage("US"), "Hello " + "US");
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        String sayMessage(String message);
    }
}
