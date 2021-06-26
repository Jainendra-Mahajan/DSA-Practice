// Bipartite graph is color all nodes with no 2 adjacent nodes must not have same color 
// Used BFS concept 
// TC is O(V + E);
// TC is O(V);
import java.util.*;

class BipartiteBFS
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] color = new int[V];
        for(int i = 0; i < V; i++){
            color[i] = -1;
        }
        
        for(int i = 0; i < V; i++){  // This for loop is used if we have more than 1 component
            if(color[i] == -1){
                if(!bipHelper(adj , color , i)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean bipHelper(ArrayList<ArrayList<Integer>> adj , int[]  color , int node){
    Queue<Integer> q = new LinkedList<>();
    q.add(node);
    color[node] = 0;
    
    while(!q.isEmpty()){
        
        int curr = q.poll(); // pick curr node
        
        for(Integer it : adj.get(curr)){  // mark adjacent nodes with opp color
            if(color[it] == -1){
                q.add(it);
                color[it] = 1 - color[curr];
            }
            else if(color[it] == color[curr]) return false; // if prev has same color or not 
        }
    }
    return true;
    }
}