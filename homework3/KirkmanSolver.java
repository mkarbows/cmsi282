public class KirkmanSolver {
  public static int[][] adjacencyTable;
	public static int totalGirls = 15;
	public static int rows = 5;
	public static int girlsPerRow = 3;
	public static int days = 7;
	public static int[][][] girlsWalking;
	public static boolean[][] unavailable;
	//public static int maxIndex = 9
	
	//if a girl is aleady next to another girl in the adjecncy table then their state is 1
	public static void fillTable (int[][][] girls, int currentRow, int currentDay, int lastIndex, boolean state) {
        int adjacentGirl;
        int currentGirl = girls[currentRow][currentDay][lastIndex];
        for (int i = lastIndex - 1; i >= 0; i--) {
            adjacentGirl = girls[currentRow][currentDay][i];
            adjacencyTable[currentGirl][adjacentGirl] = adjacencyTable[adjacentGirl][currentGirl] = (state) ? 1 : 0;
            if (adjacencyTable[adjacentGirl][currentGirl] == 1) {
        		state = true;
        	} else if (adjacencyTable[adjacentGirl][currentGirl] == 0) {
        		state = false;
        	}
        }
    }

    public static void printGirlsWalking (int[][][] table, int rows, int days, int girlsPerRow) {
    	for (int row = 0; row < rows; row++) {
    		for (int day = 0; day < days; day++) {
    			for (int girl = 0; girl < girlsPerRow; girl++) {
    				System.out.printf("%-4d", table[row][day][girl]);
    			}
    			System.out.print(" | ");
    		}
    		System.out.println("");
    	}
    }

    public static int placeGirl (int index, int rows, int girlsPerRow, int totalGirls, int[][][] girls) {
    	int student;
    	int currentEntry = index % girlsPerRow;
    	int currentDay = index / totalGirls;
    	int currentRow = (index % totalGirls)/girlsPerRow;
    	int currentGirl = girls[currentRow][currentDay][currentEntry];
    	boolean haveStudent = false;

    	if (currentGirl != 0) {
    		fillTable(girls, currentRow, currentDay, currentEntry, false);
    		student = currentGirl + 1;
    	} else {
    		if (currentEntry == 0) {
    			student = girls[currentRow - 1][currentDay][currentEntry] + 1;
    		} else {
    			student = girls[currentRow][currentDay][currentEntry - 1] + 1;
    		}
    	}

    	if ((currentEntry == 0 && student > currentRow * girlsPerRow) || (student + (girlsPerRow - currentEntry) >= totalGirls)) {
    		return -1;
    	}

    // 	while (!haveStudent) {
    // 		haveStudent = false;
    // 		// for (int i = student; i < totalGirls; i++) {
    // 		// 	if ()
    // 		// }
    // 		if (haveStudent)  {
    // 			if ()
    // 		}
    // 	}
    // 	return student;
    // }

    public static void main (String[] args) {

    	int index = totalGirls;
    	int currentCol = index % girlsPerRow;
    	int currentRow = (index % totalGirls)/girlsPerRow;
    	int currentDay = index/totalGirls;
    	int currentEntry = index % totalGirls;

    	adjacencyTable = new int[totalGirls][totalGirls];	
    	girlsWalking = new int[rows][days][girlsPerRow];
    	int checkEntry;

    	for (int i = 0; i < totalGirls; i++) {
    		girlsWalking[(i % totalGirls)/girlsPerRow][i / totalGirls][i % girlsPerRow] = i;
    	}

    	int maxIndex = girlsPerRow * girlsPerRow;

    	while (girlsWalking[rows - 1][days - 1][girlsPerRow - 1] == 0) {
    		if (index % girlsPerRow == 0 && ((index % totalGirls) <= girlsPerRow * (girlsPerRow - 1))) {
    			index ++;
    		}
    		checkEntry = placeGirl(index, rows, girlsPerRow, totalGirls, girlsWalking);

    		if (checkEntry == -1) {
    			if(girlsWalking[currentRow][currentDay][currentCol] != 0) {
    				fillTable(girlsWalking, currentRow, currentDay, currentCol, false);
    			}
    			girlsWalking[currentRow][currentDay][currentCol] = 0;
    			if ((currentCol == 1) && (currentEntry) < maxIndex) {
					index -= 2;
					continue;
				}
				index = (currentEntry == 1) ? index - 2 : index - 1;
    		} else {
    			girlsWalking[currentRow][currentDay][currentCol] = checkEntry;
    			fillTable (girlsWalking, currentRow, currentDay, currentCol, true);
    			index++;
    		}
    		printGirlsWalking(girlsWalking, rows, days, girlsPerRow);
    	}
    	
    	fillTable(girlsWalking, currentRow, currentDay, currentCol, true);

    	printGirlsWalking(girlsWalking, rows, days, girlsPerRow);

  //   public static boolean haveWalked () {
		// if (state = 1) {
		// 	return true;
		// }		
		// return false;
	}
}
