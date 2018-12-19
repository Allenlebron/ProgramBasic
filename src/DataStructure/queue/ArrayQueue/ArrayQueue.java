package DataStructure.Queue.ArrayQueue;

/**
 *
 * 使用数组实现队列
 * Created by panzhiwei on 2018/12/17.
 */
public class ArrayQueue {

    //初始化数组
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    //申请一个大小为m的数组
    public ArrayQueue(int m){
        items = new String[m];
        n = m;
    }

    //入队
    public boolean enqueue(String item){
        //队列满了
        if(tail == n)
        return false;
        //插入
        items[tail] = item;
        tail ++;
        return true;
    }

    //出队
    public String dequeue(){
        //队列为空
        if(head == tail)
            return null;
        //取出
        String ret = items[head];
        head ++;
        return ret;
    }

    //打印
    public void printAll(){
        for(int i = head; i < tail; i++){
            System.out.println(items[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(10);
        aq.enqueue("java");
        aq.enqueue("python");
        aq.enqueue("scala");
        aq.enqueue("go");
        aq.enqueue("lisp");
        aq.printAll();
    }
}