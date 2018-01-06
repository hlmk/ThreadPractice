package com.cht.syn4;

/**
 * 脏读
 * @auther chenhaiting
 * @create 2018-01-06 16:47
 */
public class DirtyRead {

    private String username = "lisi";
    private String password = "123";

    public synchronized void setValue(String username, String password){
        try {
            this.username = username;
            Thread.sleep(2000);
            this.password = password;
            System.out.println("setValue username = " + this.username + " password = "+ this.password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void getValue(){
        System.out.println("getValue username = " + this.username + " password = " + this.password);
    }

    public static void main (String[] args)throws Exception{
        DirtyRead dirtyRead = new DirtyRead();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                dirtyRead.setValue("zhangsan","456");
            }
        });
        thread.start();
        Thread.sleep(1000);
        dirtyRead.getValue();
    }

}
