package Algorithm.Recursion;

/**
 * Created by panzhiwei on 2019/3/5.
 * 编程实现斐波那契数列求值 f(n)=f(n-1)+f(n-2...

 */
public class SimpleRecursion {

    //斐波那契数列
    public static long Flib(long num){

        if(num == 0 || num == 1) {
            return num;
        }

        return Flib(num - 1) + Flib(num - 2);
    }

    public static long FlibOther(long num){

        if(num < 2){
            return num;
        }

        long first = 0L;
        long result = 1L;

        while(num > 1){
            long temp = result;
            result += first;
            first = temp;
            num--;
        }

        return result;
    }

    public static void main(String[] args) {

        long start1 = System.currentTimeMillis();
        long result1 = Flib(50);
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        long result2 = FlibOther(50);
        long end2 = System.currentTimeMillis();

        System.out.println("Result1:"+ result1 +" 耗时："+(end1 - start1) +"ms");
        System.out.println("Result2:"+ result2 +" 耗时："+(end2 - start2) +"ms");
    }
}