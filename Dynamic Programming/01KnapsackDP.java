// Memoization Method

/*class Solution 
{ 
    
    static int knapSack(int W , int wt[] , int val[] , int n){
    
     int[][] dp = new int[W + 1][n + 1];
        for(int[] row : dp)
         Arrays.fill(row , -1);
     
     
     return knapSackhelper(W , wt , val , n , dp);
    }
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSackhelper(int W, int wt[], int val[], int n , int[][] dp) 
    { 
         if(n == 0 || W == 0) // Base Case..
         return 0;
         
         if(dp[W][n] != -1){
             return dp[W][n];
         }
         
         if(wt[n-1] <= W){
             return dp[W][n] = Math.max((val[n-1] + knapSackhelper(W - wt[n-1] , wt , val , n -1 , dp)),
                            knapSackhelper(W , wt , val , n - 1 , dp));
         }
         else if(wt[n-1] > W){
             return dp[W][n] = knapSackhelper(W , wt , val , n - 1 , dp);
         }
         return 0;
    } 
}*/

// ---------------------------------------------------------------------------------//


// Top Down approach
// Time and space comp. is (N * W)

/*class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n) 
    { 
         int[][] dp = new int[n + 1][w + 1];
         
         for(int i = 0; i < n + 1; i++)
            for(int j = 0; j < w + 1; j++)
            if(i == 0 || j == 0)
            dp[i][j] = 0; // Initialize with base case of recursion
            
            for(int i = 1; i < n + 1; i++){
                for(int j = 1; j < w + 1; j++){
                    if(wt[i - 1] <= j){
                        dp[i][j] = Math.max(val[i-1] + dp[i - 1][j-wt[i-1]] , dp[i-1][j]);
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[n][w];
    } 
}*/


