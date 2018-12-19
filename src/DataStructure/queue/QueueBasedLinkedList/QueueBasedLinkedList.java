package DataStructure.Queue.QueueBasedLinkedList;

/**
 *
 * 使用链表实现队列
 * Created by panzhiwei on 2018/12/17.
 */
public class QueueBasedLinkedList {

    //Node结点
    private static class Node{
        private String data;
        private Node next;

        public Node(String data,Node next){
            this.data = data;
            this.next = next;
        }

        public String getData(){
            return data;
        }
    }

    //队首和队尾
    private Node head = null;
    private Node tail = null;

    //入队
    public void enqueue(String vaule){
        //队尾为空时
        if(tail == null){
            Node newNode = new Node(vaule,null);
            head = newNode;
            tail = newNode;
        }else{
            tail.next = new Node(vaule,null);
            tail = tail.next;
        }
    }

    //出队
    public String dequeue(){
        if(head == null)
            return null;
        String value = head.data;
        head = head.next;
        if(head == null){
            tail = null;
        }
        return value;
    }

    public void printAll(){
        Node p = head;
        while(p != null){
            System.out.println(p.data + "");
            p = p.next;
        }
        System.out.println();
    }


}