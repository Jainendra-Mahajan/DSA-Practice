/*TC -  O(N^2) */

import java.util.*;

class MaxProfit {
    static class Job{
       
    int start, end , profit;
    
     Job(int start , int end , int profit){
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}
    
    public static  int maxProfit(Job[] arr , int n){
        Arrays.sort(arr , new Comparator<Job>(){
           
           @Override
           public int compare(Job a , Job b){
               return a.end - b.end;
           }
        });
        
        int[] dp = new int[n];
        
        dp[0] = arr[0].profit;
        
        for(int i = 1; i < n; i++){
            int incl = arr[i].profit;          // Include curr profit
            int idx = Prevprofit(arr , i);     // find prev idx to include in curr profit if its end time is smaller than i's start time.
            
            if(idx != -1){
                incl += dp[idx];
            }
            
            dp[i] = Math.max(incl , dp[i - 1]);    // Max of include or exclude.
        }
        
        return dp[n - 1];
    }
    
    public static int Prevprofit(Job[] arr , int i){
        
        for(int j = i - 1; j >= 0; j--){
            if(arr[j].end <= arr[i].start){
                return j;
            }
        }
        
        return -1;
    }
    
	public static void main (String[] args) {
		Job[] arr = new Job[]{new Job(3, 10, 20), new Job(1, 2, 50),new Job(6, 19, 100),new Job(2, 100, 200)};
	    int n = arr.length;
	    System.out.println(maxProfit(arr , n));
	}
}