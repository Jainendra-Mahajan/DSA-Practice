// Here we have to perform min operations insert delete and replace to change 
// s1 to s2.

// while replacing - (m - 1)(n - 1).
// deletion - (m - 1)(n)
// inserting - (m)(n - 1).

class EditDis {
    public int editDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = 0; i < m + 1; i++){
            for(int j = 0; j < n + 1; j++){
                if(i == 0){
                    dp[i][j] = j;
                }
                if(j == 0){
                    dp[i][j] = i;
                }
            }
        }
        
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] =  dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = 1 +  Math.min(dp[i - 1][j] ,( Math.min (dp[i][j - 1] , dp[i - 1][j - 1])));
                }
            }
        }
        
        return  dp[m][n];
        
    }
}