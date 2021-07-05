// Apply LCS LOgic here fill the 2d matrix.
// Then from last check if character are equal.
// if Equal then move to upper diagonal because it was came from i-- and j--(1 + dp[i - 1][j - 1].
// else go to that index which is max.


class LongestCommonSubsequence
{
	// Returns length of LCS for X[0..m-1], Y[0..n-1]
	static void lcs(String X, String Y, int m, int n)
	{
	int[][] dp = new int[m + 1][n + 1];
	
	for(int i  = 0; i < m + 1; i++){
	    for(int j = 0; j < n + 1; j++){
	        
	        if(i == 0 || j == 0)
	        dp[i][j] = 0;
	    }
	}
	
	for(int i = 1; i < m + 1; i++){
	    for(int j = 1; j < n + 1; j++){
	        if(X.charAt(i - 1) == Y.charAt(j - 1)){
	            dp[i][j] = 1 + dp[i - 1][j - 1];
	        }
	        else {
	            dp[i][j] = Math.max(dp[i][j - 1] , dp[i - 1][j]);
	        }
	    }
	}

        int i = m;
        int j = n;
        String revans = "";
        while(i > 0 && j > 0){
            if(X.charAt(i - 1) == Y.charAt(j - 1)){    //if Equal then move to upper diagonal
                revans += X.charAt(i - 1);
                i--;
                j--;
            }
            else {                                  //go to that index which is max
                if(dp[i - 1][j] > dp[i][j - 1]){
                    i--;
                }
                else {
                    j--;
                }
            }
        }
        StringBuilder sb = new StringBuilder(); // We have to reverse string as we traverse from last 
        sb.append(revans);
        sb.reverse();
        
        System.out.println(sb);
	}
	
	
	public static void main (String[] args)
	{
		String X = "AGGTAB";
		String Y = "GXTXAYB";
		int m = X.length();
		int n = Y.length();
		lcs(X, Y, m, n);
	}
}


