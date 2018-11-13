package DataStructure.array.ArrayBasic;

import java.util.Arrays;

/**
 * Created by panzhiwei on 2018/11/8.
 *
 */
public class GenericArray<T> {
    //数据类型不确定
    private T[] data;
    //实际大小
    private int size;

    //构造数组，指定容量
    public GenericArray(int capactiy){
        data = (T[]) new Object[capactiy];
        size = 0;
    }

    //无参构造，默认数组容量10
    public GenericArray(){
        this(10);
    }

    //获取数组容量
    public int getCapactiy(){
        return data.length;
    }

    //获取元素个数
    public int count(){
        return size;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //修改index位置的元素
    public void set(int index, T e){
        checkIndex(index);
        data[index] = e;
    }

    //获取对应的元素
    public T get(int index){
        checkIndex(index);
        return data[index];
    }

    //查看数组是否包含元素
    public boolean contains(T e){
        for(int i= 0;i < size;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    //获取元素下标
    public int find(T e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    //在index位置，插入元素e,时间复杂度为O(m+n)
    public void add(int index,T e){

        //判断插入位置是否合法
        checkIndex(index);

        //如果当前元素个数等于数组容量，则需要扩容为原来的2倍
        if(size == data.length){
            resize(data.length << 1);
        }

        //将index后面的元素向后移一位
        for(int i = size - 1; i > index; --i){
            data[i + 1] = data[i];

        }

        data[index] = e;
        size++;
    }

    //向数组头部插入元素
    public void addFirst(T e){
        add(0,e);
    }

    //向数组尾部插入元素
    public void addLast(T e){
        add(size,e);
    }

    //删除index的元素并返回
    public T remove(int index){
        checkIndexForRemove(index);

        T result = data[index];
        for(int i = index + 1; i < size;i ++){
            data[i - 1] = data[i];
        }

        size--;
        data[size] = null;

        //缩容
        if(size == data.length >> 2 && data.length >> 1 != 0){
            resize(data.length >> 2);
        }

        return result;
    }

    //删除第一个元素
    public T removFirst(){
        return remove(0);
    }

    //删除最后一个元素
    public T removeLast(){
        return remove(size - 1);
    }

    //从数组中指定元素删除
    public void removeElement(T e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    //输出数组所有元素
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }

    //动态扩缩容,时间复杂度为O(n)
    private void resize(int capactiy) {

        T[] newData = (T[])new Object[capactiy];

        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }

        data = newData;
    }

    private void checkIndex(int index) {
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size！");
        }

    }

    private void checkIndexForRemove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("remove failed! Require index >=0 and index < size！");
        }

    }

    public static void main(String[] args) {
        GenericArray ga = new GenericArray();
        ga.add(0,1000);
        ga.add(1,2000);
        ga.add(2,3000);
        ga.add(3,4000);
        ga.add(4,5000);
        ga.add(5,6000);
        ga.add(6,7000);
        ga.add(7,8000);
        ga.add(8,9000);
        ga.add(9,10000);
        ga.add(10,11000);
        ga.add(11,12000);
        ga.add(12,13000);
        ga.add(13,14000);
        ga.add(14,15000);
        System.out.println(ga.toString());
    }

}