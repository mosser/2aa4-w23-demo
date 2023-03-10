import mcunit.TestReport;
import tests.IntegerTests;


public class Main {

    public static void main(String[] args) {
        System.out.println("# 2AA4 - Demo");
        TestReport report = new TestReport();
        new IntegerTests().run(report);
        System.out.println(report);

    }

}
