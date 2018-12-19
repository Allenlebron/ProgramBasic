package DataStructure.Stack.StackBasedLinkedList;

/**
 * Created by panzhiwei on 2018/12/14.
 */
public class StackBasedLinkedList {


        //定义栈顶指针
        private Node top = null;
        //定义栈结点
        private static class Node {
            //栈结点数据域
            private int data;
            //栈结点指针域
            private Node next;
            //构造函数
            public Node(int data, Node next) {
                this.data = data;
                this.next = next;
            }
            //get 获取数据域方法
            public int getData() {
                return data;
            }
        }

        /**
         *
         * 功能：入栈
         */
        public void push(int value){
            //创建一个栈节点
            Node newNode = new Node(value,null);
            //判断栈是否为空
            if(top == null){
                //如果栈为空就将入栈的值作为第一个元素
                top = newNode;
            }else{
                newNode.next = top;
                top = newNode;
            }
        }
        /**
         *
         * 功能：出栈
         */
        public int pop(){
            //如果最顶层节点为null,栈为空
            if(top == null)
                return -1;
            //否则执行出栈操作，先将栈顶节点数据元素赋值给value
            int value = top.data;
            //将top指针向下移动
            top = top.next;
            return value;
        }

        /**
         *
         * 功能：输出栈中所有元素
         */
         public void printAll(){
             //将栈顶指针赋值给p
             Node p = top;
             while(p != null){
                 System.out.println(p.data + "");
                 //指向下一个节点
                 p = p.next;
             }
             System.out.println();
         }
}