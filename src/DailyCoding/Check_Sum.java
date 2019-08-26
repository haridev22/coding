package DailyCoding;

import Util.Input;

import java.util.HashSet;
import java.util.List;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 */
public class Check_Sum {
    public static void main(String[] args) {
        int size = Input.getInteger();
        List<Integer> arr= Input.getIntArray(size);
        int sum = Input.getInteger();
        System.out.println(ifSumExist(arr,sum));
    }

    private static boolean ifSumExist(List<Integer> arr,int sum){
        HashSet<Integer> set = new HashSet<>();
        for (int v:arr){
            if(set.contains(sum-v)){
                return true;
            }else{
                set.add(v);
            }
        }
        return false;
    }

}

