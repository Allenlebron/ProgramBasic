package DataStructure.Queue.DynamicArrayQueue;

/**
 * Created by panzhiwei on 2018/12/18.
 */
public class DynamicArrayQueue {

    //数组大小
    private String[] items;
    private int n = 0;
    //head表示队头下标，tail队尾下标
    private int head = 0;
    private int tail = 0;

    //申请一个大小为m的数组
    public DynamicArrayQueue(int m){
        items = new String[m];
        n = m;
    }

    //入队操作
    public boolean enqueue(String item){
        if(tail == n){
            if(head == 0)
                return false;
            //数据搬移
            for(int i=head; i< tail; i++){
                items[i - head] = items[i];
            }
            //搬移完后重新更新head和tail
            tail -= head;
            head = 0;
        }

        items[tail] = item;
        tail ++;
        return true;
    }

    //出队操作
    public String dequeue(){
        //队列为空
        if(head == tail) return null;

        String ret = items[head];
        head++;
        return ret;
    }

    //打印
    public void printAll(){

        for(int i=head;i < tail;i++){
            System.out.println(items[i] + "");
        }
        System.out.println();
    }
}