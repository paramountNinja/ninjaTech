package com.ninja.stopthreads;

/**
 * 最佳实践：catch了InterruptedExcetion之后的优先选择：在方法签名中抛出异常 那么在run()就会强制try/catch
 * Created by ninja on 2020/2/7
 */
public class RightWayStopThreadInPrd {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            while (true && !Thread.currentThread().isInterrupted()) {
                System.out.println("go");
                try {
                    throwInMethod();
                } catch (InterruptedException e) {
                    //手动中断当前线程
                    Thread.currentThread().interrupt();
                    System.out.println("保存日志等");
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    //给上层run方法去进行异常捕获
    private static void throwInMethod() throws InterruptedException {
        Thread.sleep(2000);
    }
}
