package com.cmbchina.createthreads;

/**
 * Created by ninja on 2020/2/7
 */
public class ThreadStyle extends Thread {
    @Override
    public void run() {
        System.out.println("用thread实现线程");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
