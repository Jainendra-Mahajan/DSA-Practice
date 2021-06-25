// In DFS we travel to depth and have recursive call once every node is visited 
// it is not visited again.
// for disconnected graph we use for loop 

//TC is (V + E) and  SC is (V);

import java.util.*;

class DFS
{
    
    static void dfs(int i , boolean[] vis , ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> ans){
                ans.add(i);
                vis[i] = true;
                
                for(Integer it : adj.get(i)){
                    if(!vis[it]){
                        vis[it] = true;
                        dfs(it , vis , adj , ans);
                    }
                }
    }
    //Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        
        dfs(0 , vis , adj , ans);
        
        return ans;
    }
}