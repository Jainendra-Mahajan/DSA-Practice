/*
Count all subsequences having product less than K

TC - O(N^2)
SC - O(N * K) 

*/

// Code similar to 0/1 knapsack

class countPr {

    static int solve(int[] arr  , int k){
        
        int n = arr.length;
        int[][] dp = new int[n + 1][k + 1];
        
        for(int i = 0; i < n + 1; i++){
            for(int j = 0; j < k + 1; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
            
            for(int i = 1; i < n + 1; i++){
                for(int j = 1;  j < k + 1; j++){
                    if(j >= arr[i -1]){
                        dp[i][j] = 1 + dp[i - 1][j / arr[i - 1]] + dp[i - 1][j]; // add 1 if element is smaller than j
                    }
                    else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            
        return dp[n][k];
        }
    
    
        public static void main (String[] args) {
        int[] arr = {4 , 8 , 7 , 2};
        int k = 50;
        
        System.out.println(solve(arr , k));
        }
    }