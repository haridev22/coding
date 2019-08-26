package DailyCoding;

import Util.Input;

import java.util.stream.IntStream;

public class ProductArray {
    public static void main(String[] args) {
        int size = Input.getInteger();
        int[] arr = Input.getIntArray(size).stream().mapToInt(i -> i).toArray();
        long[] fromLeft = new long[size];
        long[] fromRight = new long[size];
        long productTillNow=1;

        fromLeft[0]=1;
        for (int i=1;i<size;i++){
            productTillNow*=arr[i-1];
            fromLeft[i]=productTillNow;
        }
        productTillNow=1;
        fromRight[size-1]=1;
        for (int i=size-2;i>=0;i--){
            productTillNow*=arr[i+1];
            fromRight[i]=productTillNow;
        }
        for(int i=0;i<size-1;i++){
            System.out.print(fromLeft[i]*fromRight[i]+", ");
        }
        System.out.print(fromLeft[size-1]*fromRight[size-1]);
    }
}
