package BookNotes;

/**
 * Created by zwilpan on 2019/3/3 .
 *
 * 素数产生程序：一个简单的重构示例
 */
public class GeneratePrimes {

    //返回结果数组
    private static int[] result;
    //布尔值数组
    private static boolean[] crossedOut;

    public static int[] generatePrimes(int maxValue){
        if(maxValue < 2)
            return new int[0];
        //保留所有的相关整数(初始化)
        uncrossIntegersUpto(maxValue);
        crossOutMultiples();
        putUncrossedIntegersIntoResult();
        return result;
    }

    private static void putUncrossedIntegersIntoResult() {
        int count = numberOfUncrossedIntegers();
        result = new int[count];
        for(int j=0,i=2;i < crossedOut.length; i++){
            if(notCrossed(i))
            result[j++] = i;
        }
    }

    private static int numberOfUncrossedIntegers() {
        int count = 0;
        for(int i = 2; i < crossedOut.length; i++){
            if(notCrossed(i)){
                count ++;
            }
        }
        return count;
    }

    private static void crossOutMultiples() {
        int limit = determineIterationLimit();
        for(int i = 2; i < limit + 1; i++){
            if(notCrossed(i)){
                crossOutMultiplesOf(i);
            }
        }
    }

    private static void crossOutMultiplesOf(int i) {
        for(int multiple = 2*i;multiple < crossedOut.length; multiple +=i){
            crossedOut[multiple] = true;
        }
    }

    private static boolean notCrossed(int i) {
        return crossedOut[i] == false;
    }

    private static int determineIterationLimit() {
        double iterationLimit = Math.sqrt(crossedOut.length);
        return (int)iterationLimit;
    }

    private static void uncrossIntegersUpto(int maxValue) {
        crossedOut = new boolean[maxValue + 1];
        for (int i = 2; i < crossedOut.length; i++){
            crossedOut[i] = false;
        }
    }

    public static void main(String[] args) {
        int result[] = generatePrimes(100);

        for(int i = 0; i < result.length;i++){
            System.out.println("result=" + result[i]);
        }
    }
}
