//Mkae adjacency list and do dfs or bfs 
 // TC is O(V + E);
 // SC is O(N) list

/*class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;
        
        //Make adj List.
        
        ArrayList<ArrayList<Integer>> adj  = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i < n; i++) 
            adj.add(new ArrayList<Integer>());
            
            for(int[] arr : connections){
               adj.get(arr[0]).add(arr[1]);
                adj.get(arr[1]).add(arr[0]);
            }
        
        boolean vis[] = new boolean[n];
        int ans = 0;
       
        // Do DFS
        
        for(int i = 0; i < n; i++){
           if(!vis[i]){
               dfs(adj , vis , i);
               ans++;
           }
       }
        
        return ans - 1;
    }
    
    void dfs(ArrayList<ArrayList<Integer>> adj  , boolean[] vis , int node){
        vis[node] = true;
        for(Integer it : adj.get(node)){
            
            if(vis[it] == false)
                dfs(adj , vis , it);
        }
    }
}*/