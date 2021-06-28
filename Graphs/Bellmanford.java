//  TC is O(N - 1) * O(E)
// SC is O(N)

// Relax the nodes n - 1 times.
// n - 1 because if further the dist. decreases means there is a negative never ending
//cycle .

// just compare dis[u] + wt < dis[v].

import java.util.*;



class bfAlgo {
    static class Node{
    int u , v , weight;
    
    Node(int u , int v , int weight){
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
    
    
}
    void bellmanFord(ArrayList<Node> adj , int n , int src){
        
        int[] dist = new int[n];
        for(int i = 0; i < n; i++){
            dist[i] = 10000000;
        }
        
        dist[src] = 0;
        
        for(int i = 1; i <= n - 1; i++){
            for(Node it : adj){
                
                if(dist[it.u] + it.weight < dist[it.v]){
                    dist[it.v] = dist[it.u] + it.weight;
                }
            }
        }
        
        int flag = 0;
        
        for(Node node : adj){   // if flag changes -ve cycle detected
            if(dist[node.u] + node.weight < dist[node.v]) {
                 flag = 1;
                System.out.println("Negative Cycle"); 
    			break;
            }
        }
        
        if(flag == 0){
            for(int i = 0 ; i < n; i++){
                System.out.println(i + " " + dist[i]);
            }
        }
    }
	public static void main (String[] args) {
		 int n = 6;
        ArrayList<Node> adj = new ArrayList<Node>();
		
			
		adj.add(new Node(3, 2, 6));
		adj.add(new Node(5, 3, 1));
		adj.add(new Node(0, 1, 5));
		adj.add(new Node(1, 5, -3));
		adj.add(new Node(1, 2, -2));
		adj.add(new Node(3, 4, -2));
		adj.add(new Node(2, 4, 3));

	
		bfAlgo obj = new bfAlgo(); 
		obj.bellmanFord(adj, n, 0);
	}
}