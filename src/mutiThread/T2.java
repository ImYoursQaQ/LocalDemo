package mutiThread;
/*改变引用的对象释放锁*/

import java.util.concurrent.TimeUnit;

public class T2 {
    Object object = new Object();
    public void m1(){
        synchronized (object){
            while (true){
                System.out.println(Thread.currentThread().getName()+"start");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void m2(){
        synchronized (object){
            while (true){

                System.out.println(Thread.currentThread().getName()+"start");
                try {
                   Thread.currentThread().wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        T2 t = new T2();

        new Thread(()->t.m1(),"m1").start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->t.m2(),"m2").start();
        t.object = new Object();
    }
}
