package LeetCode;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by panzhiwei on 2019/2/26.
 *
 * 求众数
 *  输入: [3,2,3]
    输出: 3
 *
 */
public class MostOfArray {

    //1.遍历数组,从一个开始count = 1,遇到相同的就加1，不同的减1,等于0则下一个
    public static int mostOfArray(int arr[]){

        int count = 1;
        int result = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(result == arr[i]){
                count ++;
            }else{
                count --;
                if(count == 0){
                    result = arr[i + 1];
                }
            }
        }
        return result;
    }

    //2.排序取中间的便是众数
    public static int mostOfArr(int arr[]){

        Arrays.sort(arr);
        return arr[arr.length >> 1];
    }

    public static void main(String[] args) {

        int arr[] = {3,2,3};
        long time = System.currentTimeMillis();
        int result = mostOfArr(arr);
        System.out.println("返回结果：" + result);
        long used = System.currentTimeMillis() - time;
        System.out.println("耗时：" + used);
    }
}