package LeetCode;

/**
 * Created by panzhiwei on 2019/2/25.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

    满足要求的三元组集合为：
    [
        [-1, 0, 1],
        [-1, -1, 2]
    ]
 */
public class ThreeNumbers {

//    解题思路：
//            （1）首先对数组进行排序（从小到大）
//            （2）依次取出第 i 个数（i从0开始），并且不重复的选取（跳过重复的数）
//            （3）这样问题就转换为 2 个数求和的问题（可以用双指针解决方法）2 数求和问题
//            （4）定义两个指针：左指针（left） 和 右指针（right）
//            （5）找出固定 left， 此时left所指的位置为数组中最小数，再找到两个数和 不大于 target 的最大 right 的位置
//            （6）调整 left 的位置（后移），求解和是否为 target O(n)
//            （7）时间复杂度：O(nlogn) + O(n)

    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (len < 2) {
            return result;
        }

        Arrays.sort(nums);

        int i = 0;
        while (i < len - 2) {
            // 如果当前值为正数，而且数组是有序的，循环结束
            if (nums[i] > 0) {
                break;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    // 跳过重复元素 下同
                    while (left < right && nums[right] == nums[--right]) ;
                } else if (sum < 0) {
                    while (left < right && nums[left] == nums[++left]) ;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[right] == nums[--right]) ;
                    while (left < right && nums[left] == nums[++left]) ;
                }
            }
            while (i < len - 1 && nums[i] == nums[++i]) ;
        }
        return result;
    }


    public static void main(String[] args) {

        int nums[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);

        System.out.println(result);

    }
}