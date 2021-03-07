/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularbuffer_solution;

import junit.framework.TestCase;
import junit.framework.TestResult;

/**
 *
 * @author fsan
 */
public class CircularBufferTestCaseRunner {

    public static void main(String[] args) {
        TestCase testCase = new CirularBufferTestCase();
        TestResult result = new TestResult();
        testCase.run(result);
        System.out.println("Number of test cases = " + result.runCount());
    }

}
