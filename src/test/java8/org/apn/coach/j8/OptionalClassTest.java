package org.apn.coach.j8;

import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.*;

/**
 * Optional class is a container object which may or may not contain a non-null value.
 *
 * <blockquote>Reference: https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html</blockquote>
 *
 * @author amit.nema
 */
@Test
public class OptionalClassTest {

    public void testOptionalClassNull() {
        Integer value = null;
        // Optional.ofNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.ofNullable(value);
        assertNotNull(a);
        assertFalse(a.isPresent());

        // Optional.orElse - returns the value if present otherwise returns
        // the default value passed.
        Integer val = a.orElse(0);
        assertEquals(0, val.intValue());
    }

    public void testOptionalClassNonNull() {
        Integer value = 10;
        // Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value);
        assertTrue(b.isPresent());

        // Optional.get - gets the value, value should be present
        Integer val = b.get();
        assertEquals(10, val.intValue());
    }
}
