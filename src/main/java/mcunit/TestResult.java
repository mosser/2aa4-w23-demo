package mcunit;

public class TestResult {

    private final String name;
    private STATUS status;

    public TestResult(String name) {
        this.name = name;
    }

    public void record(STATUS s) {
        this.status = s;
    }

    public STATUS status() {
        return this.status;
    }

    @Override
    public String toString() {
        return "# " + status + " " + name;
    }
}
