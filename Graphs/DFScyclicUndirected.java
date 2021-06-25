// Check for cycle in graph by DFS.
// Same as BFS use parent to detect the cyclic nature.

import java.util.*;

class DFScyclicUndirected
{
    
    public boolean checkDfs(ArrayList<ArrayList<Integer>> adj , int currV , boolean[] vis , int parent){
        
        vis[currV] = true;
        
        for(Integer it : adj.get(currV)){
            if(vis[it] == false){
                if(checkDfs(adj , it , vis , currV) == true)
                return true;
            }
            else if (parent != it)
            return true;
        }
            
        return false;
    }
    //Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        
        for(int i = 0 ; i < V; i++){
            if(visited[i] == false){
            if(checkDfs(adj , i , visited , -1)) 
            return true;
            }
        }
            
            return false;
    }
}