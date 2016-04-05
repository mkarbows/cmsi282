//For the past week we worked in the lab figuring out what the best way was to approach the Kirkman problem. 
//After a lot a work on the whiteboard we attempted the Kirkman problem. When we failed we looked through multiple books in the 
//lab and different approaches to the problem online as well as through some youtube videos. After multiple attempts at failed code 
//we found this code online and worked through it step by step, method by method to understand what it was doing. While it is very clear
//to us what is is doing now, it is not the approach we originally thought of. Because we understand this code so much better we decided
//to try and implement this in a way that made a little more sense to us but we did not finish it. Thus, we have provided our code and 
//explanations, and the original code that guided us/ made the most sense to us. Here is our attempt at writing the code to solve the 
//problem where we based the code off of ideas that we found and worked through from the code beneath ours. Our code prints the first day 
//of girls walking home successfully.

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

    	// while (!haveStudent) {
    	// 	haveStudent = false;
    	// 	// for (int i = student; i < totalGirls; i++) {
    	// 	// 	if ()
    	// 	// }
    	// 	if (haveStudent)  {
    	// 		if ()
    	// 	}
    	// }
    	return student;
    }

    public static void main (String[] args) {
    	//rows = Integer.parseInt(args[0]);
    	//girlsPerRow = Integer.parseInt(args[1]);
    	//totalGirls = rows * girlsPerRow;

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

    // 	while (girlsWalking[rows - 1][days - 1][girlsPerRow - 1] == 0) {
    // 		if (index % girlsPerRow == 0 && ((index % totalGirls) <= girlsPerRow * (girlsPerRow - 1))) {
    // 			index ++;
    // 		}
    // 		checkEntry = placeGirl(index, rows, girlsPerRow, totalGirls, girlsWalking);

    // 		if (checkEntry == -1) {
    // 			if(girlsWalking[currentRow][currentDay][currentCol] != 0) {
    // 				fillTable(girlsWalking, currentRow, currentDay, currentCol, false);
    // 			}
    // 			girlsWalking[currentRow][currentDay][currentCol] = 0;
    // 			if ((currentCol == 1) && (currentEntry) < maxIndex) {
				// 	index -= 2;
				// 	continue;
				// }
				// index = (currentEntry == 1) ? index - 2 : index - 1;
    // 		} else {
    // 			girlsWalking[currentRow][currentDay][currentCol] = checkEntry;
    // 			fillTable (girlsWalking, currentRow, currentDay, currentCol, true);
    // 			index++;
    // 		}


    // 		printGirlsWalking(girlsWalking, rows, days, girlsPerRow);
    // 	}

    	fillTable(girlsWalking, currentRow, currentDay, currentCol, true);
    	printGirlsWalking(girlsWalking, rows, days, girlsPerRow);

    	// for (int i = 0; i < totalGirls; i++) {
    	// 	adjacencyTable[i][i] = 1;
    	// }
    }

  //   	//was inside main, but i don't know if i want to use it yet:
		// unavailable = new boolean[days][totalGirls];
  //   	for (int day = 0; day < days; day++) {
  //   		for (int girl = 0; girl < girlsPerRow; girl++) {
  //   			unavailable[day][girl] = true;
  //   		}
  //   	}

    // public static void printTable (int[][] table) {
    // 	int length = table[0].length;
    // 	for (int i = 0; i < rows; i++) {
    // 		for (int j = 0; j < length; j++) {
    // 			System.out.printf("%-4d", table[i][j]);
    // 		}
    // 		System.out.print("\n");
    // 	}
    // 	System.out.print("\n");
    // }

 //    public static boolean haveWalked () {
	// 	if (state = 1) {
	// 		return true;
	// 	}		
	// 	return false;
	// }
}


//Here is the code we used to aid our understanding:
// the code below was inspired by juansc's KirkmanSolver.java code, all credit to juansc
//a few methods were modified slightly
//previous commit was based off of the ideas above
//all of the code above is understood, but I would have never thought of this approach myself

import java.util.ArrayList;
public class Kirkman {

    public static int[][] adjacencyTable;
    public static boolean[][] unavailable;

