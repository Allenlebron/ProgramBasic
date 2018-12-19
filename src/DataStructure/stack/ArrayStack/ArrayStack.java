package DataStructure.Stack.ArrayStack;

/**
 *
 * 功能：基于数组的栈
 * @author panzhiwei
 * @date 2018/12/13 17:22
 * @param
 * @return
 */
public class ArrayStack {

    private String[] items;  //数组
    private int count;      //栈中的元素个数
    private int n ;        //栈的大小


    //构造函数：申请一个大小为n的数组
    public ArrayStack(int n){
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    /**
     * 功能：入栈
     *
     */
    public boolean push(String item){
        //数组空间不够
        if(count == n)
        return false;

        //将下标放到count的位置
        items[count] = item;
        //栈中元素+1
        ++count;
        return true;
    }

    /**
     * 功能：出栈
     *
     */
    public String pop(){
        //栈为空，则直接返回null
        if(count == 0)
            return null;
        //返回下标为count - 1的数组元素
        String tmp = items[count - 1];
        --count;
        return tmp;
    }






}