/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circularbuffer_solution;

import java.util.Arrays;

/**
 *
 * @author erso Created on 08-02-2010, 09:33:34
 */
class CircularBuff {

    private Integer [] buf;
    private int size;
    private int putIndex = 0;
    private int getIndex = 0;
    //boolean valueSet = false;

    public CircularBuff(int size){
        buf = new Integer[size];
        this.size = size;
//        System.out.println(this);

    }

    synchronized int get() {
        //System.out.println(Thread.currentThread().getName()+" waiting");
        while (buf[getIndex] == null) {
//            System.out.println("*** Buffer empty ****");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        int value = buf[getIndex];
        buf[getIndex] = null;
//        System.out.println(Thread.currentThread().getName()+"\tGot: " + getIndex + ": " + value);
        getIndex = (getIndex+1) % size;
        notify();
        return value;
    }

    synchronized void put(int n) {
        //System.out.println(Thread.currentThread().getName()+" waiting");
        while (buf[putIndex] != null) {
//            System.out.println("*** Buffer full ****");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        buf[putIndex] = n;
//        System.out.println(Thread.currentThread().getName()+" Put: " + putIndex+ ": " +n);
        putIndex = (putIndex+1) %size;
        notify();
    }

    public String toString(){
        return "Buff: "+Arrays.toString(buf);
    }
}

