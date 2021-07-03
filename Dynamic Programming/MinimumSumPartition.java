/*
Intusion - Use Subset Sum logic 
In this calculate Range we have not given any sum .
Do subset sum on Sum of arr elements.

From last row take the elements which has valid sum. till mid size of dp 
as we want S1 - (Range - S1) = Range - 2S1.

if we take further values then it will be -ve .
 */


import java.util.*;
class MinSum
{

	public int minDifference(int arr[], int n) 
	{ 
	    int Range = 0;
	    for(int i = 0; i < n; i++)
	        Range += arr[i];
	 
            boolean[][] dp = subsetSum(arr , n , Range);
            
           ArrayList<Integer> al = new ArrayList<Integer>();
           
            for(int j = 0; j <= Range / 2; j++){ // Take the sum of all last N  values  
                if(dp[n][j] == true)
                al.add(j);
            }
            
            int minVal = Integer.MAX_VALUE;
            
            for(int i = 0; i < al.size(); i++){
                minVal = Math.min(minVal , (Range - (2 * al.get(i))));
            }
            
            return minVal;
	} 
	
	static boolean[][] subsetSum(int[] arr , int n , int sum){
	    
	     boolean[][] dp = new boolean[n + 1][sum + 1];
	     
	    for(int i = 0; i < n + 1; i++){          // Initialize DP
	        for(int j = 0; j < sum + 1; j++){
	            if(i == 0){
	                dp[i][j] = false;
	            }
	            if(j == 0){
	                dp[i][j] = true;
	            }
	        }
	    }
	    
	    for(int i = 1; i < n + 1; i++){
	        for(int j = 1; j < sum + 1; j++){
	            if(arr[i - 1] <= j){
	                dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
	            }
	            else {
	                dp[i][j] = dp[i - 1][j];
	            }
	        }
	    }
	    return dp;
	}
}
