package tests;

import mcunit.TestCase;
import mcunit.TestSuite;

import static mcunit.Assertions.assertEquals;

public class IntegerTests extends TestSuite {

    public IntegerTests() {
        this.add(new AddTwoIntegers());
        this.add(new SubtractTwoIntegers());
        this.add(new ThrowAnException());
    }


    private static class AddTwoIntegers extends TestCase {

        int x, y;

        @Override
        protected void setUp() {
            x = 1;
            y = 1;
        }

        @Override
        protected void test() {
            assertEquals(x+y, 2);
        }
    }


    private static class SubtractTwoIntegers extends TestCase {

        @Override
        protected void test() {
            assertEquals(1-1, 2);
        }
    }

    private static class ThrowAnException extends TestCase {

        @Override
        protected void test() {
            throw new RuntimeException("KABOOM!");
        }
    }

}
