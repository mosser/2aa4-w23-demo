package tests;

import mcunit.TestCase;

import static mcunit.Assertions.assertEquals;

public class AddTwoIntegers extends TestCase {

    int x = 1;
    int y = 1;

    @Override
    protected void test() {
        assertEquals(x+y, 2);
    }
}
