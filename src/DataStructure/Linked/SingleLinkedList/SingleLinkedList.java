package DataStructure.Linked.SingleLinkedList;

/**
 * Created by panzhiwei on 2018/11/8.
 * 1)单链表的插入、删除、查找操作
 * 2)链表中存储的是int类型
 *
 *
 */
public class SingleLinkedList {

    /**
     *
     * 功能定义：Node节点，Node包含数据域和引用（存储所指向对象的内存地址）
     */
    public static class Node{
        //数据域
        private int data;
        //引用
        private Node next;
        //初始化
        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return data;
        }

        private Node head = null;

        /**
         * 功能：单链表按值查找
         *
         */
        public Node findByValue(int value){
            //将链表的头部复制给p
            Node p = head;

            //判断链表是否为空和是否有要查找的值
            while(p != null && p.data != value){
                p = p.next;
            }
            return p;
        }

        /**
         *  功能：单链表按照索引查找
         *
         */
        public Node findByIndex(int index){
            //将链表的头部复制给p
            Node p = head;
            //定义计数变量pos
            int pos = 0;
            //如果链表不为空且索引不为用户指定索引
            while(p != null && pos != index){
                p = p.next;
                pos++;
            }
            return p;
        }

        /**
         * 功能：将元素插入节点并且利用头插法插入链表
         *
         */
        public void insertToHead(int value){

            //生成新节点
            Node newNode = new Node(value,null);
            //调用头插法函数
            insertToHead(newNode);
        }

        /**
         * 功能：头插法
         *      1.如果链表为空（head == null）需要将结点作为头部
         *      2.如果链表不为空，则将新节点的next指向头结点地址，然后将新节点替换成头部
         */
        public void insertToHead(Node newNode){
            //如果是链表是空链表
            if(head == null) {
                //将新节点作为头部
                head = newNode;
            }else{
                //将新节点的next指向头结点地址
                newNode.next = head;
                //将新节点替换为头部
                head = newNode;
            }
        }
        /**
         * 功能：将元素插入节点并且插入到指定节点的后面
         *
         */
        public void insertAfter(Node p,int value){
            //生成新节点
            Node newNode = new Node(value,null);
            //插入到指定节点前边
            insertAfter(p,newNode);
        }

        /**
         * 功能:插入到指定结点的后面
         * 思考:如果该指定结点是最后一个结点，该方法是否适用？答:可行
         * @param p:指定结点
         * @param newNode:被插入的新结点
         */
        public void insertAfter(Node p, Node newNode) {
            //判断要插入的链表是否是一个空链表
            if (p == null) return;
            //将原本 p 结点存储下一结点的地址赋值给新结点的地址域
            newNode.next = p.next;
            //然后p结点的地址域指向新结点
            p.next = newNode;
        }

    }

}