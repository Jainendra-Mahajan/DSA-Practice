/* 
Select minumum weight edge and add to the MST.

Used rank and disjoint set concept by calculating union and 
finding parent.

TC is N log N
SC is O(N)

import java.util.*;



class GFG {

    public class Node{
        int u;
        int v;
        int weight;
        
        Node(int u , int v , int weight){
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
        
        class sortComparator implements Comparator<Node> {
            @Override
            
            public int compare(Node n1 , Node n2){
                if(n1.weight > n2.weight) return 1;
                if(n1.weight < n2.weight) return -1;
                 return 0;
            }
        }
    int findPar(int u  , int[] parent){
        if(u == parent[u]) return u;
        
        return parent[u] = findPar(parent[u] , parent);
    }
    
    void Union(int u , int v , int[] rank , int[] parent){
         u = findPar(u , parent);
         v = findPar(v , parent);
        
        if(rank[u] < rank[v]){
            parent[u] = v;
        }
        else if(rank[u] > rank[v]){
            parent[v] = u;
        }
        else {
            parent[v] = u;
            rank[u]++;
        }
    }
    
    void kruskalAlgo(ArrayList<Node> adj , int N){
        Collections.sort(adj , new sortComparator());
        
        int[] parent = new int[N];
        int[] rank = new int[N];
        
        for(int i = 0; i < N; i++){
            parent[i] = i;
            rank[i] = 0;
        }
            
            ArrayList<Node> mst = new ArrayList<Node>();
            int cost = 0;
            for(Node it : adj){
                if(findPar(it.u , parent) != findPar(it.v , parent)){
                    cost += it.weight;
                    mst.add(it);
                    Union(it.u , it.v , rank , parent);
                }
            }
            System.out.println(cost);
            for(Node it : mst){
                System.out.println(it.u + " " + it.v);
            }
        
    }
	public static void main (String[] args) {
	    
	    int N = 5;
		ArrayList<Node> adj = new ArrayList<Node>();
		
		adj.add(new Node(0, 1, 2));
		adj.add(new Node(0, 3, 6));
		adj.add(new Node(1, 3, 8));
		adj.add(new Node(1, 2, 3));
		adj.add(new Node(1, 4, 5));
		adj.add(new Node(2, 4, 7));
		
		GFG obj = new GFG();
		obj.kruskalAlgo(adj , N);
	}
}*/