//program to find the maximum sum
// such that no three are consecutive

// TC - O(N)
// SC - O(N)

 // 3 conditions 
 /* 
 Take last sums value or
 take curr val skip current's prevoius val . or
 take curr ,  current's prev and sum till (i - 3);
 */
class Non3Consecutive {

	static int arr[] = {100, 1000, 100, 1000, 1};

	static int func(int n)
	{
	    int[] dp = new int[n];
	   dp[0] = arr[0];
	   dp[1] = arr[1] + arr[0];
	   dp[2] = Math.max(Math.max(dp[1] , dp[0] + arr[2]) , arr[1] + arr[2]);
	   
	   
	   for(int i = 3; i < n; i++){
	    dp[i] = Math.max(Math.max(dp[i-1] , arr[i] + dp[i - 2]) , arr[i] + arr[i - 1] + dp[i - 3]);    
                                
	   }
                                          
                                            
	   return dp[n - 1];
	}
                    
	public static void main(String[] args)
	{
		
		int n =5;
		 
		System.out.println(func(n));
	}
}

// This code is contributed by vt_m
