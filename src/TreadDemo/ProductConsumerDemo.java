package TreadDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AirCondition {

     // 方法一使用synchronized
     // 方法二使用Lock
     private int num = 0;


//     public synchronized void increment() throws Exception {
//
//         //不为0就等待消费
//         while (num != 0) {
//             this.wait();
//         }
//         // +1
//         num++;
//         System.out.println(Thread.currentThread().getName()+"\t" +num);
//         this.notifyAll();
//     }
//
//     public synchronized void decrement() throws Exception {
//
//         //等于0就等待生产
//         while (num == 0) {
//             this.wait();
//         }
//         num--;
//         System.out.println(Thread.currentThread().getName()+"\t"+num);
//         this.notifyAll();
//     }

     private Lock lock = new ReentrantLock();
     private Condition condition = lock.newCondition();
     public void increment() throws InterruptedException {
         lock.lock();
         try{
             //1.判断
             while(num != 0){
                 condition.await();
             }
             //2.干活
             num++;
             //3.通知
             condition.signalAll();
         }catch(Exception e){
             e.printStackTrace();
         }finally{
             lock.unlock();
         }
     }

    public void decrement(){
         lock.lock();
         try{
            //1.判断
             while(num == 0){
                 condition.await();
             }
             //2.干活
             num--;
             //3.通知
             condition.signalAll();
         }catch(Exception e){
             e.printStackTrace();
         }finally{
             lock.unlock();
         }
    }

 }


/**
 * 题目：
 * 现在有两个线程可以操作一个值为0的变量
 * 一个线程对该变量进行加1，一个变量进行减1
 * 实现交替，来10轮
 *
 * 1.高聚低合，线程操作资源类
 * 2.判断干活通知
 * 3.防止虚假唤醒（使用while代替if进行判断）
 *
 */
  public class ProductConsumerDemo{

        public static void main(String[] args) {

            AirCondition airCondition = new AirCondition();
            new Thread(() ->{
                for (int i = 0; i < 10 ; i++) {
                    try {
                        airCondition.increment();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            },"A").start();

            new Thread(() ->{
                for (int i = 0; i < 10; i++) {
                    try {
                        airCondition.decrement();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            },"B").start();
        }
    }

