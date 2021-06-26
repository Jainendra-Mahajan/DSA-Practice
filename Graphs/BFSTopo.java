// Kahn's Algo.
// calculate indegree of all nodes .
// push to queue all nodes with 0  indegree 
// travrese adjacent nodes and decrease adjacent nodes indegree by 1. 
//  Repeat till  queue is empty.


import java.util.*;

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] ans = new int[V];
        int[] inDegree = new int[V];
        
        for(int i = 0 ;i < V; i++){
            for(Integer it : adj.get(i)){
                inDegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0 ; i < V; i++){
            if(inDegree[i] == 0)
            q.add(i);
        }
        
        int idx = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            ans[idx++] = curr;
            for(Integer it : adj.get(curr)){
                inDegree[it]--;
                
                if(inDegree[it] == 0) q.add(it);
            }
        }
        return ans;
    }
}
