package Algorithm.sort;

/**
 * Created by panzhiwei on 2018/12/19.
 */
public class SelectionSort {

    // 选择排序
    // 选择排序将数组分成已排序区间和未排序区间。
    // 初始已排序区间为空。每次从未排序区间中选出最小的元素插入已排序区间的末尾，直到未排序区间为空。

    public static void selectionSort(int a[]){

        if (a.length <= 1) return;

        for (int i = 0; i < a.length - 1; ++i) {
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < a.length; ++j) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换
            swap(a,i,minIndex);
        }

        for(int arr:a){
            System.out.println(arr);
        }
    }

    private static void swap(int[] a, int i,int minIndex) {
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
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
            selectionSort(a);
        }
        long result = System.currentTimeMillis() - time;
        System.out.println("耗时：" + result +"ms");
    }

}