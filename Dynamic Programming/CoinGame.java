// Java program to find winner of game
// if player can pick 1, x, y coins
import java.util.Arrays;

public class CoinGame {
	
	// To find winner of game
	static boolean findWinner(int x, int y, int n)
	{
	    boolean[] dp = new boolean[n + 1];
	    dp[0] = false;                        // A has No chance to take 
	    dp[1] = true;                           // First and only chance taken by A. wins
	    
	    for(int i = 2; i <= n; i++){ 
	        if(i - 1 >= 0 && !dp[i - 1]){       // substract i from 1, x , y and check for remaining values if remianing value is false then A will win 
	            dp[i] = true;
	        }
	        else if(i - x >= 0 && !dp[i - x]){
	            dp[i] = true;
	        }
	        else if(i - y >= 0 && !dp[i - y]){
	            dp[i] = true;
	        }
	        else dp[i] = false;
	    }
	    
	    return dp[n];
	}
	
	
	public static void main(String args[])
	{
		int x = 3, y = 4, n = 5;
		if (findWinner(x, y, n) == true)
			System.out.println('A');
		else
			System.out.println('B');
	}
}

