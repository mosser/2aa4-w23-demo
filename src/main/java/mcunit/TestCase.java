package mcunit;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

import static mcunit.Assertions.assertEquals;

public final class TestCase implements Test {

    private final Method testMethod;
    private final Class klass;

    private static final String SETUP = "setUp";
    private static final String TEARDOWN = "tearDown";

    public TestCase(Class klass, Method testMethod) {
        this.testMethod = testMethod;
        this.klass = klass;
    }

    public final void run(TestReport collector) {
        String title = klass.getCanonicalName() + "::" + testMethod.getName();
        TestResult result = new TestResult(title);
        Object context = null;
        try {
            context =  klass.getDeclaredConstructor().newInstance();
            runSetup(context);
            runTest(context);
            result.record(STATUS.PASSED);
        } catch(InvocationTargetException ite) {
            try { // What happened inside the test method?
                throw ite.getTargetException();
            } catch (AssertionError ae) {
                result.record(STATUS.FAILED);
            } catch(Throwable e) {
                result.record(STATUS.ERRORED);
            }
        } catch (Exception e) {
            result.record(STATUS.ERRORED);
        } finally {
            try {
                runTearDown(context);
            } catch (Exception e) {
                result.record(STATUS.ERRORED);
            }
        }
        collector.collect(result);
    }

    private void runTest(Object context) throws IllegalAccessException, InvocationTargetException {
        this.testMethod.invoke(context);
    }

    private void runSetup(Object context) throws Exception {
        Optional<Method> m = findByName(SETUP);
        if(m.isPresent()){
            m.get().invoke(context);
        }
    }

    private void runTearDown(Object context) throws Exception {
        Optional<Method> m = findByName(TEARDOWN);
        if(m.isPresent()){
            m.get().invoke(context);
        }
    }

    private Optional<Method> findByName(String name) {
        try {
            return Optional.of(klass.getMethod(name));
        } catch (NoSuchMethodException e) {
            return Optional.empty();
        }
    }


}
