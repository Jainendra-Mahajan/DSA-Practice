//Function to find the length of longest common subsequence in two strings.
// X =  abcf , y = abdf ans = abf ie. count is 3. return 3.

/* Memoization

class Solution
{
    static int dp[][] = new int[1001][1001];
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
    char[] X=s1.toCharArray();
    char[] Y=s2.toCharArray();
    int m = X.length;
    int n = Y.length;
        
        for(int[] i : dp){
            Arrays.fill(i , -1);
        }
     return lcsHelper(X , Y , m , n);  
    }
    static int lcsHelper(char[] X , char[] Y , int m , int n){
        
    if (m == 0 || n == 0)
      return 0;
      
      if(dp[m][n] != -1){
          return dp[m][n];
      }
    if (X[m-1] == Y[n-1])
      return dp[m][n] = 1 + lcsHelper(X, Y, m-1, n-1);
      
    else
      return dp[m][n] = Math.max(lcsHelper(X, Y, m, n-1), lcsHelper(X, Y, m-1, n));
  }*/

  
//TOP DOWN 
class Solution
{
   
   
    static int lcs(int x, int y, String s1, String s2)
    {
        
    
    char[] X=s1.toCharArray();
    char[] Y=s2.toCharArray();
    
    int m = X.length;
    int n = Y.length;
        
     int[][] dp = new int[m + 1][n + 1];
     
     for(int i = 0; i < m + 1; i++){
       for(int j = 0 ; j < n + 1; j++){
           
        if(i == 0 || j == 0)
         dp[i][j] = 0;
      
    }
}

        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                
                if(X[i - 1] == Y[j - 1]){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j - 1] , dp[i - 1][j]);
                }
            }
        }
        
        return dp[m][n];
    }
  
}