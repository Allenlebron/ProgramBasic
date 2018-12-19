package DataStructure.Queue.CircularQueue;

/**
 * Created by panzhiwei on 2018/12/19.
 */
public class CircularQueue {

    //初始化数组
    private String[] items;
    private int n = 0;

    //head表示队头下标，tail表示队尾下标
    private int head =0;
    private int tail =0;

    //构造函数
    public CircularQueue(int m){
        items = new String[m];
        n = m;
    }

    //入队
    public Boolean enqueue(String item){
        //队列满了
        if((tail + 1)%n == head){
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    //出队
    public String dequeue(){
        if(head == tail)
            return null;

        String ret = items[head];
        head = (tail + 1)% n;
        return ret;
    }

    public void printAll(){
        if(0 == n)
          return;
        for(int i = head;i < n; i++){
            System.out.println(items[i] + "");
        }
        System.out.println();
    }
}