// Use Coin change logic.
class cutSegment
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       int[] arr = {x , y , z};
       int m = arr.length;
       int[][] dp = new int[m + 1][n + 1];
       
       for(int i = 0; i < m + 1; i++){
            for(int j = 0; j < n + 1; j++){
                if(i == 0)
                dp[i][j] = Integer.MIN_VALUE;
            
            if(j == 0)
            dp[i][j] = 0;
        }
    }
       
       for(int i = 1; i < m + 1; i++){
           for(int j = 1; j < n + 1; j++){
               if(j >= arr[i - 1]){
                   dp[i][j] =   Math.max(1 + dp[i][j - arr[i - 1]]  ,  dp[i - 1][j]);
               }
               else {
                   dp[i][j] = dp[i - 1][j];
               }
       }
       
    }
    
       return (dp[m][n] < 0 ? 0 : dp[m][n]);
}
}
