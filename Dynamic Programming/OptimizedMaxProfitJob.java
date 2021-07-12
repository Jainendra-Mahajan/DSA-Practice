/*TC -  O(NLogN) */
//  binarySearch used to find idx of lower ending values than curr idx. 
import java.util.*;

class OptimiizedMaxProfit {
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
            int idx = binarySearch(arr , i);     // find prev idx to include in curr profit if its end time is smaller than i's start time.
            
            if(idx != -1){
                incl += dp[idx];
            }
            
            dp[i] = Math.max(incl , dp[i - 1]);    // Max of include or exclude.
        }
        
        return dp[n - 1];
    }
    
    public static int binarySearch(Job[] arr , int idx){
        
        int low = 0;
        int high = idx - 1;
        
        while(low <= high){        // = is taken due to high is taken as idx - 1. It will compare all the values except idx index.
            int mid = (low + high) / 2;
            
            if(arr[mid].end <= arr[idx].start){
                if(arr[mid + 1].end <= arr[idx].start){  // if we have more element on mid + 1.
                    low = mid + 1;
                }
                else return mid;
            }
            else {
                high = mid - 1;
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