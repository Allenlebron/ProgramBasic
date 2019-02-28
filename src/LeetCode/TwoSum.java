package LeetCode;

/**
 * Created by panzhiwei on 2018/10/15.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
  Given an array of integers, return indices of the two numbers such that they add up to a specific target.
  You may assume that each input would have exactly one solution, and you may not use the same element twice.

     Example:

     Given nums = [2, 7, 11, 15], target = 9,
     Because nums[0] + nums[1] = 2 + 7 = 9,
     return [0, 1]
 *
 */
public class TwoSum {

    //第一种：暴力搜索法
    /**
     Complexity Analysis:

     时间复杂度：
     Time complexity : O(n)O(n). We traverse the list containing nn elements exactly twice.
     Since the hash table reduces the look up time to O(1)O(1), the time complexity is O(n)O(n).

     空间复杂度：
     Space complexity : O(n)O(n). The extra space required depends on the number of items stored
     in the hash table, which stores exactly nn elements.
     */
    public static int[] twoSum(int[] nums, int target){
        //返回一个长度为2的数组
        int twoNumbers [] = new int[2];

        //两个循环遍历
        for (int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length;j++){
                if(nums[i] + nums[j] == target){
                    twoNumbers[0] = i;
                    twoNumbers[1] = j;
                    break;
                }
            }
        }
        return twoNumbers;
    }

    //第二种：使用HashMap处理
    /**
     Complexity Analysis:

     时间复杂度：
     Time complexity : O(n)O(n). We traverse the list containing nn elements only once.
     Each look up in the table costs only O(1)O(1) time.

     空间复杂度：
     Space complexity : O(n)O(n). The extra space required depends on the number of
     items stored in the hash table, which stores at most nn elements
     */
    public static int[] twoSumByMap(int[] nums, int target){

        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0;i < nums.length;i++){
            map.put(nums[i],i);
        }

        for (int i = 0;i < nums.length;i++){
            int nextNum = target - nums[i];
            if(map.containsKey(nextNum)){
                return new int[] {i,map.get(nextNum)};
            }
        }
        return null;
    }

    //测试
    public static void main(String[] args) {

        int nums[] = {11, 7, 2, 15};
        int target = 9;

        int result[] = twoSum(nums,target);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(twoSumByMap(nums,target)));
    }

}