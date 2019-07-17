package Algorithm.Recursion;

/**
 * Created by panzhiwei on 2019/3/5.
 */

import java.util.ArrayList;
import java.util.List;

/****
 * 样例输入：
    [1,2,3]

    样例输出：
    [
    [1,2,3],
    [1,3,2],
    [2,1,3],
    [2,3,1],
    [3,1,2],
    [3,2,1]
    ]

 */
public class Permutation {

    // 最终返回的结果集
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len==0||nums==null)  return res;

        // 采用前后元素交换的办法，dfs解题
        exchange(nums, 0, len);
        return res;
    }

    public void exchange(int[] nums, int i, int len) {
        // 将当前数组加到结果集中
        if(i==len-1) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j=0; j<len; j++){
                list.add(nums[j]);
            }
            res.add(list);
            return ;
        }
        // 将当前位置的数跟后面的数交换，并搜索解
        for (int j=i; j<len; j++) {
            swap(nums, i, j);
            exchange(nums, i+1, len);
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        Permutation per = new Permutation();
        int arr[] = {1,2,3};
        List<List<Integer>> lists = per.permute(arr);
        for(List<Integer> list : lists){
            System.out.println(list);
        }
    }

}