package circularbuffer_solution;

import junit.framework.TestResult;
import junit.framework.TestSuite;

public class CircularTestSuiteClass{
    public static void main(String[] args) {
        TestSuite circularBufferTestSuite = new TestSuite(CirularBufferTest1.class, CirularBufferTest2.class);
        circularBufferTestSuite.addTestSuite(CirularBufferTestCase.class);
        TestResult result = new TestResult();
        circularBufferTestSuite.run(result);
        System.out.println("Number of test cases = " + result.runCount());       
    }
 
}
