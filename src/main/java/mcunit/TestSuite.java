package mcunit;

import java.util.HashSet;
import java.util.Set;

public class TestSuite implements Test {

    private final Set<Test> tests = new HashSet<>();

    @Override
    public void run(TestReport collector) {
        for(Test t: tests){
            t.run(collector);
        }
    }

    public void add(Test t) {
        this.tests.add(t);
    }
}