    public static int currentCol;
    public static int currentRow;
    public static int currentDay;
    public static int currentEntry;
    public static int currentGirl;
    public static boolean haveStudent;
    public static int student;
    public static int index;
    public static int checkEntry;

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Please enter the number of rows and the number of girls walking per row.");
        }

        int rows = Integer.parseInt(args[0]);
        int girlsPerRow = Integer.parseInt(args[1]);
        if (rows < 1 || girlsPerRow < 1) {
            throw new IllegalArgumentException("Please enter natural numbers.");
        }

        if ((rows * girlsPerRow - 1) % (girlsPerRow - 1) != 0) {
            System.out.println("Please enter something possible:)");
            return;
        }

        int totalGirls = rows * girlsPerRow;
        int numOfDays = (totalGirls - 1) / (girlsPerRow - 1);
        adjacencyTable = new int[totalGirls][totalGirls];
        for (int i = 0; i < totalGirls; i++) {
            adjacencyTable[i][i] = 1;
        }

        int[][][] girlsWalking = new int[rows][numOfDays][girlsPerRow];
        for (int i = 0; i < totalGirls; i++) {
            girlsWalking[(i % totalGirls) / girlsPerRow][i / totalGirls][i % girlsPerRow] = i;
        }

        for (int i = 0; i < totalGirls; i++) {
            int max = (i / girlsPerRow + 1) * girlsPerRow;
            int min = (i / girlsPerRow) * girlsPerRow;
            for (int j = min; j < max; j++) {
                adjacencyTable[i][j] = adjacencyTable[j][i] = 1;
            }
        }

        for (int day = 1; day < numOfDays; day++) {
            for (int row = 0; row < girlsPerRow; row++) {
                girlsWalking[row][day][0] = row;
            }
        }

        index = totalGirls;
        unavailable = new boolean [numOfDays][totalGirls];
        for (int day = 0; day < numOfDays; day++) {
            for (int girl = 0; girl < girlsPerRow; girl++) {
                unavailable[day][girl] = true;
            }
        }

        int maxIndex = girlsPerRow * girlsPerRow;
        while (girlsWalking[rows - 1][numOfDays - 1][girlsPerRow - 1] == 0 ) {
            if (index % girlsPerRow == 0 && ((index % totalGirls) <= girlsPerRow * (girlsPerRow - 1))) {
                index++;
            }
            checkEntry = makeLegalEntry(index, rows , girlsPerRow, totalGirls, girlsWalking);
            currentCol = index % girlsPerRow;
            currentRow = (index % totalGirls) / girlsPerRow;
            currentDay = index / totalGirls;
            currentEntry = index % totalGirls;

            if (checkEntry == -1) {
                if (girlsWalking[currentRow][currentDay][currentCol] != 0) {
                    fillTable(girlsWalking , currentRow, currentDay, currentCol, false);
                    unavailable[currentDay][girlsWalking[currentRow][currentDay][currentCol]] = false;
                }
                girlsWalking[currentRow][currentDay][currentCol] = 0;
                if ((currentCol == 1) && ((currentEntry) < maxIndex)) {
                    index -= 2;
                    continue;
                }
                index = (currentEntry == 1) ? index - 2 : index - 1;
            } else {
                unavailable[currentDay][checkEntry] = true;
                girlsWalking[currentRow][currentDay][currentCol] = checkEntry;
                fillTable(girlsWalking , currentRow, currentDay, currentCol, true);
                index++;
            }
        }
        printChildren(girlsWalking, rows, numOfDays, girlsPerRow);
    }

    public static void fillTable (int[][][] girls, int currentRow, int currentDay, int lastIndex, boolean state) {
        int adjacentGirl;
        int currentGirl = girls[currentRow][currentDay][lastIndex];
        for (int i = lastIndex - 1; i >= 0; i--) {
            adjacentGirl = girls[currentRow][currentDay][i];
            adjacencyTable[currentGirl][adjacentGirl] = adjacencyTable[adjacentGirl][ currentGirl] = (state) ? 1 : 0;
        }
    }

    // This checks if the row we are adding the new girl to is valid.
    public static boolean isValid (int girl, int[] kidRow, int girlsPerRow, int index) {
        int ind = index % kidRow.length;
        for (int i = 0; i < ind ; i++) {
            if (adjacencyTable[girl][kidRow[i]] == 1) {
                return false;
            }
        }
        return true;
    }

    //looks at the whole table and determines legal entries
    public static int makeLegalEntry (int index, int numOfRows, int girlsPerRow, int numOfKids, int[][][] girls) {
        currentEntry = index % girlsPerRow;
        currentDay =  index / numOfKids;
        currentRow = (index % numOfKids) / girlsPerRow;
        currentGirl = girls[currentRow][currentDay][currentEntry];
        haveStudent = false;

        if (currentGirl!= 0) {
            fillTable(girls , currentRow, currentDay, currentEntry, false);
            unavailable[currentDay][currentGirl] = false;
            student = currentGirl + 1;
        } else {
            if (currentEntry == 0) {
                student = girls[currentRow - 1][currentDay][currentEntry] + 1;
            } else {
                student = girls[currentRow][currentDay][currentEntry - 1] + 1;
            }
        }

        if ((currentEntry == 0 && student > currentRow * girlsPerRow) || (student  + (girlsPerRow - currentEntry) >= numOfKids)) {
            return -1;
        }

        while (!haveStudent) {
            haveStudent = false;
            for (int i = student; i < numOfKids; i++) {
                if (!unavailable[currentDay][i]) {
                    student = i;
                    haveStudent = true;
                    break;
                }
            }
            if (haveStudent) {
                if (isValid(student, girls[currentRow][currentDay], girlsPerRow, index)) {
                    return student;
                } else {
                    student++;
                    haveStudent = false;
                    continue;
                }
            } else {
                return -1;
            }
        }
        return student;
    }

     public static void printChildren (int[][][] table, int rows, int numOfDays, int girlsPerRow) {
        for (int row = 0; row < rows; row++) {
            for (int day = 0; day < numOfDays; day ++) {
                for (int kid = 0; kid < girlsPerRow; kid++) {
                    System.out.printf("%-4d",table[row][day][kid]);
                }
                System.out.print(" | ");
            }
            System.out.println("");
        }
    }
}
//was inspired by juansc's KirkmanSolver.java code, all credit to juansc
//a few methods were modified slightly
//previous commit was based off of the ideas above
//all of the code above is understood, but I did not naturally think of this approach myself
