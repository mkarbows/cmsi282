import java.util.HashMap;

class CombinationComputerWithMemoization {

	public static HashMap memoization = new HashMap<String, Integer>();

	public static void main(String[] args) {
    	choose(20, 11);
    	System.out.println(memoization.size());
	}

	public static int choose(int n, int k) {
    	memoization.put(n + "," + k, 1);

    	if (k == 0) {
        	return 1;
    	} else if (k == n) {
        	return 1;
    	} else {
        	return choose(n - 1, k -1) + choose(n - 1, k);
    	}
	}
}
