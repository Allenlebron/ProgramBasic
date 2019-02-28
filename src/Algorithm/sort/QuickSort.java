package Algorithm.sort;

/**
 * Created by panzhiwei on 2018/12/27.
 */

//如果要排序数组中下标从p到r之间的一组数据，我们选择p到r之间的任意一个数据作为pivot（分区点）。然后遍历p到r之间的数据，
//将小于pivot的放到左边，将大于pivot的放到右边，将povit放到中间。经过这一步之后，数组p到r之间的数据就分成了3部分，前面p到q-1之间都是小于povit的，
//中间是povit，后面的q+1到r之间是大于povit的。根据分治、递归的处理思想，我们可以用递归排序下标从p到q-1之间的数据和下标从q+1到r之间的数据，
//直到区间缩小为1，就说明所有的数据都有序了。

public class QuickSort {

    // 快速排序，a是数组，n表示数组的大小
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n-1);
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;

        int q = partition(a, p, r); // 获取分区点
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i=" + i);
        return i;
    }


    public static void main(String[] args) {
        int a[] ={8,6,5,1,2,7,4,9,3,10};
        quickSort(a,a.length);
    }

}