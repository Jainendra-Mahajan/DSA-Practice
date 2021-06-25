// USe 2 visited one for changes will not be done once visited the booelan array
// second when we backtrack from recursion call make the second bool array false of curr idx.

// -----> when both boolean values are true at same time cycle is detected.
 
// TC is O(V + E);
// SC is O(2 * V)
import java.util.*;

class DirectedDFS 
{
    public boolean dfsCheck(ArrayList<ArrayList<Integer>> adj , int i , boolean[] vis , boolean[] dfsVis){
    vis[i] = true;
    dfsVis[i] = true;
    
    for(Integer it : adj.get(i)){
        if(vis[it] == false){
            if(dfsCheck(adj , it , vis , dfsVis) == true)
            return true;
        }
        else if(dfsVis[it]) return true; // both values are true;
    }
    dfsVis[i] = false; // change the values while coming back
    return false;
    
    }
    //Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean visited[] = new boolean[V];
        boolean dfsVisited[] = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(visited[i] == false){
                if(dfsCheck(adj , i , visited , dfsVisited) == true)
                return true;
                }
        }
        
        return false;
    }
}