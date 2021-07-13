// Based on MCM.
// Make cuts in expression at k and increase k+=2.as symbols are at even position.
// At k there will be operator . cal all true and false condition from its left and right
// and evaluate for kth operator. 

//Eg - T^F&T ----> (T^F) & (T) ---> k at '&' evaluate ans. and soo on.


// Solution ----->

/*class BalanceParenthesis{
    static int countWays(int N, String S){
        return solve(S , 0 , N - 1 , true);
    }
    
    static int[][][] dp = new int[201][201][3];
    Solution(){
        for(int[][] row : dp){
            for(int[] adp : row){
                Arrays.fill(adp , -1);
            }
        }
    }
    
    static int solve(String str , int i , int j , boolean isTrue){
        
 if(i == j){
            if(isTrue) {
            
                if(str.charAt(i) == 'T')
                return 1;
                
                else 
                return 0;
            }
            else {
                if(str.charAt(i) == 'F')
                return 1;
            
                else return 0;
        
        }
        
        
    }
    
    if(dp[i][j][isTrue ? 1 : 2] != -1){
        
        return dp[i][j][isTrue ? 1 : 2];
        
    }
        int ans = 0;
        
        for(int k = i + 1; k <= j - 1; k+=2){
            
            int lt = dp[i][k - 1][1] = solve(str , i , k - 1 , true);
            int lf = dp[i][k - 1][2] = solve(str , i , k - 1 , false);
            int rt = dp[k + 1][j][1] = solve(str , k + 1 , j , true);
            int rf = dp[k + 1][j][2] = solve(str , k + 1 , j , false);
            
            
            
            if(str.charAt(k) == '&'){
                if(isTrue){
                    ans += lt * rt;
                }
                else {
                    ans += (lf * rf) + (lf * rt) + (lt * rf); 
                }
            }
            
            if(str.charAt(k) == '|'){
                if(isTrue == true){
                    ans += (rt * lf) + (rf * lt) + (lt * rt);
                }
                else {
                    ans += (lf * rf);
                }
            }
            
            else if(str.charAt(k) == '^'){
                if(isTrue == true){
                    ans += (lf * rt) + (rf * lt);
                }
                else {
                    ans += (lt * rt) + (lf * rf);
                }
            }
        }
        return dp[i][j][isTrue?1 : 2] = ans % 1003;
    }
}*/