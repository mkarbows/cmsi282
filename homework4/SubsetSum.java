public class SubsetSum {
	public static boolean isSumSubset(int subset[], int sum) {
    	    boolean set[][] =  new boolean [sum + 1][subset.length + 1];
    	    for (int i = 0; i <= subset.length; i++) {
        	        set[0][i] = true;
    	    }
    	    for (int i =  1; i <= sum; i++) {
        	        set[i][0] = false;
    	    }
    	    for (int i = 1; i <= sum; i++) {
        	        for (int j = 1; j <= subset.length; j++) {
                       set[i][j] = set[i][j-1];
            	if (i >= subset[j - 1]) {
                	set[i][j] = set[i][j] || set[i - subset[j - 1]][j - 1];
                       }
        	        }
    	    }
    	    return set[sum][subset.length];
	}
	public static void main (String[] args) {
    	    int subset[] = {3, 34, 4, 12, 5, 2};
    	    int sum = 9;
    	    if (isSumSubset(subset, sum) == true) {
        	        System.out.println("We found a subset that adds up to our given sum!");
    	    } else {
        	        System.out.println("There is no subset that adds up to our given sum");
    	    }
	}
}
