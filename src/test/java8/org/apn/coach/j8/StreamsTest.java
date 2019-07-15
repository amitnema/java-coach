package org.apn.coach.j8;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

/**
 * java.util.stream: A new package that contains the majority of interfaces and classes that provide functionality to streams and aggregate operations
 *
 * <blockquote>Reference: https://docs.oracle.com/javase/tutorial/collections/streams/index.html</blockquote>
 *
 * @author amit.nema
 */
@Test
public class StreamsTest {
    private static int check = 0;

    private static void count(final int i) {
        check++;
    }

    @DataProvider(name = "count")
    public Object[][] dpCount() {
        return new Object[][]{
                {Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl"), 2}
        };
    }

    @Test(dataProvider = "count")
    public void testCount(final List<String> list, final int expected) {
        // get count of empty string
        final long count = list.stream().filter(String::isEmpty).count();
        assertEquals(count, expected);
    }

    @DataProvider(name = "map")
    public Object[][] dpMap() {
        return new Object[][]{
                {Arrays.asList(3, 2, 2, 3, 7, 3, 5), Arrays.asList(9, 4, 49, 25)}
        };
    }

    @Test(dataProvider = "map")
    public void testMap(final List<Integer> numbers, final List<Integer> expected) {
        // get list of unique squares
        final List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        assertEquals(squaresList, expected);
    }

    @DataProvider(name = "for-each")
    public Object[][] dpForeach() {
        return new Object[][]{
                {10}
        };
    }

    @Test(dataProvider = "for-each")
    public void testForeach(final int limit) {
        // forEach
        final Random random = new Random();
        random.ints().limit(limit).forEach(StreamsTest::count);
        assertEquals(check, limit);
    }

    @DataProvider(name = "list")
    public Object[][] dpList() {
        return new Object[][]{
                {Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl"), Arrays.asList("abc", "bc", "efg", "abcd", "jkl")}
        };
    }

    @Test(dataProvider = "list")
    public void testFilter(List<String> given, List expected) {
        final List<String> filtered = given.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        assertEquals(filtered, expected);
    }
}
