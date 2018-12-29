package Algorithm.sort;

/**
 * Created by panzhiwei on 2018/12/27.
 */
public class MergeSort {

    //归并排序核心思想：
    //将数组分为前后两部分，然后对前后分别进行排序，再将排好序的两部分合并起来，整个数组就有序了
    //分而治之，将大问题分为小问题，先将小的问题解决了，大的问题就解决了
    //实现方式：递归
    /**
     *   递推公式：
     *   merge_sort(p…r) = merge(merge_sort(p…q), merge_sort(q+1…r))
     *
     *   终止条件：
     *   p >= r 不用再继续分解
     */

    //a是数组，n是数组大小
    public static void mergeSort(int[] a,int n){

        mergeSortInternally(a, 0, n-1);

    }

    //递归调用函数
    private static void mergeSortInternally(int[] a, int p, int r) {
        //递归终止条件：p >= r
        if(p >= r) return;

        //分治递归(左边和右边)
        int q = p +(r - p)/2;
        //左边
        mergeSortInternally(a,p,q);
        //右边
        mergeSortInternally(a,p+1,r);
        //合并a[p...q]和a[q+1...r]
        merge(a,p,q,r);

    }

    //合并a[p...q]和a[q+1...r]
    private static void merge(int[] a,int p,int q,int r) {
        //左边数组
        int i = p;
        //右边数组
        int j = q + 1;
        int k = 0;
        //申请一个跟a[p...r]一样的临时数组
        int[] tmp = new int[r - p + 1];
        while(i <= q && j <= r){
            //比较左右数组元素的大小
            if(a[i] <= a[j]){
                tmp[k++] = a[i++];
            }else{
                tmp[k++] = a[j++];
            }
        }

        //判断哪个子数组中有剩余的数据
        int start = i;
        int end  = q;
        if(j <= r){
            start = j;
            end = r;
        }

        //将剩余的数据拷贝到临时数组tmp
        while(start < end){
            tmp[k++] = a[start++];
        }

        //将tmp数组中的元素拷贝到a[p...r]
        for(i = 0;i < r-p; i++){
            a[p + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int a[] = {5,45,12,2,4,8,1};
        mergeSort(a,7);
    }

}