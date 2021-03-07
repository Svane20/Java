package circularbuffer_solution;

import junit.framework.TestCase;
import junit.framework.TestResult;

public class CircularBufferTestCaseRunner {

    public static void main(String[] args) {
        TestCase testCase = new CirularBufferTestCase();
        TestResult result = new TestResult();
        testCase.run(result);
        System.out.println("Number of test cases = " + result.runCount());
    }

}
