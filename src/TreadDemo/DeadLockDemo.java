package TreadDemo;

import java.util.concurrent.TimeUnit;

public class DeadLockDemo implements Runnable{

    private String lockA;
    private String lockB;

    public DeadLockDemo(String lockA,String lockB){
        this.lockA = lockA;
        this.lockB = lockB;
    }

    public static void main(String[] args) {

        DeadLockDemo deadLockDemo1 = new DeadLockDemo("lockA","lockB");
        DeadLockDemo deadLockDemo2 = new DeadLockDemo("lockB","lockA");

        Thread thread1 = new Thread(deadLockDemo1,"Thread1");
        Thread thread2 = new Thread(deadLockDemo2,"Thread2");

        thread1.start();
        thread2.start();

    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName() + "持有锁："+lockA +"尝试获得："+lockB);

            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + "持有锁："+lockB +"尝试获得："+lockA);
            }
        }
    }
}
