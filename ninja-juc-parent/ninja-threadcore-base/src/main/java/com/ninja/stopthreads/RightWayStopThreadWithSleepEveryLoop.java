package com.ninja.stopthreads;

/**
 * run方法的每个迭代中存在sleep等方法时，停止线程
 * Created by ninja on 2020/2/7
 */
public class RightWayStopThreadWithSleepEveryLoop {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            try {
                //无需判断当前线程是否中断，因为每个迭代里都有休眠
                while (num <= 30000) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                    //迭代中的休眠,由于主线程中调用interrupt方法，会抛异常
                    Thread.sleep(10);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
