package Jvm;

import java.util.Random;

public class OOMErrorDemo {
    /**
     *  1 出现java.lang.OutOfMemoryError:Java heap space异常
     *
     *      1.1 java虚拟机的堆内存不够，可以通过-Xms -Xmx来调整
     *      1.2 代码创建了大量对象，并且长时间不能被垃圾回收器收集
     *
     */

    public static void main(String[] args) {
        //模拟内存溢出
        //返回虚拟机试图使用最大内存
        long maxMemory = Runtime.getRuntime().maxMemory();
        //返回虚拟机内存总量
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("maxMemory="+maxMemory+"字节");
        System.out.println("maxMemory="+(maxMemory/(double)1024/1024)+"MB");

        System.out.println("totalMemory="+totalMemory+"字节");
        System.out.println("totalMemory="+(totalMemory/(double)1024/1024)+"MB");

        byte[] bytes = new byte[1024*1024*5];


        String str = "testOOM";
        while(true){
            str +=""+new Random().nextInt(88888888) + new Random().nextInt(999999999);
            System.out.println(str);
        }


    }


}
