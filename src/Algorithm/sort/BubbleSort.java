package Algorithm.sort;

/**
 * Created by panzhiwei on 2018/12/19.
 */
public class BubbleSort {


    //冒泡排序，a是数组
    public static void bubbleSort(int a[]){
        int count = 0;
        //执行趟数
        for(int i = 0; i < a.length - 1; i++){
            //退出标志
            boolean flag = false;
            //比较次数
            for(int j = 0; j < a.length - i - 1; j++){
                if(a[j] > a[j+1]){
                    swap(a,j);
                    flag = true;
                    count++;
                }
            }
            if(!flag) break;
        }
        for(int arr:a){
            System.out.println(arr);
        }
        System.out.println("交换次数：" + count);
    }

    //向下冒泡排序
    public static void bubbleSortFromLow(int a[]){
        int count =0 ;
        for(int i = 0; i< a.length; i++){
            for(int j = i +1;j<a.length;j++){
                if(a[i] > a[j]){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                    count++;
                }
            }
        }
        for(int arr:a){
            System.out.println(arr);
        }
        System.out.println("交换次数：" + count);
    }

    //交换
    public static void swap(int a[],int j){
        int tmp = a[j];
        a[j] = a[j+1];
        a[j+1] = tmp;
    }



    public static void main(String[] args) {
        long time = System.currentTimeMillis();
//        for(int j=0;j<1000;j++) {
//            int a[] = new int[1000];
//            for (int i = 0; i < 1000; i++) {
//                a[i] = (int) (Math.random() * 1000) + 1;
//            }
//            for (int arr : a) {
//                System.out.println(arr);
//            }
//            bubbleSortFromLow(a);
//        }
        int a[] = {8,4,5,3,2,100,7,9,10,78,1,6,47,12};
        //bubbleSortFromLow(a);
        bubbleSort(a);
        long result = System.currentTimeMillis() - time;
        System.out.println("耗时：" + result);
    }
}