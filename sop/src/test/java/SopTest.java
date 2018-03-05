import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SopTest {
    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        MultiplyClass tester = new MultiplyClass();

        assertEquals(0, tester.multiply(10, 0));
        assertEquals(0, tester.multiply(0, 10));
        assertEquals(0, tester.multiply(0, 0));
    }

    @Test
    public void sumOfZeroIntegersShouldReturnSumOfNumbers() {
        SumClass tester = new SumClass();

        assertEquals(10, tester.sum(10, 0));
        assertEquals(10, tester.sum(0, 10));
    }

    @Test
    public void sumOfZeroesShouldReturnZero() {
        SumClass tester = new SumClass();

        assertEquals(0, tester.sum(0, 0));
    }

    @Test
    public void sumOfZeroesShouldNotReturnOne() {
        SumClass tester = new SumClass();

        assertNotEquals(1, tester.sum(0, 0));
    }
}
