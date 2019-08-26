package Util;

import java.util.*;
import java.util.stream.Collectors;

public class Input {
    static Scanner scanner = new Scanner(System.in);

    /**
     * Returns user input string
     * @return String
     */
    public static String getString(){
            return scanner.nextLine();
    }

    /**
     * Returns user input integer
     * @return int
     */
    public static int getInteger(){
        return scanner.nextInt();
    }

    /**
     * Returns a list of integers
     * @param size
     * @return
     */
    public static List<Integer> getIntArray(int size){
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<size;i++){
            arr.add(scanner.nextInt());
        }
        return arr;
    }
}
