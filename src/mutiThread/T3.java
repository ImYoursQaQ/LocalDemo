package mutiThread;
/*volatile关键字保证可见性*/

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T3 {
    String name;
     int anInt = 0;
    volatile boolean flag = true;
    //public  int anInt = 0;
    public synchronized void m1(String name,int anInt){
            this.name = name;
           try {
               TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

            this.anInt = anInt;
    }

    public  int m2(String name){

            return this.anInt;


    }

    public void  m3(){
        while (flag){

        }
        System.out.println("233");
    }


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        T3 t = new T3();
        new Thread(t::m3,"m3").start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.flag = false;
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(t.m2("zhang"));
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(()->t.m1("zhang",100),"m1").start();*/
       /* try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.m2("zhang"));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.m2("zhang"));*/
    }
}
