//Unbounded Knapsack calculate Min coins to get sum as providedin input. 
 
 
class CoinChange2{

	public int minCoins(int coins[], int n, int sum) 
	{ 
	    int[][] dp = new int[n + 1][sum + 1];
	    
	    for(int i = 0; i < n + 1; i++){
	        for(int j = 0; j < sum + 1; j++){
	            if(i == 0){
	                dp[i][j] = Integer.MAX_VALUE - 1;
	            }
	            if(j == 0){
	                dp[i][j] = 0;
	            }
	        }
	    }
	    
	    for(int i = 1; i < n + 1; i++){
	        for(int j = 1; j < sum + 1; j++){
	            if(j >= coins[i - 1]){
	                dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]] , dp[i - 1][j]); // if we take the coin add 1 to increase count.
	            }
	            else {
	                dp[i][j] = dp[i - 1][j];
	            }
	        }
	    }
	
	if (dp[n][sum] == Integer.MAX_VALUE - 1)
	return -1;
	
	return dp[n][sum];
	    
	} 
}