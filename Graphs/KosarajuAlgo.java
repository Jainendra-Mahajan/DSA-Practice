// Helps to find if we can reach to a nodes again in directed graph.
 // Do toposort store in an stack
 // Transpose the graph
 //And do rev DFS


//  TC is O(N + E) for dfs for toposort + 
//  O(N + E) for rev dfs ~ O(N + E);
// SC is O(N + E) + O(N) + O(N) for transpose graph , stack , vis.
import java.util.*;

class KosaR {
    
    
    void revdfs(ArrayList<ArrayList<Integer>> rev , int[] vis , int i){
        vis[i] = 1;
        
        System.out.print(i + " ");
        for(Integer it : rev.get(i)){
            if(vis[it] == 0){
                revdfs(rev , vis , it);
            }
        }
    }
    
    void dfs(ArrayList<ArrayList<Integer>> adj , int[] vis , Stack<Integer> st , int node){
        vis[node] = 1;
        
        for(Integer it : adj.get(node)){
            if(vis[it] == 0){
                dfs(adj , vis , st , it);
            }
        }
        st.add(node);
    }
    
    void kosaRaju(ArrayList<ArrayList<Integer>> adj , int n){
        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n; i++){
            if(vis[i] == 0)
            dfs(adj , vis , st , i);
        }
        
        ArrayList<ArrayList<Integer> > transpose = new ArrayList<ArrayList<Integer> >();
        
        for(int i = 0; i < n; i++){
            transpose.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < n ; i++){
            vis[i] = 0;
            for(Integer it :  adj.get(i)){
                transpose.get(it).add(i);
            }
        }
        
        while(!st.isEmpty()){
            int node = st.pop();
           
                if(vis[node] == 0){
                    
                    System.out.print("SCC: ");
                    revdfs(transpose , vis , node);
                    System.out.println();
                }
        }
        
    }
	public static void main (String[] args) {
		int n = 5;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Integer>());
			
		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(2).add(0);
		adj.get(1).add(3);
		adj.get(3).add(4);

			
		KosaR obj = new KosaR(); 
		obj.kosaRaju(adj, n); 
		
    
	}
}