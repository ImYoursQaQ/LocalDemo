package mutiThread.TicketSeller;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/*使用同步容器*/
public class TicketSeller {
    static Queue<String> tickets = new ConcurrentLinkedQueue<>();
    static {
        for (int i = 0; i <1000 ; i++) {
            tickets.add("票号："+i);
        }
    }

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                while (true){
                    String s = tickets.poll();
                    if (s == null){
                        break;
                    }else{
                        System.out.println("已售出："+s);
                    }
                }

            }
        }).start();
    }
}
