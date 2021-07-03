// Memoization.

/*import java.io.*;
import java.lang.*;
import java.util.*;
 
class countSubset{
 
static int subsetSum(int arr[], int n, int sum)
{
     int[][] dp = new int[n + 1][sum + 1];
     
     for(int i = 0; i < n + 1; i++){
         for(int j = 0; j < sum + 1; j++){
             dp[i][j] = -1;
         }
     }
     
     
    return SubsetHelper(arr , n , sum , dp);
}

static int SubsetHelper(int[] arr , int n , int sum , int[][] dp){
    if(n == 0 && sum == 0)
    return 1;
    
    if(n == 0 && sum != 0) 
    return 0;
    
    
    if(dp[n][sum] != -1){
        return dp[n][sum];
    }
    
    if(sum >= arr[n - 1]){
        return dp[n][sum] = SubsetHelper(arr , n - 1 , sum - arr[n - 1] , dp) + SubsetHelper(arr , n - 1, sum , dp);
    }
    else  {
        return dp[n][sum] = SubsetHelper(arr , n - 1, sum , dp);
    }
   
}
 
// Driver Code
public static void main(String[] args)
{
    int n = 4;
    int a[] = { 3, 3, 3, 3 };
    int sum = 6;
 
    System.out.print(subsetSum(a, n, sum));
}
}*/ 



// TABULAR APPROACH

/*import java.io.*;
import java.lang.*;
import java.util.*;
 
class countSubset{
 
static int subsetSum(int arr[], int n, int sum)
{
     
    int[][] dp = new int[n + 1][sum + 1];
    
    for(int i = 0; i < n + 1; i++){
        for(int j = 0; j < sum + 1; j++){
            if(i == 0){
                dp[i][j] = 0;
            }
            if(j == 0){
                dp[i][j] = 1;
            }
        }
    }
    
    for(int i = 1; i < n + 1; i++){
        for(int j = 1; j < sum + 1; j++){
            if(arr[i - 1] <= j)
            dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i-1][j];
            
            else {
                dp[i][j] = dp[i - 1][j];
            }
            
        }
    
        
    }
    return dp[n][sum];
}
 
// Driver Code
public static void main(String[] args)
{
    int n = 4;
    int a[] = { 3, 3, 3, 3 };
    int sum = 6;
 
    System.out.print(subsetSum(a, n, sum));
}
}*/