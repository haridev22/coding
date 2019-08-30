package DailyCoding;

public class DecodableCount {
    private static int getDecodableCount(String encodedString){
        if (encodedString.length()==0){
            return 1;
        }
        int retuenCount=0;
        if(isEncodable(encodedString)) {
            retuenCount = getDecodableCount(encodedString.substring(1));
            if (encodedString.length()>1) {
                if (isEncodable(encodedString)) {
                    retuenCount += getDecodableCount(encodedString.substring(2));
                }
            }
        }
        return retuenCount;
    }

    private static boolean isEncodable(String encodedString){
        int firstDigit=Integer.parseInt(encodedString.substring(0,1));
        if(firstDigit==0)
            return false;
        if(encodedString.length()>1) {
            int firstTowDigits = Integer.parseInt(encodedString.substring(0, 2));
            if (firstTowDigits > 26)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(getDecodableCount("111"));
        System.out.println(getDecodableCount("191"));
        System.out.println(getDecodableCount("101"));

    }
}
