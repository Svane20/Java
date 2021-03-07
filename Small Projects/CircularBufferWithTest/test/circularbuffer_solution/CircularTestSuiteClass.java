/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularbuffer_solution;

import junit.framework.TestResult;
import junit.framework.TestSuite;

/**
 *
 * @author fsan
 */
public class CircularTestSuiteClass{
    public static void main(String[] args) {
        TestSuite circularBufferTestSuite = new TestSuite(CirularBufferTest1.class, CirularBufferTest2.class);
        circularBufferTestSuite.addTestSuite(CirularBufferTestCase.class);
        TestResult result = new TestResult();
        circularBufferTestSuite.run(result);
        System.out.println("Number of test cases = " + result.runCount());       
    }
 
}
