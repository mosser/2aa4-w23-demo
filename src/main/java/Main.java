import tests.AddTwoIntegers;
import tests.SubtractTwoIntegers;
import tests.ThrowAnException;

import static mcunit.Assertions.assertEquals;

public class Main {

    public static void main(String[] args) {
        System.out.println("# 2AA4 - Demo");
        new AddTwoIntegers().run();
        new SubtractTwoIntegers().run();
        new ThrowAnException().run();

    }

}
