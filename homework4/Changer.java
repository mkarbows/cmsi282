public class Changer {

	public static void main (String[] args) {
		int[] denominations = {4, 7, 2};
		int amount = 13;
		int maxCoins = 3;
		System.out.println(canMakeChangeFor(denominations, amount));
		System.out.println(canMakeChangeUsingEachCoinOnce(denominations, 
amount));
		System.out.println(canMakeChangeWithLimitedCoins(denominations, amount,
 maxCoins));
	}


	public static int[] canMakeChangeFor(int[] denominations, int amount) {
		boolean [][] change = new boolean[denominations.length + 1][amount+1];
		for (int i = 1; i <= amount; i++) {
			change[0][i] = false;
		}

		for(int i = 0; i <= denominations.legnth; i++) {
			change[i][0] = true;
		}

		return true;
	}

	public static int[] canMakeChangeUsingEachCoinOnce(int cents) {
		boolean [][] change = new boolean[denominations.length + 1][amount+1];
		for (int i = 1; i <= amount; i++) {
			change[0][i] = false;
		}

		for(int i = 0; i <= denominations.legnth; i++) {
			change[i][0] = true;
		}

		for (int i = 1; i <= denominations.length; i++) {
			for (int j = 1; j <= amount; j++) {
				change[i][j] = change[i-1][j];
			}
		}

		if (change[i][j] == false && change >= denominations[i - 1]) {
			change[i][j] = change[i - 1][j - denominations[i - 1]];
		}
		return true;
	}
	

	public static boolean canMakeChangeWithLimitedCoins(int[] denominations, int cents, int 
maxCoins) {

		if (canMakeChangeFor > maxCoins) {
			return false;
		} else {
			return true;
		}
	}

} 
// public static int divideDivisor(int dividend, int divisor){
// 		return (dividend/divisor);
// 	}
	
// 	public static int getQuarters(int cents) {
// 		return divideDivisor(cents, 25);
// 	}

// 	public static int getDimes(int cents) {
// 		return divideDivisor(cents, 10);
// 	}

// 	public static int getNickels(int cents) {
// 		return divideDivisor(cents, 5);
// 	}

// 	public static int getPennies(int cents) {
// 		return divideDivisor(cents, 1) ;
// 	}

// int quarters = getQuarters(cents);
// 		int dimes = (cents - (quarters*25))/10;
// 		int nickels = (cents - ((quarters*25) + (dimes*10)))/5;
// 		int pennies = (cents - ((quarters*25) + (dimes*10) + (nickels*5)));

// 		int[] change = new int [4];
// 			change[0] = quarters;
// 			change[1] = dimes;
// 			change[2] = nickels;
// 			change[3] = pennies;
// 			return change;
