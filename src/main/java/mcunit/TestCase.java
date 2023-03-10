package mcunit;

import static mcunit.Assertions.assertEquals;

public abstract class TestCase implements Test {

    public final void run(TestReport collector) {
        TestResult result = new TestResult(this.getClass().getCanonicalName());
        try {
            setUp();
            test();
            result.record(STATUS.PASSED);
        } catch (AssertionError ae) {
            result.record(STATUS.FAILED);
        } catch (Exception e) {
            result.record(STATUS.ERRORED);
        } finally {
            teardown();
        }
        collector.collect(result);
    }

    protected abstract void test();

    protected void setUp() {

    }

    protected void teardown() {

    }

}
