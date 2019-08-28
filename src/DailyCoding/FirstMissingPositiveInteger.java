package DailyCoding;

public class FirstMissingPositiveInteger {
    static int[] segregate(int[] array) {
        if (array == null)
            return null;
        if (array.length == 0)
            return array;
        int[] arrayCopy = array.clone();
        int left = 0, right = arrayCopy.length - 1;
        while (left < right) {
            while (left<arrayCopy.length && arrayCopy[left] < 1)
                left++;
            while (right>=0&&arrayCopy[right] >= 1)
                right--;
            if(left<right) {
                int temp = arrayCopy[left];
                arrayCopy[left] = arrayCopy[right];
                arrayCopy[right] = temp;
            }
        }
        return arrayCopy;
    }

    static int findMissingPositive(int[] array){
        if (array == null)
            return 1;
        if (array.length == 0)
            return 1;
        int[] segregatedArray= segregate(array);
        int offset=0;
        boolean allNegative=true;
        for(int index=0;index<segregatedArray.length;index++){
            if (segregatedArray[index]>0){
                offset=index;
                allNegative=false;
                break;
            }
        }
        if(allNegative)
            return 1;
        offset--;
        int length=segregatedArray.length;
        for(int index=offset+1;index<length;index++){
            if(segregatedArray[index]+offset<length){
                if(segregatedArray[offset+segregatedArray[index]]>0)
                    segregatedArray[offset+segregatedArray[index]]*=-1;
            }
        }

        for (int index=offset+1;index<length;index++){
            if(segregatedArray[index]>0){
                return index-offset;
            }
        }
        return length-offset;
    }

    public static void main(String[] args) {
        System.out.println(findMissingPositive(new int[]{0,1,2}));
        System.out.println(findMissingPositive(new int[]{0,1,-2}));
        System.out.println(findMissingPositive(new int[]{0,-1,-2}));
        System.out.println(findMissingPositive(new int[]{0,1,1}));
        System.out.println(findMissingPositive(new int[]{0,-1,-1}));
        System.out.println(findMissingPositive(new int[]{0,0,0}));
    }
}
