package com.cmbchina.stopthreads;

/**
 * while循环内部try catch 即使加了判断是否中断也会继续执行
 * 因为在执行一个迭代的中断过程中，java语言设计sleep函数时，清除了中断标志位，即使下次判断也不会获取是否中断
 * Created by ninja on 2020/2/7
 */
public class CantInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            //这里加isInterrupt方法没用
            while (num <= 30000) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                try {
                    //抛异常了继续执行下个迭代
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
