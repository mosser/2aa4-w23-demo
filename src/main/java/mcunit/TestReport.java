package mcunit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestReport {

    private List<TestResult> results = new ArrayList<>();
    private Map<STATUS,Integer> counter = new HashMap<>();

    public void collect(TestResult r) {
        this.results.add(r);
        Integer howMany = this.counter.getOrDefault(r.status(),0);
        this.counter.put(r.status(), howMany + 1);
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        for (TestResult r: this.results) {
            result.append(r.toString() + "\n");
        }
        result.append(this.counter.toString());
        return result.toString();
    }
}
