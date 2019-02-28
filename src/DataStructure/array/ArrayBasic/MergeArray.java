package DataStructure.array.ArrayBasic;

/**
 * Created by panzhiwei on 2019/2/23.
 *
 * 合并两个有序数组
 */

public class MergeArray {

    //合并两个有序数组
    public static int[] MergeTwoArray(int array1[],int array2[]){

        //两个有序数组的总长度
        int length = array1.length + array2.length;
        //初始化
        int result[] = new int[length];

        //定义三个变量
        int i = 0,j = 0,k = 0;

        //设定边界条件
        while(i < array1.length || j < array2.length){
            //如果数组2有剩余元素直接添加到结果数组中
            if(i == array1.length && j < array2.length){
                result[k++] = array2[j++];
            //如果数组1有剩余元素直接添加到结果数组中
            }else if(j == array2.length && i < array1.length ){
                result[k++] = array1[i++];
            //比较数组1和数组2相同下标元素的大小，小的直接添加到结果数组中
            }else {
                if(array1[i] <= array2[j]){
                    result[k++] = array1[i++];

                }else if(array1[i] > array2[j]){
                    result[k++] = array2[j++];
                }
            }
        }
        //返回结果数组
        return result;
    }

    public static void main(String[] args) {

        int a[] = {1,2,3,4,10};
        int b[] = {2,6,7,9};

        int[] result = MergeTwoArray(a,b);

        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", result.length, result.length));
        builder.append('[');
        for (int i = 0; i < result.length; i++) {
            builder.append(result[i]);
            if (i != result.length - 1){
                builder.append(", ");
            }
        }
        builder.append(']');

        System.out.println(builder.toString());
    }


}