package circularbuffer_solution;

class Producer implements Runnable {
   private CircularBuff q;
   private int initVal;

   Producer(CircularBuff q, int number) {
      this.q = q;
      initVal = number*100;
      new Thread(this, "Producer_"+number).start();
   }

   public void run() {
      int i = initVal;
      while(true) {
         q.put(i++);
      }
   }
}