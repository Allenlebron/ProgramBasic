package TreadDemo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class UnsafeList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        List<String> list2 = new CopyOnWriteArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        //单线程
        list.forEach(System.out::println);

        //多线程条件下List
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list2.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list2);
            }, String.valueOf(i)).start();
        }
    }
        //多线程条件下Map
    public static void  MapNotSafe()
    {
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 1; i <=30; i++)
        {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }

    //多线程条件下Set
    public static void setNotSafe()
    {
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <=30; i++)
        {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}



