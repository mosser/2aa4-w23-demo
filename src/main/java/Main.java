import static mcunit.Assertions.assertEquals;

public class Main {

    public static void main(String[] args) {
        System.out.println("# 2AA4 - Demo");
        try {
            System.out.println("## Add two integers");
            assertEquals(1 + 1, 2);
            System.out.println("PASSED");
        } catch (AssertionError ae) {
            System.out.println("FAILED");
        }
        try {
            System.out.println("## Subtract two integers");
            assertEquals(1 - 1, 2);
            System.out.println("PASSED");
        } catch (AssertionError ae) {
            System.out.println("FAILED");
        }

    }

}
