package org.apn.coach.j7;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * In Java SE 7, the integral types (byte, short, int, and long) can also be expressed using the binary number system.
 *
 * <blockquote>Reference: https://docs.oracle.com/javase/7/docs/technotes/guides/language/binary-literals.html</blockquote>
 */
@Test
public class BinaryLiteralsTest {

    @DataProvider(name = "binary-literals")
    public Object[][] dpBinaryLiterals() {
        return new Object[][]{{(byte) 0b0010, (byte) 2}, {(short) 0b1010, (short) 10}, {0b110, 6}, {0B110, 6}, {0b111, 7}, {0b10100001L, 161L}};
    }

    @Test(dataProvider = "binary-literals")
    public void testBinaryLiterals(Object binaryInt, Object expected) {
        assert binaryInt.equals(expected);
    }
}
