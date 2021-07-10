// Use maximum of diagonal , left and top value add 1 to it.

class Max1subArray{
    static int maxSquare(int n, int m, int arr[][]){
        int[][] dp = new int[n][m];
        
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(i == 0 || j == 0)
                dp[i][j] = arr[i][j];
               
                else if(arr[i][j] == 1) 
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j] , dp[i - 1][j - 1]) , dp[i][j - 1]);
                
                 else {
                    dp[i][j] = 0;
                 }
                 max = Math.max(max , dp[i][j]);
            }
        }
        return max;
    }
}