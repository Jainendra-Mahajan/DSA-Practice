// Time complexity : O(n * k *log k). 
// space complexity : O(K)
import java.util.*;
class smallestRangeFromKLists
{
    static class Element{
    int row , col , val;
    
    Element(int row , int col , int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
	static int[] findSmallestRange(int[][] arr,int n,int k)
	{
	    
	    int[] ans = new int[2]; // PQ arranged in ascending order
	    PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>(){
	        
	        @Override
	        public int compare(Element a , Element b){
	            return a.val - b.val;
	        }
	    });
	    
	    int min = Integer.MAX_VALUE; // for new minimum value occured
	    int max = Integer.MIN_VALUE;// for new max value occured
        int minRange = Integer.MAX_VALUE;	  // for minimum range
        
	    for(int i = 0; i < k; i++){
	        pq.add(new Element(i , 0 , arr[i][0])); // add k elements of each starting index 
	        max = Math.max(max , arr[i][0]);    
	    }
	    

	    while(pq.size() == k){
	        
	        Element curr = pq.poll(); // get current min elem.
	        min = curr.val;
	      
	        if(minRange > max - min){ //  calc minimum range
	            minRange = max - min;
	            ans[0] = min;
	            ans[1] = max;
	        }
	        
	        
	        if(curr.col + 1 < n){ // move further in minimum element found list
	            
	            curr.col = curr.col + 1; // by updating col + 1 and new value
	            
	            curr.val = arr[curr.row][curr.col];
	            
	            pq.add(curr);
	            
	            if(curr.val > max)
	            max = curr.val;
	        }
	        
	    }
	    
	    return ans;
	}
}