// TC / SC ---> O(N^2)

// If i choose 1st value then both are playing optimally so 2nd player will provide me that array from which i will be forced to choose
// the min value in next chance 
// similar is for jth value if i choose.
import java.util.*;
class OptimalGame
{
     static long[][] dp;
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n)
    {
         dp = new long[n + 1][n + 1];
        for(long[] row : dp){
            Arrays.fill(row , -1);
        }
        return solve(arr , 0 , n - 1);        
    }
    
    static long solve(int[] arr , int i  , int j){
        if(i > j) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        return dp[i][j] = (long)Math.max(arr[i] + Math.min(solve(arr , i + 2 , j) , solve(arr , i + 1, j - 1)),
                            arr[j] + Math.min(solve(arr , i + 1 , j - 1) , solve(arr , i  , j - 2)));
    }
    
}
