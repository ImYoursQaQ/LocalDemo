package mutiThread;
/*使用阻塞队列实现线程同步*/

import java.util.Random;
import java.util.concurrent.BlockingQueue;

//消费者
public class Producer implements Runnable{
   private final BlockingQueue<Integer> queue;
 
   public Producer(BlockingQueue q){
       this.queue=q;
   }
 
   @Override
   public void run() {
       try {
           while (true){
               Thread.sleep(500);//模拟耗时
               queue.put(produce());
           }
       }catch (InterruptedException e){
 
       }
   }
 
   private int produce() {
      // int n=new Random().nextInt(10000);
       int n = 1;
       System.out.println("Thread:" + Thread.currentThread().getId() + " produce:" + n);
       return n;
   }
}