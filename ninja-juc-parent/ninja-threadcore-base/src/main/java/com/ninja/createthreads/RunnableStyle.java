package com.ninja.createthreads;

/**
 * Created by ninja on 2020/2/7
 */
public class RunnableStyle implements Runnable {
    public void run() {
        System.out.println("runnable实现线程");
    }


    public static void main(String[] args) {
        new Thread(new RunnableStyle()).start();
    }
}
