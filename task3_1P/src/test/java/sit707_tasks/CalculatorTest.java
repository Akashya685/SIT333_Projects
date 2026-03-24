package sit707_tasks;

import org.junit.Test;
import org.junit.Assert;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    public void testAdd() {
        Assert.assertEquals(4, calc.add(2, 2));
    }

    @Test
    public void testConcat() {
        Assert.assertEquals("HelloWorld", calc.concat("Hello", "World"));
    }
}