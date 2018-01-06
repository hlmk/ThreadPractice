package com.cht.syn3;

/**
 * 线程的同步和异步（synchronized修饰的是对象所）
 * @auther chenhaiting
 * @create 2018-01-06 16:29
 */
public class MyObject {

    public synchronized void    method1(){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method2(){
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args){

        MyObject mo = new MyObject();

        /**
         * mo对象只有一个，因此锁也只有一个，thread1和thread2同时被mo对象调用，而且thread1和thread2都被synchronized修饰，所以thread1和thread2
         * 之间会存在竞争mo对象锁的问题。
         */

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.method1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.method2();
            }
        });

        thread1.start();
        thread2.start();

    }

}
