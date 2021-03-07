/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularbuffer_solution;

/**
 *
 * @author fsan
 */
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
