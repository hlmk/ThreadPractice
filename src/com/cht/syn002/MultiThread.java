package com.cht.syn002;

/**
 * @auther chenhaiting
 * @create 2018-01-06 15:56
 */
public class MultiThread {

    private static int num = 0;

    public synchronized static void prinNum(String tag){
        try {
            if("a".equals(tag)){
                num = 100;
                System.out.println("tag a, set num over!");
                Thread.sleep(1000);
            }
            if("b".equals(tag)){
                num = 200;
                System.out.println("tag b, set num over!");
            }
            System.out.println("tag = " + tag + " num = " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){

        MultiThread m1 = new MultiThread();
        MultiThread m2 = new MultiThread();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                m1.prinNum("a");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                m2.prinNum("b");
            }
        });

        thread1.start();
        thread2.start();

    }

}
