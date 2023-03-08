package mcunit;

import static mcunit.Assertions.assertEquals;

public abstract class TestCase {

    public final TestResult run() {
        TestResult result = new TestResult(this.getClass().getCanonicalName());
        try {
            test();
            result.record(STATUS.PASSED);
        } catch (AssertionError ae) {
            result.record(STATUS.FAILED);
        } catch (Exception e) {
            result.record(STATUS.ERRORED);
        }
        return result;
    }

    protected abstract void test();

}
