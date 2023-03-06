package mcunit;

public class Assertions {

    public static void assertTrue(boolean condition) {
        if(!condition){
            throw new AssertionError();
        }
    }

    public static void assertFalse(boolean condition) {
        assertTrue(!condition);
    }

    public static void assertEquals(Object o1, Object o2) {
        assertTrue(o1.equals(o2));
    }

}
