package circularbuffer_solution;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CirularBufferTest2 {

    CircularBuff instance = null;
    int size;

    public CirularBufferTest2() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        size = 5;
        instance = new CircularBuff(size);
    }

    @After
    public void tearDown() {
    }
    /**
     * Test of toString method, of class CircularBuff.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Integer[] buf = new Integer[size];
        String expResult = "Buff: " + Arrays.toString(buf);
        String result = instance.toString();
        assertEquals(expResult, result);
    }


}
