package org.apn.coach.j7;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * In Java SE 7 and later, any number of underscore characters (_) can appear anywhere between digits in a numerical literal.
 * This feature enables you, for example, to separate groups of digits in numeric literals, which can improve the readability of your code.
 *
 * <p>
 * You can place underscores only between digits; you cannot place underscores in the following places:
 * <ul>
 * <li>At the beginning or end of a number</li>
 * <li>Adjacent to a decimal point in a floating point literal</li>
 * <li>Prior to an F or L suffix</li>
 * <li>In positions where a string of digits is expected</li>
 * </ul>
 * </p>
 * <blockquote>Reference: https://docs.oracle.com/javase/7/docs/technotes/guides/language/underscores-literals.html</blockquote>
 */
@Test
public class UnderscoresInNumericLiteralsTest {

    @DataProvider(name = "underscores-in-numeric-literals")
    public Object[][] dpUnderscoresInNumericLiterals() {
        return new Object[][]{
                {(byte) 2_45, (byte) 245},
                {(short) 75_556, (short) 75556},
                {4135_5669, 41355669},
                {202_555_0191L, 2025550191L}
        };
    }

    @Test(dataProvider = "underscores-in-numeric-literals")
    public void testUnderscoresInNumericLiterals(Object numberWithUnderscore, Object expected) {
        assert numberWithUnderscore.equals(expected);
    }
}
