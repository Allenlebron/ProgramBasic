package DataStructure.Array.MorethanHalfNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by panzhiwei on 2018/10/27.
 */
public class MorethanHalfNumber {

    //1.利用map存值，找出存值最多并且大于长度一半的元素
    public static int MoreHalfNumber_Solution(int [] array){

            if(array.length == 0 || array == null){
                    return 0;
            }

            Map<Integer,Integer> map = new HashMap<Integer,Integer>();

            for(int i = 0; i < array.length; i++){
                if(!map.containsKey(array[i])){
                    map.put(array[i],1);
                }else{
                    map.put(array[i],map.get(array[i]) + 1);
                }

            }
            //遍历map找出value大于长度一半的元素
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                if(entry.getValue() > (array.length / 2)){
                    return entry.getKey();
                }
            }

            return 0;
    }

    //2.将数组进行排序，若该元素超过数组长度一半，则为中位数
    public static int MoreHalf_Solution(int [] array){
        //数组排序
        Arrays.sort(array);
        int count = 0;
        for(int i=0; i< array.length; i++){
            if(array[i] == array[array.length / 2]){
                count ++;
            }
        }
        if(count > array.length / 2){
            return array[array.length / 2];
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        int array[] ={2,4,5,5,5,5,6};

        int n = MorethanHalfNumber.MoreHalfNumber_Solution(array);
        int m = MorethanHalfNumber.MoreHalf_Solution(array);

        System.out.println("返回的结果n是："+ n);
        System.out.println("返回的结果m是："+ m);
    }




}