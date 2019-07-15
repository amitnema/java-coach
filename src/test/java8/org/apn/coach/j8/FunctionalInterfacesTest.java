package org.apn.coach.j8;

import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

/**
 * java.util.function: A new package that contains general purpose functional interfaces that provide target types for lambda expressions and method references.
 *
 * <blockquote>Reference: https://docs.oracle.com/javase/8/docs/technotes/guides/language/enhancements.html</blockquote>
 *
 * @author amit.nema
 */
@Test
public class FunctionalInterfacesTest {

    /**
     * The int result.
     */
    private int intResult;

    /**
     * Eval.
     *
     * @param list      the list
     * @param predicate the predicate
     */
    private static List<Integer> eval(final List<Integer> list, final Predicate<Integer> predicate) {
        List<Integer> retList = Lists.newArrayList();
        for (final Integer n : list) {
            if (predicate.test(n)) {
                retList.add(n);
            }
        }
        return retList;
    }

    /**
     * Test predicate.
     */
    public void testPredicate() {
        final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Predicate<Integer> predicate = n -> true
        // n is passed as parameter to test method of Predicate interface
        // test method will always return true no matter what value n has.

        // pass n as parameter
        final List<Integer> allNumbers = eval(list, n -> true);
        assertEquals(list, allNumbers);

        // Predicate<Integer> predicate1 = n -> n%2 == 0
        // n is passed as parameter to test method of Predicate interface
        // test method will return true if n%2 comes to be zero

        final List<Integer> evenNumbers = eval(list, n -> n % 2 == 0);
        assertEquals(list.parallelStream().filter(n -> n % 2 == 0).collect(Collectors.toList()), evenNumbers);

        // Predicate<Integer> predicate2 = n -> n > 3
        // n is passed as parameter to test method of Predicate interface
        // test method will return true if n is greater than 3.

        System.out.println("Print numbers greater than 3:");
        final List<Integer> numbersGrtrThnThree = eval(list, n -> n > 3);
        assertEquals(list.parallelStream().filter(n -> n > 3).collect(Collectors.toList()), numbersGrtrThnThree);
    }

    /**
     * Test bi consumer.
     */
    public void testBiConsumer() {
        final BiConsumer<Integer, Integer> biConsumer = (x, y) -> {
            intResult = x * y;
        };
        biConsumer.accept(4, 5);
        assertEquals(20, intResult);
    }

    /**
     * Test bi function.
     */
    public void testBiFunction() {
        final BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> {
            return x * y;
        };
        intResult = biFunction.apply(5, 5);
        assertEquals(25, intResult);
    }
}
