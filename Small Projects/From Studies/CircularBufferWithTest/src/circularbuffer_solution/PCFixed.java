package circularbuffer_solution;

public class PCFixed {
   public static void main(String args[]) throws InterruptedException {
      CircularBuff q = new CircularBuff(5);
      new Producer(q, 0);
      new Producer(q, 1);

      new Consumer(q, 0);
      new Consumer(q, 1);
      new Consumer(q, 2);

   }
}
