class Solution{
    static int equalPartition(int n, int arr[])
    {
     if(findPartition(arr , n)) return 1;
        return 0;
       
    }
    
    static boolean findPartition(int[] arr , int n){
       int sum = 0;
       for(int i = 0; i < n; i++){
           sum += arr[i];
       }
       
       if(sum%2  != 0) return false;
       
       return subsetSum(arr , sum/2 , n);
    }
    
    static boolean subsetSum(int[] arr , int sum  , int n){
        if(sum == 0) return true;
        
        if(n == 0 && sum != 0) return false;
        
        return (subsetSum(arr , sum , n - 1) || subsetSum(arr , sum - arr[n - 1] , n - 1));
    }
    
    
}