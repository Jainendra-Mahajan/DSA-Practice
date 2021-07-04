//UnBounded Knapsack + subsetsum combiantion problem

class Knapsack1
{
    public long count(int coin[], int n, int sum) 
    { 
         long[][] dp = new long[n + 1][sum + 1];
        
        for(int i = 0; i < n + 1; i++){
            for(int j = 0; j < sum + 1; j++){
                if(i == 0)
                dp[i][j] = 0;
            
            if(j == 0)
            dp[i][j] = 1;
        }
    }
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < sum + 1; j++){
                if(j >= coin[i - 1]){
                    dp[i][j] = dp[i][j - coin[i - 1]] + dp[i - 1][j]; // unbounded condition -  pass [i] in place of [i - 1] it can occur once again
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    } 
}