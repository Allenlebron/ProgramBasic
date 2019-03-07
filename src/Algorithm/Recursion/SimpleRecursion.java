package Algorithm.Recursion;

/**
 * Created by panzhiwei on 2019/3/5.
 * 编程实现斐波那契数列求值 f(n)=f(n-1)+f(n-2...

 */
public class SimpleRecursion {

    //斐波那契数列
    public static long Flib(long num){
        if(num == 0 || num == 1)
            return num;

        return Flib(num - 1) + Flib(num - 2);
    }

    public static void main(String[] args) {
        System.out.println("Result:"+ Flib(10));
    }
}