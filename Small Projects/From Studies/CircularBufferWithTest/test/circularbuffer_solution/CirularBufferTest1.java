package circularbuffer_solution;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CirularBufferTest1 {

    CircularBuff instance = null;
    int size;
    Producer producer;

    public CirularBufferTest1() {
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
        producer = new Producer(instance);
        producer.start();
    }

    @After
    public void tearDown() {
        producer.interrupt();
    }
       
    /**
     * Test of put method, of class CircularBuff.
     */
    @Test
    public void testPutGet() {
        System.out.println("putGet");
        int[] arr = new int[11];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = instance.get();
        }
        int[] expResult = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(expResult, arr);
    }
    
       public class Producer extends Thread {

        private CircularBuff q;

        public Producer(CircularBuff q) {
            this.q = q;
        }

        @Override
        public void run() {
            int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            try {
                for (int j : arr) {
                    q.put(j);
                    Thread.sleep((long) (Math.random() * 100));
                }
            } catch (InterruptedException ex) {
                System.out.println("Producer was interrupted");
            }

        }
    }

}
