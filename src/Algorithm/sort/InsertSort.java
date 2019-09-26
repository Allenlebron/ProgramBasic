package Algorithm.sort;

import java.util.Random;

/**
 * Created by panzhiwei on 2018/12/19.
 */
public class InsertSort {

    //插入排序
    //插入排序将数组数据分成已排序区间和未排序区间。
    //初始已排序区间只有一个元素，即数组第一个元素。
    //在未排序区间取出一个元素插入到已排序区间的合适位置，直到未排序区间为空。

    public static void insertSort(int a[]){
        if(a.length <= 1) return;

        for(int i=0;i<a.length;i++){
            int j = i -1;
            int value = a[i];

            //如果插入的数据比被插入的数据小
            while(j >= 0 && value < a[j]) {

                //将a[j]后移
                a[j + 1] = a[j];

                //让j向前移
                j--;
            }

            //把插入的数据放到合适的位置
            a[j+1] = value;
        }
        //输出
        for(int arr:a){
            System.out.println(arr);
        }
    }

    public static void main(String[] args) {

        long time = System.currentTimeMillis();
        for(int j=0;j<1000;j++) {
            int a[] = new int[1000];
            for (int i = 0; i < 1000; i++) {
                a[i] = (int) (Math.random() * 1000) + 1;
            }
            for (int arr : a) {
                System.out.println(arr);
            }
            insertSort(a);
        }
        long result = System.currentTimeMillis() - time;
        System.out.println("耗时：" + result +"ms");
    }
}