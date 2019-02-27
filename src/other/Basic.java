package other;

import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Math.*;
public class Basic {
    static  String name ;
    public static void main(String[] args) {
        //引用类型地址不同。前两个在变量池中，所以相等。
       /* String s1 = "ab";
        String s = "ab";
        String s2 = "a"+"b";
        String s3 = "a";
        String s4 = "b";
        String s5 = s3 + s4;
        System.out.println(s1==s2);
        System.out.println(s2==s5);
        System.out.println(s1==s5);
        System.out.println(s1==s);
        System.out.println(s1.intern());*/
       //+= 会转化类型
       /* byte a = 127;

        byte b = 127;
        b += a;
        System.out.println( (byte)254);*/
       //&和&&的区别。

        /*if(name!=null&name.equals("")){
            System.out.println("ok");
        }else{
            System.out.println("erro");
        }*/
        //static引入静态包
        System.out.println(random());
        boolean i = (3*0.1==0.3);
        System.out.println(i);
        ConcurrentHashMap map = new ConcurrentHashMap();

    }
}
