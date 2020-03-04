package com.cmbchina.stopthreads;

/**
 * run方法中存在sleep等方法时，停止线程
 * Created by ninja on 2020/2/7
 */
public class RightWayStopThreadWithSleep {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;

            //isInterrupted这里主要用于while循环执行过慢导致的中断
            while (!Thread.currentThread().isInterrupted() && num <= 300) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
            }
            try {
                //休眠,由于主线程中调用interrupt方法，会抛异常
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}
