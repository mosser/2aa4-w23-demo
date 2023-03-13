package tests;

import mcunit.TestCase;
import mcunit.TestSuite;

import static mcunit.Assertions.assertEquals;

public class IntegerTests extends TestSuite {

    public IntegerTests() {
        try {
            Class suite = IntegerTests.class;
            this.add(new TestCase(suite, suite.getMethod("addTwoIntegers")));
            this.add(new TestCase(suite, suite.getMethod("subtractTwoIntegers")));
            this.add(new TestCase(suite, suite.getMethod("throwAnException")));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    int x,y;

    public void setUp() {
        x = 1;
        y = 1;
    }

    public void addTwoIntegers() {
        assertEquals(x+y, 2);
    }

    public void subtractTwoIntegers() {
        assertEquals(x-y, 2);
    }

    public void throwAnException() {
        throw new RuntimeException("KABOOM!");
    }


}
