package Algorithm.Recursion;

/**
 * Created by panzhiwei on 2019/3/5.
 * 编程实现求阶乘 n!

 */
class Factorial {
    public static long factorial(long num){
        if(num < 0){
            return 0;
        }
        if(num == 0 || num == 1){
            return 1;
        }

        return num * factorial(num - 1);
    }

    public static void main(String[] args) {
        System.out.println("Result:" +factorial(1));
    }
}