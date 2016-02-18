import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class ThreePartitionSolver {
    public static boolean threePartition(List<Integer> numbers) {
     
        if (numbers.size() == 0) {
            return false;
        }
        if (!isValidSize(numbers)) {
            return false;
        }
        if (!isValidAveSum(numbers)) {
            return false;
        }
        int sum = sumOfGroups(numbers);
        //java.util.Collections.sort(numbers);
        return findGroup(numbers, sum);
    }

    private static boolean isValidSize(List<Integer> numbers) {
        return numbers.size() % 3 == 0;
    }

    //like the sum() method (from python)
    private static int sumOfNumbers(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int numberOfGroups(List<Integer> numbers) {
        return numbers.size() / 3;
    }
    private static boolean isValidAveSum(List<Integer> numbers) {
        return sumOfNumbers(numbers) % numberOfGroups(numbers) == 0;
    }

    private static int sumOfGroups(List<Integer> numbers) {
        return sumOfNumbers(numbers) / numberOfGroups(numbers);
    }
    private static boolean findGroup(List<Integer> numbers, int sum) {
        if(numbers.size() == 3){
            return true;
        }
        for (int i = 1; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if((numbers.get(i) + numbers.get(j) + numbers.get(0)) == sum) {
                    int num1 = numbers.remove(0);
                    int num2 = numbers.remove(i - 1);
                    int num3 = numbers.remove(j - 2);
                    if (findGroup(numbers, sum)) {
                        return true;
                    }else {
                        numbers.add(0, num1);
                        numbers.add(i, num2);
                        numbers.add(j, num3);
                    }
                }
            }
        }
        return false;
    }

    public static void main (String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        //list.addAll(Arrays.asList(9,9,0,6,2,10,12,5,1,11,6,1));
        // list.add(9);
        // list.add(9);
        // list.add(0);
        // list.add(6);
        // list.add(2);
        // list.add(10);
        // list.add(12);
        // list.add(5);
        // list.add(1);
        // list.add(11);
        // list.add(6);
        // list.add(1);

        list.add(2);
        list.add(4);
        list.add(8);
        list.add(12);
        list.add(15);
        list.add(2);
        list.add(0);
        list.add(6);
        list.add(3);
        list.add(2);
        list.add(9);
        list.add(1);

        // list.add(9);
        // list.add(9);
        // list.add(0);
        // list.add(6);
        // list.add(2);
        // list.add(10);
        // list.add(12);
        // list.add(5);
        // list.add(1);
        // list.add(11);
        // list.add(6);
        // list.add(1);

        System.out.println(ThreePartitionSolver.threePartition(list));
    }
}
