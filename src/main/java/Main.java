import mcunit.TestReport;
import tests.AddTwoIntegers;
import tests.SubtractTwoIntegers;
import tests.ThrowAnException;

import static mcunit.Assertions.assertEquals;

public class Main {

    public static void main(String[] args) {
        System.out.println("# 2AA4 - Demo");
        TestReport report = new TestReport();
        report.collect(new AddTwoIntegers().run());
        report.collect(new SubtractTwoIntegers().run());
        report.collect(new ThrowAnException().run());
        System.out.println(report);

    }

}
