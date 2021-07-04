//  we are using LCS logic and returning through loop and finding max value at last
// We have to traverse bcoz value can become 0 any where. we have to return max value.

// if char  matches increase count by 1 and pass another part of string else start form 0.

class LongestString{
    int longestCommonSubstr(String S1, String S2, int a, int b){
       
       char[] x = S1.toCharArray();
       char[] y = S2.toCharArray();
       
        int m = x.length;
        int n = y.length;
        
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++){
            for(int j = 0; j < n + 1; j++){
                if(i == 0 || j == 0)
                dp[i][j] = 0;
            }
        }
        
        
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
            
            if(x[i - 1] == y[j - 1]){
                dp[i][j] = 1 + dp[i - 1][j - 1];
            }
            else 
                dp[i][j] = 0;
            
            }
        }
        
        int ans = Integer.MIN_VALUE;
        
      for(int i = 0; i < m + 1; i++)
          for(int j = 0; j < n + 1; j++)
              ans = Math.max(ans , dp[i][j]);
          
      return ans;
    }
}