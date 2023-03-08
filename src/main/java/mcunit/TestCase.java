package mcunit;

import static mcunit.Assertions.assertEquals;

public abstract class TestCase {

    public final void run() {
        try {
            System.out.println(this.getClass().getCanonicalName());
            test();
            System.out.println("PASSED");
        } catch (AssertionError ae) {
            System.out.println("FAILED");
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    protected abstract void test();

}
