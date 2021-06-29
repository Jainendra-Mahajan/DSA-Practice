/*Use Topo sort to perform all the work of minimum indegree and then perform for all
other childrens
TC - O(N + E)
SC is O(N) */

import java.util.*;

  
class MinTimeJob {
    
    void minTime(ArrayList<ArrayList<Integer>> adj , int n){
        
    // Toposort
    int[] inDegree = new int[n];
    int[] min = new int[n];
    
    for(int i = 0; i < n; i++){
        for(Integer it : adj.get(i)){
            inDegree[it]++;
        }
    }
    Queue<Integer> q = new LinkedList<>();
    for(int i = 0; i < n ;i++){
        if(inDegree[i] == 0){ 
        q.add(i);
        min[i] = 1;
            
        }
    }
    
    while(!q.isEmpty()){
        int curr = q.poll();
        
        for(Integer it : adj.get(curr)){
            inDegree[it]--;
            
            if(inDegree[it] == 0) {
                q.add(it);
                min[it] = min[curr] + 1;
            }
        }
    }
    for(int i = 0; i < n; i++){
        System.out.print(min[i] + " ");
    }
}
    
	public static void main (String[] args) {
		int n = 7;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		for(int i = 0; i < n; i++){
		    adj.add(new ArrayList<Integer>());
		}
		
		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(1).add(3);
		adj.get(1).add(4);
		adj.get(2).add(5);
		adj.get(3).add(5);
		adj.get(4).add(6);
		
		MinTimeJob obj = new MinTimeJob();
		obj.minTime(adj , n);
	}
}