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

        /**
         * 功能：将元素插入节点并且插入到指定节点的前边
         *
         */
        public void insertBefore(Node p,int value){
            //生成新结点
            Node newNode = new Node(value,null);
            //插入到指定结点前面
            insertBerfore(p,newNode);

        }
        /**
         *
         * 功能：插入到指定结点的前面
         */
        public void insertBerfore(Node p,Node newNode){

            //判断建表是否为空
            if(p == null) return;
            //判断指定的节点是否为头结点
            if(head == p){
                //头插法
                insertToHead(newNode);
                return;
            }

            //将单链表表头赋值给节点q
            Node q = head;
            //如果此链表为空则返回
            if(q == null){
                return ;
            }

            //通过遍历查找结点p
            while(q != null & q.next != p){
                q = q.next;
            }
            //将p节点存入新节点的地址域
            newNode.next = p;
            //将新节点的地址域存入q节点的地址域
            q.next = newNode;
        }

        /**
         * 功能：指定节点删除
         *
         */
        public void deleteByNode(Node p){

           //如果是空链表，直接return
            if(p == null || head == null)
                return;
            //如果指定的节点为头节点
            if(p == head){
                //下一节点为头结点
                head = head.next;
                return;
            }
            //将存储头结点的地址赋值给q
            Node q = head;
            //如果链表不为空且地址域存储的值不为指定删除节点的地址就继续执行while循环
            while(q != null && q.next != p){
                q = q.next;
            }

            //如果遍历到链尾还没有找到指定删除的节点，就return
            if(q == null){
                return;
            }

            //如果找到了，就删除p节点，也就是将该删除的结点下一结点的地址赋值给删除结点前的地址域存储
            q.next = q.next.next;
        }

        /**
         * 功能:指定元素值删除链表结点
         * @param value:指定的元素值
         */
        public void deleteByValue(int value) {
            //如果链表为空链表，则就return
            if (head == null) return;

            //将存储头结点的地址赋值 q
            Node p = head;

            Node q = null;

            //如果不是空链表且当前结点的元素值不等于指定元素的值，继续执行while循环
            while (p != null && p.data != value) {
                //将 p 结点赋值给 q 结点
                q = p;
                //然后将下一个结点赋值给 p 结点
                p = p.next;
            }

            //如果遍历完单链表没有找到存储该元素的结点，就return。
            if (p == null) return;

            //如果单链表为空链表（？）
            if (q == null) {
                head = head.next;
            } else {
                //如果找到了，就删除p结点，也就是将该删除的结点下一结点的地址赋值给删除结点前的地址域存储
                //q.next = p.next 与下边等式等价
                q.next = q.next.next;
            }
        }

        //打印链表结点中所有数据结点
        public void printAll() {
            Node p = head;

            //由于链表最后一个存储的结点为null,所以不到
            while (p != null) {
                System.out.print(p.data + " ");
                p = p.next;
            }
            System.out.println();
        }
    }
}