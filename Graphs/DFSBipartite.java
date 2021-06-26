// Used DFS to find the Bipartite graph
import java.util.*;
class DFSBip
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] color = new int[V];
        for(int i = 0 ; i < V; i++)
            color[i] = -1;
        
        for(int i = 0;  i < V; i++){
            if(color[i] == -1){
                if(!DfsHelper(adj , color , i)) return false;
            }
        }
        return true;
    }
    
    public boolean DfsHelper(ArrayList<ArrayList<Integer>> adj , int[] color , int node){
        
     if(color[node] == -1)  // Starting Condn.
     color[node] = 1;
        
        for(Integer it : adj.get(node)){ // check for adjacent nodes
            if(color[it] == -1){ // if not visited
                color[it] = 1 - color[node]; // visit the node
                
                if(!DfsHelper(adj , color , it)) return false;
            }
            
                else if(color[it] == color[node]) return false; // parent color != adjacent color
            
        }
        
        return true;
    }
}