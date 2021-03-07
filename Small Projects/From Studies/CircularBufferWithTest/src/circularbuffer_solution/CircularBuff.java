package circularbuffer_solution;

import java.util.Arrays;

class CircularBuff {

    private Integer [] buf;
    private int size;
    private int putIndex = 0;
    private int getIndex = 0;

    public CircularBuff(int size){
        buf = new Integer[size];
        this.size = size;
    }

    synchronized int get() {
        while (buf[getIndex] == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        int value = buf[getIndex];
        buf[getIndex] = null;
        getIndex = (getIndex+1) % size;
        notify();
        return value;
    }

    synchronized void put(int n) {
        while (buf[putIndex] != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        buf[putIndex] = n;
        putIndex = (putIndex+1) %size;
        notify();
    }

    public String toString(){
        return "Buff: "+Arrays.toString(buf);
    }
}

