package com.ninja.stopthreads;

/**
 * run 方法中没有sleep或wait方法时，停止线程
 * Created by ninja on 2020/2/7
 */
public class RightWayStopThreadWithoutSleep implements Runnable {
    public void run() {
        int i = 0;
        //自己控制的线程可以通过isInterrupted函数来停止执行
        while (!Thread.currentThread().isInterrupted() && i < Integer.MAX_VALUE / 2) {
            if (i % 10000 == 0) {
                System.out.println(i++ + "是10000的倍数");
            }
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(1000);
        //停止线程
        thread.interrupt();
    }
}
