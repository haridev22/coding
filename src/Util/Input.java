package Util;

import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);

    /**
     * Returns user input string
     * @return String
     */
    static String getString(){
            return scanner.nextLine();
    }

    /**
     * Returns user input integer
     * @return int
     */
    static int getInteger(){
        return scanner.nextInt();
    }
}
