package circularbuffer_solution;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(circularbuffer_solution.CirularBufferTest1.class, circularbuffer_solution.CirularBufferTest2.class, circularbuffer_solution.CirularBufferTestCase.class, circularbuffer_solution.CircularBufferTestSuite.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
