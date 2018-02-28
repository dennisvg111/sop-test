import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SopTest {
    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        MyClass tester = new MyClass();

        assertEquals(0, tester.multiply(10, 0));
        assertEquals(0, tester.multiply(0, 10));
        assertEquals(0, tester.multiply(0, 0));
    }
}
