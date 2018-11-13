package DataStructure.Array.BinarySearch;

/**
 * Created by panzhiwei on 2018/10/15.
 */

import java.util.Arrays;

/**
 在一个二维数组中（每个一维数组的长度相同）
 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class BinarySearchDemo {

    //通过二分查找法判断是否存在
    public static boolean FindTarget(int target , int arr[][]){

        //循环行记录
        for(int i=0; i<arr[i].length;i++){

            int start = 0;
            int end   = arr[i].length - 1;
            int mid   = (start + end) / 2;
            while(start <= end){
                if(target == arr[i][mid]){
                    int returnArr[] = {i,mid};
                    System.out.println(Arrays.toString(returnArr));
                    return true;
                }else if(target > mid){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int target  = 25;
        int arr[][] = {{1,2,25},{52,85,45}};

        Arrays.sort(new int[]{2,5,4,6,3});
        Long startTime = System.currentTimeMillis();
        Boolean flag = FindTarget(target,arr);
        long endTime = System.currentTimeMillis();
        System.out.println(flag);
        System.out.println("花费时间："+ (endTime - startTime )+"毫秒");
    }

}

