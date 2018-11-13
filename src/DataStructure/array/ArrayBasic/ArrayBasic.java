package DataStructure.array.ArrayBasic;


/**
 * 数组的插入、删除、按照下标随机访问操作
 * 数组中的数据是int类型的
 * @author panzhiwei
 */
public class ArrayBasic {

    //定义整数数据data保存数据
    public int data[];
    //定义数组长度
    private int n;
    //定义实际个数
    private int count;

    //构造方法，初始化数组容量
    public ArrayBasic(int capacity){
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    //根据索引，找到数组中的元素并返回
    public int find(int index){
        if(index < 0 || index >= count){
            return -1;
        }
        return data[index];
    }

    //插入元素：头部插入、尾部插入
    public boolean insert(int index,int value){

        //数组空间已满
        if( n == count){
            System.out.println("没有插入的位置!");
            return false;
        }
        //如果count没满,就可以插入数组中
        //排除位置不合法的
        if(index < 0 || index > count){
            System.out.println("位置不合法！");
            return false;
        }
        //位置合法插入后移
        for(int i = count; i > index; i--){

            data[i] = data[i - 1];
        }

        data[index] = value;
        ++count;
        return true;
    }

    //删除元素
    public boolean delete(int index){

        if(index < 0 || index >= count){
            System.out.println("位置不合法!");
            return false;
        }
        //从删除位置开始，将后面的元素向前移一位
        for(int i = index + 1;i < count; i++){
            data[i - 1] = data[i];
        }
        --count;
        return true;

    }

    //输出数组所有元素
    public void printAll(){
        for(int i = 0; i < count; i++){
            System.out.println(data[i] + "");
        }

    }


    public static void main(String[] args) {
        ArrayBasic ab = new ArrayBasic(5);
        ab.insert(0,1000);
        ab.insert(1,1001);
        ab.insert(2,1002);
        ab.insert(3,1003);
        ab.insert(4,1004);
        ab.delete(4);
        ab.insert(4,1004);
        ab.printAll();
        System.out.println("查找的元素是：" + ab.find(3));
    }

}