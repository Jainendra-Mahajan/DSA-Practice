// We only require pre 2 values.
//TC is O(N)
// SC is O(N)

// Use formula - countDer(n) = (n - 1) * [countDer(n - 1) + countDer(n - 2)]
// Link to formula explained in proper way --> https://www.youtube.com/watch?v=ZcYI6ZVsu2w

                            // n - 1 -- > element has n - 1 choices.
                            // countDer(n - 2) ---> as n element has left so if person  sat on the lone chair we left with n - 2 condition
                            //countDer(n - 1) -->  If The person wants to sit on another chair then it has n - 1 choices.
class Dearrange{
    static long disarrange(int n){
        long[] dp = new long[n + 1];
        int mod = 1000000007;
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        
        for(int i = 3; i <= n; i++){
            dp[i] = ((i - 1) % mod) * ((dp[i - 1] + dp[i - 2]))%mod;
        }
        
        return dp[n];
    }
}