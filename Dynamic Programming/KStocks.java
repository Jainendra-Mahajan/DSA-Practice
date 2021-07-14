// Classical DP Problem.
// Choose Max of left element or prev compare with all prev row elements.
class KStocks {
    static int maxProfit(int k, int n, int arr[]) {
        int[][] dp = new int[k + 1][n]; //Trans in row , price on cols.
        
        for(int i = 1; i < k + 1; i++){
            
            int max = Integer.MIN_VALUE;
            for(int j = 1; j < n ; j++){
                
            max = Math.max(dp[i - 1][j - 1] - arr[j - 1] , max);
            
            
            if(max + arr[j] > dp[i][j - 1])
                dp[i][j] = max + arr[j];
            
            else 
                dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[k][n - 1];
    }
}