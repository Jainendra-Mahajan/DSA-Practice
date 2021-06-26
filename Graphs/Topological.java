//  Topological sort is like linear ordering vertices first vertex 
//  will be the vertex with 0 indegree.
//Use stack DS visited all adjacent nodes of curr node and then push to stack
// TC O(V + E);
// SC is O(V) + O(V) ~ O(V). // stack visited array
import java.util.*;

class Topological
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        Stack<Integer> st = new Stack<>();
        int[] visited = new int[V];
        
        for(int i = 0 ; i < V; i++){
            if(visited[i] == 0)
            dfs(adj , st , visited , i);
        }
        
        int[] ans = new int[V];
        int idx = 0;
        while(!st.isEmpty()){
            ans[idx++] = st.pop();
        }
        
        return ans;
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> adj , Stack<Integer> st , int[] vis , int i){
        vis[i] = 1; // Mark visited to curr.
        
        for(Integer it : adj.get(i)){ // visit every  adjacent node.
            if(vis[it] == 0)
            dfs(adj , st , vis , it);
        }
        st.push(i); // push after all adjacent node visited.
    }
}
