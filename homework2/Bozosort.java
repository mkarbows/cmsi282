import java.util.Random;
import java.util.Arrays;

public class Bozosort{

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i +1]) {
                return false;
            }
        }
        return true; 
    }

    public static int[] bozosort(int[] inputArr) {
        int randInt1;
        int randInt2;
        int tempVar = 0;

        while (!isSorted(inputArr)) {
            randInt1 = (int) (Math.random() * inputArr.length);
            randInt2 = (int) (Math.random() * inputArr.length);                
                tempVar = inputArr[randInt2];
                inputArr[randInt2] = inputArr[randInt1];
                inputArr[randInt1] = tempVar; 
        }
        return inputArr;
    }

    public static void main(String[] args) {
        final long beginTime = System.nanoTime();
        int[] result = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            try {
                result[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException nfe) {};
        }

        System.out.println(Arrays.toString(bozosort(result)));
        final long endTime = System.nanoTime();
        System.out.println("Total Time: " + (endTime - beginTime) / Math.pow(10, -9) + " seconds");

    }
}
