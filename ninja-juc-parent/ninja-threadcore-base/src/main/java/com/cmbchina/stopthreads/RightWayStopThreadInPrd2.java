package com.cmbchina.stopthreads;

/**
 * Created by ninja on 2020/2/7
 */
public class RightWayStopThreadInPrd2 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("中断当前线程");
                    break;
                }
                throwInMethod();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    private static void throwInMethod() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
