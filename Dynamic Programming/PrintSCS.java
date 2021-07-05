/* Same as LCS printing here we have to print all character which are not common and make the superstring.*/
class GFG {

	static String printShortestSuperSeq(String s1, String s2)
	{
	int m = s1.length();
	int n = s2.length();
	
	int[][] dp = new int[m + 1][n + 1];
	
	for(int i = 0; i < m + 1; i++){
	    for(int j = 0;  j < n + 1; j++)
	        if(i == 0 || j == 0)
	            dp[i][j] = 0;
	    }
	    
	    for(int i = 1; i < m + 1; i++){
	        for(int j = 1; j < n + 1; j++){
	            if(s1.charAt(i - 1) == s2.charAt(j - 1)){
	                dp[i][j] = 1 + dp[i - 1][j - 1];
	            }
	            else {
	                dp[i][j] = Math.max(dp[i][j - 1] , dp[i - 1][j]);
	            }
	        }
	    }
	    
	    int i = m;
	    int j = n;
	    String ans = "";
	    
	    while(i > 0 && j > 0){
	        if(s1.charAt(i - 1) == s2.charAt(j - 1)){
	            ans += s1.charAt(i - 1);
	            i--;
	            j--;
	        }
	        else {                                  
	            if(dp[i][j - 1] > dp[i - 1][j]){
                    ans += s2.charAt(j - 1);
                    j--;
	            }
	            
                else {
                    ans += s1.charAt(i - 1);
                    i--;
                }
               
                
            }
	    }
	    
	    while(i > 0){
	          ans += s1.charAt(i - 1);
	          i--;
	    }
	    while(j > 0){
	          ans += s2.charAt(j - 1);
	          j--;
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    
	    sb.append(ans);
	    sb.reverse();
	    
	return sb.toString();
}
	
	public static void main(String[] args)
	{
		String X = "AGGTAB";
		String Y = "GXTXAYB";
		System.out.println(printShortestSuperSeq(X, Y));
	}
}
