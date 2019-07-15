package org.apn.coach.j8;

import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

import static org.testng.Assert.assertNotNull;

/**
 * Method References are compact, easy-to-read lambda expressions for methods that already have a name.
 *
 * <blockquote>Reference: https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html</blockquote>
 *
 * @author amit.nema
 */
@Test
public class MethodReferencesTest {

    public void testMethodReference() {
        final List<String> list = Lists.newArrayList("India", "Germany", "United States", "Singapore", "Australia");
        // Method Reference call to MethodReferences.check(String s) method
        list.forEach(MethodReferences::check);
    }
}

class MethodReferences {
    public static void check(String s) {
        assertNotNull(s);
    }
}