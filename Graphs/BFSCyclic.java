// Do bfs trversal but have a node pair of parent and data
// helps to detremine the cyclic nature .
//  TC is O(V + E)
// SC is O(V)

import java.util.*;

class BFSCyclic
{
    class Node {
        int data , parent;
        
        public Node(int data , int parent){
            this.data = data;
            this.parent = parent;
        }
    }

public boolean isCycleHelper(ArrayList<ArrayList<Integer>> adj , int i , boolean[] vis)
{
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(i , -1)); // first node parent should be -1
    vis[i] = true;
    
    while(!q.isEmpty()){
        int curr = q.peek().data;
        int par = q.peek().parent;
        q.remove();
        
        for(Integer it : adj.get(curr)){
            if(vis[it] == false){
                q.add(new Node(it , curr));
                vis[it] = true;
            }
            else if(par != it) return true; // IMP STEP compare these values help recognize cycle
        }        
        
    }
    return false;
}
 //Function to detect cycle in an undirected graph.
public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
{
    boolean[] visited = new boolean[V];
    Arrays.fill(visited , false);
    
  
    
    for(int i = 0; i < V; i++)
        if(visited[i] == false)
            if(isCycleHelper(adj , i , visited))
                return true;
    
    return false;
    }
}