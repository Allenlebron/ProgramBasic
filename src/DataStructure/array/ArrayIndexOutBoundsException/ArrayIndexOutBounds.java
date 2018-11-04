package src.DataStructure.array.ArrayIndexOutBoundsException;

/**
 * Created by Administrator on 2018/11/2 0002.
 */
public class ArrayIndexOutBounds {

    public static void main(String[] args) {
        outBounds();
    }

    private static int outBounds() {
        int arr[] = new int[3];
        int i = 0;
        try {
            for(;i<=3;i++){
                arr[i] = 0;
                System.out.println("Hello World!");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.print("数组发生越界！");
        }

        return 0;
    }

}
