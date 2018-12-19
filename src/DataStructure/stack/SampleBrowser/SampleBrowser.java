package DataStructure.Stack.SampleBrowser;

/**
 *
 * 功能：使用前后栈使用浏览器前进后退
 * @author panzhiwei
 * @date 2018/12/13 17:18
 * @param
 * @return
 */
public class SampleBrowser {

    //存储当前页面变量
    private String currentPage;

    //backStack栈（存储浏览器前进时浏览过的页面）
    private LinkedListBasedStack backStack;
    //forwardStack栈(存储浏览器后退时浏览过的页面)
    private LinkedListBasedStack forwardStack;

    //构造函数
    public SampleBrowser(){
        //新建一个浏览器栈（backStack）
        this.backStack = new LinkedListBasedStack();
        //新建一个浏览器栈（forwardStack）
        this.forwardStack = new LinkedListBasedStack();
    }

    //打开一个网页
    public void open(String url){
        //判断是不是第一个入栈页面（除第一次调用外，将前一个页面入栈，让当前的页面显示浏览器）
        if(this.currentPage != null){
            //入栈操作
            this.backStack.push(this.currentPage);
            this.forwardStack.clear();
        }
        //第一个入栈网页，显示界面
        showUrl(url,"Open");
    }

    //显示网页，并标记为当前页面
    public void showUrl(String url,String prefix){
        this.currentPage = url;
        System.out.println(prefix + "page ==" +url);
    }

    //当前页面是哪一个页面
    public void checkCurrentPage(){
        System.out.println("Current page is: " + this.currentPage);
    }

    //判断back栈是否大于0
    public boolean canGoBack(){
        return this.backStack.size > 0;
    }

    //判断forward栈是否大于0
    public boolean canGoForward(){
        return this.forwardStack.size > 0;
    }

    //浏览器退回
    public String GoBack(){
        if(canGoBack()){
            //将当前页面入栈到forward
            this.forwardStack.push(currentPage);
            //将原来栈数据出栈
            String backUrl = this.backStack.pop();
            //将出栈的页面显示在浏览器页面上
            showUrl(backUrl,"Forward");
            //返回url
            return backUrl;
        }
        //否则提示不能进行浏览器倒退
        System.out.println("* Cannot go back, no pages behind.");
        return null;
    }

    //浏览器前进
    public String GoForward(){
        if(canGoForward()){
            //将当前页面入栈到back
            this.backStack.push(currentPage);
            //将原来的数据出栈
            String forwardUrl = this.forwardStack.pop();
            //将出栈的页面显示在浏览器页面上
            showUrl(forwardUrl,"Back");
            //返回url
            return forwardUrl;
        }
        return null;
    }

    //主函数
    public static void main(String[] args) {
        SampleBrowser browser = new SampleBrowser();
        //打开新网页
        browser.open("http://www.baidu.com");
        //打开新网页
        browser.open("http://news.baidu.com/");
        //打开新网页
        browser.open("http://news.baidu.com/net");
        //后退网页
        browser.GoBack();
        //后退网页
        browser.GoBack();
        //前进页面
        browser.GoForward();
        //打开新页面
        browser.open("http://www.qq.com");
        //前进页面
        browser.GoForward();
        //后退网页
        browser.GoBack();
        //前进页面
        browser.GoForward();
        //后退网页
        browser.GoBack();
        //后退网页
        browser.GoBack();
        //后退网页
        browser.GoBack();
        //后退网页
        browser.GoBack();
        //查看当前页面
        browser.checkCurrentPage();
    }
    public static class LinkedListBasedStack{
        //栈的大小
        private int size;
        //栈的顶部
        private Node top;

        //该定义一个结点类
        public static class Node {

            //数据域
            private String data;
            //指针域
            private Node next;

            public Node(String data) {
                this(data, null);
            }

            public Node(String data, Node next) {
                this.data = data;
                this.next = next;
            }

            public void setData(String data) {
                this.data = data;
            }

            public String getData() {
                return this.data;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public Node getNext() {
                return this.next;
            }
        }

        //创建一个节点
        static Node createNode(String data,Node next){
            return new Node(data,next);
        }

        //清空栈
        public void clear(){
            this.top  = null;
            this.size = 0;
        }

        //入栈
        public void push(String data){
            Node node = createNode(data,this.top);
            this.top = node;
            this.size++;
        }

        //出栈
        public String pop(){
            Node popNode = this.top;
            if(popNode == null){
                System.out.println("Stack is empty!");
                return null;
            }
            this.top = popNode.next;
            if(size > 0){
                size --;
            }
            return popNode.data;
        }

        //获取栈顶元素
        public String getTopData(){
            if(this.top == null){
                return null;
            }
            return this.top.data;
        }

        //栈的大小
        public int size(){
            return this.size;
        }

        //输出栈中的所有元素
        public void print(){
            System.out.println("print Stack!");
            Node currentNode = this.top;
            while (currentNode != null){
                String data = currentNode.getData();
                System.out.println(data + " \t");
                currentNode = currentNode.next;
            }
            System.out.println();

        }
    }
}