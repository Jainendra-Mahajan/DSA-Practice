// Use priority queue as minheap

import java.util.*;

class KLargest {
    int[] kLargest(int[] arr, int n, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] ans = new int[k];
        
        for(int i = 0 ; i < k; i++){
            minHeap.add(arr[i]);
        }
        
        for(int i = k ; i < n; i++){
            
            if(arr[i] > minHeap.peek()) 
          {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        
        int idx = k - 1;
        while(!minHeap.isEmpty()){
            ans[idx--] = minHeap.peek();
            minHeap.poll();
        }
        
        
        return ans;
    }
}